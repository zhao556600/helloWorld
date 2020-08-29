import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestMain {
    //    public static void main(String[] args) {
//        try {
//            File f = new File("/Users/zhaojunpeng/Documents/development/test/haha.txt");
//            FileInputStream fis = new FileInputStream(f);
//            for(int i=0;i<fis.available();){
//                //System.out.print(fis.available());
//                System.out.print((char)fis.read());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    ///Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/src.zjp
//    }
//    public static void main(String[] args) {
//        File file1 = new File("/Users/zhaojunpeng/Documents/development/test/haha.txt");
//        File file2 = new File("/Users/zhaojunpeng/Documents/development/test/haha1.txt");
//        try {
//            FileInputStream fis = new FileInputStream(file1);
//            FileOutputStream fos = new FileOutputStream(file2);
//            int length = fis.available();
//            for(int i=0;i<length;i++){
//                fos.write(fis.read());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    public static void main(String[] args) {
        File file1 = new File("/Users/zhaojunpeng/Documents/development/test/src.zip");
        File file2 = new File("/Users/zhaojunpeng/Documents/development/test/src1.zip");
        try {
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            byte[] bb = new byte[8192];
            int len = fis.available()/8192;
            for(int i=0;i<len;i++){
                fis.read(bb);
                fos.write(bb);
            }
            int s = fis.read(bb);
            fos.write(bb,0,s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
