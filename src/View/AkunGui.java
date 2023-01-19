package View;
import Controller.AkunController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class AkunGui {
    private static AkunController akunController = new AkunController();
    JFrame Akun = new JFrame();
    JLabel top,labelsaldo;
    JTextField textsaldo;
    JButton btnubahakun,btnhapus,btnback,btntambahakun;
    JTable tabelakun = new JTable();
    JScrollPane scrolakun = new JScrollPane(tabelakun);
    int index;

    public AkunGui(){

        Akun.setSize(900,700);
        Akun.setLayout(null);
        Akun.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel("E-Wallet");
        top.setBounds(130,10,600,50);
        top.setFont(new Font("Times New Roman", Font.BOLD,40));
        Akun.add(top);

        scrolakun.setBounds(300,180,600,270);
        tabelakun.setModel(akunController.listakun());
        Akun.add(scrolakun);

        labelsaldo = new JLabel("SALDO");
        labelsaldo.setBounds(30,270,100,30);
        Akun.add(labelsaldo);

        textsaldo = new JTextField();
        textsaldo.setBounds(30,300,200,30);
        Akun.add(textsaldo);


        btntambahakun = new JButton("Tambah Saldo");
        btntambahakun.setBounds(50,470,150,30);
        Akun.add(btntambahakun);

        btnubahakun = new JButton("Ubah Saldo");
        btnubahakun.setBounds(50,510,150,30);
        Akun.add(btnubahakun);

        btnhapus = new JButton("Hilangkan Saldo");
        btnhapus.setBounds(50,550,150,30);
        Akun.add(btnhapus);

        btnback = new JButton("back");
        btnback.setBounds(30, 600, 100, 30);
        btnback.setBackground(Color.red);
        Akun.add(btnback);

        Akun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Akun.setVisible(true);
        Akun.setLocationRelativeTo(null);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Akun.dispose();
                MenuGui menuGui = new MenuGui();
            }
        });

        btntambahakun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String saldo = (textsaldo.getText());
                    allobjcontroller.akunController.insert(saldo);
                    JOptionPane.showMessageDialog(null,"Input saldo Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelakun.setModel(allobjcontroller.akunController.listakun());
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } );

        btnubahakun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String saldo = (textsaldo.getText());
                    allobjcontroller.akunController.update(index,saldo);
                    JOptionPane.showMessageDialog(null,"Ubah saldo Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelakun.setModel(allobjcontroller.akunController.listakun());
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } );
        tabelakun.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelakun.getSelectedRow();
                index=i;
                textsaldo.setText(allobjcontroller.akunController.listakun().getValueAt(i, 0).toString());
            }
        });

        btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    allobjcontroller.akunController.delete(index);
                    JOptionPane.showMessageDialog(null,"Menghilangkan saldo Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    tabelakun.setModel(allobjcontroller.akunController.listakun());
                    reset();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }
    void reset(){
        textsaldo.setText(null);
    }
}
