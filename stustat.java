/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;
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
public class stustat{
    JMenu stuACC,viewAll,uploadM,ViewM;
    JMenuItem i1,i2,i3,i4,i5,ViewAtt,i6,i7,i8;
    JPanel p,p1;
    JSeparator s1,s9,s3,s4;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
       ImageIcon image,nimag;
       JComboBox cb;
       String s8,s5,s6,s7,t1,t2,tf1;
       int to,tj,tp;
       static int j=1;
       String r;
       JProgressBar prg,prg1;
       String sr;
       int u;
       //s34=f1.s2;
    //JSeparator s1,s2
    
    stustat(String s33,String sub)
    {
        System.out.println(s33);
        System.out.println(sub);
        sr=s33;
        
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select * from students where id='"+s33+"'";
                        /*String query1="select total from MarksOS where id='"+s33+"'";
                        String query2="select total from MarksJava where id='"+s33+"'";*/
                        ResultSet rs=st.executeQuery(query);
                       /* ResultSet rs1=st.executeQuery(query1);
                        ResultSet rs2=st.executeQuery(query2);*/
			
                        if(rs.next()) {
                            
                        s5=rs.getString("name");
                        s6=rs.getString("dob");
                        s7=rs.getString("email");
                        s8=rs.getString("contact");
                        Blob b7=rs.getBlob("photo");
                        byte barr[]=b7.getBytes(1,(int)b7.length());
                        r="d:\\img1"+j+".jpg";
                        System.out.println(r);
                        FileOutputStream fout=new FileOutputStream(r);
                        fout.write(barr);
                        fout.close();
                        j++;
                        }
                       /* if(rs1.next())
                        {
                            to=rs1.getInt("total");
                            
                        }
                        if(rs2.next())
                        {
                            tj=rs1.getInt("total");
                        }
                        /*l1.setText(s5);
                        l3.setText(s6);
                        l4.setText(s7);
                        l7.setText(s8);*/
                        con.close();
		}
		catch(Exception g)
		{
			System.out.println("Exception has occured"+g);
		}
                 try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select total from MarksJava where id='"+s33+"'";
                        /*String query1="select total from MarksOS where id='"+s33+"'";
                        String query2="select total from MarksJava where id='"+s33+"'";*/
                        ResultSet rs=st.executeQuery(query);
                       /* ResultSet rs1=st.executeQuery(query1);
                        ResultSet rs2=st.executeQuery(query2);*/
			
