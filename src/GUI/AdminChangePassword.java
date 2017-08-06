package GUI;
import javax.swing.*;

import connection.CreateConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminChangePassword extends JFrame {
	GridBagLayout gb1;
	GridBagConstraints gc1;
	JButton jb;
	JTextField jtf;
	JPasswordField jpf1,jpf2,jpf3;
	 void properties(){
	        setSize(500,300);
	        setLocation(500,200);
	        setTitle("ADMIN PASSWORD CHANGE");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addLabel(String name,int size,int y){
		JLabel jl=new JLabel(name); 
		jl.setFont(new Font("Corbel",Font.ITALIC,size));
		jl.setForeground(Color.BLUE);
		gc1.gridx=0;
		gc1.gridy=y;
		gc1.anchor=GridBagConstraints.WEST;
		gb1.setConstraints(jl,gc1);
		add(jl);
	 	}
	 JPasswordField addPasswordField(int y){
         JPasswordField jpf=new JPasswordField(13);
         gc1.gridx=1;
 		 gc1.gridy=y;
 		 gb1.setConstraints(jpf, gc1);
         return jpf;
        }
	 void addTextField(){
         jtf=new JTextField(13);
         gc1.gridx=1;
 		 gc1.gridy=1;
 		 gb1.setConstraints(jtf, gc1);
         add(jtf);
        }
	 void addButton(){
		 jb=new JButton("CHANGE");
		 jb.setFont(new Font("Corbel",Font.BOLD,20));
		jb.setForeground(Color.BLACK);
		 gc1.gridx=1;
		 gc1.gridy=5;
		 gb1.setConstraints(jb,gc1);
		 getRootPane().setDefaultButton(jb);
		 add(jb);
		 jb.addActionListener(new PasswordChangeWork());
	 }
	 void addComponents(){
		addLabel("CHANGE PASSWORD",30,0);
		addLabel("USER ID:",20,1);
		addTextField();
		addLabel("OLD PASSWORD:",20,2);
		jpf1=addPasswordField(2);
		add(jpf1);
		addLabel("NEW PASSWORD:",20,3);
		jpf2=addPasswordField(3);
		add(jpf2);
		addLabel("RETYPE PASSWORD:",20,4);
		jpf3=addPasswordField(4);
		add(jpf3);
		addButton();
	 	}
	 public void control(){
		 properties();
		 gb1=new GridBagLayout();
		 gc1=new GridBagConstraints();
		 setLayout(gb1);
		 addComponents();
		 setVisible(true); 
	 	}
	 class PasswordChangeWork implements ActionListener{
		 String id,s2,s3,s4;
		 void getVal(){
			 s2=new String(jpf2.getPassword());
			 s3=new String(jpf3.getPassword());
			 s4=new String(jpf1.getPassword());
		 }
		 boolean checkUserid(){
			 id=jtf.getText();
			 if(id.length()!=5||id.charAt(0)=='0'){jtf.setText("");
			 JOptionPane.showMessageDialog(null, "user id should be of 5 numbers");
			 return false;
			 }	 
			 return true;
		 }
		 boolean checkNewPass(){
			 if(!s2.equals(s3)){
				 JOptionPane.showMessageDialog(null, "two password are not equal");
				 return false;
			 }
			return true; 
		 }
		 boolean checkVal(){
			 if((s4.equals("")||s2.equals("")||s3.equals(""))){
				 JOptionPane.showMessageDialog(null, "field empty");
				 return false;
			 }
			 return true;
		 }
		 public void actionPerformed(ActionEvent e){getVal();
			 try{if(checkUserid()&&checkVal()&&checkNewPass()){
				 if(CreateConnection.Update("update user set password='"+s2+"' where user_id="+id+" and password='"+s4+"'")==1)
					 JOptionPane.showMessageDialog(null, "password changed");
			 	else 	JOptionPane.showMessageDialog(null, " invalid user_id or password");
				 CreateConnection.close1();
			 }	
			 	}
			 catch(SQLException ex){
					ex.printStackTrace();
					}
			catch(ClassNotFoundException ex){
					ex.printStackTrace();
					}
		 }
	 }
 	}
