package Java.util.exception;

import Java.util.RegisterOrLoginByXML;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileAddress {
    public static final File FILE = new File("src\\users.xml");

    public static void main(String[] args) throws IOException, RegisterException {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String b = input.nextLine();
        RegisterOrLoginByXML registerOrLoginByXML = new RegisterOrLoginByXML();
        registerOrLoginByXML.Register();
    }


}
