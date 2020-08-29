import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestDecrypy {
//    public static void main(String[] args) {
//        File file = new File("/Users/zhaojunpeng/Documents/development/test/haha2.txt");
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            int len = fis.available();
//            for (int i = 0; i < len; i++) {
//                System.out.print((char) (fis.read() - 100));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//public static void main(String[] args) {
//    File file = new File("/Users/zhaojunpeng/Documents/development/test/src2.zip");
//    File file2 = new File("/Users/zhaojunpeng/Documents/development/test/src3.zip");
//    try {
//        FileInputStream fis = new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream(file2);
//        byte[] bytes = new byte[8192];
//        int length = fis.available()/8192;
//        for(int i=0;i<length;i++){
//            fis.read(bytes);
//            Decrypy(bytes);
//            fos.write(bytes);
//        }
//        int ss = fis.read(bytes);
//        Decrypy(bytes);
//        fos.write(bytes,0,ss);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//}
//private static byte[] Decrypy(byte[] args){
//    for(int i=0;i<args.length;i++){
//        args[i] = (byte)(args[i]-100);
//    }
//    return args;
//}
public static void main(String[] args) {
    File mPython = new File("/Users/zhaojunpeng/Documents/development/test/缅甸蟒.txt");
    try {
        FileInputStream fis = new FileInputStream(mPython);
        byte[] bytes = new byte[fis.available()];
        for (int i=0;i<1;i++){
            fis.read(bytes);
            decrypy(bytes);
            System.out.print(new String(bytes));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private  static  byte[] decrypy(byte[] args){
    File salt = new File("/Users/zhaojunpeng/Documents/development/test/key.key");
    try {
        FileInputStream fisSalt = new FileInputStream(salt);
        int saltLen = fisSalt.available();
        int[] key = new int[saltLen];
        for(int i=0;i<saltLen;i++){
            key[i] = fisSalt.read();
        }
        for(int i=0;i<args.length;i++){
            args[i] = (byte) (args[i] - key[i%saltLen]);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return args;
}
}
