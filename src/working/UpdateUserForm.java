package working;
import javax.swing.*;

import GUI.*;
import connection.CreateConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class UpdateUserForm extends JFrame {
	UpdateUserPanel jp;
	void properties(){
        setSize(930,600);
        setLocation(200,80);
        setTitle("UPDATE USER FORM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        }
	void addHeader(){
        Header h1=new Header();
        add(h1,BorderLayout.NORTH);
        h1.control("update  user  form");
        }
	
	void addPanel1(){
        jp=new UpdateUserPanel();
        add(jp,BorderLayout.CENTER);
        jp.setBackground(Color.LIGHT_GRAY);
        jp.setLayout(new FlowLayout(FlowLayout.CENTER,231,10));
        jp.addPanel1Components(this);
        }
	public void control(){
		properties();
		addHeader();
		addPanel1();
		setVisible(true);
    } 
	public class UpdateUserWork implements ActionListener{
		String id,username,name,gender,phone,address;
		long  userid,euserid;
		java.util.Date date;
		Calendar c1=Calendar.getInstance();
		boolean checkUserid(){
    		id=jp.jtf1.getText();
    		 if(id.length()!=5){jp.jtf1.setText("");
    			 JOptionPane.showMessageDialog(null, "invalid user id");
    			 return false;
    		 	}	 
    		 return true;
    	 }
		void  setVal(){
			c1.setTime(date);
			jp.jtf2.setText(username);
			jp.jtf3.setText(name);
			jp.jtf4.setText(phone);
			jp.jta.setText(address);
			jp.jcb1.setSelectedItem(c1.get(Calendar.DAY_OF_MONTH));
			jp.jcb2.setSelectedIndex(c1.get(Calendar.MONTH));
			jp.jcb3.setSelectedItem(c1.get(Calendar.YEAR));
			if(gender.equals("male"))
				jp.bg.setSelected(jp.jrb1.getModel(), true);
			else jp.bg.setSelected(jp.jrb2.getModel(), true);

		}
		void getVal(){
			username=jp.jtf2.getText();
			name=jp.jtf3.getText();
			phone=jp.jtf4.getText();
			address=jp.jta.getText();
			c1.set(Calendar.DAY_OF_MONTH,(int)jp.jcb1.getSelectedItem());
			c1.set(Calendar.MONTH,jp.jcb2.getSelectedIndex());
			c1.set(Calendar.YEAR,(int) jp.jcb3.getSelectedItem());
		}
		 boolean checkValues(){
    		 try{
    			 getVal();
    		 if(jp.jcb2.getSelectedIndex()==0){
    			 JOptionPane.showMessageDialog(null, "month not selected");
    		 		return false;
    		 	}
    		 if(name.equals("")||username.equals("")||phone.equals("")||address.equals("")){
    			 JOptionPane.showMessageDialog(null, "field is empty");
    		 		return false;
    		 	}
 		 	}
    		 catch(ClassCastException ex){
    			 JOptionPane.showMessageDialog(null, "date not selected correctly");
				 return false;
			 }
    		 return true;
    	}
		 boolean checkRadioB(){
    		 if(jp.bg.isSelected(jp.jrb1.getModel())||jp.bg.isSelected(jp.jrb1.getModel())){}
    		 else{ 
 				JOptionPane.showMessageDialog(null, "gender not selected"); 
 				return false;
 				}
 		 return true;
    			 
    	 }
		 void insert()throws SQLException,ClassNotFoundException,NumberFormatException,SQLIntegrityConstraintViolationException{
			 if(checkValues()&&checkUserid()&&checkRadioB()) {
				 euserid=new Long(id);
				 if(CreateConnection.Update("update user set user_id="+euserid+",name='"+name+
						 "',date_of_birth='"+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+
						 "',phone='"+phone+"',address='"+address+"',username='"+username+"' where user_id="+userid)==1)
					JOptionPane.showMessageDialog(null, "user updated");
				 CreateConnection.close1();
			 }				 
		 }
		 void Delete()throws SQLException,ClassNotFoundException,NumberFormatException,SQLIntegrityConstraintViolationException{
			 if(CreateConnection.Update("delete from user where user_id="+userid)==1)
				 JOptionPane.showMessageDialog(null, "user deleted");
			 else 
				 JOptionPane.showMessageDialog(null, "try again");
			 CreateConnection.close1();
		 }
		public void actionPerformed(ActionEvent e){
			try{
				if(e.getSource()==jp.jb1&&checkUserid()){
					userid=new Long(id);
					ResultSet r1=CreateConnection.execute("select user_id,username,name,gender,phone,address,date_of_birth from user where user_id="+userid);
					if(r1.next()){
						username=r1.getString(2);
						name=r1.getString(3);
						gender=r1.getString(4);
						phone=r1.getString(5);
						address=r1.getString(6);
						date=r1.getDate(7);
						setVal();
					}
					else 
						JOptionPane.showMessageDialog(null, "user id not exist");
					r1.close();
					CreateConnection.close1();
				
				
				}
			else	
			if(e.getSource()==jp.jb2){ 
				    if(checkUserid())
					userid=new Long(id);
					insert();
					}
			else if(e.getSource()==jp.jb3){String[] ab={"yes","no","cancel"};
					if(checkUserid())
						userid=new Long(id);
					if(JOptionPane.showOptionDialog(UpdateUserForm.this,"Are you sure you want to delete this Account??",
    						"Confirmation", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null, ab,ab[1] )==JOptionPane.YES_OPTION)
					Delete();
					}	
			}
			catch(SQLIntegrityConstraintViolationException ex){
				JOptionPane.showMessageDialog(null, "invalid user id1");
			}
			catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "invalid user id1"); 
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

