import be.md.MyParser;
import be.md.OKSLineConsumer;
import be.md.ResultComparator;
import be.md.model.RoundResult;
import freemarker.template.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) throws IOException, TemplateException {
        System.out.println("Information:");
        System.out.println("Usage: <path to csv file> <round number>");
        System.out.println("Supported columns:");
        for (OKSLineConsumer.Columns value : OKSLineConsumer.Columns.values()) {
            System.out.println("["+value.name()+ "] on index: "+value.column);
        }
        int round = Integer.parseInt(args[1]);
        Set<RoundResult> result = new MyParser().processFile(args[0], new OKSLineConsumer(),round)
                .stream()
                .filter(RoundResult::hasVS)
                .collect(Collectors.toSet());

        SortedSet<RoundResult> sorted = new TreeSet<>(new ResultComparator());
        sorted.addAll(result);

        Main main = new Main();
        main.processFile(sorted);
    }

    private void processFile(Set<RoundResult> result) throws IOException, TemplateException {
        Configuration cfg = createFreemarkerConfig();
        Template template = cfg.getTemplate("roundresults.html");
        String output = "output.html";
        FileWriter fileWriter = new FileWriter(output);

        HashMap<String, Set<RoundResult>> context = new HashMap<>();
        context.put("obj", result);

        template.process(context, fileWriter);
        System.out.println("File written:" + output);
    }

    private static HashMap<String, String> mapOfKeysStartingWithUnderscore(Map<String, String> arguments) {
        var context = new HashMap<String, String>();
        arguments.keySet().stream().filter(s -> s.startsWith("_")).forEach(param -> {
            context.put(param, arguments.get(param));
        });
        return context;
    }

    private Map<String, String> parse(String[] args) {
        var result = new HashMap<String, String>();
        StreamSupport.stream(Arrays.stream(args).spliterator(), false)
                .forEach(s -> {
                    var splitted = s.split("=");
                    result.put(splitted[0], splitted[1]);
                });
        return result;
    }

    private Configuration createFreemarkerConfig() {
        Configuration cfg = new Configuration(new Version(2, 3, 29));
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }
}
