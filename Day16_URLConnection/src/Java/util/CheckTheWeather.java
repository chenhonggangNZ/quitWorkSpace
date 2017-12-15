package Java.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CheckTheWeather {


    public static  void windows() throws IOException {
        System.out.println("请输入您要查询的城市：");
        Scanner input = new Scanner(System.in);
        String place = input.nextLine();
        check(place);
    }
    public static void check(String city) throws IOException {
        String urlin = "http://www.sojson.com/open/api/weather/json.shtml?city="+city;
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
                sb.append(new String(bytes,"utf-8"));
                bytes = new byte[1024];
                i = 0;
            }
        }
        try {
            sb.append(new String(bytes, "utf-8"));
        }catch(Exception e){}
        System.out.println(sb);
    }

}
