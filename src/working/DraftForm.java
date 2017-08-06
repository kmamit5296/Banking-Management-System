package working;
import javax.swing.*;
import GUI.*;
import connection.CreateConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
public class DraftForm extends JFrame {
	 DraftPanel dp;
	 void properties(){
	        setSize(930,500);
	        setLocation(200,80);
	        setTitle("DRAFT FORM");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("Money Transfer form");
	        }
	 void addPanel1(){
	        dp=new DraftPanel();
	        add(dp,BorderLayout.CENTER);
	        dp.setBackground(Color.LIGHT_GRAY);
	        dp.setLayout(new FlowLayout(FlowLayout.CENTER,231,10));
	        dp.addPanel1Components(this);
	        }
	 public void control(){
         properties();
         addHeader();
         addPanel1();
         setVisible(true);
        } 
	 public class DraftWork implements ActionListener{
		 	String dfno,favour,acno;
		 	double amt;
		 	Calendar c1=Calendar.getInstance();
		 	boolean getAmt(){
		 		try{amt=Double.parseDouble(dp.jtf3.getText());
		 		}
		 		catch(IllegalArgumentException ex){
		 			dp.jtf3.setText("");
		 			JOptionPane.showMessageDialog(null,"amount incorrect");
		 			return false;
		 		}
		 		return true;
		 	}
		 	boolean checkDraftno(){
		 		dfno=dp.jtf1.getText();
		 		if(dfno.length()!=5){
		 			 JOptionPane.showMessageDialog(null, "invalid draft number");
		 			 return false;
		 		}
		 		return true;
		 	}
		 	boolean checkAccount(){
		 		
	    		ResultSet r1;int a=0;
		 		acno=dp.jtf2.getText();
	    		 if(acno.length()!=10){
	    			 dp.jtf2.setText("");
	    			 JOptionPane.showMessageDialog(null, "invalid account number");
	    			 return false;
	    		 	}
	    		 else{
	    		 try{r1=CreateConnection.execute("select account_number from account");
	    		 		while(r1.next()){
	    		 			if(r1.getString(1).equals(acno))
	    		 				a=1;
	    		 		}
	    		 		if(a==1)
	    		 			return true;
	    		 		else if(a==0){dp.jtf2.setText("");
	    		 			JOptionPane.showMessageDialog(null, "account number does not exist");
	    		 			return false;
	    		 		}
	    		 		r1.close();
	    		 }
	    		
		 		 catch(SQLException ex){
				 		ex.printStackTrace();
						}
		 	   	 catch(ClassNotFoundException ex){
	   				 ex.printStackTrace();
						}
	    		 
	    		 }
	    		 return true;
	    	 }
		 	boolean checkEmpty(){
		 		favour=dp.jta.getText();
		 		if(favour.equals("")){
		 			JOptionPane.showMessageDialog(null, "in favourof field is empty");
		 			return false;
		 			}
		 		return true;
		 	}
		 	public void actionPerformed(ActionEvent e){
		 		if(checkDraftno()&&checkAccount()&&getAmt()&&checkEmpty()){
		 			
		 			try{
		 			if(CreateConnection.Update("insert into draft values('"+dfno+"','"+favour+"','"+acno+"',"+amt+")")==1){
		 				CreateConnection.Update("Update account set balance=balance-"+amt+"where account_number="+acno);
		 				CreateConnection.Update("insert into balance_sheet (account_number,date,mode,debit,balance) values('"+acno+"','"
								+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+"','draft',"+amt+
								",(select balance from account where account_number='"+acno+"'))");
		 				JOptionPane.showMessageDialog(null, "draft saved");
		 				}
		 			}
		 			 catch(SQLIntegrityConstraintViolationException ex){
		    			 JOptionPane.showMessageDialog(null, "draft number already exist");
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

