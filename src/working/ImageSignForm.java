package working;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import GUI.*;
import javax.swing.*;

import connection.CreateConnection;
import GUI.ImageSignPanel;
public class ImageSignForm extends JFrame {
	 ImageSignPanel dp;
	 File fp1,fp2;
	 String acno;
	 void properties(){
	        setSize(930,500);
	        setLocation(200,80);
	        setTitle("IMAGE  FORM");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("Image  form");
	        }
	
	 void addPanel1(){
	        dp=new ImageSignPanel();
	        add(dp,BorderLayout.CENTER);
	        dp.setBackground(Color.LIGHT_GRAY);
	        dp.setLayout(new FlowLayout(FlowLayout.CENTER,231,10));
	        dp.addPanel1Components(this);
	        }
	 public void control(String no){
		 acno=no;
      properties();
      addHeader();
      addPanel1();
      setVisible(true);
     } 
	 public class ImageWork implements ActionListener{
		
		 public void actionPerformed(ActionEvent e){
			Connection con;
			PreparedStatement p1;
			FileInputStream fin1,fin2;
			 JFileChooser jfc=new JFileChooser();
			 jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			 if(e.getSource()==dp.jb1){
				 int s=jfc.showOpenDialog(ImageSignForm.this);
				 if(s==JFileChooser.APPROVE_OPTION)
					 fp1=jfc.getSelectedFile();
				 else if(s==JFileChooser.CANCEL_OPTION)
					 	JOptionPane.showMessageDialog(null,"image not selected");
				 dp.addPanel2Label1(fp1,0,1);
			
				 dp.jp2.invalidate();
				 dp.jp2.validate();
			 	}
			 else
			 if(e.getSource()==dp.jb2){
				 int s=jfc.showOpenDialog(ImageSignForm.this);
				 if(s==JFileChooser.APPROVE_OPTION)
					 fp2=jfc.getSelectedFile();
				 else if(s==JFileChooser.CANCEL_OPTION)
					 	JOptionPane.showMessageDialog(null,"image not selected");
				 dp.addPanel2Label1(fp2,2,1);
				 dp.jp2.invalidate();
				 dp.jp2.validate();
			 	}
			 else if(e.getSource()==dp.jb3){
				 
				 if(fp1!=null&&fp2!=null){
					 try{
					 	fin1=new FileInputStream(fp1);
					 	fin2=new FileInputStream(fp2);
					 	CreateConnection.loadDriverClass();
					 	con=CreateConnection.createconnection();
					 	p1=con.prepareStatement("insert into image values(?,?,?)");
					 	p1.setString(1, acno);
					 	p1.setBinaryStream(2, fin1,fin1.available());
					 	p1.setBinaryStream(3, fin2,fin2.available());
					 	if(p1.executeUpdate()==1)
					 		JOptionPane.showMessageDialog(null,"image saved");
					 	fin1.close();
						 fin2.close();
						 p1.close();
						 con.close();
				 	}
					 catch(FileNotFoundException ex){
					 		ex.printStackTrace();
							}
					 catch(IOException ex){
					 		ex.printStackTrace();
							}
					 catch(SQLException ex){
					 		ex.printStackTrace();
							}
			 		catch(ClassNotFoundException ex){
		   				 ex.printStackTrace();
			 			}
						  
					 }
				 else
					 JOptionPane.showMessageDialog(null,"image not selected");
				 
			 }
		 }
	 }
}
