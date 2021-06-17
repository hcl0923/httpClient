package yc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program: HttpClient
 * @description:
 * @author: 作者
 * @create: 2021-05-01 11:19
 */
public class HttpUrlConnection {
    public static void main(String[] args) throws IOException {
        HttpURLConnection urlconn = null;
        URL url = new URL("http://www.baidu.com");
        urlconn = (HttpURLConnection) url.openConnection();
        urlconn.setRequestMethod("GET");
        urlconn.setConnectTimeout(5000);
        urlconn.setReadTimeout(5000);
        urlconn.setUseCaches(false);
        urlconn.connect();

        InputStream inputStream = urlconn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader buff = new BufferedReader(inputStreamReader);
        String line = buff.readLine();
        while (line != null) {
            System.out.println(line);
            line = buff.readLine();
        }
        inputStream.close();
        inputStreamReader.close();
        buff.close();
    }
}
