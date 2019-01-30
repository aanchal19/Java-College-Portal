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
public class uploadA implements MouseListener {
    JTable table=new JTable();
    
     uploadA(String sv)
   { JFrame f = new JFrame("table");
   f.setLayout(new BorderLayout());
    ArrayList columnNames=new ArrayList();
    ArrayList data=new ArrayList();
   
		try{    String query;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("Jdbc:mysql:///p","root","");
			Statement st = con.createStatement();
                        if(sv.equals("Operating Systems"))
                        { query="select id,name,Attendance from MarksOS";}
                        else if (sv.equals("Java"))
                        { query="select id,name,Attendance from MarksJava";}
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
                 table.addMouseListener(this);
                try{

int rows=table.getRowCount();
Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("Jdbc:mysql:///p","root","");
				
				
				
				
				
				Statement stmt = conn.createStatement();
			
				
conn.setAutoCommit(false);

String queryco;
 if(sv.equals("Operating Systems"))
                        { queryco="update marksOS set Attendance=? where id=?";}
                        else if (sv.equals("Java"))
                        { queryco="update MARKSOS set Attendnce=? where id=?";}
                        else
                            queryco="";

PreparedStatement pst = conn.prepareStatement(queryco);
for(int row = 0; row<rows; row++)
{
    String id = (String)table.getValueAt(row, 0);
    String name = (String)table.getValueAt(row, 1);
    String Attendance = (String)table.getValueAt(row, 2);
    String coloc = (String)table.getValueAt(row, 3);
    String coitemtagno = (String)table.getValueAt(row, 4);
    /*pst.setString(1, coitemname);
    pst.setString(2, cocateg);
    pst.setString(3, codesc);
    pst.setString(4, coloc);
    pst.setString(5, coitemtagno);*/

    pst.addBatch();
}
pst.executeBatch();
conn.commit();
}
catch(Exception e){
    
}
                //table.setPreferredScrollableViewportSize(table.getPreferredSize());
                //table.setFillsViewportHeight(true);
                JScrollPane scrollPane=new JScrollPane(table);
                //scrollPane.setBounds(10,10,1500,1500);
                f.add(scrollPane,BorderLayout.CENTER);
               // f.setLayout(null);
                
                f.setSize(1536,1536);
               // f.setLayout(null);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                
                
                
   }
      @Override
    public void mouseClicked(MouseEvent e)
    {
         int selectedRow = table.getSelectedRow();
        
       /* jTextFieldID.setText(model.getValueAt(selectedRow, 0).toString());
        jTextFieldFN.setText(model.getValueAt(selectedRow, 1).toString());
        jTextFieldLN.setText(model.getValueAt(selectedRow, 2).toString());
        jTextFieldAGE.setText(model.getValueAt(selectedRow, 3).toString());*/
        
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

