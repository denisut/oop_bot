package bot.model;

import java.util.List;

public class YoutubeVideo {
    private Snippet snippet;
    private Statistics statistics;

    public Snippet getSnippet() {
        return snippet;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

}
