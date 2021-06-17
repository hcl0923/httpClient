package yc;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

;

/**
 * @program: HttpClient
 * @description:
 * @author: 作者
 * @create: 2021-05-01 11:19
 */
public class HttpClientdemo2 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        CloseableHttpResponse response = aDefault.execute(httpGet);

        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
    }
}
