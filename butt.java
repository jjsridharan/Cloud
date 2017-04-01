import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
 
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
public class butt //extends JFrame
{
       JButton b1,b2,b3,b4;
    FTPClient ftpClient;
    String host,user,pass;
    JFrame f;
    butt()
	{

	}
    butt(FTPClient ft,String ser,String us,String pas)
    {
        f=new JFrame("buttons");
        ftpClient=ft;
        host=ser;
        user=us;
	pass=pas;
        f.setSize(1300,700);
        f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
        JLabel n=new JLabel("",JLabel.CENTER);
        n.setText("Options in FTP");
        n.setFont(new Font("Serif", Font.PLAIN, 18));
        n.setSize(1320,200);
        b1=new JButton("Upload");
        b2=new JButton("Download");
        b3=new JButton("File list");
	b4=new JButton("Cloud Saas");
        b1.setBounds(600,230,170,25);
        b2.setBounds(600,300,170,25);
        b3.setBounds(600,370,170,25);
	b4.setBounds(600,440,170,25);
        b2.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0) { 
       	        new newdown(ftpClient,host,user,pass);
  f.dispose(); }    });
	 b3.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0)
       	         { 
       	         
       	   		new list(ftpClient,host,user,pass);
       	   		f.dispose();      
              	}   
            });
	b1.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0)
       	         { 
       	         
       	   		new file(ftpClient,host,user,pass);
       	   		f.dispose();      
              	}   
            });
	b4.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0)
       	         {
			String s[]={host,user,pass};
			Cloud c=new Cloud();
			c.main(s);
			f.dispose();
				 
       	         }   
            });
        f.add(b1);
        f.add(n);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.setLayout(null);
        f.setVisible(true);
     }	

    public static void main(String args[])
    {
        new butt();
    }
}
