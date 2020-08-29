package org.socket1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8001);
            System.out.println("接通前");
            Socket s = ss.accept();
            System.out.println("接通后");
            InputStream is =s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String mess = br.readLine();
            System.out.println(mess);

            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw, true);
            pw.println("欢迎你"+mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
