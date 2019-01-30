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
public class stu  implements MouseListener,ActionListener{
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
    
    stu(String s33)
    {
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
        JFrame f=new JFrame("MenuS");
        p=new JPanel();
        p1=new JPanel();
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
       l5=new JLabel("email_Id");
       l5.setBounds(10,450,100,50);
     //  l5.setForeground(Color.);
       l5.setFont(l5.getFont().deriveFont(15.0f));
       l4=new JLabel(s7);
       l4.setBounds(150,450,200,50);
       l4.setForeground(Color.BLACK);
        l6=new JLabel("Contact_No");
       l6.setBounds(10,500,100,50);
     //  l5.setForeground(Color.);
       l6.setFont(l5.getFont().deriveFont(15.0f));
       l7=new JLabel(s8);
       l7.setBounds(150,500,200,50);
       l7.setForeground(Color.BLACK);
       l18=new JLabel("OVERALL PROGRESS");
       l18.setBounds(70,550,200,50);
       l18.setFont(l18.getFont().deriveFont(17.0f));
      tp=(to+tj)/2;
        prg1=new JProgressBar();
        prg1.setValue(tp);
        //prg.setMaximum(j);
        prg1.setStringPainted(true);
        prg1.setBounds(60,600,200,50);
       s9=new JSeparator();
       s9.setOrientation(SwingConstants.HORIZONTAL);
       s9.setBounds(10,350,400,100);
       s3=new JSeparator();
       s3.setOrientation(SwingConstants.HORIZONTAL);
       s3.setBounds(10,400,400,100);
        s4=new JSeparator();
       s4.setOrientation(SwingConstants.HORIZONTAL);
       s4.setBounds(10,550,400,100);
       l8=new JLabel();
       l8.setBounds(50, 50, 200,200);
       
                       l8.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13\\src\\imge\\1251121-200.png"));
                         l9=new JLabel("     View Marks");
                         l9.setFont(l9.getFont().deriveFont(15.0f));
                         l9.setBounds(50,260,200,50);
                         Border border=BorderFactory.createLineBorder(Color.BLACK, 2);
                         l9.setBorder(border);
                         l9.setForeground(Color.BLUE);
                          l8.addMouseListener(this);
                         l9.addMouseListener(this);
          l10=new JLabel();
       l10.setBounds(300, 50, 200,200);
       
                       l10.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13\\src\\imge\\Remove_document_icon_(the_Noun_Project_27892).svg.png"));
                         l11=new JLabel("     Upload Documents");
                         l11.setFont(l9.getFont().deriveFont(15.0f));
                         l11.setBounds(300,260,200,50);
                         Border border1=BorderFactory.createLineBorder(Color.BLACK, 2);
                         l11.setBorder(border1);
                         l11.setForeground(Color.BLUE);
                         l10.addMouseListener(this);
                         l11.addMouseListener(this);
         l12=new JLabel();
       l12.setBounds(550, 50, 200,200);
       
                       l12.setIcon(ResizeImage("C:\\Users\\Aanchhal\\Documents\\NetBeansProjects\\JavaApplication13_1\\src\\imge\\file-document-clipboard-survey-512.png"));
                         l13=new JLabel("     Play Quiz");
                         l13.setFont(l9.getFont().deriveFont(15.0f));
                         l13.setBounds(550,260,200,50);
                         Border border2=BorderFactory.createLineBorder(Color.BLACK, 2);
                         l13.setBorder(border2);
                         l13.setForeground(Color.BLUE);
                         l12.addMouseListener(this);
                         l13.addMouseListener(this);
                         l14=new JLabel("Subject");
                         l14.setBounds(300,400,200,50);
                         l14.setFont(l14.getFont().deriveFont(20.0f));
                         String v[]={"Subject","Java","OS"};
                         cb=new JComboBox(v);
                         cb.setBounds(500,400,200,50);
                         l17=new JLabel(" Progress");
                                 l17.setBounds(300,500,200,50);
                                 l17.setFont(l14.getFont().deriveFont(20.0f));
                                
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
        prg.setBounds(500,500,200,50);
        prg.addMouseListener(this);
                         /*l1.setText(s5);
                        l3.setText(s6);
                        l4.setText(s7);
                        l7.setText(s8);*/
        JMenuBar mb= new JMenuBar();
        stuACC=new JMenu("Attendance");
        // viewAll=new JMenu("View");
          //i1=new JMenuItem("upload");
          i2=new JMenu("View");
          ViewM=new JMenu("Marks");
           // ViewAtt=new JMenuItem("Attendance");
            
            i4=new JMenuItem("View");
           // i5=new JMenuItem("Java");
            i6=new JMenuItem("Quiz");
            i7=new JMenuItem("Major");
            i8=new JMenuItem("Minor");
            i6.addActionListener(this);
            i7.addActionListener(this);
            i8.addActionListener(this);
          
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
            ViewM.add(i2);
           i2.add(i7);
           i2.add(i8);
           i2.add(i6);
           //viewAll.add(ViewAtt);
           //i4.addActionListener(this);
           i4.addActionListener(this);
           stuACC.add(i4);
           //stuACC.add(i5);
          //viewAll.add(i5);
           
            mb.add(ViewM);
            //mb.add(ViewDoc);
             mb.add(stuACC);
             // mb.add(viewAll);
            f.setJMenuBar(mb);
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
                   p.add(prg1);
               p.setBounds(0,0,400,800);
               p.setLayout(null);
               p1.add(l8);
               p1.add(l9);
               p1.add(l10);
               p1.add(l11);
             p1.add(l12);
               p1.add(l13);
               p1.add(l14);
               p1.add(cb);
               p1.add(l17);
               p1.add(prg);
               p1.setBounds(400,0,1136,1536);
               p1.setLayout(null);
            f.add(p);
            f.add(p1);
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
     @Override
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==i7)
         {
             new major(sr);
         }
          if(e.getSource()==i8)
         {
             new minor(sr);
         }
          if(e.getSource()==i6)
         {
             new quizm(sr);
         }
           if(e.getSource()==i4)
         {
             new Attendance(sr);
         }
     }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {tf1=(String)cb.getSelectedItem();
       if(e.getSource()==l13||e.getSource()==l12)
       {
        if(tf1.equals("Java"))
         {   
             try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select QuizJ from MarksJava where id='"+sr+"'";
                        ResultSet rs=st.executeQuery(query);
			
                        if(rs.next()) { 
                            u=rs.getInt("QuizJ");
                        }
                        if(u!=0)
                        {
                            if(u==-1)
                            {JOptionPane.showMessageDialog(null,"You have already attempted the Quiz");
                            JOptionPane.showMessageDialog(null,"you marks are"+(u+1));
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"You have already attempted the Quiz");
                            JOptionPane.showMessageDialog(null,"you marks are"+u);
                            }

                        }
                        else
                        {
                            new Quiz(sr);
                            //new stu(0,sr);
                        }
                        con.close();
		}
		catch(Exception f)
		{
			System.out.println("Exception has occured"+f);
		}
             
         }
         else if(tf1.equals("OS"))
         {
             try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="select QuizOS from MarksOS where id='"+sr+"'";
                        ResultSet rs=st.executeQuery(query);
			
                        if(rs.next()) { 
                            u=rs.getInt("QuizOS");
                        }
                        if(u!=0)
                        {
                            if(u==-1)
                            {JOptionPane.showMessageDialog(null,"You have already attempted the Quiz");
                            JOptionPane.showMessageDialog(null,"you marks are"+(u+1));
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"You have already attempted the Quiz");
                            JOptionPane.showMessageDialog(null,"you marks are"+u);
                            }

                        }
                        else
                        {
                            new quiz2(sr);
                        }
                        con.close();
		}
		catch(Exception f)
		{
			System.out.println("Exception has occured"+f);
		}
             
         }
       }
        if(e.getSource()==prg)
        {
            if(tf1.equals("Java"))
                           {   prg.setValue(tj);
                           }
                           else if(tf1.equals("OS"))
                           {
                              prg.setValue(to); 
                           }
        }
         if(e.getSource()==l10||e.getSource()==l11)
        {
            new uploadD(sr);
        }
        if(e.getSource()==l8||e.getSource()==l9)
        {
            new vp(sr);
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
    
   
    
}

    

