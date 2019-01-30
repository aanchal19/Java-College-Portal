/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Quiz implements ActionListener
{
    JFrame f;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JRadioButton rb[] = new JRadioButton[6];
    JButton b1,b2;
    JButton b[] = new JButton[10];
    ButtonGroup bg;
    int count = 0;
    int flag[]=new int[10];
   String sqd;
    
    Quiz(String sq)
    {
        sqd=sq;
        f = new JFrame("Java Quiz");
        f.setSize(1536,1536);
        f.setLayout(null);
      
        p1 = new JPanel();
        p1.setBounds(0,0,1536,150);
        p1.setBackground(Color.GRAY);
        p1.setLayout(null);
        f.add(p1);
         
        for(int i=0;i<=9;i++)
            {flag[i]=0;}
        
        l1 = new JLabel("WELCOME TO ONLINE ASSESSMENT");
        l1.setBounds(200,50,1000,100);
        l1.setFont(l1.getFont().deriveFont(50.0f));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setBounds(0,150,1536,1386);
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setLayout(null);
       f.add(p2);
        
        l2 = new JLabel();
        l2.setBounds(280,40,500,80);
        l2.setFont(l2.getFont().deriveFont(15.0f));
        p2.add(l2);
 
        
        
   
        
        for(int i=0;i<10;i++)
        {
            b[i] = new JButton();
            p2.add(b[i]);
            b[i].setBackground(Color.LIGHT_GRAY);
            b[i].addActionListener(this);
        }
        b[0].setBounds(0,0,70,30);
        b[1].setBounds(0,30,70,30);
        b[2].setBounds(0,60,70,30);
        b[3].setBounds(0,90,70,30);
        b[4].setBounds(0,120,70,30);
        b[5].setBounds(0,150,70,30);
        b[6].setBounds(0,180,70,30);
        b[7].setBounds(0,210,70,30);
        b[8].setBounds(0,240,70,30);
        b[9].setBounds(0,270,70,30);
        
        b[0].setText("1");
        b[1].setText("2");
        b[2].setText("3");
        b[3].setText("4");
        b[4].setText("5");
        b[5].setText("6");
        b[6].setText("7");
        b[7].setText("8");
        b[8].setText("9");
        b[9].setText("10");
         
      
       
        l3 = new JLabel("ONLINE ASSESMENT SYSTEM : COPYRIGHT BY AANCHAL,KANIKA and MANPREET");
        l3.setOpaque(true);
        l3.setBackground(Color.BLACK);
        l3.setForeground(Color.white);
        l3.setBounds(0,520,1500,20);
        p2.add(l3);
       
        l4 = new JLabel("Rules of Quiz");
        l4.setBounds(300,30,300,50);
        l4.setFont(l4.getFont().deriveFont(25.0f));
        p2.add(l4);
        
        l5 = new JLabel("1. There are 10 questions in all.");
        l5.setBounds(310,70,300,50);
        p2.add(l5);
         l6 = new JLabel("2. All questions are of 1 mark each.");
        l6.setBounds(310,100,300,50);
        p2.add(l6);
         l7 = new JLabel("3. There is no negative marking.");
        l7.setBounds(310,130,300,50);
        p2.add(l7);
         l8 = new JLabel("4. Use of calculators is not permitted.");
        l8.setBounds(310,160,300,50);
        p2.add(l8);
         l13 = new JLabel("5. One question can be attempted only once.");
        l13.setBounds(310,190,300,50);
        p2.add(l13);
        l9 = new JLabel("6. You can view your score anytime you want by clicking on view score button on the bottom right of screen.");
        l9.setBounds(310,220,700,50);
        p2.add(l9);
        l10 = new JLabel("7. Once you have finished your quiz, click on Submit button.");
        l10.setBounds(310,250,350,50);
        p2.add(l10); 
         l11 = new JLabel("Max Marks:10");
        l11.setBounds(1000,0,300,30);
        p2.add(l11);
         
        l12 = new JLabel("Time limit:10 min");
        l12.setBounds(100,0,300,30);
        p2.add(l12);
        
         b1 = new JButton("Submit");
         b1.setBounds(1200,450,100,30);
        p2.add(b1);
        b1.setVisible(false);
            
        b2 = new JButton("View Score");
        b2.setBounds(1040,450,115,30);
        p2.add(b2);
        b2.setVisible(false);       
        
         bg = new ButtonGroup();
       
        for(int i=0;i<5;i++)
        {
            rb[i] = new JRadioButton("");
            bg.add(rb[i]);
            p2.add(rb[i]);
            rb[i].setVisible(false);
        }
          // rb[4].setVisible(false);
 
         rb[0].setBounds(300,150,500,35);
        rb[1].setBounds(300,210,500,35);
        rb[2].setBounds(300,270,500,35);
        rb[3].setBounds(300,330,500,35);
        rb[4].setBounds(300,400,500,35);
           
       b2.addActionListener(this);
       b1.addActionListener(this);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE); 
    }
    public void check()
    {
        if(flag[0]==1)
                {
                    if(rb[3].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[0].setEnabled(false);
                        flag[0]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[0].setEnabled(false);
                        flag[0]=0;
                
                    }
                    else
                         flag[0]=0;
                }
                if(flag[1]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[1].setEnabled(false);
                        flag[1]=0;
                    }
                     else if(rb[3].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[1].setEnabled(false);
                        flag[1]=0;
                
                    }
                    else
                         flag[1]=0;
                }
                if(flag[2]==1)
                {
                    if(rb[3].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[2].setEnabled(false);
                        flag[2]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[2].setEnabled(false);
                        flag[2]=0;
                
                    }
                    else
                         flag[2]=0;
                }
                if(flag[3]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[3].setEnabled(false);
                        flag[3]=0;
                    }
                     else if(rb[3].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[3].setEnabled(false);
                        flag[3]=0;
                
                    }
                    else
                         flag[3]=0;
                }
                if(flag[4]==1)
                {
                    if(rb[2].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[4].setEnabled(false);
                        flag[4]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[3].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[4].setEnabled(false);
                        flag[4]=0;
                
                    }
                    else
                         flag[4]=0;
                }
                if(flag[5]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[5].setEnabled(false);
                        flag[5]=0;
                    }
                     else if(rb[3].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[5].setEnabled(false);
                        flag[5]=0;
                
                    }
                    else
                         flag[5]=0;
                }
                if(flag[6]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[6].setEnabled(false);
                        flag[6]=0;
                    }
                     else if(rb[3].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[6].setEnabled(false);
                        flag[6]=0;
                
                    }
                    else
                         flag[6]=0;
                }
                if(flag[7]==1)
                {
                    if(rb[3].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[7].setEnabled(false);
                        flag[7]=0;
                    }
                     else if(rb[0].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[7].setEnabled(false);
                        flag[7]=0;
                
                    }
                    else
                         flag[7]=0;
                }
                if(flag[8]==1)
                {
                    if(rb[1].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[8].setEnabled(false);
                        flag[8]=0;
                    }
                     else if(rb[0].isSelected()||rb[3].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[8].setEnabled(false);
                        flag[8]=0;
                
                    }
                    else
                         flag[8]=0;
                }
                if(flag[9]==1)
                {
                    if(rb[0].isSelected())
                    {
                        count++;
                        JOptionPane.showMessageDialog(null,"Correct answer with total score: "+count);
                        b[9].setEnabled(false);
                        flag[9]=0;
                    }
                     else if(rb[3].isSelected()||rb[1].isSelected()||rb[2].isSelected())
                    {
                        JOptionPane.showMessageDialog(null,"Wrong answer with total score:"+count);
                        b[9].setEnabled(false);
                        flag[9]=0;
                
                    }
                    else
                         flag[9]=0;
                }
    }
     public void actionPerformed(ActionEvent e)
        {
          l1.setBounds(500,60,800,40);
          l1.setText("Java Quiz");
          
           b1.setVisible(true);
           b2.setVisible(true);
           
          l4.setVisible(false);
          l5.setVisible(false);
          l6.setVisible(false);
          l7.setVisible(false);
          l8.setVisible(false);
          l9.setVisible(false);
          l10.setVisible(false);
          l13.setVisible(false);
         
           // rb[4].setSelected(true);
          for(int i=0;i<4;i++)
          {
              rb[i].setVisible(true);
          }
          
            if(e.getSource()==b[0])
            {
                check();
                
                l2.setText("Que1:What is the function of JVM(Java Virtual Machine)?");
                rb[0].setText("Loads Code");
                rb[1].setText("Verifies Code");
                rb[2].setText("Provides run-time environment");
                rb[3].setText("All of the above");
                    rb[4].setSelected(true);
                bg.getSelection();
                flag[0]=1;
       
            
            }
                
            if(e.getSource()==b[1])
            {
                 check();
              rb[4].setSelected(true);
                l2.setText("<html>Que2:If an expression contains double,int,float,long,then whole expression will be promoted to which of these datatypes?</html>");
                rb[0].setText("double");
                rb[1].setText("int");
                rb[2].setText("float");
                rb[3].setText("long");
               flag[1]=1;
                bg.getSelection();
                
               
            }
             if(e.getSource()==b[2])
            {
                check();
                rb[4].setSelected(true);
                l2.setText("<html>Que3:Which of these operators can skip evaluating right hand operand?</html>");
                rb[0].setText("!");
                rb[1].setText("|");
                rb[2].setText("&");
                rb[3].setText("&&");
                flag[2]=1;
            }
             if(e.getSource()==b[3])
             {
                   check();
                 l2.setText("<html>Que4:Which concept of Java is achieved by combining methods and attributes in a class?</html>");
                rb[0].setText("Encapsulation");
                rb[1].setText("Inheritance");
                rb[2].setText("Polymorphism");
                rb[3].setText("Abstraction");
                rb[4].setSelected(true);
                 flag[3]=1;
             }
            
            if(e.getSource()==b[4])
             {
                
                      check();
                rb[4].setSelected(true); 
                l2.setText("Que5:How can a protected modifier be accessed?");
                rb[0].setText("accessible only within the class");
                rb[1].setText("accessible only within package");
                rb[2].setText("accessible within package and outside the package but through inheritance");
                rb[3].setText("accessible by all");
                 flag[4]=1;
             }
             
            if(e.getSource()==b[5])
             { check();
             rb[4].setSelected(true);
                 l2.setText("Que6:Which of these packages contains abstract keyword?");
                rb[0].setText("java.lang");
                rb[1].setText("java.util");
                rb[2].setText("java.io");
                rb[3].setText("java.system");
                 flag[5]=1;
             }
             
             if(e.getSource()==b[6])
             {
                 check();
                rb[4].setSelected(true);
                l2.setText("Que7:Which of these is a super class of Exception class?");
                rb[0].setText("Throwable");
                rb[1].setText("System");
                rb[2].setText("RunTime");
                rb[3].setText("Class");
                 flag[6]=1;
             }
             if(e.getSource()==b[7])
             { check();
             rb[4].setSelected(true);
                 l2.setText("Que8:What is true about threading?");
                rb[0].setText("run() method calls start() method and runs the code");
                rb[1].setText("run() method creates new thread");
                rb[2].setText("run() method can be called directly without start() method being called");
                rb[3].setText("<html>start() method creates new thread and calls code written in run() method</html>");
                 flag[7]=1;
             }
             if(e.getSource()==b[8])
             {
                check();
                rb[4].setSelected(true);
                 l2.setText("Que9:What is listener in context to event handling?");
                rb[0].setText("-a variable that is notified when an event occurs");
                rb[1].setText("-an object");
                rb[2].setText("-a method");
                rb[3].setText("None of the mentioned");
                 flag[8]=1;
             }
             if(e.getSource()==b[9])
             {
                  check();
                rb[4].setSelected(true);
                 l2.setText("Que10:Which of these access specifiers can be used for an interface?");
                rb[0].setText("public");
                rb[1].setText("protected");
                rb[2].setText("private");
                rb[3].setText("All");
                 flag[9]=1;
             }
             if(e.getSource()==b2)
             {
                 check();
                 JOptionPane.showMessageDialog(null,"Your total score till now is "+count);
                 
             }
             if(e.getSource()==b1)
             {  
                // System.out.println(sqd);
                 //System.out.println(count);
                 check();
                 JOptionPane.showMessageDialog(null,"Total score: "+count);
                 for(int i=0;i<10;i++)
                 {
                     b[i].setEnabled(false);
                 }
                 if(count==0)
                     count=-1;
                  try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
			String query="update MarksJava set QuizJ="+count+" where id='"+sqd+"' ";
                        
			int i=st.executeUpdate(query);
                           if(i>0) { System.out.println("inserted"); } else{ System.out.println("Unsuccessful"); }
		}
		
		catch(Exception f)
		{
			System.out.println("Exception has occured"+f);
		}
                 
             }
             
        }
    
}

