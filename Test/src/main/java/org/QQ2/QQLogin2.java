package org.QQ2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QQLogin2 extends JFrame implements ActionListener {
    JTextField user = new JTextField();
    JTextField pass = new JTextField();
    public  QQLogin2(){
        this.setSize(300,250);
        JLabel username = new JLabel("用户");
        JLabel password = new JLabel("密码");
        JButton btnLogin = new JButton("登陆");
        JButton btnreg = new JButton("注册");
        JButton canel = new JButton("取消");
        btnLogin.addActionListener(this);
        btnreg.addActionListener(this);
        canel.addActionListener(this);
        JPanel userPan = new JPanel(new GridLayout(2, 2));
        userPan.add(username);
        userPan.add(user);
        userPan.add(password);
        userPan.add(pass);
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(btnLogin);
        btnPanel.add(btnreg);
        btnPanel.add(canel);
        this.setLayout(new BorderLayout());
        this.add(userPan, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        QQLogin2 qqLogin2 = new QQLogin2();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if("登陆".equals(e.getActionCommand())){
          if("aaa".equals(user.getText())&&"111".equals(pass.getText())){
              this.setVisible(false);
              QQMain2 qqMain2 = new QQMain2();
              qqMain2.setVisible(true);
          }
      }
    }
}
