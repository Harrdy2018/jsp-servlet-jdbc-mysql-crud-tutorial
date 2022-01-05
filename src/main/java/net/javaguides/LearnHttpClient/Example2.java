package net.javaguides.LearnHttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Example2 {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        String param = "abc+123|wer";
        // 要想后台拿到的参数和发送的一样，需要做urlencode，如果是浏览器的话，浏览器会自动帮我们做
        param = URLEncoder.encode(param, StandardCharsets.UTF_8.name());
        String urlStr = "http://localhost:8080/jsp_servlet_jdbc_mysql_crud_tutorial/test/query?name="+param;
        HttpGet httpget = new HttpGet(urlStr);
        httpget.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");

        CloseableHttpResponse response = null;
        try {
            // CloseableHttpResponse 接口实现类 HttpResponseProxy
            response = client.execute(httpget);
            // HttpEntity  接口实现类 DecompressingEntity
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, StandardCharsets.UTF_8));
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

