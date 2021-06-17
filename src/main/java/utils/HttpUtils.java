package utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @program: HttpClient
 * @description:
 * @author: 作者
 * @create: 2021-05-01 11:49
 */
public class HttpUtils {
    //创建连接池管理对象
    static PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
    static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(5000)//读取数据的超时时间
            .setConnectTimeout(5000)//网洛请求的超时时间
            .setConnectionRequestTimeout(5000)//连接池去获取链接的超时时间
            .build();

    static {
        //配置最大连接数
        manager.setMaxTotal(300);
        //每个路由的最大连接数
        manager.setDefaultMaxPerRoute(20);
    }

    /**
     * @return
     */
    public static CloseableHttpClient getHttoConnection() {
        CloseableHttpClient build = HttpClients.custom()
                .setConnectionManager(manager)
                .setDefaultRequestConfig(requestConfig).build();
        return build;
    }
}
