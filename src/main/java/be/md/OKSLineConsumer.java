package be.md;

import be.md.model.RoundResult;

import java.util.function.Function;

public class OKSLineConsumer implements Function<String[], RoundResult> {

    public enum Columns {
        time(0), name(1), vs(2), round(3), result(4), lichessLink(5), report(6);
        public final int column;

        Columns(int column) {
            this.column = column;
        }
    }

    @Override
    public RoundResult apply(String[] strings) {
        return RoundResult.RoundResultBuilder.aRoundResult()
                .withLichessLink(strings[Columns.lichessLink.column])
                .withReport(strings[Columns.report.column])
                .withName(strings[Columns.name.column])
                .withResult(strings[Columns.result.column])
                .withRound(strings[Columns.round.column])
                .withTime(strings[Columns.time.column])
                .withVs(strings[Columns.vs.column]).build();
    }
}
