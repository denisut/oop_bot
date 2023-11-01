package bot.handlers;

import bot.model.Snippet;
import bot.model.Statistics;
import bot.model.YoutubeVideo;
import bot.util.JsonParser;
import bot.util.JsonSaver;

public class YoutubeHandler {

    private static final String APIKEY = "AIzaSyBIAZKoDQDDL0R4pJW0-PBRNFy4xr8yS5g";
    private String answer;

    public YoutubeHandler(String id) {

        String UrlForParse = "https://www.googleapis.com/youtube/v3/videos?id=" + id + "&key=" + APIKEY + "&part=snippet,statistics";

        JsonSaver jsonSaver = new JsonSaver(UrlForParse);

        JsonParser parser = new JsonParser();
        YoutubeVideo video = parser.parse();
        Statistics stat = video.getStatistics();
        Snippet snippet = video.getSnippet();

        this.setAnswer("Название: " + snippet.getTitle() + "\nПросмотров: " + stat.getViewCount() + "\nДата загрузки: " + snippet.getPublishedAt());
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
