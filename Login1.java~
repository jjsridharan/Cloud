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
 class Login1 extends JFrame
    {
    JButton b;
    JLabel l1,verify;
    JTextField area2;
    JPasswordField area1;
    FTPClient ftpClient;
    String server;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction();    
        Login1()
	{
	
	}
    	Login1(FTPClient c,String hos)
    	{
    	setTitle("Login page");
    	setSize(1200,700);
    	server=hos;
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
    	b=new JButton("Login");
    	b.setBounds(530,280,80,25);
    	add(b);
	b.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent arg0) { }    });
	b.setAction(action_1);
	area1=new JPasswordField();
	area2=new JTextField();
	area1.setBounds(550,200,200,20);
	area1.setBackground(Color.white);
	area2.setBounds(550,160,200,20);
	area2.setBackground(Color.white);
	add(area1);
	add(area2);
	JLabel head=new JLabel("",JLabel.CENTER);
	JLabel user=new JLabel("",JLabel.CENTER);
	JLabel pass=new JLabel("",JLabel.CENTER);
	head.setText("Login Verfication");
	head.setFont(new Font("Serif", Font.PLAIN, 18));
	head.setSize(1180,200);
	user.setText("Username :");
	pass.setText("Password :");
	user.setSize(1000,335);
	pass.setSize(1000,420);
	add(head);
	add(user);
	add(pass);
	setLayout(null);
	setVisible(true);
    	setSize(1300,700);
	ftpClient=c;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	}
	private class SwingAction extends AbstractAction 
	{
   		 public SwingAction()
   		 {
        		putValue(NAME, "Login");
        		putValue(SHORT_DESCRIPTION, "Some short description");
    		}
		public void actionPerformed(ActionEvent e)
		{
        String user =String.valueOf(area1.getPassword());
        String pass = area2.getText();
        
        try {
            
            boolean success = ftpClient.login(pass, user); 
            if (!success) {
                System.out.println("Could not login to the server"+user+pass);
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
       			 new butt(ftpClient,server,pass,user);
					dispose();
            }
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
    		}
    	}
    	public static void main(String args[])
    	{
    		new Login();
    	}
   }
