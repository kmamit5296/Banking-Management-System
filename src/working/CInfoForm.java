package working;
import GUI.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;

import connection.*;
import javax.swing.*;
public class CInfoForm extends JFrame {
	CInfoPanel jp;
	String b1,b2,paccount;
	 Date date;
     void properties(){
        setSize(1100,600);
        setLocation(100,80);
        setTitle("CUSTOMER INFORMATION FORM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }    
     void addHeader(){
        Header h1=new Header();
        add(h1,BorderLayout.NORTH);
        h1.control("Customer information form");
        }
     void addPanel1(){
        jp=new CInfoPanel();
        add(jp,BorderLayout.CENTER);
        jp.setBackground(Color.LIGHT_GRAY);
        jp.setLayout(new FlowLayout(FlowLayout.CENTER,240,10));
        jp.addPanel1Components(this,b1,b2);
        }
    
     public void control(String sd,String rd){
         properties();
         addHeader();
         b1=sd;
         b2=rd;
         addPanel1();
         setVisible(true);
        }
     public class Account implements ActionListener{
    	 String name,account_no,phone_no,distric,father,mother,address,state,gender,marry;
    	 double bal;
    	
    	 Calendar c1=Calendar.getInstance();
    	 void setEmpty(){
    		jp.jtf1.setText("");
     		jp.jtf2.setText("");
     		jp.jtf3.setText("");
     		jp.jtf4.setText("");
     		jp.jtf5.setText("");
     		jp.jtf6.setText("");
     		jp.jtf7.setText("");
     		jp.jta.setText("");
     		jp.jcb1.setSelectedIndex(0);
     		jp.jcb2.setSelectedIndex(0);
     		jp.jcb3.setSelectedIndex(0);
     		jp.jcb4.setSelectedIndex(0);
     		jp.bg1.clearSelection();
     		jp.bg2.clearSelection();
    	 }
    	 void getVal()throws IllegalArgumentException{
    		 account_no=jp.jtf1.getText();
    		 name=jp.jtf2.getText();
    		 phone_no=jp.jtf3.getText();
    		 distric=jp.jtf4.getText();
    		 father=jp.jtf5.getText();
    		 mother=jp.jtf6.getText();
    		 bal=Double.parseDouble(jp.jtf7.getText());
    		 address=jp.jta.getText();
    		 state=(String)jp.jcb4.getSelectedItem();
    		 c1.set(Calendar.DAY_OF_MONTH,(int)jp.jcb1.getSelectedItem());
 			 c1.set(Calendar.MONTH,(jp.jcb2.getSelectedIndex()+1));
 		   	 c1.set(Calendar.YEAR,(int) jp.jcb3.getSelectedItem());
    		 if(jp.bg1.getSelection()==jp.jrb1.getModel())
    			 marry="married";
    		 else 
    			 marry="unmarried";
    		 if(jp.bg2.getSelection()==jp.jrb3.getModel())
    			 gender="male";
    		 else  
    			 gender="female";
    	 }
    	 void setVal(){c1.setTime(date);
    		jp.jtf1.setText(account_no);
      		jp.jtf2.setText(name);
      		jp.jtf3.setText(phone_no);
      		jp.jtf4.setText(distric);
      		jp.jtf5.setText(father);
      		jp.jtf6.setText(mother);
      		jp.jtf7.setText(Double.toString(bal));
      		jp.jta.setText(address);
      		jp.jcb1.setSelectedItem(c1.get(Calendar.DAY_OF_MONTH));
      		jp.jcb2.setSelectedIndex(c1.get(Calendar.MONTH));
      		jp.jcb3.setSelectedItem(c1.get(Calendar.YEAR));
      		jp.jcb4.setSelectedItem(state);
      		if(marry.equals("married"))
				jp.bg1.setSelected(jp.jrb1.getModel(), true);
			else jp.bg1.setSelected(jp.jrb2.getModel(), true);
      		if(gender.equals("male"))
				jp.bg2.setSelected(jp.jrb3.getModel(), true);
			else jp.bg2.setSelected(jp.jrb4.getModel(), true);
    	 }
    	 boolean checkDigit(){
    		 for(int i=0;i!=account_no.length();i++){
    			if(Character.isDigit(account_no.charAt(i))){}
    			else{ jp.jtf1.setText("");
    				JOptionPane.showMessageDialog(CInfoForm.this, "invalid account number"); 
    				return false;
    				}
    		 }
    		 return true;
    	 }
    	 boolean checkRadioB(){
    		 if((jp.bg1.isSelected(jp.jrb1.getModel())||jp.bg1.isSelected(jp.jrb2.getModel()))&&(jp.bg2.isSelected(jp.jrb3.getModel())||jp.bg2.isSelected(jp.jrb4.getModel()))){}
    		 else{ 
 				JOptionPane.showMessageDialog(CInfoForm.this, "gender or marital status not selected"); 
 				return false;
 				}
 		 return true;
    			 
    	 }
    	 boolean checkValues(){
    		 try{getVal();
    		 if(state.equals("state")||c1.get(Calendar.MONTH)==0){
    			 JOptionPane.showMessageDialog(null, "state or month not selected rightly");
    		 		return false;
    		 	}
    		 if(name.equals("")||phone_no.equals("")||distric.equals("")||father.equals("")||mother.equals("")||address.equals("")){
    			 JOptionPane.showMessageDialog(null, "field is empty");
    		 		return false;
    		 	}
 		 	}
    		 catch(IllegalArgumentException exp){
    			 jp.jtf7.setText("");
 			 		JOptionPane.showMessageDialog(CInfoForm.this, "invalid data");
 			 		return false;
    		 		}
    		 catch(ClassCastException ex){
    			 JOptionPane.showMessageDialog(null, "date not selected rightly");
				 return false;
			 }
    		 return true;
    	}
    	 boolean checkAccount_no(){account_no=jp.jtf1.getText();
    		 if(account_no.length()!=10){jp.jtf1.setText("");
			 JOptionPane.showMessageDialog(CInfoForm.this, "invalid account number");
			 return false;
		 	}	 
		 return true;
    	 }
    	 void updateValues() throws ClassNotFoundException,SQLIntegrityConstraintViolationException,SQLException{
    		 if(CreateConnection.Update("update account set account_number="+account_no+",name='"+name+"',phone_number='"+phone_no+"',distric='"+distric+"',father_name='"+father+
    				 "',mother_name='"+mother+"',address='"+address+"',DOB='"+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+
					 "',state='"+state+"',marital_status='"+marry+"',balance="+bal+" where account_number='"+paccount+"'")==1)
				JOptionPane.showMessageDialog(null, "user updated");
			 CreateConnection.close1();
    	 }
    	 void insertValues()throws SQLException,ClassNotFoundException{
   			if (CreateConnection.Update("insert into account values('"+account_no+"','"+name+"','"+phone_no+"','"+distric+"','"+father+"','"+
					 mother+"','"+address+"','"+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+
					 "','"+state+"','"+gender+"','"+marry+"',"+bal+")")==1)
   			 
    				JOptionPane.showMessageDialog(CInfoForm.this, "account saved");
    				 
    	    CreateConnection.close1();
    		}
    	 void Delete()throws SQLIntegrityConstraintViolationException,SQLException,ClassNotFoundException{
    		 if(CreateConnection.Update("delete from account where account_number='"+account_no+"'")==1)
    			 
				 JOptionPane.showMessageDialog(null, "Account deleted");
			 else 
				 JOptionPane.showMessageDialog(null, "invalid account number");
    		 CreateConnection.close1();
    	 }
    	 boolean checkImage()throws SQLException,ClassNotFoundException {
    		 int a=0;
    		 ResultSet r1=CreateConnection.execute("select account_number from image");
		 		while(r1.next()){
		 			if(r1.getString(1).equals(account_no))
		 				a=1;
		 		}
		 		if(a==1)
		 			return true;
		 		else if(a==0){
		 			JOptionPane.showMessageDialog(null, "image not selected");
		 			return false;
		 		}
		 		r1.close();
		 		return true;
    	 }
    	 public void actionPerformed(ActionEvent e){
    		 try{
    		 if(e.getSource()==jp.jb1&&b1.equals("SUBMIT"))
    			 setEmpty();
    		 else if(e.getSource()==jp.jb2&&b1.equals("SUBMIT")){	 
    				 if(checkValues()&&checkAccount_no()&&checkDigit()&&checkRadioB()&&checkImage()){
    						 insertValues();
    				 }
    		 	}
    		 else if(e.getSource()==jp.jb3&&b1.equals("SUBMIT")){
    			 if(checkAccount_no()&&checkDigit()){
    				 ImageSignForm i1=new ImageSignForm();
    				 i1.control(account_no);
    			 }
    		 }
    		 else if(e.getSource()==jp.jb3&&b1.equals("UPDATE")){
    			 if(checkAccount_no()){
    				 ResultSet r1=CreateConnection.execute("select * from account where account_number='"+account_no+"'");
    				 if(r1.next()){paccount=jp.jtf1.getText();
    					 name=r1.getString(2);
    					 phone_no=r1.getString(3);
    					 distric=r1.getString(4);
    					 father=r1.getString(5);
    					 mother=r1.getString(6);
    					 address=r1.getString(7);
    					 date=r1.getDate(8);
    					 state=r1.getString(9);
    					 gender=r1.getString(10);
    					 marry=r1.getString(11);
    					 bal=r1.getDouble(12);
    					 setVal();
    				 		}
    				else 
    						JOptionPane.showMessageDialog(null, "Account not exist");
    				
    				 CreateConnection.close1();
    				 r1.close();
    			 		}
    		 		}
    		 else if(e.getSource()==jp.jb2&&b1.equals("UPDATE")){
    			 if(checkValues()&&checkAccount_no()&&checkDigit()&&checkRadioB()){
					 updateValues();
    			 	}
    		 	}
    		 else if(e.getSource()==jp.jb1&&b1.equals("UPDATE")){String[] ab={"yes","no","cancel"};
    			if(checkAccount_no()){
    				if(JOptionPane.showOptionDialog(CInfoForm.this,"Are you sure you want to delete this Account??",
    						"Confirmation", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null, ab,ab[1] )==JOptionPane.YES_OPTION)
    				Delete();
    				}
    		 	}
    		 else if(e.getSource()==jp.jb4&&b1.equals("UPDATE")){
    			 if(checkAccount_no()&&checkDigit()){
    				 ImageCheck i1=new ImageCheck();
    			 		i1.control(account_no);
    			 	}
    		 	}
    		 }
    		 catch(SQLIntegrityConstraintViolationException ex){
				 JOptionPane.showMessageDialog(CInfoForm.this, "account number already existst");
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
