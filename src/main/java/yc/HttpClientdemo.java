package yc;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
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
public class HttpClientdemo {
    public static void main(String[] args) throws IOException {
//        RequestConfig.custom();
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)//读取数据的超时时间
                .setConnectTimeout(5000)//网洛请求的超时时间
                .setConnectionRequestTimeout(5000)//连接池去获取链接的超时时间
                .build();
        CloseableHttpClient aDefault = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://www.baidu.com");
//        httpPost.setConfig(requestConfig);
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = aDefault.execute(httpGet);
        System.out.println(response.getAllHeaders());
        Header[] headers = response.getAllHeaders();
//        for (Header header : headers) {
//            System.out.println(header.getName());
//            System.out.println(header.getValue());
//        }
        //请求实体
        HttpEntity entity = response.getEntity();
//        InputStream inputStream = entity.getContent();
//
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader buff = new BufferedReader(inputStreamReader);
//        String line = buff.readLine();
//        while (line != null) {
//            System.out.println(line);
//            line = buff.readLine();
//        }
//        inputStream.close();
//        inputStreamReader.close();
//        buff.close();
        String result = EntityUtils.toString(entity);
        System.out.println(result);
    }
}
