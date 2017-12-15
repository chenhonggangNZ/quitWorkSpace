package Java.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HandSpeedGame {
    public static void windows(String user){
        System.out.println("欢迎来到手速游戏");
        System.out.println("请选择等级:\n1.困难\n2.适中\n3.简单");
        String mode = null;
        Scanner input = new Scanner(System.in);
        String choose01 = input.nextLine();
        int choose = -1;
        try{
            choose = Integer.parseInt(choose01);
        } catch(java.lang.NumberFormatException e){
            System.out.println(e.getMessage());
            if (choose01.equals("困难")){
                choose = 1;
            } else if (choose01.equals("适中")){
                choose = 2;
            } else if(choose01.equals("简单")){
                choose = 3;
            }
        }
        if (choose == 1){
            mode = hardMode();
        } else if (choose == 2){
            mode = moderation();
        } else if (choose == 3){
            mode = simpleMode();
        } else if (choose == 0){
            return ;
        }
        try {
            submit(mode,user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static StringBuffer submit(String score, String user) throws IOException {
        int sublit = 12000;
        String number = null;
        if (score.contains("100%")){
            for (int i = 0; i < score.length(); i++) {
                if(Pattern.matches("\\d",String.valueOf(score.charAt(i)))){

                    if (number == null) {
                        number = String.valueOf(score.charAt(i));
                    } else {
                        number = number + String.valueOf(score.charAt(i));
                    }
                } else {
                    break;
                }
            }
            sublit = Integer.parseInt(number);
            String urlin = "http://192.168.20.221:8080/day16/insert?username="+user+"&score="+sublit;
            URL url = new URL(urlin);
            URLConnection urlC = url.openConnection();
            InputStream inputStream = urlC.getInputStream();
            int num = 0;
            int i = 0;
            StringBuffer sb = new StringBuffer();
            byte[] bytes = new byte[1024];
            while( (num = inputStream.read()) != -1){
                bytes[i] = (byte) num;
                i++;
                if (i == 1023){
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
        return null;
    }


    public static String simpleMode() {
        Random random = new Random();
        ts();
        char[] chars = new char[10];
        for (int i = 0; i < 10; i++) {
            int randomChoose = random.nextInt(36) + 1;
            //48--57 +47
            if(randomChoose <= 10 && randomChoose >0){
                chars[i] = (char) (randomChoose + 47);
            } else if(randomChoose <= 36 && randomChoose >= 11){
                chars[i] = (char) (randomChoose + 86);
            } else if (randomChoose <= 62 && randomChoose>= 37){
                chars[i] = (char) (randomChoose + 60);
            }
            //65--90  +54
            //97--122 +60
        }
        String s = String.valueOf(chars);
        System.out.println(s);
        return test(s);
    }

    private static String test(String s) {
        Scanner input = new Scanner(System.in);
        long l = System.currentTimeMillis();
        String ins = input.nextLine();
        long l1 = System.currentTimeMillis();
        long times = l1 - (l + 400);
        System.out.println(times+"毫秒");
        double num = 0;
        if (ins.equals(s)){
            num = 100;
        }else{
            try {
                for (int i = 0; i < s.length(); i++) {
                    if (String.valueOf(ins.charAt(i)).equals(String.valueOf(s.charAt(i)))) {
                        double j = 100.0/s.length();
                        num += j;
                    }
                }
                System.out.println("正确率" + ((int)num) + "%");
            } catch (java.lang.StringIndexOutOfBoundsException e){
                System.out.println("正确率" + ((int)num) + "%");
            }
        }
        System.out.println(times+""+((int)num) + "%");
        return times+"&"+((int)num) + "%";
    }

    private static String moderation() {
        Random random = new Random();
        ts();
        char[] chars = new char[20];
        for (int i = 0; i < 20; i++) {
            int randomChoose = random.nextInt(62) + 1;
            //48--57 +47
            if(randomChoose <= 10 && randomChoose >0){
                chars[i] = (char) (randomChoose + 47);
            } else if(randomChoose <= 36 && randomChoose >= 11){
                chars[i] = (char) (randomChoose + 54);
            } else if (randomChoose <= 62 && randomChoose >= 37){
                chars[i] = (char) (randomChoose + 60);
            }
            //65--90  +54
            //97--122 +60
        }
        String s = String.valueOf(chars);
        System.out.println(s);
        return test(s);

    }

    private static void ts() {
        for (int i = 3; i > 0; i--) {
            System.out.println("倒计时"+ i +"秒后开始！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String hardMode() {
        Random random = new Random();
        ts();
        char[] chars = new char[30];
        for (int i = 0; i < 30; i++) {
            int randomChoose = random.nextInt(95) + 1;
            //48--57 +47
//            randomChoose = getRandomChoose(randomChoose);
            chars[i] = (char) (randomChoose+31);
            //65--90  +54
            //97--122 +60
        }
        String s = String.valueOf(chars);
        System.out.println(s);
        return test(s);
    }

    private static int getRandomChoose(int randomChoose) {
        Random random = new Random();
        if((randomChoose+31) == 96){
            randomChoose = random.nextInt(96) + 1;
            getRandomChoose(randomChoose);
        }
        return randomChoose;
    }
}
