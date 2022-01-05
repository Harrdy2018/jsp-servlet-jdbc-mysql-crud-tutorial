package net.javaguides.LearnHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class OriginApiExample1 {
    public static void main(String[] args) throws Exception {
        String urlStr = "https://www.baidu.com";
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpURLConnection =(HttpURLConnection)urlConnection;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");

        try(InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            ) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
