import java.io.*;

public class TestReadFile {
//    public static void main(String[] args) {
//        File file = new File("/Users/zhaojunpeng/Documents/development/test/haha.txt");
//        try {
//            FileReader fr = new FileReader(file);
////            System.out.print((char)(fr.read()));
//            BufferedReader br = new BufferedReader(fr);
//            while (br.ready()){
//                System.out.print(br.readLine());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
public static void main(String[] args) {
    File file = new File("/Users/zhaojunpeng/Documents/development/test/haha.txt");
    File newFile = new File("/Users/zhaojunpeng/Documents/development/test/haha2.txt");
    try {
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(newFile);
        BufferedReader br = new BufferedReader(fr);
        PrintWriter pw = new PrintWriter(fw);
        while (br.ready()){
            pw.println(br.readLine());
        }
        pw.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
