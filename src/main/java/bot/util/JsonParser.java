package bot.util;

import bot.model.Snippet;
import bot.model.Statistics;
import bot.model.YoutubeVideo;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
    public YoutubeVideo parse() {

        YoutubeVideo video = new YoutubeVideo();
        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("videos.json")) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            JSONArray videoJsonArray = (JSONArray) rootJsonObject.get("items");

            for(Object it: videoJsonArray) {
                JSONObject videoJsonObject = (JSONObject) it;

                JSONObject snippetObject = (JSONObject) videoJsonObject.get("snippet");
                String publishedAt = (String) snippetObject.get("publishedAt");
                String title = (String) snippetObject.get("title");

                Snippet snippet = new Snippet(publishedAt, title);
                video.setSnippet(snippet);

                JSONObject statisticsObject = (JSONObject) videoJsonObject.get("statistics");
                String viewCount = (String) statisticsObject.get("viewCount");
                String likeCount = (String) statisticsObject.get("likeCount");
                String commentCount = (String) statisticsObject.get("commentCount");

                Statistics statistics = new Statistics(viewCount, likeCount, commentCount);
                video.setStatistics(statistics);
            }

            return video;
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}
