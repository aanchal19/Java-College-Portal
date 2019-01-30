/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Pagee3 implements ActionListener,ItemListener
{
	JFrame f;
	JTextField[] tf=new JTextField[8];
	JLabel[] l = new JLabel[10];
        JLabel l1=new JLabel();
	JPasswordField[] pf = new JPasswordField[2];
	JPanel p;
	JButton b1,b2,b3;
	ImageIcon image1,image;
	String s;
	JComboBox cb,day,month,year;
	Pagee3()
	{
		f = new JFrame("Student Registration");
		f.setSize(1536,1536);
		l1=new JLabel();
                 l1.setBounds(0,110,1536,600);
               l1.setIcon(ResizImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13_1\\src\\imge\\online-business-ideas-male-hand-holding-computer-mouse-with-laptop-keyboard-in-the-background-929912106-5be498ff46e0fb0051062280.jpg"));
        
               l[0] = new JLabel("Fill the Student details");
		l[0].setBounds(50,20,300,100);
		l[0].setFont(l[0].getFont().deriveFont(24.0f));
		JSeparator sep = new JSeparator();
		sep.setBounds(0,110,1536,100);
		f.add(sep);
		l[1] = new JLabel("ID:");
		l[1].setBounds(200,100,210,200);
		l[2] = new JLabel("Name:");
		l[2].setBounds(200,150,210,200);
		l[3] = new JLabel("DOB:");
		l[3].setBounds(200,200,210,200);
		l[4] = new JLabel("Gender:");
		l[4].setBounds(200,250,210,200);
		l[5] = new JLabel("Email-ID:");
		l[5].setBounds(200,300,210,200);
		l[6] = new JLabel("Contact No.:");
		l[6].setBounds(200,350,210,200);
		l[7] = new JLabel("Create Password:");
		l[7].setBounds(200,400,210,200);
		l[8] = new JLabel("Confirm Password:");
		l[8].setBounds(200,450,210,200);
		
		
		
		l[9] = new JLabel();
		l[9].setOpaque(true);
		l[9].setBackground(Color.WHITE);
		l[9].setBounds(750,200,200,200);
		
		f.add(l[9]);
		
		for(int i=0;i<9;i++)
		{
			f.add(l[i]);
		}
		
		
		tf[0] = new JTextField();
		tf[0].setBounds(400,190,170,30);
		tf[1] = new JTextField();
		tf[1].setBounds(400,240,170,30);
		
		String day_arr[]=new String[31];
		for(int i=1;i<=31;i++)
			day_arr[i-1]=Integer.toString(i); 
		day=new JComboBox(day_arr);
		day.setBounds(400,290,40,30);
		
		String month_arr[]={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		month=new JComboBox(month_arr);
		month.setBounds(450,290,55,30);
 
		String year_arr[]=new String[20];
		for(int i=1990;i<=2000;i++)
			year_arr[i-1990]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(510,290,60,30);
 
		f.add(day);
		f.add(month);
		f.add(year);
		
		String sex[] = {"Male","Female"};
		cb = new JComboBox(sex);
		cb.setBounds(400,340,170,30);
		f.add(cb);
		tf[2] = new JTextField();
		tf[2].setBounds(400,390,170,30);
		tf[3] = new JTextField();
		tf[3].setBounds(400,440,170,30);
		pf[0] = new JPasswordField();
		pf[0].setBounds(400,490,170,30);
		pf[1] = new JPasswordField();
		pf[1].setBounds(400,540,170,30);
		
		for(int i=0;i<4;i++)
		{
			f.add(tf[i]);
		}
		f.add(pf[0]);
		f.add(pf[1]);
		
		b1 = new JButton("Create");
		b2 = new JButton("Clear");
		b3 = new JButton("Browse");
		b1.setBounds(650,600,80,40);
		b2.setBounds(500,600,80,40);
		b3.setBounds(820,420,90,40);
                b1.addActionListener(this);
		b3.addActionListener(this);
                b2.addActionListener(this);
		f.add(b1);
		f.add(b2);
		f.add(l1);
		
		f.add(b3);
		//b2.addActionListener(this);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent e2)
	{	
	}
	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(l[9].getWidth(),l[9].getHeight(),Image.SCALE_SMOOTH);
		image1 = new ImageIcon(newImg);
		return image1;
	}
        public ImageIcon ResizImage(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_SMOOTH);
		image = new ImageIcon(newImg);
		return image;
	}
	public boolean isValid(String mail)
	{
		String emailregex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailregex);
		if(mail == null)
			return false;
		else
			return pat.matcher(mail).matches();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String s1[] = new String[8];
			char[] p1 = pf[0].getPassword();
				s1[6] = new String(p1);
			char[] p2 = pf[1].getPassword();
				s1[7] = new String(p2);
				
			for(int i=0;i<4;i++)
			{
				s1[i] = tf[i].getText();
			}
	
			if((s1[6].equals(s1[7]))&&(isValid(s1[2]))&&(!(s1[1].equals(" "))))
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("Jdbc:mysql:///p","root","");
				
				
				String dd = ""+day.getItemAt(day.getSelectedIndex()); 
				String mm = ""+month.getItemAt(month.getSelectedIndex());
				String yy = ""+year.getItemAt(year.getSelectedIndex());
				
				String dob1 = new String(dd+"/"+mm+"/"+yy); 
				String gender1 = new String();
				gender1 = ""+cb.getItemAt(cb.getSelectedIndex());
				
				
				Statement stmt = con.createStatement();
				String query ="select id from students where id='"+s1[0]+"'";
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"ID already existing.Choose other.");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ID created.Fill other details");
				
				
				FileInputStream fin = new FileInputStream(new File(s));
				PreparedStatement ps = con.prepareStatement( "insert into students(id,name,dob,gender,email,contact,password,photo)values('"+s1[0]+"','"+s1[1]+"','"+dob1+"','"+gender1+"','"+s1[2]+"','"+s1[3]+"','"+s1[6]+"',?)");
				ps.setBinaryStream(1,fin);
				int i =  ps.executeUpdate();
				if(i>0)
				{
					System.out.println("Record inserted");
					JOptionPane.showMessageDialog(null,"Data inserted");
				}
				else
				{
					System.out.println("Error adding");
				}
				con.close();
                                }
			
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
                        try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("Jdbc:mysql:///p","root","");
				
				
				
				
				
				Statement stmt = con.createStatement();
			
				
				
				
				PreparedStatement ps = con.prepareStatement( "insert into MarksJava(id,name)values('"+s1[0]+"','"+s1[1]+"')");
			
				int i =  ps.executeUpdate();
				if(i>0)
				{
					//System.out.println("Record inserted");
					JOptionPane.showMessageDialog(null,"Data inserted");
				}
				else
				{
					System.out.println("Error adding");
				}
				con.close();
                                
			
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
                         try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("Jdbc:mysql:///p","root","");
				
				
				
				
				
				Statement stmt = con.createStatement();
			
				
				
				
				PreparedStatement ps = con.prepareStatement( "insert into MarksOS(id,name)values('"+s1[0]+"','"+s1[1]+"')");
			
				int i =  ps.executeUpdate();
				if(i>0)
				{
					System.out.println("Record inserted");
					//JOptionPane.showMessageDialog(null,"Data inserted");
				}
				else
				{
					System.out.println("Error adding");
				}
				con.close();
                                
			
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Passwords do not match or Invalid email id format or Name field is empty");
		}
                
                }
		if(e.getSource()==b2)
		{
			for(int i=0;i<6;i++)
			{
				tf[i].setText(" ");
			}
			pf[0].setText(" ");
			pf[1].setText(" ");
		}
		if(e.getSource()==b3)
		{
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f1 = chooser.getSelectedFile();
			String path = f1.getAbsolutePath();
			s = path;
			l[9].setIcon(ResizeImage(s));
		}
	}
       
    
	
}
        
