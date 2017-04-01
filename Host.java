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
public class Host
{
	private final Action action = new SwingAction();
	JTextField area;
	JButton b;
	private final Action action_1 = new SwingAction();
	JFrame f;
	Host()
	{
		f=new JFrame("Cloud Computing");
		f.setSize(1300,700);
		b=new JButton("Verify");
		b.setBounds(530,270,80,25);
		f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
		JLabel head=new JLabel("",JLabel.CENTER);
		JLabel topic=new JLabel("",JLabel.CENTER);
		JLabel host=new JLabel("",JLabel.CENTER);
		head.setText("Host verification");
		topic.setText("Cloud using SAAS");
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
			String addr=area.getText();
			if(addr.equals(""))
				System.out.println("Host Address is empty");
			else
			{
				new Login(addr);
				f.dispose();
			}
    		}
    	}
	public static void main(String args[])
	{
		new Host();
	}
}
