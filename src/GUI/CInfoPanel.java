package GUI;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import connection.CreateConnection;
public class CInfoPanel extends JPanel {
	 GridBagLayout gb1;
	 GridBagConstraints gc1;
	 String nb1;
	 working.CInfoForm c1;
	 public JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
	 public JTextArea jta;
	 public JComboBox jcb1,jcb2,jcb3,jcb4;
	 public JRadioButton jrb1,jrb2,jrb3,jrb4;
	 public ButtonGroup bg1,bg2;
	 public JButton jb2,jb1,jb3,jb4;
	 void addPanel1Name(){
	        FormName fn1=new FormName();
	        fn1.control("CUSTOMER  INFORMATION  FORM:");
	        add(fn1);
	         }
	     void addPanel5ButtonGroup(JPanel jp5,String name[]){
	         jrb1=new JRadioButton(name[0]);
	         jrb2=new JRadioButton(name[1]);
	         bg1=new ButtonGroup();
	         bg1.add(jrb1);
	         bg1.add(jrb2);
	         jp5.add(jrb1);
	         jp5.add(jrb2);
	        }
	     void addPanel2Panel5(JPanel jp2){
	         JPanel jp5=new JPanel();
	         jp5.setBackground(Color.LIGHT_GRAY);
	         gc1.gridx=4;
	         gc1.gridy=5;
	         gb1.setConstraints(jp5, gc1);
	         jp2.add(jp5);
	         String name1[]={"MARRIED","UNMARRIED"};
	         addPanel5ButtonGroup(jp5,name1);
	        }
	     void addPanel4ButtonGroup(JPanel jp4,String name[]){
	         jrb3=new JRadioButton(name[0]);
	         jrb4=new JRadioButton(name[1]);
	         bg2=new ButtonGroup();
	         bg2.add(jrb3);
	         bg2.add(jrb4);
	         jp4.add(jrb3);
	         jp4.add(jrb4);
	        }
	     void addPanel2Panel4(JPanel jp2){
	         JPanel jp4=new JPanel();
	         jp4.setBackground(Color.LIGHT_GRAY);
	         gc1.gridx=1;
	         gc1.gridy=5;
	         gb1.setConstraints(jp4,gc1);
	         jp2.add(jp4);
	         String name1[]={"MALE","FEMALE"};
	         addPanel4ButtonGroup(jp4,name1);
	        }
	     void addPanel2Combobox4(JPanel jp2){
	         String[] state={"state","UTTAR PRADESH","JAMMU & KASHMIR","HARYANA","PUNJAB","UTTRANCHAL",
	             "DELHI","RAJASTHAN","MADHYA PRADESH","BIHAR","ARUNACHAL PRADESH","SIKKIM","TRIPURA",
	         "GOA","KERLA","MAHARASHTRA","TAMILNADU","CHATTISGARH"};
	         jcb4=new JComboBox(state);
	         gc1.gridx=4;
	         gc1.gridy=4;
	         gb1.setConstraints(jcb4,gc1);
	         jp2.add(jcb4);
	         }
	     
