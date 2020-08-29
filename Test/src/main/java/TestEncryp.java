import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestEncryp {
//    public static void main(String[] args) {
//        File file = new File("/Users/zhaojunpeng/Documents/development/test/haha1.txt");
//        File file1 = new File("/Users/zhaojunpeng/Documents/development/test/haha2.txt");
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            FileOutputStream fos = new FileOutputStream(file1);
//            int len = fis.available();
//            for(int i=0;i<len;i++){
//                fos.write(fis.read()+100);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//public static void main(String[] args) {
//    File file = new File("/Users/zhaojunpeng/Documents/development/test/src.zip");
//    File file1 = new File("/Users/zhaojunpeng/Documents/development/test/src2.zip");
//    try {
//        FileInputStream fis = new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream(file1);
//        byte[] bytes = new byte[8192];
//        int len = fis.available()/8192;
//        for(int i=0;i<len;i++){
//            fis.read(bytes);
////            for(int j=0;j<bytes.length;j++){
////                bytes[j] = (byte) (bytes[j]+100);
////            }
//            encryp(bytes);
//            fos.write(bytes);
//        }
//        int ss = fis.read(bytes);
////        for(int j=0;j<bytes.length;j++){
////            bytes[j] = (byte) (bytes[j]+100);
////        }
//        encryp(bytes);
//        fos.write(bytes,0,ss);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//
//private static   byte[] encryp(byte[] bytes){
//    for (int i=0;i<bytes.length;i++){
//        bytes[i] = (byte)(bytes[i]+100);
//    }
//    return bytes;
//}
public static void main(String[] args) {
    File orgDoc = new File("/Users/zhaojunpeng/Documents/development/test/haha.txt");
    File enDoc = new File("/Users/zhaojunpeng/Documents/development/test/缅甸蟒.txt");
    try {
        FileInputStream fisOrgDoc = new FileInputStream(orgDoc);
        FileOutputStream fosenDoc = new FileOutputStream(enDoc);
        byte[] bytes = new byte[fisOrgDoc.available()];
        for(int i=0;i<1;i++){
            fisOrgDoc.read(bytes);
            encrycp(bytes);
            fosenDoc.write(bytes);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private  static byte[] encrycp(byte[] args){
    File salt = new File("/Users/zhaojunpeng/Documents/development/test/key.key");
    try {
        FileInputStream fissalt = new FileInputStream(salt);
        int saltLen = fissalt.available();
        int[] key = new int[saltLen];
        int len = fissalt.available();
        for(int i=0;i<len;i++){
            key[i] = fissalt.read();
        }
        for(int i=0;i<args.length;i++){
            args[i] = (byte) (args[i] + key[i % saltLen]);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return args;
}
}
