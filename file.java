import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFile;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;


public class file extends JFrame
{
	List<String> files = new ArrayList<String>();
	public void zipFiles(List<String> files)
  {
         
        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("testing.zip");
            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
            for(String filePath:files){
                File input = new File(filePath);
                fis = new FileInputStream(input);
                ZipEntry ze = new ZipEntry(input.getName());
                System.out.println("Zipping the file: "+input.getName());
                zipOut.putNextEntry(ze);
                byte[] tmp = new byte[4*1024];
                int size = 0;
                while((size = fis.read(tmp)) != -1){
                    zipOut.write(tmp, 0, size);
                }
                zipOut.flush();
                fis.close();
            }
            zipOut.close();
            System.out.println("Done... Zipped the files...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(fos != null) fos.close();
            } catch(Exception ex){
                 
            }
        }
}

	JTextArea a1;
	JButton b,v;
	JFrame f;
	boolean cho=true;
	private final static String newline = "\n";
	//private final static String newline="\n";
	JTextField t;
	 FTPClient ftpClient;
	JScrollPane scroll; 
	String ser,user,passwd;
	file()
	{
			
	}
	public file(FTPClient ftp,String seri,String use,String pass)
	{
		f=new JFrame("my");
		ser=seri;
		user=use;
		passwd=pass;
		ftpClient=ftp;
		f.setSize(1300,700);
		f.setTitle("FILE UPLOAD");
		f.setContentPane(new JLabel(new ImageIcon("pic6.jpg")));
		JLabel he=new JLabel("",JLabel.CENTER);
		JLabel d=new JLabel("",JLabel.CENTER);
		d.setText("Files so far selected :");
		he.setText("FILE UPLOAD");
		he.setFont(new Font("Serif", Font.PLAIN, 18));
		t= new JTextField();	
		t.setBounds(600,180,230,25);
		JLabel chf=new JLabel("",JLabel.CENTER);
		JLabel adf=new JLabel("",JLabel.CENTER);
		chf.setText("File Chosen : ");
		a1=new JTextArea();
		a1.setEditable(false);
		//, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		a1.setBounds(5,5,100,200);
		 b=new JButton("choose");
		JButton n=new JButton("upload");
		n.setBounds(600,500,90,25);
		v=new JButton("FTP options");
		v.setBounds(930,330,120,25);
		b.setBounds(850,180,90,25);
		chf.setSize(1080,390);
		d.setSize(1000,470);
		he.setSize(1250,100);
		scroll = new JScrollPane(a1);	
		scroll.setBounds(600,220,230,240);	
		f.add(he);
		f.add(chf);
		//f.add(a1);
		f.add(t);
		f.add(d);
		//f.add(x);
		f.add(b);
		f.add(n);
		f.add(v);
		v.addActionListener(new ActionListener() {
       	        public void actionPerformed(ActionEvent arg0)
       	         { 
       	         
       	   		new butt(ftpClient,ser,user,passwd);      
       	   		f.dispose();
              	}   
            });
		f.add(scroll);
	        b.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent ae) 
		{
		String s="s";
		if(cho)
		{
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
				{
				  s="SADf";
				  s= ""+chooser.getSelectedFile();
				  t.setText(s); 
				  cho=!cho;
				  b.setText("add");
				} 
				else
				{
				  System.out.println("No Selection ");
				}	
		}
		else
		{
			String n=t.getText();
			a1.append(n+newline);
			files.add(n);
			t.setText(null);
			b.setText("Choose");
			cho=!cho;
		}
		}
    		});
		n.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent ae) 
		{
			file ff=new file();	
			ff.zipFiles(files);		
			 try
        	{
  
                InputStream in = new FileInputStream("testing.zip");
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);		
                ftpClient.enterLocalPassiveMode();
                boolean Store = ftpClient.storeFile("testing.zip", in);
		System.out.println(ftpClient.getReplyString());
                in.close();
                a1.setText("");
			Connection conn = new Connection(ser);
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(user, passwd);

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");
			Session sess = conn.openSession();

			sess.execCommand("unzip testing.zip");

			System.out.println("Here is some information about the remote host:");
			InputStream stdout = new StreamGobbler(sess.getStdout());
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
			while (true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			System.out.println("ExitCode: " + sess.getExitStatus());
			sess.close();
			sess=conn.openSession();
			sess.execCommand("rm testing.zip");
			sess.close();
			conn.close();
			JOptionPane.showMessageDialog(null,"File Uploaded Successully");
            
        	}
        catch(Exception e)
        {
            System.out.println(e);
        }

		}
    		});

		JTextArea a1 = new JTextArea ("Test");	
		f.setVisible(true);
		f.setLayout(null);
		f.setVisible(true);	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public static void main(String args[])
	{
		new file();
	}
}
