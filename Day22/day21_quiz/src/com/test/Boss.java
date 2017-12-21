package com.test;

public class Boss extends Person implements UserInter {

	public Boss(){}
	
	public Boss(String name,String user,String password, String profession){
		super( name, user, password, profession);
	}
	
	@Override
	public void onLine() {
		System.out.println(super.getName() + "上班开始监管公司了！");
		
	}

	@Override
	public void offLine() {
		System.out.println(super.getName() + "下班了，去打高尔夫球了！");
		
	}
	
	public void offWork() {
		System.out.println(super.getName() + "卷走钱带小姨子跑路了！");
	}

}
