package fr.devteam.plugin.helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageHelper {
    public static boolean isURL(String path){
        return path.startsWith("https://") || path.startsWith("http://");
    }

    public static BufferedImage getImage(String path) throws IOException {
        if (isURL(path)){
            final URL url = new URL(path);
            final HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
            return ImageIO.read(connection.getInputStream());

        } else {
            final File imageFile = new File(path);
            if (!imageFile.exists()){
                return ImageIO.read(imageFile);
            } else {
                throw new IOException("Image not found");
            }
        }

    }
}