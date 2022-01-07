package net.javaguides.LearnHttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
// 根据链接下载图片并保存到本地
public class Example3 {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        String urlStr = "http://www.roadjava.com/thumbnail/2021/07/38121010145589328_23030859685909203_wxjt_20201227174618.png";
        HttpGet httpget = new HttpGet(urlStr);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpget);
            HttpEntity entity = response.getEntity();
            // image/jpg iamge/jpeg image/png
            String contentType=entity.getContentType().getValue();
            String suffix = ".jpg";
            if (contentType.contains("jpg") || contentType.contains("jpeg")) {
                suffix = ".jpg";
            } else if(contentType.contains("bmp") || contentType.contains("bitmap")) {
                suffix = ".bmp";
            } else if (contentType.contains("png")) {
                suffix = ".png";
            } else if (contentType.contains("gif")) {
                suffix = ".gif";
            }

            byte bytes[] = EntityUtils.toByteArray(entity);
            String localAbsPath  = "e:\\test"+suffix;
            FileOutputStream fos = new FileOutputStream(localAbsPath);
            fos.write(bytes);
            fos.close();
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
