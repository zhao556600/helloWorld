package org.QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QQLogin extends JFrame implements ActionListener {
    JLabel username = new JLabel("用户名");
    JTextField user = new JTextField();
    JLabel password = new JLabel("密码");
    JTextField pass = new JTextField();
    JButton login = new JButton("登陆");
    JButton reg = new JButton("注册");
    JButton cancel = new JButton("取消");
    public QQLogin(){
        this.setSize(300,250);
        JPanel smallPan = new JPanel();
        smallPan.setLayout(new GridLayout(2,2));
        smallPan.add(username);
        smallPan.add(user);
        smallPan.add(password);
        smallPan.add(pass);
        login.addActionListener(this);
        reg.addActionListener(this);
        cancel.addActionListener(this);
        JPanel btnPan = new JPanel();
        btnPan.setLayout(new FlowLayout());
        btnPan.add(login);
        btnPan.add(reg);
        btnPan.add(cancel);
        this.setLayout(new BorderLayout());
        this.add(smallPan,BorderLayout.NORTH);
        this.add(btnPan, BorderLayout.CENTER);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("登陆")){
           if(user.getText().equals("aaa")&&pass.getText().equals("111")){
              this.setVisible(false);
              QQMain qqMain = new QQMain();
                qqMain.setVisible(true);
           }
       }
       if(e.getActionCommand().equals("注册")){
           System.out.print("用户点击了注册");
       }
       if(e.getActionCommand().equals("取消")){
           System.out.print("用户点击了取消");
       }
    }

    public static void main(String[] args) {
        QQLogin qq = new QQLogin();
    }
}
