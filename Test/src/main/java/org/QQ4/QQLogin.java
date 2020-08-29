package org.QQ4;

import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class QQLogin extends JFrame implements ActionListener {
    private JTextField account;
    private JTextField password;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public void setBr(Socket socket) {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPw(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            pw = new PrintWriter(osw,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QQLogin() {
        try {
            socket = new Socket("127.0.0.1", 8005);
            setBr(socket);
            setPw(socket);
            this.setSize(300, 125);
            JLabel username = new JLabel("账号");
            JLabel pass = new JLabel("密码");
            account = new JTextField();
            password = new JTextField();
            JPanel users = new JPanel(new GridLayout(2, 2));
            users.add(username);
            users.add(account);
            users.add(pass);
            users.add(password);
            JButton login = new JButton("登陆");
            JButton reg = new JButton("注册");
            JButton canel = new JButton("取消");
            JPanel btn = new JPanel(new FlowLayout());
            login.addActionListener(this);
            reg.addActionListener(this);
            canel.addActionListener(this);
            btn.add(login);
            btn.add(reg);
            btn.add(canel);
            setLayout(new BorderLayout());
            add(users, BorderLayout.NORTH);
            add(btn, BorderLayout.CENTER);
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QQLogin log = new QQLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        if ("登陆".equals(e.getActionCommand())) {
            if (null != account.getText() && !"".equals(account.getText()) &&
                    null != password.getText() && !"".equals(password.getText())
            ) {
                String message = account.getText() + "&&" + password.getText();
                System.out.println(message);
                pw.println(message);
                String result = br.readLine();
                //System.out.println(result);
                    if("OK".equals(result)){
                        QQMain qqMain = new QQMain(this.socket,this.br,this.pw);
                        this.setVisible(false);
                        qqMain.setVisible(true);
                    }else{
                        account.setText("");
                        password.setText("");
                        JOptionPane.showMessageDialog(this,"验证失败，请重新登陆");
                    }

            } else {
                account.setText("");
                password.setText("");
                JOptionPane.showMessageDialog(this, "请输入用户名或密码");
            }
        }
        if ("注册".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "还没有做出注册功能");
        }
        if ("取消".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(this, "还没有做出取消功能");
        }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
