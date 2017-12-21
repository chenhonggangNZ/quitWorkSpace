package com.test;

public class Doctor extends Person implements UserInter {

	public Doctor(){}
	
	public Doctor(String name,String user,String password, String profession){
		super( name, user, password, profession);
	}
	
	@Override
	public void onLine() {
		System.out.println(super.getName() + "上班，开始坐诊了！");
		
	}

	@Override
	public void offLine() {
		System.out.println(super.getName() + "下班，回家陪亲人了！");
		
	}
	
	public void operation() {
		System.out.println(super.getName() + "正在给病人做手术！");
	}

}
