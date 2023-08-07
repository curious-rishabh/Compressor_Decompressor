/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author beast
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(30,100,200,30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to Decompress");
        decompressButton.setBounds(300,100,220,30);
        decompressButton.addActionListener(this);
        
        this.setLayout(null);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(600,500);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        if compress button pressed
        if(e.getSource() ==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                    
                }
                catch(IOException ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                    
                }
                catch(IOException ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        
    }
            
            
            
            
    
}
