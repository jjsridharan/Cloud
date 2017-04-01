import com.jcraft.jsch.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Cloud extends Thread
{
	static String host,user,pass;
	JFrame f;
	JButton b,b1;
	JTextArea con;
	JTextField area;
	JSch jsch;
	Session session;
	Channel channel;
	StringBuilder ss;
	JScrollPane scroll; 
	int first=0;
	private final Action action_1 = new SwingAction();
	Cloud()
	{
	}
	Cloud(String h,String u,String p)
	{
		host=h;
		user=u;
		pass=p;
	}
	public void run()
	{
						
	}
	public void getApplication()
	{
		f=new JFrame("Select the Application");
		f.setSize(1300,700);
		b=new JButton("Open");
		b.setBounds(530,270,80,25);
		f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
		JLabel head=new JLabel("",JLabel.CENTER);
		JLabel topic=new JLabel("",JLabel.CENTER);
		JLabel host=new JLabel("",JLabel.CENTER);
		JLabel app=new JLabel("",JLabel.CENTER);
		head.setText("Application");
		topic.setText("Cloud using SAAS");
		topic.setFont(new Font("Serif", Font.PLAIN, 18));
		app.setText("Application List :");
		host.setText("Enter the Application Name: ");
		topic.setSize(1150,150);
		app.setSize(1340,800);
		head.setSize(1140,240);
		host.setSize(800,410);	
		area=new JTextField();
		con=new JTextArea();
		con.setEditable(false);
		//, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.setBounds(5,5,500,200);
		String cons="adsfadsf",line=null;
		try
		{		
			 cons = new String(Files.readAllBytes(Paths.get("out.txt")));
		}
		catch(Exception e){System.out.println(e);}
		scroll = new JScrollPane(con);	
		scroll.setBounds(800,380,400,280);	
		con.setText(cons);
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
		f.add(app);
		f.add(scroll);
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
			System.out.println(e.getSource());
				String addr=area.getText();
				if(addr.equals(""))
					System.out.println("Host Address is empty");
				else
				{
					try{
					String cons=new String(Files.readAllBytes(Paths.get("dis.txt")));
					cons=cons.replace("\n","").replace("\r","");
					ss=new StringBuilder("export DISPLAY='"+cons+"'\n");
					ss.append(addr);
					ss.append("\n");
			       		FileWriter fw = new FileWriter("comm.txt");
				        BufferedWriter bw = new BufferedWriter(fw);
				        bw.write(ss.toString());
					bw.flush();
					fw.close();
			       		bw.close();
					InputStream is=new FileInputStream("comm.txt");
					OutputStream os=new FileOutputStream("outs.txt");   
					channel.setInputStream(is);
			       		channel.setOutputStream(os);
			      	  	Thread.sleep(1000);
			      		channel.connect();
					System.out.println("connected");
					f.dispose();
					getApplication();
					}
					catch(Exception ee)
					{
					
					}
				}
    		}
    	}
	public static void main(String ar[])
	{
		try
		{
			Cloud cloud =new Cloud(ar[0],ar[1],ar[2]);
			cloud.jsch=new JSch();		
			cloud.session=cloud.jsch.getSession(cloud.user,cloud.host, 22);
			cloud.session.setX11Host("127.0.0.1");
			cloud.session.setX11Port(6000);
			UserInfo ui=new MyUserInfo();
			cloud.session.setPassword(cloud.pass);
			cloud.session.setUserInfo(ui);
			cloud.session.connect();
			cloud.channel=cloud.session.openChannel("shell");
			cloud.channel.setXForwarding(true);
			try
			{
				String sa=new String("ls /usr/share/applications | awk -F '.desktop' ' { print $1}' -\n");
		       		FileWriter fw = new FileWriter("comm.txt");
		                BufferedWriter bw = new BufferedWriter(fw);
		                bw.write(sa);
		        	bw.flush();
		        	fw.close();
		       		bw.close();
		        	InputStream is=new FileInputStream("comm.txt");
				OutputStream os=new FileOutputStream("out.txt");    
		        	cloud.channel.setInputStream(is);
		       		cloud.channel.setOutputStream(os);
		      	  	Thread.sleep(1000);
		      		cloud.channel.connect();
				Thread.sleep(2000);
				System.out.println("connected");
			}
			catch(Exception ee)
			{
					
			}
			cloud.getApplication();
		}
		catch(Exception e)
		{
			
		}
	}
	public static class MyUserInfo implements UserInfo
	{
	    String password = null;
	    public String getPassphrase() {
		return null;
	    }
	    public String getPassword() {
		return password;
	    }
	    public void setPassword(String passwd) {
		password = passwd;
	    }
	    public boolean promptPassphrase(String message) {
		return false;
	    }
	    public boolean promptPassword(String message) {
		return false;
	    }
	    public boolean promptYesNo(String message) {
		return true;
	    }
	    public void showMessage(String message) {
	    }
	}
}
