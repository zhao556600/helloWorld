package org.QQ1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class QQMain1 extends JFrame implements ActionListener {
    JTextField mess = new JTextField();
    JTextArea textContext = new JTextArea();
    JComboBox cmbUser = new JComboBox();

    public QQMain1() {
        this.setSize(300, 400);
        JPanel smallPan = new JPanel(new GridLayout(1, 2));
        JButton sendMess = new JButton("发送");
        smallPan.add(cmbUser);
        smallPan.add(sendMess);
        sendMess.addActionListener(this);
        JPanel bigPan = new JPanel(new BorderLayout());
        bigPan.add(smallPan, BorderLayout.NORTH);
        JScrollPane js = new JScrollPane(textContext);
        bigPan.add(js, BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(mess, BorderLayout.NORTH);
        this.add(bigPan, BorderLayout.CENTER);
        File file = getFile();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                textContext.append(br.readLine()+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (("发送").equals(e.getActionCommand())) {
            textContext.append(mess.getText() + "\n");
            File f = getFile();
            try {
                FileWriter fw = new FileWriter(f, true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(mess.getText());
                pw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            mess.setText("");

        }
    }

    private File getFile() {
        File file = new File("/Users/zhaojunpeng/Documents/development/test/聊天记录1.qq");
        return file;
    }
}
