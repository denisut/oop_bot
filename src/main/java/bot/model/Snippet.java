package bot.model;

public class Snippet {
    private String publishedAt;
    private String title;

    public Snippet(String publishedAt, String title) {
        this.publishedAt = publishedAt;
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getTitle() {
        return title;
    }
}
