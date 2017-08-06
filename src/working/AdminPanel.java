package working;
import GUI.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tables.*;
public class AdminPanel extends JFrame {
	AdminPanel1 ap;
    void properties(String tl){
        setSize(1300,600);
        setLocation(20,50);
        setTitle(tl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }    
    void addHeader(String tl){
        Header h1=new Header();
        add(h1,BorderLayout.NORTH);
        h1.control(tl);
        }
    void addDeveloper(){
		JLabel jl=new JLabel("Developed By: AMIT KUMAR");
		jl.setFont(new Font("Candara",Font.BOLD,20));
	    jl.setForeground(Color.RED);
	    add(jl,BorderLayout.SOUTH);
		}
    void addPanel1(String tp,String fn){
    	ap=new AdminPanel1();
        add(ap,BorderLayout.CENTER);
        ap.setLayout(new FlowLayout(FlowLayout.CENTER,120,40));
        ap.addComponents(this,tp,fn);
        }
    public void control(String tp,String tl,String fn){
        properties(tl);
        addHeader(tl);
        addPanel1(tp,fn);
        addDeveloper();
        setVisible(true);
        }
    void openForm(int a){
    	switch(a){
    	case 1:CInfoForm c1=new CInfoForm();
				c1.control("SUBMIT","RESET");
				break;
    	case 2:CInfoForm c2=new CInfoForm();
				c2.control("UPDATE","DELETE");
				break;
    	case 3:LOCTable ap=new  LOCTable();
        		ap.control();
        		break;
    	}
    }
    void openForm1(int a){
    	switch(a){
    	case 1:UserInformationForm c1=new UserInformationForm();
				c1.control();
				break;
    	case 2:UpdateUserForm c2=new UpdateUserForm();
				c2.control();
				break;
    	case 3:LOUTable ap=new  LOUTable();
				ap.control();
				break;
    	}
    }
    void openForm2(int a){
    	switch(a){
    	case 1:DepositWithdrawWork c1=new DepositWithdrawWork();
				c1.control("DEPOSIT FORM","DEPOSIT");
				break;
    	case 2:DepositWithdrawWork c2=new DepositWithdrawWork();
				c2.control("DEBIT FORM","DEBIT");
				break;
    	case 3:MoneyTransfer c3=new MoneyTransfer();
				c3.control();
				break;	
    	case 4:DraftForm c4=new DraftForm();
				c4.control();
				break;			
    	}
    }
    void openForm4(int a){
    	switch(a){
    	case 1:BalanceSheet b1=new BalanceSheet();
				b1.control();
				break;
    	case 2:LODTable c2=new LODTable();
				c2.control();
				break;
    	}
    }	
    void openForm3(int a){
    	switch(a){
    	case 3:setVisible(false);
    			break;
    	case 1:AdminChangePassword c1=new AdminChangePassword();
				c1.control();
				break;
    	case 2:System.exit(0);	
    			break;
    	case 4:ContactMe cm=new ContactMe();
    			cm.control();
    			
    	}
    }	
    public class AdminSelect implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource()==ap.jcb1){
    			if(ap.jcb1.getSelectedItem().equals("New Account"))
    				openForm(1);
    			else if(ap.jcb1.getSelectedItem().equals("Search Account"))
    				openForm(2);
    			else if(ap.jcb1.getSelectedItem().equals("Update Account"))
    				openForm(2);
    			else if(ap.jcb1.getSelectedItem().equals("All Customers"))
    				openForm(3);
    		}
    		else if(e.getSource()==ap.jcb2){
    			if(ap.jcb2.getSelectedItem().equals("Create User"))
    				openForm1(1);
    			else if(ap.jcb2.getSelectedItem().equals("Search User"))
    				openForm1(2);
    			else if(ap.jcb2.getSelectedItem().equals("Update User"))
    				openForm1(2);
    			else if(ap.jcb2.getSelectedItem().equals("All User"))
    				openForm1(3);
    		}
    		else if(e.getSource()==ap.jcb3){
    			if(ap.jcb3.getSelectedItem().equals("Deposit"))
    				openForm2(1);
    			else if(ap.jcb3.getSelectedItem().equals("Withdraw"))
    				openForm2(2);
    			else if(ap.jcb3.getSelectedItem().equals("Transfer"))
    				openForm2(3);
    			else if(ap.jcb3.getSelectedItem().equals("Draft Form"))
    				openForm2(4);
    		}
    		else if(e.getSource()==ap.jcb4){
    			if(ap.jcb4.getSelectedItem().equals("Balance Sheet"))
    				openForm4(1);
    			else if(ap.jcb4.getSelectedItem().equals("Draft(s)"))
    				openForm4(2);
    		}
    		else if(e.getSource()==ap.jcb5){
    			if(ap.jcb5.getSelectedItem().equals("Logout"))
    				openForm3(3);
    			if(ap.jcb5.getSelectedItem().equals("Change Password"))
    				openForm3(1);
    			if(ap.jcb5.getSelectedItem().equals("Contact Developer"))
    				openForm3(4);
    			else if(ap.jcb5.getSelectedItem().equals("Exit"))
    				openForm3(2);
    		}
    	}
    }
 }
