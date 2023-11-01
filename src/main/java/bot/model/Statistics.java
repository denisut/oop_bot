package bot.model;

public class Statistics {
    private String viewCount;
    private String likeCount;
    private String commentCount;

    public Statistics(String viewCount, String likeCount, String commentCount) {
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    @Override
    public String toString() {
        return "Statistics{" + "viewCount='" + viewCount + '\'' + ", likeCount=" + likeCount + '\'' + ", commentCount=" + commentCount + '}';
    }
}
