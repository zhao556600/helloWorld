package org.QQ1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QQLogin1 extends JFrame implements ActionListener {
    JTextField user = new JTextField();
    JTextField pass = new JTextField();
    JButton login = new JButton("登陆");
    JButton reg = new JButton("注册");
    JButton canel = new JButton("取消");
    public QQLogin1(){
        this.setSize(300,250);
        JLabel username = new JLabel("用户");
        JLabel password = new JLabel("密码");
        JPanel userTex = new JPanel(new GridLayout(2, 2));
        userTex.add(username);
        userTex.add(user);
        userTex.add(password);
        userTex.add(pass);
        JPanel jbut = new JPanel(new FlowLayout());
        jbut.add(login);
        jbut.add(reg);
        jbut.add(canel);
        this.setLayout(new BorderLayout());
        this.add(userTex, BorderLayout.NORTH);
        this.add(jbut, BorderLayout.CENTER);
        login.addActionListener(this);
        reg.addActionListener(this);
        canel.addActionListener(this);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(("登陆").equals(e.getActionCommand())){
          if(("aaa").equals(user.getText())&&("111").equals(pass.getText())){
              this.setVisible(false);
              QQMain1 qqMain1 = new QQMain1();
              qqMain1.setVisible(true);
          }else{
              System.out.print("登陆失败啦");
          }
      }
    }

    public static void main(String[] args) {
        QQLogin1 qqlog = new QQLogin1();
    }
}