                        /*if(rs.next()) {
                            
                        /*s5=rs.getString("name");
                        s6=rs.getString("dob");
                        s7=rs.getString("email");
                        s8=rs.getString("contact");
                        Blob b7=rs.getBlob("photo");
                        byte barr[]=b7.getBytes(1,(int)b7.length());
                        r="d:\\img1"+j+".jpg";
                        System.out.println(r);
                        FileOutputStream fout=new FileOutputStream(r);
                        fout.write(barr);
                        fout.close();
                        j++;
                        }*/
                       /* if(rs1.next())
                        {
                            to=rs1.getInt("total");
                            
                        }*/
                        if(rs.next())
                        {
                            tj=rs.getInt("total");
                        }
                        /*l1.setText(s5);
                        l3.setText(s6);
                        l4.setText(s7);
                        l7.setText(s8);*/
                        con.close();
		}
		catch(Exception g)
		{
			System.out.println("Exception has occured"+g);
		}
                 try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select total from MarksOS where id='"+s33+"'";
                        /*String query1="select total from MarksOS where id='"+s33+"'";
                        String query2="select total from MarksJava where id='"+s33+"'";*/
                        ResultSet rs=st.executeQuery(query);
                       /* ResultSet rs1=st.executeQuery(query1);
                        ResultSet rs2=st.executeQuery(query2);*/
			
                        /*if(rs.next()) {
                            
                        /*s5=rs.getString("name");
                        s6=rs.getString("dob");
                        s7=rs.getString("email");
                        s8=rs.getString("contact");
                        Blob b7=rs.getBlob("photo");
                        byte barr[]=b7.getBytes(1,(int)b7.length());
                        r="d:\\img1"+j+".jpg";
                        System.out.println(r);
                        FileOutputStream fout=new FileOutputStream(r);
                        fout.write(barr);
                        fout.close();
                        j++;
                        }*/
                       /* if(rs1.next())
                        {
                            to=rs1.getInt("total");
                            
                        }*/
                        if(rs.next())
                        {
                            to=rs.getInt("total");
                        }
                        /*l1.setText(s5);
                        l3.setText(s6);
                        l4.setText(s7);
                        l7.setText(s8);*/
                        con.close();
		}
		catch(Exception g)
		{
			System.out.println("Exception has occured"+g);
		}
        // System.out.println(s5);
        JFrame f=new JFrame("MenuD");
        p=new JPanel();
        
        p.setBackground(Color.lightGray);
        l=new JLabel("Insert image");
       // l.setSize(200,200);
        l.setBounds(100, 10, 200, 200);
       l.setIcon(ResizeImage(r));
                //l.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13\\src\\imge\\961-200.png"));

       s1=new JSeparator();
      s1.setBounds(0,200,800,0);
       //l.add(s1);
       l1=new JLabel(s5);
       //l1.setBackground(Color.red);
       l1.setBounds(100,250,200,100);
       l1.setFont(l.getFont().deriveFont(24.0f));
       l2=new JLabel("(Student)");
       l2.setBounds(130,300,100,50);
       l2.setFont(l.getFont().deriveFont(9.0f));
       l3=new JLabel(s6);
       l3.setBounds(90,350,200,50);
       l3.setFont(l.getFont().deriveFont(16.0f));
       l5=new JLabel("Email_Id");
       l5.setBounds(10,400,100,50);
     //  l5.setForeground(Color.);
       l5.setFont(l5.getFont().deriveFont(15.0f));
       l4=new JLabel(s7);
       l4.setBounds(150,400,200,50);
       l4.setForeground(Color.BLACK);
        l6=new JLabel("Contact_No");
       l6.setBounds(10,450,100,50);
     //  l5.setForeground(Color.);
       l6.setFont(l5.getFont().deriveFont(15.0f));
       l7=new JLabel(s8);
       l7.setBounds(150,450,200,50);
       l7.setForeground(Color.BLACK);
       l18=new JLabel("OVERALL PROGRESS");
       l18.setBounds(70,500,200,50);
       l18.setFont(l18.getFont().deriveFont(17.0f));
        l17=new JLabel(sub);
       l17.setBounds(70,570,200,50);
       l17.setFont(l18.getFont().deriveFont(17.0f));
      tp=(to+tj)/2;
        prg1=new JProgressBar();
        prg1.setValue(tp);
        //prg.setMaximum(j);
        prg1.setStringPainted(true);
        prg1.setBounds(60,550,200,25);
       s9=new JSeparator();
       s9.setOrientation(SwingConstants.HORIZONTAL);
       s9.setBounds(10,350,400,100);
       s3=new JSeparator();
       s3.setOrientation(SwingConstants.HORIZONTAL);
       s3.setBounds(10,400,400,100);
        s4=new JSeparator();
       s4.setOrientation(SwingConstants.HORIZONTAL);
       s4.setBounds(10,500,400,100);
       
                                
                          prg=new JProgressBar();
                           /*if(tf1.equals("Java"))
                           {   prg.setValue(tj);
                           }
                           else if(tf1.equals("OS"))
                           {
                              prg.setValue(to); 
                           }*/
                           prg.setValue(0);
        //prg.setMaximum(j);
        prg.setStringPainted(true);
        prg.setBounds(60,600,200,25);
        if(sub.equals("Java"))
             {   prg.setValue(tj);
                           }
                           else if(sub.equals("Operating Systems"))
                           {
                              prg.setValue(to); 
                           }
    
                         /*l1.setText(s5);
                        l3.setText(s6);
                        l4.setText(s7);
                        l7.setText(s8);*/
       
          
         /*  try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select * from teachers where empid='"+s2+"'";
                        ResultSet rs=st.executeQuery(query);
			
                        while(rs.next()) {
                            }
                        s5=rs.getString("name");
                        s6=rs.getString("course");
                        s7=rs.getString("email");
                        s8=rs.getString("contact");
                        l1.setText(s5);
                        l3.setText(s6);
                        l4.setText(s7);
                        l7.setText(s8);
                        con.close();
		}
		catch(Exception g)
		{
			System.out.println("Exception has occured"+g);
		}*/
            //ViewM.add(i1);
          
            p.add(l);
             p.add(s1);
            p.add(l1);
           p.add(l2);
           p.add(s9);
                   p.add(l3);
                   p.add(s3);
                   p.add(l5);
                   p.add(l4);
                   p.add(l6);
                   p.add(l7);
                   p.add(s4);
                   p.add(l18);
                   p.add(l17);
                   p.add(prg1);
                   p.add(prg);
               p.setBounds(500,0,400,800);
               p.setLayout(null);
              
               
           
            f.add(p);
           
            f.setSize(1536,1536);
            f.setLayout(null);
            f.setVisible(true);
            
        
    }
     public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        return image;
    }
    
    
  }
   
    


    

