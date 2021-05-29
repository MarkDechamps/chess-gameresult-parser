package be.md;

import be.md.model.RoundResult;

import java.util.Comparator;

public class ResultComparator implements Comparator<RoundResult> {
    @Override
    public int compare(RoundResult r1, RoundResult r2) {
        if (r1.equals(r2)) return 0;

        if (!r1.getRound().equals(r2.getRound())) {
            return r1.getRound().compareTo(r2.getRound());
        }

        if (r1.getIndex() != r2.getIndex()) {
            return r1.getIndex() - r2.getIndex();
        }

        String report = r1.getNamedReport() + "<br/><br/>" + r2.getNamedReport();
        r1.setReport(report);
        r2.setReport(report);
        r1.reportWasModified();
        r2.reportWasModified();
        return 0;

    }
}
