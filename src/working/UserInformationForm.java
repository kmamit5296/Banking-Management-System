package working;
import javax.swing.*;
import GUI.*;
import connection.CreateConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UserInformationForm extends JFrame{
	UserInformationPanel jp;
	void properties(){
        setSize(960,500);
        setLocation(200,80);
        setTitle("USER INFORMATION FORM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        }
	void addHeader(){
        Header h1=new Header();
        add(h1,BorderLayout.NORTH);
        h1.control("User Information form");
        }
	
	void addPanel1(){
	        jp=new UserInformationPanel();
	        add(jp,BorderLayout.CENTER);
	        jp.setBackground(Color.LIGHT_GRAY);
	        jp.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
	        jp.addPanel1Components(this);
	        }
	 public void control(){
         properties();
         addHeader(); 
         addPanel1();
         setVisible(true);
        }
	 public class UserInformationWork implements ActionListener{
		 String userid,name,gender,phone,address,username,password,type;
		Integer d,m,y;
		 void getVal()throws ClassCastException{
			 name=jp.jtf1.getText();
			 phone=jp.jtf2.getText();
			 address=jp.jta.getText();
			 username=jp.jtf3.getText();
			 
			 password=new String(jp.jpf.getPassword());
			 type=(String)jp.jcb4.getSelectedItem();
			 d=(Integer)jp.jcb1.getSelectedItem();
			 m=jp.jcb2.getSelectedIndex();
    		 y=(Integer)jp.jcb3.getSelectedItem();
    		 if(jp.bg.getSelection()==jp.jrb1.getModel())
    			 gender="male";
    		 else gender="female";
		 }
		 boolean checkRadioB(){
    		 if(jp.bg.isSelected(jp.jrb1.getModel())||jp.bg.isSelected(jp.jrb2.getModel())){}
    		 else{ 
 				JOptionPane.showMessageDialog(null, "gender not selected"); 
 				return false;
 				}
 		 return true;
    			 
    	 }
		 boolean checkValues(){
    		 try{getVal();
    		 if(type.equals("select")||m==0){
    			 JOptionPane.showMessageDialog(null, "type or month not selected rightly");
    		 		return false;
    		 	}
    		 if(name.equals("")||phone.equals("")||address.equals("")||username.equals("")||password.equals("")){
    			 JOptionPane.showMessageDialog(null, "field is empty");
    		 		return false;
    		 	}
 		 	}
    		 catch(ClassCastException ex){
    			 JOptionPane.showMessageDialog(null, "date not selected rightly");
				 return false;
			 }
    		 return true;
		 }
		 boolean checkUserid(){userid=jp.jtf4.getText();
    		 if(userid.length()!=5||userid.charAt(0)=='0'){jp.jtf4.setText("");
			 JOptionPane.showMessageDialog(null, "user id should be of 5 numbers");
			 return false;
		 	}	 
		 return true;
    	 }
		 public void actionPerformed(ActionEvent e){
			 try{
				 if(checkValues()&&checkUserid()&&checkValues()&&checkRadioB())
					 if(CreateConnection.Update("insert into user values('"+userid+"','"+name+"','"+gender+"','"+y+"-"+m+"-"+d+"','"+phone+"','"+address+"','"
							 +username+"','"+password+"','"+type+"')")==1)
						 JOptionPane.showMessageDialog(null, "user created");
				 
			 }
			 catch(SQLIntegrityConstraintViolationException ex){
				 JOptionPane.showMessageDialog(null, "user id already existst");
			 	}
			 catch(ClassCastException ex){
				 JOptionPane.showMessageDialog(null, "date not selected rightly");
			 }
			 catch(SQLException ex){jp.jtf4.setText("");
				 JOptionPane.showMessageDialog(null, "invalid user id");
			 }
			 catch(ClassNotFoundException ex){
				 JOptionPane.showMessageDialog(null, "something incorrect happened try again");
			 }
		 }
	 }
}
