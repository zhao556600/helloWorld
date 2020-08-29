package org.QQ2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class QQMain2 extends JFrame implements ActionListener {
    JTextField mess = new JTextField();
    JComboBox box = new JComboBox();
    JTextArea txtContxt = new JTextArea();

    public QQMain2() {
        this.setSize(300, 400);
        JScrollPane jsp = new JScrollPane(txtContxt);
        JButton btn = new JButton("发送");
        btn.addActionListener(this);
        JPanel smallPan = new JPanel(new GridLayout(1, 2));
        smallPan.add(box);
        smallPan.add(btn);
        JPanel bigPan = new JPanel(new GridLayout(2, 1));
        bigPan.add(mess);
        bigPan.add(smallPan);
        this.setLayout(new BorderLayout());
        this.add(bigPan, BorderLayout.NORTH);
        this.add(jsp, BorderLayout.CENTER);
//        this.setVisible(true);
        File file = getFile();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                txtContxt.append(br.readLine()+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("发送".equals(e.getActionCommand())) {
            txtContxt.append(mess.getText() + "\n");
            File file = getFile();
            try {
                FileWriter fw = new FileWriter(file,true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(mess.getText());
                pw.close();
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
            mess.setText("");
        }
    }

    private File getFile() {
        File file = new File("/Users/zhaojunpeng/Documents/development/test/聊天记录2.qq");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
