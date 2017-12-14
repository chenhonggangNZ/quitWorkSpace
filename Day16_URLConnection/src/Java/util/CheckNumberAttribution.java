package Java.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CheckNumberAttribution {
    public void Serches(String telnumber) throws IOException {

        String urlin = "http://api.k780.com/?app=phone.get&phone=" + telnumber + "&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json";
        URL url = new URL(urlin);
        URLConnection urlC = url.openConnection();
        InputStream inputStream = urlC.getInputStream();
        int num = 0;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        byte[] bytes = new byte[1024];
        while ((num = inputStream.read()) != -1) {
            bytes[i] = (byte) num;
            i++;
            if (i == 1023) {
                sb.append(bytes);
                i = 0;
            }
        }
        System.out.println(sb);
    }
}
