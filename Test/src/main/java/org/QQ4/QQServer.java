package org.QQ4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
    private BufferedReader sbr;
    private PrintWriter spw;

    public void setSbr(Socket socket) {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            sbr = new BufferedReader(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSpw(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            spw = new PrintWriter(osw, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QQServer() {
        try {
            ServerSocket ss = new ServerSocket(8005);
            Socket socket = ss.accept();
            setSbr(socket);
            setSpw(socket);
            boolean flag = false;
            do {
                if (sbr.ready()) {
                    flag = checkLogin(sbr);
                    if (false == flag) {
                        spw.println("ERR");
                    }
                }
            } while (false == flag);
            spw.println("OK");
            getReady();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getReady() {
        try {
            File qqMessage = new File("/Users/zhaojunpeng/Documents/development/test/qqMessage.qq");
            if(!qqMessage.exists())
                qqMessage.createNewFile();
            FileReader fr = new FileReader(qqMessage);
            BufferedReader fbr = new BufferedReader(fr);
            FileWriter fw = new FileWriter(qqMessage,true);
            PrintWriter fpw = new PrintWriter(fw,true);
            while (true) {
                if (sbr.ready()) {
                    String message = sbr.readLine();
                    if ("init".equals(message)) {
                    String result = "";
                    while(fbr.ready()){
                        result += fbr.readLine()+"&&";
                    }
                    System.out.println("返回结果是"+result);
                    spw.println(result);
                    } else {
                      fpw.println(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkLogin(BufferedReader br) {
        try {
            String users = br.readLine();
            if ("aaa".equals(users.split("&&")[0]) && "111".equals(users.split("&&")[1])) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        QQServer server = new QQServer();
    }
}
