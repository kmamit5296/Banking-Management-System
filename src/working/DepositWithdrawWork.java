package working;
import working.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;

import javax.swing.*;

import GUI.*;

import connection.CreateConnection;
public class DepositWithdrawWork extends JFrame {
	String formname,type;
	DepositWithdawPanel jp;
    void properties(){
        setSize(850,400);
        setLocation(200,80);
        setTitle(formname);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        }
    void addHeader(){
        Header h1=new Header();
        add(h1,BorderLayout.NORTH);
        h1.control(formname);
        }

    void addPanel1(){
        jp=new DepositWithdawPanel();
        add(jp,BorderLayout.CENTER);
        jp.setBackground(Color.LIGHT_GRAY);
        jp.setLayout(new FlowLayout(FlowLayout.CENTER,200,10));
        jp.addPanel1Components(this,formname,type);
        }
    public void control(String fn,String t1){
        type=t1;
        formname=fn;
    	properties();
        addHeader();
        addPanel1();
        setVisible(true);
        }
    public class DepositWork implements ActionListener {
    	String acno,bal1;
    	double dwbal,bal;
    	Calendar c1=Calendar.getInstance();
    	boolean getDWBal(){
    		try{dwbal=Double.parseDouble(jp.jtf4.getText());
    		}
    		catch(IllegalArgumentException ev){
    			jp.jtf4.setText("");
    			JOptionPane.showMessageDialog(null, "INCORRECT "+type+" AMOUNT");
    			return false;
    		}
    		return true;
    	}
    	boolean checkAccount(){
    		acno=jp.jtf1.getText();
    		 if(acno.length()!=10){
    			 JOptionPane.showMessageDialog(null, "invalid account number");
    			 return false;
    		 	}	 
    		 return true;
    	 }
    	void DW(String s){
    			
				try{if(CreateConnection.Update("update account set balance=balance"+s+dwbal+"where account_number="+acno)==1){
						if(s.equals("+"))
						CreateConnection.Update("insert into balance_sheet (account_number,date,mode,deposit,balance) values('"+acno+"','"
								+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+"','cash',"+dwbal+
								",(select balance from account where account_number='"+acno+"'))");
						else if(s.equals("-"))
							CreateConnection.Update("insert into balance_sheet (account_number,date,mode,debit,balance) values('"+acno+"','"
									+c1.get(Calendar.YEAR)+"-"+c1.get(Calendar.MONTH)+"-"+c1.get(Calendar.DAY_OF_MONTH)+"','cash',"+dwbal+
									",(select balance from account where account_number='"+acno+"'))");
						JOptionPane.showMessageDialog(null, "AMOUNT "+type+"ED");
						}	
					CreateConnection.close1();
				}
				catch(SQLException ex){
			 		ex.printStackTrace();
					}
				catch(ClassNotFoundException ex){
					ex.printStackTrace();
					}
    			
    	}
    	boolean checkbal(){
    		if((bal-dwbal)<=500){
    			JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
    			return false;}
    		return true;
    	}
    	public void actionPerformed(ActionEvent e){
    			if(checkAccount()){
    				try{
    					ResultSet r1=CreateConnection.execute("select account_number,name,balance from account where account_number="+acno);
    					if(r1.next()){
    						jp.jtf2.setText(r1.getString(2));
    						bal1=r1.getString(3);
    						jp.jtf3.setText(bal1);
    					    bal=Double.parseDouble(bal1);
    					}
    					else
    						JOptionPane.showMessageDialog(null, "account number not exist");
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
    			if(e.getSource()==jp.jb2&&type.equals("DEPOSIT")&&getDWBal()){
    				DW("+");
    			}
    			else if(e.getSource()==jp.jb2&&type.equals("DEBIT")&&getDWBal()){	
    				if(checkbal())
    					DW("-");
    			}			
    		}
    }

}
