package working;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import connection.CreateConnection;
public class ImageCheck extends JFrame{
	GridBagConstraints gc1;
	GridBagLayout gb1;
	String acno;
	 void properties(){
	        setSize(800,500);
	        setLocation(200,80);
	        setTitle("IMAGE FORM");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        }   
	 void addLabel(String name,int x,int y){
		 JLabel jl=new JLabel(name);
		 jl.setFont(new Font("Corbel",Font.ITALIC,20));
         jl.setForeground(Color.BLUE);
		 gc1.gridx=x;
		 gc1.gridy=y;
		 gb1.setConstraints(jl, gc1);
		 add(jl);
	 }
	 void displayImage(){
		 byte[] b1,b2;
		 ImageIcon i1=new ImageIcon(),i2=new ImageIcon();
		 try{
		 ResultSet r1=CreateConnection.execute("select * from image where account_number='"+acno+"'");
    	 if(r1.next()){
    		b1=r1.getBytes(2);System.out.println(b1);
    		i1=new ImageIcon(b1);
    		i1.setImage(i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    		b2=r1.getBytes(3);System.out.println(b2);
    		i2=new ImageIcon(b2);
    		i2.setImage(i2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    		JLabel jl1=new JLabel(i1);
    		gc1.gridx=0;
    	   	 gc1.gridy=1;
    	   	 gb1.setConstraints(jl1, gc1);
    	   	 add(jl1);
    	   	 JLabel jl2=new JLabel(i2);
    	   	 gc1.gridx=2;
    	   	 gc1.gridy=1;
    	   	 gb1.setConstraints(jl2, gc1);
    	   	 add(jl2);
    	   	 setVisible(true);
    	 	}
    	 else {setVisible(false);
    		 JOptionPane.showMessageDialog(null, "account number not exist");
    	 }
    	 r1.close();
    	 CreateConnection.close1();
		 }
		 catch(SQLException ex){
			 ex.printStackTrace();
		 }
		 catch(ClassNotFoundException ex){
			 ex.printStackTrace();
		 }
    	 
	 }
	 public void control(String ac){
		 properties();
		 acno=ac;System.out.println(acno);
		 gc1=new GridBagConstraints();
		 gb1=new GridBagLayout();
		 setLayout(gb1);
		 addLabel("IMAGE:",0,0);
		 addLabel("                 ",1,0);
		 addLabel("SIGN:",2,0);
		 displayImage();
	 }
}
