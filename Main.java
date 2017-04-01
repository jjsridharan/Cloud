import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.lang.*;
import java.util.*;
public class Main //extends JFrame
{
       JButton b1,b2;
    String host,user,pass;
    JFrame f;
    Main()
    {
        f=new JFrame("buttons");
    
        f.setSize(1300,700);
        f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
        JLabel n=new JLabel("",JLabel.CENTER);
        n.setText("Options in FTP");
        n.setFont(new Font("Serif", Font.PLAIN, 18));
        n.setSize(1320,200);
        b1=new JButton("Cloud SAAS");
        b2=new JButton("FTP ZIP");
        b1.setBounds(600,230,170,25);
        b2.setBounds(600,300,170,25);
        b2.addActionListener(new ActionListener() {
		String s[];
       	        public void actionPerformed(ActionEvent arg0) { 
       	        new Host1();
  f.dispose(); }    });
	b1.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0)
       	         { 
        		String s[]=new String[10];
       	   		new Host();
       	   		f.dispose();      
              	}   
            });
		
        f.add(b1);
        f.add(n);
        f.add(b2);
        f.setLayout(null);
        f.setVisible(true);
     }	

    public static void main(String args[])
    {
        new Main();
    }
}
