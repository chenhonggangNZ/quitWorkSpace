package com.xinyou.bookstore.user.service;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * Created by zyf on 2017/6/28.
 */
public class SendMessege {

	private String sendAddr = "chenhonggangn@qq.com";//这是发送方的邮箱
	private String receiveAddr = "1763508830@qq.com";//接收方的邮箱
	private String pass = "ahxuzupwzzijdfjh";//这个不是密码,是开启163邮箱第三方登录时候设置的授权码//如果不开启,那么是无法第三方登录163邮箱账号的
	private String sendInfo = "谢谢您的访问www.xinyoubook.com";
	private String theme = "请访问以下网址完成账号激活";
	private File file = null;
	private String filename ="附件.xin";
	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setSendAddr(String sendAddr) {
		this.sendAddr = sendAddr;
	}

	public void setSendInfo(String sendInfo) {
		this.sendInfo = sendInfo;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void t1() throws MessagingException {
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.host", "smtp.qq.com");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.port","465");//25
		prop.setProperty("mail.smtp.ssl.enable","true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendAddr,pass);
			}
		};//我们要登录一个账号,来给别人发邮件//现在先构建一个邮件账号，需要用邮件地址和密码

		Session session = Session.getInstance(prop,auth);//与服务器连接,登录邮箱
		MimeMessage msg = new MimeMessage(session);//创建一个邮件对象
		msg.setFrom(new InternetAddress(sendAddr));//设置发件人
		msg.setRecipients(Message.RecipientType.TO,receiveAddr);//设置收件人
		//添加主题
		msg.setSubject(theme);

		//添加内容,第二个参数表示这是html的内容
		msg.setContent(sendInfo,"text/html;charset=utf-8");
		Transport.send(msg);
	}

	public void t2() throws Exception{

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.port","465");//25
		//prop.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.ssl.enable","true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendAddr,pass);
			}
		};
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		// 设置发件人
		msg.setFrom(new InternetAddress(sendAddr));
		// 设置收件人
		msg.setRecipients(Message.RecipientType.TO, receiveAddr);
		msg.setSubject("带有附件的邮件");
		// 创建多部分内容
		MimeMultipart list = new MimeMultipart();
		// 创建MimeBodyPart 主体部件
		MimeBodyPart part1 = new MimeBodyPart();
		part1.setContent(sendInfo, "text/html;charset=utf-8");
		list.addBodyPart(part1); // 把主体部件添加到多部件主体
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(file); // 设置附件内容
		part2.setFileName(MimeUtility.encodeText(filename));// 显示在附件上的名称 . 会乱码.需要处理,使用 MimeUtility.encodeText处理
		list.addBodyPart(part2);
		msg.setContent(list); // 把多部件设置给邮件内容
		Transport.send(msg);
	}
}
