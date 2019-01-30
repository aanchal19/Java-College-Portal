/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Image;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
//import javafx.scene.paint.Color;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import java.sql.*;
import javax.swing.border.LineBorder;
import java.awt.color.*;


/**
 *
 * @author Aanchhal
 */
public class f1 implements MouseListener,ActionListener {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    JPanel p,p1;
    JFrame f;
    JLabel label,l2,l6;
    JTextField tf1;
    JPasswordField pf;
    JButton b;
    ImageIcon image;
    JComboBox cb;
    char i;
    String s2;
    JLabel bg,l5;
    //String s8,s5,s6,s7;
    
    
    f1() {

        f = new JFrame("Welcome to SPUTNIK ");
        p = new JPanel();
        p1 = new JPanel(); 
         Border thickBorder = new LineBorder(Color.LIGHT_GRAY, 4);
            label=new JLabel();
       label.setBounds(0, 0, 1400,900);
       
                      label.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13_1\\src\\imge\\ufe.jpg"));
                      
         l5=new JLabel("SPUTNIK");
       l5.setBounds(600, 10,200,200);
       
       l5.setFont(label.getFont().deriveFont(25.0f));
       label.add(l5);
        l6=new JLabel(":Student Assessment Portal");
       l6.setBounds(720, 10,200,200);
       
       l6.setFont(l5.getFont().deriveFont(15.0f));
       label.add(l6);
        
       
                      b = new JButton("Sign In");
        tf1 = new JTextField("Enter UserID");
        tf1.setBorder(thickBorder);
        
        pf= new JPasswordField();
         i=pf.getEchoChar();
        pf.setEchoChar((char)0);
        pf.setText("EnterPassword");
        pf.setBorder(thickBorder);
        
       /* b.setBorderPainted(true);
            b.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13_1\\src\\imge\\ufe.jpg")); */

        l2 = new JLabel("Welcome! Enter your Details");
        l2.setFont(label.getFont().deriveFont(16.0f));
        l2.setForeground(Color.PINK);
        String role[] = {"ROLE","Student","Teacher"};
        cb = new JComboBox(role);
                
        
        //label.setBounds(0, 0, 900, 700);
         //label.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\Trails\\src\\image\\logologos.jpg"));

        l2.setBounds(550, 300, 300, 40);
        tf1.setBounds(525, 350, 270, 40);//x axis, y axis, width, height 
        pf.setBounds(525, 425, 270, 40);
        cb.setBounds(550,  525, 200, 40);
        b.setBounds(600,625,100,40);
   
            b.setBorder(thickBorder);


        cb.setVisible(true);
        b.addActionListener(this);
        //tf1.setBackground(Color.WHITE);
        pf.setBackground(Color.WHITE);
        tf1.addMouseListener(this);
        pf.addMouseListener(this);
       //Border border = BorderFactory.createLineBorder(Color.WHITE);
       //tf1.setBorder(border);
        f.add(p);
      p.add(label);
        label.add(l2);
       label.add(tf1);
        label.add(pf);
        label.add(cb);
        label.add(b);
      //p.add(bg);
         p.setBounds(0,0,1500, 1500);
         p.setLayout(null);
        
       
     
        
         f.setLayout(null);
         f.setSize(1536, 1536);
         f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.validate();

    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        return image;
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource()==tf1)
            tf1.setText("");
        else if(e.getSource()==pf)
        { pf.setText("");
                pf.setEchoChar(i);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }
    @Override
    public void actionPerformed(ActionEvent f)
    {
        String s1=(String)cb.getSelectedItem();
         s2=tf1.getText();
        char pa[]=pf.getPassword();
        String s3=new String(pa);
        if(f.getSource()==b)
        {
            
            if(s1.equals("Teacher"))
            {
                 
                
                try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select * from teachers where empid='"+s2+"' and password='"+s3+"'";
                        ResultSet rs=st.executeQuery(query);
			
                        if(rs.next()) {
                            /*s5=rs.getString("name");
                        s6=rs.getString("course");
                        s7=rs.getString("email");
                        s8=rs.getString("contact");*/
                       
                            new JavaApplication13(s2);
                            }
                        else
                            JOptionPane.showMessageDialog(null,"Invalid ID or PASSWORD");
                        con.close();
		}
		catch(Exception g)
		{
			System.out.println("Exception has occured"+g);
		}
                //new JavaApplication13();
            }
           else if(s1.equals("Student"))
            {
                 
                
                try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select * from students where id='"+s2+"' and password='"+s3+"'";
                        ResultSet rs=st.executeQuery(query);
			
                        if(rs.next()) {
                            /*s5=rs.getString("name");
                        s6=rs.getString("course");
                        s7=rs.getString("email");
                        s8=rs.getString("contact");*/
                       
                            new stu(s2);
                            }
                        else
                            JOptionPane.showMessageDialog(null,"Invalid ID or PASSWORD");
                        con.close();
		}
		catch(Exception g)
		{
			System.out.println("Exception has occured"+g);
		}
                //new JavaApplication13();
            }
        }
    }
   

}


