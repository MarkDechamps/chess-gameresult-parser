package be.md.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class RoundResult {
    private String time = "";
    private String name = "";
    private String vs = "";
    private String round = "";
    private String result = "";
    private String lichessLink = "";
    private String report = "";
    private boolean shouldAppendName = true;

    @Override
    public String toString() {
        return "RoundResult{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", vs='" + vs + '\'' +
                ", round='" + round + '\'' +
                ", result='" + result + '\'' +
                ", lichessLink='" + lichessLink + '\'' +
                ", report='" + report + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getVs() {
        return vs;
    }

    public String getRound() {
        return round;
    }

    public String getResult() {
        return result;
    }

    public String getLichessLink() {
        return lichessLink;
    }

    public String getNamedReport() {
        if (hasReport()) {
            return  "<b>"+getName()+"</b>" + ":" + report;
        } else {
            return "";
        }
    }

    public String getReport() {
        if (shouldAppendName) {
            return getNamedReport();
        } else {
            return report;
        }
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVs(String vs) {
        this.vs = vs;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setLichessLink(String lichessLink) {
        this.lichessLink = lichessLink;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public boolean hasVS() {
        return !isEmpty(vs);
    }

    public boolean hasReport() {
        return !isEmpty(report);
    }

    public int getIndex() {
        if (!hasVS()) return -1;
        int index = 0;
        try {
            index = Integer.parseInt(vs.split(" ")[0]);
        } catch (NumberFormatException n) {
            n.printStackTrace();
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundResult that = (RoundResult) o;
        return time.equals(that.time) && name.equals(that.name) && Objects.equals(vs, that.vs) && round.equals(that.round) && result.equals(that.result) && Objects.equals(lichessLink, that.lichessLink) && Objects.equals(report, that.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, name, vs, round, result, lichessLink, report);
    }

    public void reportWasModified() {
        shouldAppendName = false;
    }

    public boolean hasRound(int round) {
        if (StringUtils.isEmpty(this.round)) {
            return false;
        }
        try {
            int theRound = Integer.parseInt(this.round);
            return round == theRound;
        } catch (NumberFormatException nfe) {

            return false;
        }
    }

    public static final class RoundResultBuilder {
        private String time;
        private String name;
        private String vs;
        private String round;
        private String result;
        private String lichessLink;
        private String report;

        private RoundResultBuilder() {
        }

        public static RoundResultBuilder aRoundResult() {
            return new RoundResultBuilder();
        }

        public RoundResultBuilder withTime(String time) {
            this.time = time;
            return this;
        }

        public RoundResultBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RoundResultBuilder withVs(String vs) {
            this.vs = vs;
            return this;
        }

        public RoundResultBuilder withRound(String round) {
            this.round = round;
            return this;
        }

        public RoundResultBuilder withResult(String result) {
            this.result = result;
            return this;
        }

        public RoundResultBuilder withLichessLink(String lichessLink) {
            this.lichessLink = lichessLink;
            return this;
        }

        public RoundResultBuilder withReport(String report) {
            this.report = report;
            return this;
        }

        public RoundResult build() {
            RoundResult roundResult = new RoundResult();
            roundResult.setTime(time);
            roundResult.setName(name);
            roundResult.setVs(vs);
            roundResult.setRound(round);
            roundResult.setResult(result);
            roundResult.setLichessLink(lichessLink);
            roundResult.setReport(report);
            return roundResult;
        }
    }
}
