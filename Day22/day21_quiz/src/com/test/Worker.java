package com.test;

public class Worker extends Person implements UserInter {

	public Worker(){}
	
	public Worker(String name,String user,String password, String profession){
		super( name, user, password, profession);
	}
	
	@Override
	public void onLine() {
		System.out.println(super.getName() + "开始干活了！");
		
	}

	@Override
	public void offLine() {
		System.out.println(super.getName() +"干完了！，回家");
		
	}
	
	public void offWork() {
		System.out.println(super.getName() + "没领到薪水，罢工了！");
	}

}
