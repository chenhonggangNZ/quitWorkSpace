package Java.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CheckHandSpeedGameTopTenPlayer {
        //http://192.168.20.221:8080/day16/ten
        public static StringBuffer check() throws IOException {
            String urlin = "http://192.168.20.221:8080/day16/ten";
            URL url = new URL(urlin);
            URLConnection urlC = url.openConnection();
            InputStream inputStream = urlC.getInputStream();
            int num = 0;
            int i = 0;
            StringBuffer sb = new StringBuffer();
            byte[] bytes = new byte[1024];
            while ((num = inputStream.read()) != -1) {
                bytes[i] = (byte) num;
                bytes[i] = (byte) num;
                i++;
                if (i == 1023) {
                    sb.append(new String(bytes,"utf-8"));
                    bytes = new byte[1024];
                    i = 0;
                }
            }
            try {
                sb.append(new String(bytes, "utf-8"));
            }catch(Exception e){}
            System.out.println(sb);
            return sb;
        }
}
