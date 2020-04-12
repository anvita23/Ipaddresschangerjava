package com.test.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class my_main extends JFrame
{
   JLabel label1, label2, label3, label4, label5;
   JTextField tf1,tf2,tf3,tf4,tf5;
   JButton button;
   static String word1,word2,word3,word4,word5;
   public my_main()
   {
       setLayout(new FlowLayout());
       
       label1 = new JLabel("Enter new IP Address");
       add(label1);
       
       tf1 = new JTextField(20);
       add(tf1);
       
       label2 = new JLabel("Enter new Subnet Mask");
       add(label2);
       
       tf2 = new JTextField(20);
       add(tf2);
       
       label3 = new JLabel("Enter new Default Gateway");
       add(label3);
       
       tf3 = new JTextField(20);
       add(tf3);
       
       label4 = new JLabel("Enter new DNS-1");
       add(label4);
       
       tf4 = new JTextField(20);
       add(tf4);
       
       label5 = new JLabel("Enter new DNS-2");
       add(label5);
       
       tf5 = new JTextField(20);
       add(tf5);
       
       button =new JButton("Apply");
       add(button);
       
       event e =new event();
       button.addActionListener(e);    
   }
   public void runner()
   {
	    String adapter_name="Wi-fi";
		String ip_address=word1;
		String subnet_mask=word2;
		String default_gateway=word3;
		String dns_1=word4;
		String dns_2=word5;
		String[] command ={"cmd",};
	    Process p;
		
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("netsh int ip set address "+adapter_name+" static "+ip_address+" "+subnet_mask+" "+default_gateway);
	                stdin.println("netsh int ip set dns "+adapter_name+" static "+dns_1+" primary");
	                stdin.println("netsh interface ip add dns "+adapter_name+" "+dns_2+" INDEX=2");
		                stdin.close();
	                p.waitFor();
	    
   }
   public class event implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
                word1=tf1.getText();
                word2=tf2.getText();
                word3=tf3.getText();
                word4=tf4.getText();
                word5=tf5.getText();
                runner();
            }
            catch(Exception ex){
                System.out.println("problem with input");
            }
        }
    }
   public static void main(String[] args)
   {
               my_main gui= new my_main();
               gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               gui.setSize(300,300);
               gui.setTitle("Input");
               gui.setVisible(true);
               
	}	
    }
