/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author verma_000
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

        

class Assi extends Frame implements ActionListener,WindowListener
{
    TextField t1,t2,t3,t4,t5,ts,tdn;
    Button bn,bs,be,bu,bd,bc,b1,b2,b3,b4;
    Label lbi,lbn,lbs,lbd,lbc,lbdn;
    int k1;
    ResultSet rs;
    Connection con;
    Statement st1;
    Assi()
    {   
        t1=new TextField(20);
        t2=new TextField(20);
        t3=new TextField(20);
        t4=new TextField(20);
        t5=new TextField(20);
        ts=new TextField(2);
        tdn=new TextField(10);
        bn=new Button("new");
        bs=new Button("save");
        be=new Button("edit");
        bu=new Button("update");
        bd=new Button("delete");
        bc=new Button("cancel");
        b1=new Button("1<");
        b2=new Button("<");
        b3=new Button(">");
        b4=new Button(">1");
        lbi=new Label("Id:");
        lbn=new Label("Name:");
        lbs=new Label("Salary:");
        lbd=new Label("Dept:");
        lbc=new Label("City:");
        lbdn=new Label("Directory Name:");
        FlowLayout f=new FlowLayout(FlowLayout.RIGHT);
        setLayout(f);
        add(lbi);
        t1.addActionListener(this);
        t1.setEditable(false);
        add(t1);
        bn.addActionListener(this);
        add(bn);
        add(lbn);
        t2.addActionListener(this);
        t2.setEditable(false);
        add(t2);
        bs.setEnabled(false);
        bs.addActionListener(this);
        add(bs);
        add(lbs);
        t3.addActionListener(this);
        t3.setEditable(false);
        add(t3);
        be.addActionListener(this);
        add(be);
        add(lbd);
        t4.addActionListener(this);
        t4.setEditable(false);
        add(t4);
        bu.setEnabled(false);
        bu.addActionListener(this);
        add(bu);
        add(lbc);
        t5.addActionListener(this);
        t5.setEditable(false);
        add(t5);
        bd.addActionListener(this);
        add(bd); 
        add(lbdn);
        tdn.addActionListener(this);
        tdn.setEditable(false);
        add(tdn);
        bc.setEnabled(false);
        bc.addActionListener(this);
        add(bc);
    
        b1.addActionListener(this);
        add(b1);
        b2.addActionListener(this);
        add(b2);
        ts.addActionListener(this);
        add(ts);
        b3.addActionListener(this);
        add(b3);
        b4.addActionListener(this);
        add(b4);
        
        
    
        setSize(300,300);
        
        getrecords();
        show();
        
        
    }
    
    
    
       
    @Override
    public void actionPerformed(ActionEvent m)
 {  
     try
     {   
     if(m.getSource()==b3)
    { 
        if(rs.next())
        
        {
        int k=rs.getRow();
        t1.setText(""+rs.getInt("Id"));
        t2.setText(rs.getString("Name"));
        t3.setText(rs.getString("Salary"));
        t4.setText(rs.getString("Department"));
        t5.setText(rs.getString("City"));
        ts.setText(""+k);
        }     
        else
        {
            getrecords();
        }
        
    }
     
     if(m.getSource()==bn)
    {
        bs.setEnabled(true);
        bc.setEnabled(true);
        be.setEnabled(false);
        bu.setEnabled(false);
        bd.setEnabled(false);
        k1=going_last();
        t1.setText(""+k1);
        ts.setText(""+k1);
        t2.setEditable(true);
        t2.setText("");
        t3.setEditable(true);
        t3.setText("");
        t4.setEditable(true);
        t4.setText("");
        t5.setEditable(true);
        t5.setText("");
       
     }
     
     if(m.getSource()==bc)
     {
         getrecords();        
         bc.setEnabled(false);
         be.setEnabled(true);
         bd.setEnabled(true);
     }
         if(m.getSource()==bs)
         {
             String t22=t2.getText();
             String t33=t3.getText();
             String t44=t4.getText();
             String t55=t5.getText();
             String sql="Insert into Employee values('"+k1+"','"+t22+"','"+t33+"','"+t44+"','"+t55+"')";
             st1.executeUpdate(sql);
             bc.setEnabled(false);
             con.commit();
             bs.setEnabled(false);
             be.setEnabled(true);
             bd.setEnabled(true);
             getrecords();
         }
     if(m.getSource()==be)
     {
         bu.setEnabled(true);
         bc.setEnabled(true);
         bu.setEnabled(true);
         bd.setEnabled(false);
         bn.setEnabled(false);
         int k=rs.getRow();
         t1.setText(""+k);
         ts.setText(""+k);
         t2.setEditable(true);
         t3.setEditable(true);
         t4.setEditable(true);
         t5.setEditable(true);
         con.setAutoCommit(false);
     }
     if(m.getSource()==bu)
     {
         String t22=t2.getText();
         String t33=t3.getText();
         String t44=t4.getText();
         String t55=t5.getText();
         String sql="Update into Employee values('"+k1+"','"+t22+"','"+t33+"','"+t44+"','"+t55+"')";
         st1.executeUpdate(sql);
         bc.setEnabled(false);
         con.commit();
         bu.setEnabled(false);
         bn.setEnabled(true);
         be.setEnabled(true);
         bd.setEnabled(true);
         getrecords();
     }
     if(m.getSource()==bd)
     {
         int i=JOptionPane.showConfirmDialog(this,"Hello!!are you sure?", "Confirm Dialog Box", 2);
        if(i==0)
        { 
           int t11= Integer.parseInt(t1.getText());
           String t22=t2.getText();
           String t33=t3.getText();
           String t44=t4.getText();
           String t55=t5.getText();
           String sql="Delete from Employee where Name='"+t22+"'";
           st1.executeUpdate(sql);
           getrecords();
        con.close();
        }
        
     }
     
     if(m.getSource()==b1)
     {
         rs.first();
         int k=rs.getRow();
         t1.setText(""+rs.getInt("Id"));
         t2.setText(rs.getString("Name"));
         t3.setText(rs.getString("Salary"));
         t4.setText(rs.getString("Department"));
         t5.setText(rs.getString("City"));
         ts.setText(""+k);
         tdn.setText("officce");   
     }
         
     if(m.getSource()==b4)
     {
         rs.last();
         int k=rs.getRow();
         t1.setText(""+rs.getInt("Id"));
         t2.setText(rs.getString("Name"));
         t3.setText(rs.getString("Salary"));
         t4.setText(rs.getString("Department"));
         t5.setText(rs.getString("City"));
         ts.setText(""+k);
         tdn.setText("officce");
     }
     
     if(m.getSource()==b2)
     {
         if(rs.previous())
         {int k=rs.getRow();
         t1.setText(""+rs.getInt("Id"));
         t2.setText(rs.getString("Name"));
         t3.setText(rs.getString("Salary"));
         t4.setText(rs.getString("Department"));
         t5.setText(rs.getString("City"));
         ts.setText(""+k);
         tdn.setText("officce");
         }
         else
         {
             getrecords();
         }
     
     }
     
     if(m.getSource()==ts)
     { 
         String t10=ts.getText();
         int k=Integer.parseInt(t10);
         rs.absolute(k);
         t1.setText(""+rs.getInt("Id")); 
         t2.setText(rs.getString("Name"));
         t3.setText(rs.getString("Salary"));
         t4.setText(rs.getString("Department"));
         t5.setText(rs.getString("City"));
         ts.setText(""+k);
         tdn.setText("officce");
     }
 }
     catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }
 }

    
    public void getrecords()
    {
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:dsn1");
         st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);        
         rs=st1.executeQuery("Select * from Employee");
         rs.next();
         t1.setText(""+rs.getInt("Id")); 
         t2.setText(rs.getString("Name"));
         t3.setText(rs.getString("Salary"));
         t4.setText(rs.getString("Department"));
         t5.setText(rs.getString("City"));
         tdn.setText("officce");
         ts.setText(""+1);

        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    public int going_last()
    {int h=-1;
        try
        {rs=st1.executeQuery("Select * from Employee");
        rs.last();
        h=rs.getRow();
         h++;
        }
    catch(Exception x)
            {
                System.out.println(x.toString());
            }
    return h;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
               System.exit(0); // Dispose the window after the close button is clicked.
                
    }

    @Override
    public void windowClosed(WindowEvent e) {
      
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    

}
public class Assignment 
{

 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Assi d=new Assi();
    
    }
    
}
