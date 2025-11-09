/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul06;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gf63
 */
public class ContohFlowLayout {
    public static void main(String[] args) {

        JFrame frame = new JFrame("COntoh Flowlayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // 2. buat panel container
        //jframe secara default sudah menggunakan FlowLayout
        JPanel panel = new JPanel();

        panel.add(new JButton("Tombol  1"));
        panel.add(new JButton("Tombol  2"));
        panel.add(new JButton("Tombol  tiga"));
        panel.add(new JButton("Tombol  Empat panjang"));
        panel.add(new JButton("Tombol  5"));

        frame.add(panel);

        frame.setVisible(true);
    }
}
