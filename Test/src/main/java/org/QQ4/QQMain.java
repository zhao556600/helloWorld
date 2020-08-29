package org.QQ4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class QQMain extends JFrame implements ActionListener {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private JTextField sendMessage;
    private JTextArea textContext;
    public QQMain(Socket socket,BufferedReader br,PrintWriter pw){
        this.socket = socket;
        this.br = br;
        this.pw = pw;
        this.setSize(600,800);
        this.sendMessage = new JTextField();
        JPanel smallPan = new JPanel(new GridLayout(1,2));
        JComboBox box = new JComboBox();
        JButton  sendBtn = new JButton("发送");
        sendBtn.addActionListener(this);
        smallPan.add(box);
        smallPan.add(sendBtn);
        this.textContext = new JTextArea();
        JScrollPane jsp = new JScrollPane(textContext);
        JPanel bigPan = new JPanel(new GridLayout(2,1));
        bigPan.add(sendMessage);
        bigPan.add(smallPan);
        this.setLayout(new BorderLayout());
        this.add(bigPan,BorderLayout.NORTH);
        this.add(jsp,BorderLayout.CENTER);
       // this.setVisible(true);
        init(this.br,this.pw);
    }
    private void init(BufferedReader br,PrintWriter pw){
        try {
            pw.println("init");
            String result = br.readLine();
            if(null!=result&&!"".equals(result));
            textContext.append(result.replaceAll("&&","\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = sendMessage.getText().trim();
        if(null!=message&&!"".equals(message)){
            pw.println(message);
            textContext.append(message+"\n");
            sendMessage.setText("");
        }

    }
}
