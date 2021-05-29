package be.md;

import be.md.model.RoundResult;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class MyParser {
    public List<RoundResult> processFile(String file, Function<String[], RoundResult> consumer,int round) {
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> r = reader.readAll();
            return r.stream().map(consumer).filter(result->result.hasRound(round)).collect(toList());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            throw new IllegalStateException("Something went wrong..",e);
        }
    }

}
