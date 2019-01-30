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



/**
 *
 * @author Aanchhal
 */
public class uploadD implements ActionListener{
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
        String s11;
       
     uploadD(String s12)
   { 
       s11=s12;
		f = new JFrame("Upload Documents");
		f.setSize(1536,1536);
                 l[0]=new JLabel();
       l[0].setBounds(0, 0, 1400,900);
       
                      l[0].setIcon(ResizImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13_1\\src\\imge\\upload3.jpg"));
                     
                 l[9] = new JLabel();
		l[9].setOpaque(true);
		l[9].setBackground(Color.WHITE);
		l[9].setBounds(200,50,900,500);
               // l[8].setForeground(Color.WHITE);
                //l[8].setFont(l[0].getFont().deriveFont(15.0f));
                l[0].add(l[9]);
                 
                b3 = new JButton("Browse");
		b3.addActionListener(this);
		b3.setBounds(550,570,90,40);
                l[0].add(b3);
                
                b1 = new JButton("Save");
		b1.addActionListener(this);
		b1.setBounds(650,570,90,40);
                l[0].add(b1);
                f.add(l[0]);
                f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
        // TODO code application logic here
    }
      public ImageIcon ResizImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(l[0].getWidth(), l[0].getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(newImg);
        return image;
    }
     public void actionPerformed(ActionEvent e)
     {if(e.getSource()==b3)
		{
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f1 = chooser.getSelectedFile();
			String path = f1.getAbsolutePath();
			s = path;
			l[9].setIcon(ResizeImage(s));
		}
     if(e.getSource()==b1)
		{    
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("Jdbc:mysql:///p","root","");
                                FileInputStream fin = new FileInputStream(new File(s));
				PreparedStatement ps = con.prepareStatement( "insert into documents(id,doc)values('"+s11+"',?)");
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
                        catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
     }
     public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(l[9].getWidth(),l[9].getHeight(),Image.SCALE_SMOOTH);
		image1 = new ImageIcon(newImg);
		return image1;
	}
     
                
                
                
   }
     
