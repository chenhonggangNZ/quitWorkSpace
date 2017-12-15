package Java.util;

import Java.util.exception.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterOrLoginByXML {
    private static XMLWriter xmlWriter = new XMLWriter();
    private static SAXReader reader = new SAXReader();
    private static String user;
    private static String password;
    private static BigInteger telephone;
    private static Document document;
    public static void Register() throws RegisterException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到注册系统！");
        System.out.println("请输入邮箱号或手机号完成注册！");
        user = input.nextLine();
        RegisterUserIsReasonable(user);
        System.out.println("请输入密码！");
         password = input.nextLine();
        isSafe(password);
        try{
             document = reader.read(FileAddress.FILE);
        } catch (DocumentException e) {
           document = DocumentHelper.createDocument();
        }
        if (document.getRootElement() == null){
            document.addElement("RegisterInfo");
        }
        Element rootElement = document.getRootElement();
        Element element = rootElement.addElement("user");
        element.addAttribute("user",user);
        Element element1 = element.addElement("password");
        element1.addText(password);

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();

        xmlWriter = new XMLWriter(new FileWriter(FileAddress.FILE),outputFormat);
        xmlWriter.write(document);
        xmlWriter.flush();
        xmlWriter.close();
    }

    private static void isSafe(String password) throws RegisterException {
        if (!Pattern.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*).{6,15}$",password)){
           throw new PasswordNotSafeException();
        }
    }



    private static void RegisterUserIsReasonable(String in) throws RegisterException {

       try{
           if (!Pattern.matches("\\d*",in)){
               if (!Pattern.matches("[1][3,4,5,6,7,8]\\d{9}",in)){
                   throw new NumberFormatException();
                }
               isa(in);

           } else {
               if (!Pattern.matches("[1][3,4,5,6,7,8]\\d{9}",in)){
                   throw new TelphoneNumberNonexistentException();
               } else {
                   try {
                       Document read = reader.read(FileAddress.FILE);
                       List<Element> elements = read.getRootElement().elements();
                       for (Element element : elements) {
                           if(element.attribute("user").getValue().equals(in)){
                               throw new UserAlreadyExistsException();
                           }
                       }
                   } catch (DocumentException e1) {
                       System.out.println(e1.getMessage());
                   }
                   throw new MailboxNonexistentException();
               }

           }

       } catch(java.lang.NumberFormatException e){
           isa(in);
       }


    }

    private static void isa(String in) throws UserAlreadyExistsException, MailboxNonexistentException {
        if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,3}",in)){
        } else if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,4}[.][a-z,A-Z]{2,3}",in)){
        } else {
            try {
                Document read = reader.read(FileAddress.FILE);
                List<Element> elements = read.getRootElement().elements();
                for (Element element : elements) {
                    if(element.attribute("user").getValue().equals(in)){
                        throw new UserAlreadyExistsException();
                    }
                }
            } catch (DocumentException e1) {
                e1.printStackTrace();
            }
            throw new MailboxNonexistentException();
        }
    }

    public  static Element Login(String user, String password) throws LoginException {
        boolean flag = false;
        Document read = null;
        try {
            read = reader.read(FileAddress.FILE);
            List<Element> user1 = read.getRootElement().elements("user");
            for (Element element : user1) {
                if (element.attribute("user").getValue().equals(user)){
                    if (element.element("password").getText().equals(password)) {
                        return element;
                    } else {
                        throw new PasswordWrongException();
                    }
                }
            }
            if (flag == false){
                throw new UserNotExistException();
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Element LoginInput() throws LoginException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名！");
        String user = input.nextLine();
        System.out.println("请输入密码！");
        String password = input.nextLine();
        Element login = Login(user, password);
        return login;
    }
}
