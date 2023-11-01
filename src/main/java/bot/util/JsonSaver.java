package bot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class JsonSaver {

    public JsonSaver(String URL) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(URL);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            int responseCode = httpsURLConnection.getResponseCode();

            if(responseCode == HttpsURLConnection.HTTP_OK) {
                inputStream = httpsURLConnection.getInputStream();

                File file = new File("videos.json");
                outputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while((byteRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, byteRead);
                }
            }

        } catch (IOException e) {
            System.out.println("Error:" + e.toString());
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                System.out.println("Error:" + e.toString());
            }
        }
    }

}
