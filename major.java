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
/**
 *
 * @author Aanchhal
 */
public class major {
  
     major(String sv)
   { System.out.println(sv);
       JFrame f = new JFrame("table");
   f.setLayout(new BorderLayout());
    ArrayList columnNames=new ArrayList();
    ArrayList data=new ArrayList();
   
		try{    String query;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
                      
                         query="Select marksOS.id,marksOs.name,MarksOS.majorOS OS,MarksJava.majorJ JAVA from marksOS,marksJava where marksOS.id=marksJava.id and marksOS.id='"+sv+"'";
                        
                        
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
                           con.close();
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
                JTable table=new JTable(dataVector,columnNamesVector)
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
                f.add(scrollPane,BorderLayout.CENTER);
               // f.setLayout(null);
                
                f.setSize(1536,1536);
               // f.setLayout(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
                 
               
        // TODO code application logic here
    }
    
     


    
}
