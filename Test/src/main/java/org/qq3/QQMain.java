package org.qq3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class QQMain extends JFrame implements ActionListener {

	private JTextField sendMessage;
	private JTextArea showMessage;
	private BufferedReader br;
	private PrintWriter pw;

	private void setBr(Socket socket) {
		InputStream is;
		try {
			is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			this.br = new BufferedReader(isr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setPw(Socket socket) {
		try {
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			this.pw = new PrintWriter(osw,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public QQMain(Socket socket) throws IOException {
		this.setSize(300,500);
		setBr(socket);
		setPw(socket);
		sendMessage = new JTextField();
		showMessage = new JTextArea();
		JScrollPane jsp = new JScrollPane(showMessage);
		JComboBox box = new JComboBox<>();
		JButton send = new JButton("发送");
		send.addActionListener(this);
		JPanel smallPan = new JPanel(new GridLayout(1,2));
		smallPan.add(box);
		smallPan.add(send);
		JPanel bigPan = new JPanel(new GridLayout(2,1));
		bigPan.add(sendMessage);
		bigPan.add(smallPan);
		setLayout(new BorderLayout());
		add(bigPan,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		init();
	}
	@SuppressWarnings("unused")
	private void init() throws IOException {
		pw.println("before");
		String res = br.readLine();
		System.out.println(res);
		if(!"".equals(res)&&null!=res) {
		showMessage.append(res.replaceAll("&&", "\n"));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(null!=sendMessage.getText()&&!"".equals(sendMessage.getText().trim())) {
			pw.println(sendMessage.getText().trim());
			showMessage.append(sendMessage.getText().trim()+"\n");
			sendMessage.setText("");
		}
	}

}
