package util;

public class LoginTool {
    private static int key = 50;
    public  static String keySet(String value){
        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
        }
        return new String(bytes);
    }

    public static void setKey(int key) {
        LoginTool.key = key;
    }

}
