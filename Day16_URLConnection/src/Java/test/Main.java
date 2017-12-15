package Java.test;

import Java.basic.CheckHandSpeedGameTopTenPlayer;
import Java.basic.HandSpeedGame;
import Java.util.CheckNumberAttribution;
import Java.util.CheckTheWeather;
import Java.util.RegisterOrLoginByXML;
import Java.util.exception.LoginException;
import org.dom4j.Element;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("欢迎来到本世纪末！");
        Element windows = UIWindows();
        if(windows != null){
            System.out.println("登录成功，进入主菜单：\n1.查询天气\n2.查询手机号归属地\n3.手速游戏\n4.查询手速游戏前十用户");
            Scanner input = new Scanner(System.in);
            String choose01 = input.nextLine();
            int choose = -1;
            try{
                choose = Integer.parseInt(choose01);
            } catch(java.lang.NumberFormatException e){
                System.out.println(e.getMessage());
                if (choose01.equals("查询天气")){
                    choose = 1;
                } else if (choose01.equals("查询号码归属地")){
                    choose = 2;
                } else if(choose01.equals("手速游戏")){
                    choose = 3;
                } else if (choose01.equals("查询手速游戏前十用户")){
                    choose = 4;
                }
            }

            switch(choose){

                case 1:
                    CheckTheWeather.windows();
                break;
                case 2:
                    CheckNumberAttribution.windows();
                    break;
                case 3:
                    HandSpeedGame.windows(windows.attribute("user").getValue());
                    break;
                case 4:
//                    CheckHandSpeedGameTopTenPlayer
                    System.out.println("尚在思索中！");
                    break;
                default:
                    break;
            }

        }

    }

    private static Element UIWindows() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("请选择操作类型： \n1.登录\n2.注册");
            String choose01 = input.nextLine();
            int choose = -1;
            try {
                choose = Integer.parseInt(choose01);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                if (choose01.equals("登录")) {
                    choose = 1;
                } else if (choose01.equals("注册")) {
                    choose = 2;
                } else if (choose01.equals("退出")){
                    choose = 0;
                }
            }
            if (choose == 1) {
                try {
                    return RegisterOrLoginByXML.LoginInput();
                } catch (LoginException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (choose == 2) {
                try {
                    RegisterOrLoginByXML.Register();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (choose == 0){
                return null;
            }
        }
        return null;
    }
}
