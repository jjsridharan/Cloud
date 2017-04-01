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
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


class list
{
     JFrame f;
     JButton b1,b2,v;
     JLabel l,m,n;
     JTextArea ta;
     JTextField t1,t2;
     JScrollPane scrolltxt;
	 private final static String newline = "\n";
	 String host,user,passwd;
	 FTPClient ftpClient;
	void fun()
	{
		try{
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
       	   	t1.setText("");
		    ta.setText("");
			String[] files = ftpClient.listNames();
			if (files != null && files.length > 0) 
			{
			    for (String aFile: files) {
					ta.append(aFile+newline);     
              	}
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			} 
	}

	list()
	{
	
	}
	list(FTPClient ftp,String hst,String us,String pas) 
	{
    		f=new JFrame();
         	ftpClient=ftp;
	        host=hst;
            user=us;
            passwd=pas;
    		f.setVisible(true);
    		f.setLayout(null);
    		f.setSize(1360,720);
    		f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
    		ta=new JTextArea();
    		ta.setBounds(5,5,100,200);
    		ta.setEditable(false);
    		l=new JLabel("",JLabel.CENTER);
    		l.setText("List of files in FTP");
    		l.setSize(300,150);
    		f.add(l);
		    scrolltxt=new JScrollPane(ta);
    		scrolltxt.setBounds(100,130,380,500);
			f.add(scrolltxt);
			t1=new JTextField();
			t1.setBounds(730,200,150,25);
			f.add(t1);
			m=new JLabel("",JLabel.CENTER);
			m.setText("Enter directory to change:");
			m.setSize(1250,430);
			f.add(m);
			v=new JButton("FTP options");
			v.setBounds(720,330,120,25);
			f.add(v);
			v.addActionListener(new ActionListener() {
		   	        public void actionPerformed(ActionEvent arg0)
		   	         { 
		   	         
		   	   		new butt(ftpClient,host,user,passwd);   
		   	   		f.dispose();   
		          	}   
		    });
			b1=new JButton("Change Directory");
			b1.setBounds(900,200,150,25);
			f.add(b1);
			fun();
			b1.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0)
       	         {
					 try{
							ftpClient.enterLocalPassiveMode();
						    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
						   	boolean suc=ftpClient.changeWorkingDirectory(t1.getText());     
							t1.setText("");
							ta.setText("");
							String[] files = ftpClient.listNames();
							if (files != null && files.length > 0) 
							{
								for (String aFile: files) {
									ta.append(aFile+newline);     
								}
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						} 
				} 
								  
            });		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
	    new list();
	}
}

