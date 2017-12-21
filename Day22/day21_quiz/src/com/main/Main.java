package com.main;

import com.test.*;
import com.util.LoginTools;
import com.util.ObjectUtil;
import com.util.RegisterTools;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	private static int uid;
	private static Person instances;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		try {
//			RegisterForXml.register();
//		} catch (RegisterException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		boolean flag = true;
		while(flag) {
			System.out.println("请选择您要进行的操作，1.注册，2.登录");
			String chooseIn = input.nextLine();
			try{
				if (Integer.parseInt(chooseIn) == 1) {
					try{
						RegisterTools.Register();
					} catch(Exception e){
						System.out.println(e.getMessage());
						continue;
					}
				} else if (Integer.parseInt(chooseIn) == 2) {
					String user = null;
					System.out.println("请输入用户名！");
					user = input.nextLine();
					System.out.println("请输入密码!");
					String password = input.nextLine();
					try{
						uid = LoginTools.LoginInput();
						instances = ObjectUtil.getInstances(uid);
						isWho(instances);
						break;
					} catch(Exception e){
						System.out.println(e.getMessage());
						continue;
					}
//					Person person = getObjectValue();
//					isWho(person);
//					if (person == null) {return;}
//
//					System.out.println(person + "。 当前系统的时间为：" +new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()));
//					flag = false;
				} else  if (Integer.parseInt(chooseIn) == 0){
					return;
				} else {
					System.out.println("怕是没有！");
				}
			} catch (Exception a) {
				System.out.println(a.getMessage());
			}
		}
		System.out.println("当前系统的时间为：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()));
		System.out.println("是否要开始工作？1.开始 2.不工作");
		int choose = 0;
		String works = input.nextLine();
		try {
			choose = Integer.parseInt(works);
		} catch (Exception a) {
			if (works.equals("开始")) {
				choose = 1;
			} else if (works.equals("不工作")) {
				choose = 2;
			} else {
				choose = 3;
			}
		}
		work(choose);
		/*1，创建一个UserData类，通过二维数组存储姓名，用户名，密码，职业四个信息。
		姓名		用户名		密码			职业
		张三		zhangSan	111111		Worker
		李四		liSi666		222222		Doctor
		王五		wangWu888	333333		Cooker
		赵六		zhaoLiu999	444444		Boss
	2，	创建一个Login类，里面有登录方法，接收一个用户名和密码，返回一个
	UserInter接口类型的实现类对象。
		在登录方法中，与UserData中的数据进行匹配，如果匹配失败则提示错误信息，如果成功则返回对应职业类型的实现类对象。
	http://idea.iteblog.com/key.php
	3，UserInter接口中的方法：taiaoguos sset beforse
			void onLine();
			void offLine();
	4，四种职业类型都实现这个User接口并且复写方法，
	比如：	onLine：工人开始干活了，厨师开始做菜了等等
			offLine：工人干完了回家了，厨师做完了

	5，创建一个类Person，类中有姓名，用户名，密码，职业四个属性，及其set/get方法
			四种职业类型都继承Person。

	6，四种职业类型，都有符合自己职业的独有的方法，比如厨师有颠勺()，工人有罢工()等。
		在onLine中调用自己的独有的方法。


	7，在Main类中，主入口中，使用Scanner接收用户输入的用户名和密码
		然后使用Login中的登录方法登录。
		登录成功后提示用户当前登录的用户的姓名及职业，当前系统时间
		提示是否开始工作：1，是 2，否
		如果输入1，则调用onLine方法
		输入2，则调用offLine方法
*/
//		int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
//		for (int i = 0; i < arr.length - 1 ; i++){
//			for (int j = 0; j < arr.length - 1 - i ; j++){
//				if (arr[j] > arr[j + 1]){
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//		int[] arr02 = new int[]{9,8,7,6,5,4,3,2,1};
//		for (int i = 0; i < arr02.length - 1 ; i++){
//			for (int j = 0; j < arr02.length - 1 - i ; j++){
//				if (arr02[i] > arr02[j]){
//					int temp = arr02[i];
//					arr02[i] = arr02[j];
//					arr02[j] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
	}

//	private static Person getObjectValue() {
//		Element profession = element.element("profession");
//		Person person = null;
//		switch (profession.getText()){
//			case "Worker":
//				work = new Worker(element.element("name").getText(),element.attribute("user").getValue(),element.element("password").getText(),element.element("profession").getText());
//				person = work;
//			break;
//			case "Cooker":
//				cooker = new Cooker(element.element("name").getText(),element.attribute("user").getValue(),element.element("password").getText(),element.element("profession").getText());
//				person = cooker;
//			break;
//			case "Doctor":
//				doctor = new Doctor(element.element("name").getText(),element.attribute("user").getValue(),element.element("password").getText(),element.element("profession").getText());
//				person = doctor;
//			break;
//			case "Boss":
//				boss = new Boss(element.element("name").getText(),element.attribute("user").getValue(),element.element("password").getText(),element.element("profession").getText());
//				person = boss;
//			break;
//			default:
//				person01 = new Person(element.element("name").getText(),element.attribute("user").getValue(),element.element("password").getText(),element.element("profession").getText());
//				person = person01;
//			break;
//		}
//		return person;
//	}

	public static void isWho(Object userInter) {
		if (userInter instanceof Worker) {
			work = (Worker) userInter;
			num = 1;
		} else if (userInter instanceof Doctor) {
			doctor = (Doctor) userInter;
			num = 2;
		} else if (userInter instanceof Cooker ) {
			cooker = (Cooker) userInter;
		} else if (userInter instanceof Boss) {
			boss = (Boss) userInter;
		} else if (userInter instanceof Person) {
			person01 = (Person) userInter;
		}
	}

	public static void work(int choose) {
		if (choose == 1) {
			if (work != null) {
				work.onLine();
			} else if (doctor != null) {
				doctor.onLine();
			} else if (cooker != null) {
				cooker.onLine();
			} else if (boss != null) {
				boss.onLine();
			}
		} else if (choose == 2) {
			if (work != null) {
				work.offLine();
			} else if (doctor != null) {
				doctor.offLine();
			} else if (cooker != null) {
				cooker.offLine();
			} else if (boss != null) {
				boss.offLine();
			}
		} else {
			System.out.println("错误,用户将随机行动！");
			int nuc = (int) (Math.random()*3 +1);
			if (nuc != 3) {
				work(nuc);
			} else {
				if (work != null) {
					work.offWork();
				} else if (doctor != null) {
					doctor.operation();
				} else if (cooker != null) {
					cooker.offWork();
				} else if (boss != null) {
					boss.offWork();
				}
			}

		}
	}
	private static Worker work;
	private static Doctor doctor;
	private static Cooker cooker;
	private static Boss boss;
	private static Person person01;
	private static int num = 0;
}
