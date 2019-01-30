/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author Aanchhal
 */
public class viewD implements ActionListener{
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
         static int j=1;
       String r,s5;
    
     viewD()
   { 
       
		f = new JFrame("View Documents");
		f.setSize(1536,1536);
                 l[0]=new JLabel();
       l[0].setBounds(0, 0, 1400,900);
       
                      l[0].setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13_1\\src\\imge\\upload3.jpg"));
                     
                 l[9] = new JLabel();
		l[9].setOpaque(true);
                
		l[9].setBackground(Color.WHITE);
               
		l[9].setBounds(200,50,900,500);
                l[0].add(l[9]);
                l[8] = new JLabel("Enter Roll Number");
                  l[8].setForeground(Color.WHITE);
                l[8].setFont(l[0].getFont().deriveFont(15.0f));
		//l[8].setOpaque(true);
                
		//l[].setBackground(Color.WHITE);
               
		l[8].setBounds(380,550,150,100);
                l[0].add(l[8]);
                tf[0] = new JTextField();
		
		tf[0].setBounds(520,570,100,40);
                //tf[0].setForeground(Color.WHITE);
                
                
                l[0].add(tf[0]);
               
       
                b1 = new JButton("Show");
		b1.addActionListener(this);
		b1.setBounds(650,570,90,40);
                l[0].add(b1);
                 f.add(l[0]);
                //l[0].setLayout(null);
                f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
        // TODO code application logic here
    }
      public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(l[0].getWidth(), l[0].getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        return image;
    }
       public ImageIcon ResizImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(l[9].getWidth(), l[9].getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        return image;
    }
     public void actionPerformed(ActionEvent e)
     {
     if(e.getSource()==b1)
		{
                    String s1=tf[0].getText();
			try
		{
				/*Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///blo","root","");
			Statement st = con.createStatement();
			String query="select ima from blo1 where id='"+s1+"'";
                        /*String query1="select total from MarksOS where id='"+s33+"'";
                        String query2="select total from MarksJava where id='"+s33+"'";*/
                       // ResultSet rs=st.executeQuery(query);
                       /* ResultSet rs1=st.executeQuery(query1);
                        ResultSet rs2=st.executeQuery(query2);*/
			
                        /*if(rs.next()) {
                            
                       
                        Blob b7=rs.getBlob("ima");
                        byte barr[]=b7.getBytes(1,(int)b7.length());
                        r="C:\\Users\\Aanchhal\\Desktop\\doc\\img1"+j+".jpg";
                        System.out.println(r);
                        FileOutputStream fout=new FileOutputStream(r);
                        fout.write(barr);
                        fout.close();
                        j++;
                         l[9].setIcon(ResizeImage(r));
				con.close();*/
                    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select * from documents where id='"+s1+"'";
                        /*String query1="select total from MarksOS where id='"+s33+"'";
                        String query2="select total from MarksJava where id='"+s33+"'";*/
                        ResultSet rs=st.executeQuery(query);
                       /* ResultSet rs1=st.executeQuery(query1);
                        ResultSet rs2=st.executeQuery(query2);*/
			//byte img[]=null;
                        if(rs.next()) {
                            
                          //img = rs.getBytes("ima");

//s5=rs.getString("dno");
                        Blob b7=rs.getBlob("doc");
                        System.out.println("hi");
                         System.out.println(s5);
                        byte bar[]=b7.getBytes(1,(int)b7.length());
                        System.out.println("hi");
                        r="d:\\img2"+j+".jpg";
                        System.out.println(r);
                        FileOutputStream fout=new FileOutputStream(r);
                        fout.write(bar);
                       // fout.close();
                        j++;
                         l[9].setIcon(ResizImage(r));
                                        
				
                        }}
                        catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
     }
   
    
}
