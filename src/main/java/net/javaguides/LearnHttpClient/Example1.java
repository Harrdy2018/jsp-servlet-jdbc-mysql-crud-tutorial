package net.javaguides.LearnHttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.MessageHeader;

public class Example1 {
    public static void main(String[] args) throws Exception {
        MessageHeader messageHeader = new MessageHeader();


        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.baidu.com/");
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");
        CloseableHttpResponse response = client.execute(httpget);

        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity, "utf-8"));
        response.close();
        client.close();
    }
}
