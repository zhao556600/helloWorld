package org.QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class QQMain extends JFrame implements ActionListener {
    JTextField txtmess = new JTextField();
    JComboBox cmbUser = new JComboBox();
    JTextArea txtContent = new JTextArea();

    public QQMain() {
        this.setSize(300, 400);
        JButton btnSend = new JButton("发送");
        JScrollPane spContent = new JScrollPane(txtContent);
        btnSend.addActionListener(this);
        JPanel panSmall = new JPanel();
        panSmall.setLayout(new GridLayout(1, 2));
        panSmall.add(cmbUser);
        panSmall.add(btnSend);
        JPanel panBig = new JPanel();
        panBig.setLayout(new GridLayout(2, 1));
        panBig.add(txtmess);
        panBig.add(panSmall);
        this.setLayout(new BorderLayout());
        this.add(panBig, BorderLayout.NORTH);
        this.add(spContent, BorderLayout.CENTER);
        File file = new File("/Users/zhaojunpeng/Documents/development/test/聊天记录.qq");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                txtContent.append(br.readLine()+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          txtContent.append(txtmess.getText()+"\n");
        File f = new File("/Users/zhaojunpeng/Documents/development/test/聊天记录.qq");
        try {
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(txtmess.getText());
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        txtmess.setText("");
    }
}
