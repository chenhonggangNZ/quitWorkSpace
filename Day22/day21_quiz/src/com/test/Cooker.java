package com.test;

public class Cooker extends Person implements UserInter {

	public Cooker(){}
	
	public Cooker(String name,String user,String password, String profession){
		super( name, user, password, profession);
	}

	@Override
	public void onLine() {
		System.out.println(super.getName() + "开始炒菜了！");
		
	}

	@Override
	public void offLine() {
		System.out.println(super.getName() + "抄好并被端给顾客了！");
		
	}
	
	public void offWork() {
		System.out.println(super.getName() + "没领到工资，颠勺了！");
	}
	
}
