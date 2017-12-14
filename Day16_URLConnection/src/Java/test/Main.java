package Java.test;

import Java.basic.HandSpeedGame;
import Java.util.RegisterOrLoginByXML;
import Java.util.exception.LoginException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HandSpeedGame.windows("19271115866");
        System.out.println("欢迎来到本世纪末！");
        boolean windows = UIWindows();
        if(windows == true){
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

        }

    }

    private static boolean UIWindows() {
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
                }
            }
            if (choose == 1) {
                try {
                    RegisterOrLoginByXML.LoginInput();
                    return true;
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
            }
        }
        return flag;
    }
}
