package org.qq3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {

	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private File file = new File("/Users/zhaojunpeng/Documents/development/test/message.qq");

	private void setSocket() {
		try {
			ServerSocket ss = new ServerSocket(8003);
			this.socket = ss.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setBr() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			this.br = new BufferedReader(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setPw() {
		OutputStream os;
		try {
			os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			this.pw = new PrintWriter(osw, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public QQServer() {
		setSocket();
		setBr();
		setPw();
		getReady();
	}

	private void getReady() {
		try {
			String message = "";
			do {
				message = br.readLine();
				if (!"aaa".equals(message.split("&&")[0]) && !"111".equals(message.split("&&")[1])) {
					pw.println("ERR");
				}
			} while (!"aaa".equals(message.split("&&")[0]) && !"111".equals(message.split("&&")[1]));
			pw.println("OK");
			FileWriter fw = new FileWriter(file, true);
			@SuppressWarnings("resource")
			PrintWriter pwf = new PrintWriter(fw, true);
			FileReader fr = new FileReader(file);
			BufferedReader brf = new BufferedReader(fr);
			while (true) {
				if(br.ready()) {
				String sendMessage = br.readLine();
				System.out.println(sendMessage);
				if ("before".equals(sendMessage)) {
					String res = "";
					while (brf.ready()) {
						res += brf.readLine() + "&&";
					};
						System.out.println(res);
						pw.println(res);
				} else {
					pwf.println(sendMessage);
				}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		QQServer server = new QQServer();
	}
}
