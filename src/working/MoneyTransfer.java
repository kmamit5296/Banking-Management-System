package working;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;

import javax.swing.*;

import GUI.*;
import connection.CreateConnection;
public class MoneyTransfer extends JFrame {
	 MoneyTransferPanel jp;
	 void properties(){
	        setSize(930,400);
	        setLocation(200,80);
	        setTitle("MONEY TRANSFER FORM");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("Money Transfer form");
	        }
	 void addPanel1(){
	        jp=new MoneyTransferPanel();
	        add(jp,BorderLayout.CENTER);
	        jp.setBackground(Color.LIGHT_GRAY);
	        jp.setLayout(new FlowLayout(FlowLayout.CENTER,168,10));
	        jp.addPanel1Components(this);
	        }
	 public void control(){
         properties();
         addHeader();
         addPanel1();
         setVisible(true);
        }  
	 public class MoneyTransferWork implements ActionListener{
		 String sacno,dacno,name,bal;
		 double camt,amt;
		 Calendar c1=Calendar.getInstance();
		 boolean checkSDAccount(JTextField jtf,String acno){
			 	ResultSet r1;int a=0;
	    		 if(acno.length()!=10){jtf.setText("");
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
		    		 		else if(a==0){jtf.setText("");
		    		 			JOptionPane.showMessageDialog(null, "invalid account number");
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
		 boolean getBal(){
	    		try{amt=Double.parseDouble(jp.jtf5.getText());
	    		}
	    		catch(IllegalArgumentException ev){
	    			jp.jtf5.setText("");
	    			JOptionPane.showMessageDialog(null, "INCORRECT  AMOUNT");
	    			return false;
	    		}
	    		return true;
	    	}
		 boolean checkbal(){
	    		if((camt-amt)<=500){
	    			JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE TO TRANSFER");
	    			return false;}
	    		return true;
	    	}
		 public void actionPerformed(ActionEvent e){
			 try{sacno=jp.jtf1.getText();
			 	if(checkSDAccount(jp.jtf1,sacno)){
 				
 					ResultSet r1=CreateConnection.execute("select account_number,name,balance from account where account_number="+sacno);
 					if(r1.next()){
 						jp.jtf2.setText(r1.getString(2));
 						bal=r1.getString(3);
 						jp.jtf3.setText(bal);
 						camt=Double.parseDouble(bal);
 					}
 					CreateConnection.close1();
 					r1.close();
 				}
 			dacno=jp.jtf4.getText();
 			if(e.getSource()==jp.jb2&&checkSDAccount(jp.jtf4,dacno)&&getBal()&&checkbal()){
 				if(CreateConnection.Update("update account set balance=balance-"+amt+"where account_number="+sacno)==1) 
 					if(CreateConnection.Update("update account set balance=balance+"+amt+"where account_number="+dacno)==1){
 						CreateConnection.Update("insert into balance_sheet (account_number,date,mode,debit,balance) values('"+sacno+"','"
								+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+"','transfer',"+amt+
								",(select balance from account where account_number='"+sacno+"'))");
 						CreateConnection.Update("insert into balance_sheet (account_number,date,mode,deposit,balance) values('"+dacno+"','"
								+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+"','transfer',"+amt+
								",(select balance from account where account_number='"+dacno+"'))");
 						JOptionPane.showMessageDialog(null, "Amount transferred");
 					}
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
