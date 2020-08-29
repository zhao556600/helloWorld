import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestMyKey {
    public static void main(String[] args) {
        File file = new File("/Users/zhaojunpeng/Documents/development/test/key.key");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            for(int i=0;i<128;i++){
                fos.write((int)(Math.random()*128));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
