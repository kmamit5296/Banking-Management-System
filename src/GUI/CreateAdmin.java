package GUI;
import connection.*;
import javax.swing.*;

import working.AdminPanel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CreateAdmin extends JFrame {
	GridBagLayout gb1;
	GridBagConstraints gc1;
	JButton jb1,jb2;
	public	JTextField jtf;
	public	JPasswordField jpf;
	void properties(){
        setSize(500,200);
        setLocation(500, 200);
        setTitle("CREATE ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    	}
	 void addLabel1(String name){
			JLabel jl1=new JLabel(name); 
			jl1.setFont(new Font("Corbel",Font.ITALIC,30));
			jl1.setForeground(Color.BLUE);
			gc1.gridx=0;
			gc1.gridy=0;
			gc1.gridwidth=2;
			gc1.anchor=GridBagConstraints.WEST;
			gb1.setConstraints(jl1,gc1);
			add(jl1);
		 	}
	 void addLabel(String name,int y){
			JLabel jl=new JLabel(name); 
			jl.setFont(new Font("Corbel",Font.ITALIC,20));
			jl.setForeground(Color.BLACK);
			gc1.gridx=0;
			gc1.gridy=y;
			gc1.gridwidth=1;
			gc1.anchor=GridBagConstraints.WEST;
			gb1.setConstraints(jl,gc1);
			add(jl);
		 	}
	 void addPasswordField(){
         jpf=new JPasswordField(13);
         gc1.gridx=1;
 		 gc1.gridy=2;
 		 gb1.setConstraints(jpf, gc1);
         add(jpf);
         
        }
	 void addTextField(){
		 jtf=new  JTextField(13);
         gc1.gridx=1;
 		 gc1.gridy=1;
 		 gb1.setConstraints(jtf, gc1);
         add(jtf);
        }
	 void addButton1(){
		 jb1=new JButton("LOG IN");
		 gc1.gridx=1;
		 gc1.gridy=5;
		 gb1.setConstraints(jb1,gc1);
		 getRootPane().setDefaultButton(jb1);
		 add(jb1);
		 jb1.addActionListener(new Administrator());
	 }
	 void addButton2(){
		 jb2=new JButton("RESET");
		 gc1.gridx=0;
		 gc1.gridy=5;
		 gb1.setConstraints(jb2,gc1);
		 add(jb2);
		 jb2.addActionListener(new Administrator());
	 }
	 void addComponents(){
			addLabel1("BANKING MANAGEMENT SYSTEM");
			addLabel("USERNAME:",1);
			addTextField();
			addLabel("PASSWORD:",2);
			addPasswordField();
			addButton1();
			addButton2();
	 }	
	 public void control(){
		 properties();
		 gb1=new GridBagLayout();
		 gc1=new GridBagConstraints();
		 setLayout(gb1);
		 addComponents();
		 setVisible(true); 
	 	}
	 class Administrator implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String s1=jtf.getText();
				String s2=new String(jpf.getPassword());
				Object ob=e.getSource();
				if(ob==jb2){
					jtf.setText("");
					jpf.setText("");
				}
				else{
				jtf.setText("");
				jpf.setText("");
				try{
				ResultSet r1=CreateConnection.execute("select username,password,type from user where username='"+s1+"'and password='"+s2+"'");
				if(r1.next()){
					if(r1.getString(3).equals("ADMIN")){
					 AdminPanel ap=new AdminPanel();
				     ap.control(r1.getString(3),"ADMIN PANEL","ADMIN  CONTROLS:");
					}
					if(r1.getString(3).equals("EMPLOYEE")){
						 AdminPanel ap=new AdminPanel();
					     ap.control(r1.getString(3),"EMPLOYEE PANEL","EMPLOYEE  CONTROLS:");
						}
				}
				else
					JOptionPane.showMessageDialog(null, "incorrcet username|password");
				CreateConnection.close1();
				r1.close();
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
}
 
