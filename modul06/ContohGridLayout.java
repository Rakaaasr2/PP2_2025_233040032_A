/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul06;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 *
 * @author gf63
 */
public class ContohGridLayout {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("COntoh Gridlayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        frame.setLayout(new GridLayout (3, 2, 5, 5));
        
        
        frame.add(new JLabel("Tombol  1"));
        frame.add(new JTextField());
        frame.add(new JLabel("Tombol  2"));
        frame.add(new JPasswordField());
        frame.add(new JButton("Login"));
        frame.add(new JButton("batal"));
       
        
        frame.setVisible(true);
    }
}
