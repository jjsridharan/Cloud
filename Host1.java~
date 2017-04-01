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
public class Host1 //extends JFrame
{
	private final Action action = new SwingAction();
	JTextField area;
	JButton b;
	private final Action action_1 = new SwingAction();
	JFrame f;
	Host1()
	{
		f=new JFrame("My Application");
		f.setSize(1300,700);
		//f.getContentPane().setBackground("new.jpg");
		b=new JButton("Verify");
		b.setBounds(530,270,80,25);
		f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
		JLabel head=new JLabel("",JLabel.CENTER);
		JLabel topic=new JLabel("",JLabel.CENTER);
		JLabel host=new JLabel("",JLabel.CENTER);
		head.setText("Host verification");
		topic.setText("FTP By zipping and uploading");
		topic.setFont(new Font("Serif", Font.PLAIN, 18));
		host.setText("Enter the Host Address(or IP address) : ");
		topic.setSize(1150,150);
		head.setSize(1140,240);
		host.setSize(800,410);	
		area=new JTextField();
		area.setBounds(550,200,200,20);
		area.setBackground(Color.white);	
		f.add(b);
		b.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0) { }    });
		b.setAction(action_1);
		f.add(topic);
		f.add(area);
		f.add(head);
		f.add(host);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction 
	{
   		 public SwingAction()
   		 {
        		putValue(NAME, "Verify");
        		putValue(SHORT_DESCRIPTION, "Verify Host");
    		}
		public void actionPerformed(ActionEvent e)
		{
			String server = area.getText();
        		int port = 21;
        		FTPClient ftpClient = new FTPClient();
			try
			 {
System.out.println(server);
			 	if(!server.equals(""))
			    ftpClient.connect(server,port);
			   ftpClient.enterLocalPassiveMode();
			    int replyCode = ftpClient.getReplyCode();
			   // if (!FTPReply.isPositiveCompletion(replyCode)) {
				//System.out.println("Operation failed. Server reply code: " + replyCode);
				//return;
			 //}
			//else{
				System.out.println("Successfully Verified\n");
				f.dispose();
				new Login1(ftpClient,server);
			//}
			  
			} catch (IOException ex) {
			    System.out.println("Oops! Something wrong happened");
			    ex.printStackTrace();
			}
    		}
    	}
	public static void main(String args[])
	{
		new Host1();
	}
}
