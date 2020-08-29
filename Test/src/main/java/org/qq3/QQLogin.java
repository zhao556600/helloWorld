package org.qq3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class QQLogin extends JFrame implements ActionListener {
	private JTextField account;
	private JTextField password;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	private void setSocket() {
		try {
			this.socket = new Socket("127.0.0.1", 8003);
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

	/**
	 * 
	 */
	public QQLogin() {
		this.setSize(300, 125);
		account = new JTextField();
		password = new JTextField();
		JLabel userAccount = new JLabel("用户名");
		JLabel userPassword = new JLabel("密码");
		JPanel user = new JPanel(new GridLayout(2, 2));
		user.add(userAccount);
		user.add(account);
		user.add(userPassword);
		user.add(password);
		JButton login = new JButton("登陆");
		login.addActionListener(this);
		JButton reg = new JButton("注册");
		reg.addActionListener(this);
		JButton canel = new JButton("取消");
		canel.addActionListener(this);
		JPanel btn = new JPanel(new FlowLayout());
		btn.add(login);
		btn.add(reg);
		btn.add(canel);
		setSocket();
		setBr();
		setPw();
		this.setLayout(new BorderLayout());
		this.add(user, BorderLayout.NORTH);
		this.add(btn, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if ("登陆".equals(e.getActionCommand())) {
				if (null != account.getText() && !"".equals(account.getText().trim()) && null != password.getText()
						&& !"".equals(password.getText().trim())) {
					pw.println(account.getText() + "&&" + password.getText());
					if ("OK".equals(br.readLine())) {
						QQMain main = new QQMain(socket);
						setVisible(false);
						main.setVisible(true);
					} else {
						account.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(this, "账号验证错误，请重新输入");
					}
				} else {
					account.setText("");
					password.setText("");
					JOptionPane.showMessageDialog(this, "请输入正确的账号，密码");
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		QQLogin login = new QQLogin();
	}

}
