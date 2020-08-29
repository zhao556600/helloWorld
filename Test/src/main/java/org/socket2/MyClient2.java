package org.socket2;

import java.io.*;
import java.net.Socket;

public class MyClient2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8002);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw, true);
            pw.println("悠米");
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
