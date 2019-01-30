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
public class Umarks implements ActionListener{

    /**
     * @param args the command line arguments
     */
    JButton b1,b2;
    String s;
    JTable table;
    String se;
      Umarks(String sv)
   { se=sv;
       JFrame f = new JFrame("Upload Marks");
    f.setSize(1536,1536);
   JPanel p=new JPanel();
    JPanel p1=new JPanel();
     p1.setBounds(900,600,700,500);
               // f.add(p);
                 b1=new JButton("edit");
                b1.setBounds(250,10,250,150);
                         p1.add(b1);
                         b1.addActionListener(this);
                         f.add(p1);
                         b2=new JButton("save");
                b2.setBounds(300,10,250,150);
                         p1.add(b2);
                         b2.addActionListener(this);
                         f.add(p1);
   p.setLayout(new BorderLayout());
    ArrayList columnNames=new ArrayList();
    ArrayList data=new ArrayList();
   
		try{    String query;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
                        if(sv.equals("Operating Systems"))
                        { query="select * from MarksOS";}
                        else if (sv.equals("Java"))
                        { query="select * from MarksJava";}
                        else
                            query="";
                        
			 ResultSet rs=st.executeQuery(query);
                         ResultSetMetaData md=rs.getMetaData();
                         int columns=md.getColumnCount();
                         for(int i=1;i<=columns;i++)
                         {
                             columnNames.add(md.getColumnName(i));
                             
                         }
                         while(rs.next())
                         {
                             ArrayList row=new ArrayList(columns);
                             for(int i=1;i<=columns;i++)
                             {
                                 row.add(rs.getObject(i));
                                 
                             }
                             data.add(row);
                             
            
                         }
                         
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                Vector columnNamesVector=new Vector();
                Vector dataVector=new Vector();
                for(int i=0;i<data.size();i++)
                {
                    ArrayList subArray=(ArrayList)data.get(i);
                    Vector subVector = new Vector();
                    for(int j=0;j<subArray.size();j++)
                    {
                        subVector.add(subArray.get(j));
                    }
                  dataVector.add(subVector);
                  
                }
                for(int i=0;i<columnNames.size();i++)
                {
                    columnNamesVector.add(columnNames.get(i));
                }
                table=new JTable(dataVector,columnNamesVector)
                {
                    public Class getColumnClass(int column)
                    {
                        for(int row=0;row<getRowCount();row++)
                        {
                            Object o=getValueAt(row,column);
                            if(o!=null)
                            {
                                return o.getClass();
                            }
                            
                        }
                        return Object.class;
                    }
                };
                //table.setPreferredScrollableViewportSize(table.getPreferredSize());
                //table.setFillsViewportHeight(true);
                JScrollPane scrollPane=new JScrollPane(table);
                //scrollPane.setBounds(10,10,1500,1500);
                p.add(scrollPane,BorderLayout.CENTER);
                p.setBounds(0,0,1400,700);
               f.add(p);
                           
               f.setLayout(null);
                
               
               // f.setLayout(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
   }
                
                
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            table.setEnabled(true);
            
        }
        if(e.getSource()==b2)
        {
            try{


                        Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///re","root","");
			Statement st = con.createStatement();
                        String query;
                        if(se.equals("Operating Systems"))
                        {  query="delete from from MarksOS";}
                        else if (se.equals("Java"))
                        {  query="select * from MarksJava";}
                        else
                        {  query=" ";}
                       
                        st.executeUpdate(query);
                        PreparedStatement pst;
                        //FileInputStream fin = new FileInputStream(new File(s));
                        //PreparedStatement ps = con.prepareStatement( "insert into login(name,password)values(?,?)");
//String query = "Insert into tblcheckout(CheckoutID,ItemTagNo,ItemName,Category,Description,Location) values (?,?,?,?,?)";
                         int rows=table.getRowCount();
                          for(int row = 0; row<rows; row++)
                        {
                          String id = (String)table.getValueAt(row, 0);
                          //System.out.println(name);
                          String name= (String)table.getValueAt(row, 2);
                           Integer majorOS= (Integer)table.getValueAt(row, 3);
                            Integer minor1OS= (Integer)table.getValueAt(row, 4);
                           Integer minor2OS= (Integer)table.getValueAt(row, 5);
                          Integer Assignment= (Integer)table.getValueAt(row, 6);
                            Integer QuizOS= (Integer)table.getValueAt(row, 7);
                              Integer AttendanceOS= (Integer)table.getValueAt(row, 8);
                                Integer total= (Integer)table.getValueAt(row, 9);
                          String query1;
                           if(se.equals("Operating Systems"))
                        {  query1="insert into marksOS(id,name,marksOS,minor1OS,minor2OS,Assignment,QuizOS,AttendanceOS,total)values('"+id+"','"+name+"',"+majorOS+","+minor1OS+","+minor2OS+","+Assignment+","+QuizOS+","+AttendanceOS+","+total+")";}
                        else if (se.equals("Java"))
                        {  query1="insert into marksJava(id,name,marksJ,minor1J,minor2J,Assignment,QuizJ,AttendanceJ,total)values('"+id+"','"+name+"',"+majorOS+","+minor1OS+","+minor2OS+","+Assignment+","+QuizOS+","+AttendanceOS+","+total+")";}
                        else
                        {  query1=" ";}
                           //String query1= "insert into login(name,password)values('"+name+"','"+password+"')";
                          
                            pst = con.prepareStatement(query1);
                           
    int i=pst.executeUpdate();
    if(i>0)
       System.out.println("l");
    //String codesc = (String)tblCO2.getValueAt(row, 2);
    //String coloc = (String)tblCO2.getValueAt(row, 3);
    //String coitemtagno = (String)tblCO2.getValueAt(row, 4);
                                  // ps.setString(1, coitemname);
    //ps.setString(2, cocateg);
    //pst.setString(3, codesc);
    //pst.setString(4, coloc);
    //pst.setString(5, coitemtagno);
                                  //ps.executeUpdate();
                                     
                                 }
                                 
				
                                }
                            catch(Exception f){
                              System.out.println(f);
                              }

				
        }
    }
}