	     void addPanel3Combobox1(JPanel jp3){
	         Integer[] day=new Integer[31];
	         jcb1=new JComboBox();
	         jcb1.addItem("day");
	         for(int i=0;i<31;i++){
	             day[i]=i+1;
	             jcb1.addItem(day[i]);
	            }
	         jp3.add(jcb1);
	         }
	     void addPanel3Combobox2(JPanel jp3){
	         String[] month={"month","JANUARY","FEBURARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
	         jcb2=new JComboBox(month);
	         jp3.add(jcb2);
	         }
	     void addPanel3Combobox3(JPanel jp3){
	         Integer[] year=new Integer[60];
	         jcb3=new JComboBox();
	         jcb3.addItem("year");
	         for(int i=0;i<60;i++){
	             year[i]=1960+i;
	             jcb3.addItem(year[i]);
	            }
	         jp3.add(jcb3);
	         }
	     void addPanel2Panel3(JPanel jp2){
	         JPanel jp3=new JPanel();
	         jp3.setBackground(Color.LIGHT_GRAY);
	         jp3.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
	         gc1.gridx=1;
	         gc1.gridy=4;
	         gb1.setConstraints(jp3, gc1);
	         jp2.add(jp3);
	         addPanel3Combobox1(jp3);
	         addPanel3Combobox2(jp3);
	         addPanel3Combobox3(jp3);
	     }
	     JTextField addPanel2TextField(int x,int y){
	         JTextField jtf=new JTextField(18);
	         gc1.gridx=x;
	         gc1.gridy=y;
	         gc1.anchor=GridBagConstraints.WEST;
	         gb1.setConstraints(jtf,gc1);
	         return jtf;
	        }
	     void addPanel2Label(JPanel jp2,String name,int x,int y){
	         JLabel jl=new JLabel(name);
	         jl.setFont(new Font("Corbel",Font.ITALIC,20));
	         jl.setForeground(Color.BLUE);
	         gc1.gridx=x;
	         gc1.gridy=y;
	         gb1.setConstraints(jl,gc1);
	         jp2.add(jl);
	        }
	     void addPanel2TextArea(JPanel jp2){
	         jta=new JTextArea(8,18);
	         gc1.gridx=1;
	         gc1.gridy=3;
	         gb1.setConstraints(jta,gc1);
	         jp2.add(jta);
	        }
	     void addLine1Components(JPanel jp2){
	    	 addPanel2Label(jp2,"ACCOUNT NUMBER:   ",0,0);
	    	 jtf1=addPanel2TextField(1,0);
	    	 jp2.add(jtf1);
	    	 addPanel2Label(jp2,"                    ",2,0);
	    	 addPanel2Label(jp2,"NAME:   ",3,0);
	    	 jtf2=addPanel2TextField(4,0);
	    	 jp2.add(jtf2);
	     }
	     void addPanel2Button(JPanel jp2){
	    	 jb3=new JButton("DETAILS");
	    	 jb3.setFont(new Font("Verdana",Font.BOLD,20));
	    	 gc1.gridx=2;
	    	 gc1.gridy=0;
	    	 gc1.anchor=GridBagConstraints.WEST;
	    	 gb1.setConstraints(jb3,gc1);
	    	 jp2.add(jb3);
	    	 jb3.addActionListener(c1.new Account());
	     }
	     void addLine1Components1(JPanel jp2){
	    	 addPanel2Label(jp2,"ACCOUNT NUMBER:   ",0,0);
	    	 jtf1=addPanel2TextField(1,0);
	    	 jp2.add(jtf1);
	    	 addPanel2Button(jp2);
	    	 addPanel2Label(jp2," NAME:   ",3,0);
	    	 jtf2=addPanel2TextField(4,0);
	    	 jp2.add(jtf2);
	     }
	     void addPanel2Components(JPanel jp2){
	    	 if(nb1.equals("SUBMIT"))
	    		addLine1Components(jp2);
	    	 else 
	    		 addLine1Components1(jp2);
	    	 addPanel2Label(jp2,"PHONE NUMBER:   ",0,1);
	    	 jtf3=addPanel2TextField(1,1);
	    	 jp2.add(jtf3);
	    	 addPanel2Label(jp2,"DISTRIC:   ",3,1);
	    	 jtf4=addPanel2TextField(4,1);
	    	 jp2.add(jtf4);
	    	 addPanel2Label(jp2,"FATHER'S NAME:   ",0,2);
	    	 jtf5=addPanel2TextField(1,2);
	    	 jp2.add(jtf5);
	    	 addPanel2Label(jp2,"MOTHER'S NAME:   ",3,2);
	    	 jtf6=addPanel2TextField(4,2);
	    	 jp2.add(jtf6);
	    	 addPanel2Label(jp2,"ADDRESS:   ",0,3);
	    	 addPanel2TextArea(jp2);
	    	 addPanel2Label(jp2,"BALANCE:   ",3,3);
	    	 jtf7=addPanel2TextField(4,3);
	    	 jp2.add(jtf7);
	    	 addPanel2Label(jp2,"DATE OF BIRTH:   ",0,4);
	    	 addPanel2Panel3(jp2);
	    	 addPanel2Label(jp2,"STATE:   ",3,4);
	    	 addPanel2Combobox4(jp2);
	    	 addPanel2Label(jp2,"GENDER:   ",0,5);
	    	 addPanel2Panel4(jp2);
	    	 addPanel2Label(jp2,"MARITL STATUS:   ",3,5);
	    	 addPanel2Panel5(jp2);
	     }
	     JButton addPanel1Button(String name){
	         JButton jb=new JButton(name);
	         jb.setFont(new Font("Verdana",Font.BOLD,20));
	         return jb;
	        }
	     void addPanel1Panel2(){
	    	 JPanel jp2=new JPanel();
	         add(jp2);
	         jp2.setBackground(Color.LIGHT_GRAY);
	         gb1=new GridBagLayout();
	         gc1=new GridBagConstraints();
	         jp2.setLayout(gb1);
	         addPanel2Components(jp2);
	     }
	     public void addPanel1Components(working.CInfoForm c,String b1,String b2){
	         addPanel1Name();
	         c1=c;
	         nb1=b1;
	         addPanel1Panel2();
	         jb2=addPanel1Button(b1);
	         add(jb2);
	         getRootPane().setDefaultButton(jb2);
	         jb2.addActionListener(c1.new Account());
	         jb1=addPanel1Button(b2);
	         add(jb1);
	         jb1.addActionListener(c1.new Account());
	         if(b1.equals("SUBMIT")){
	        	 jb3=addPanel1Button("ADD PHOTO");
	        	 add(jb3);
	        	 jb3.addActionListener(c1.new Account());	
	        }
	         if(b1.equals("UPDATE")){
	        	 jb4=addPanel1Button("SEE PHOTO");
	        	 add(jb4);
	        	 jb4.addActionListener(c1.new Account());
	         }	 
	         }
	
}
