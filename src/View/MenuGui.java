package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class MenuGui {
    JFrame LogReg = new JFrame();
    JLabel top;
    JButton btnbuku,btnanggota,btnpeminjaman,btnback,btnpengembalian;

    public MenuGui(){
        LogReg.setSize(900,700);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel("=MENU UTAMA=");
        top.setBounds(270,10,700,40);
        top.setFont(new Font("Times New Roman", Font.BOLD,40));
        LogReg.add(top);

        btnbuku = new JButton("ISI SALDO");
        btnbuku.setBounds(270,150,300,50);
        btnbuku.setBackground(Color.CYAN);
        LogReg.add(btnbuku);

        //===== EXIT =====
        btnback = new JButton("EXIT");
        btnback.setBounds(30, 600, 100, 30);
        btnback.setBackground(Color.red);
        LogReg.add(btnback);

        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogReg.dispose();
                LoginGui loginGui = new LoginGui();
            }
        });
        btnbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AkunGui akunGui = new AkunGui();
            }
        });
    }
}