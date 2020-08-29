package org.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("监听前");
          Socket s= ss.accept();
            System.out.println("监听后");
            InputStream is =s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            //System.out.println(br.readLine());
            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw,true);
            pw.println("欢迎你"+br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
