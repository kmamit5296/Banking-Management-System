package GUI;
import working.*;
import java.awt.*;
import javax.swing.*;
public class AdminPanel1 extends JPanel {
	public JComboBox jcb1,jcb2,jcb3,jcb4,jcb5;
	String s1[]={"Account            ","New Account","Search Account","Update Account","All Customers"};
	String s2[]={"User             ","Create User","Search User","Update User","All User"};
	String s3[]={"Transactions             ","Deposit","Withdraw","Transfer","Draft Form"};
	String s4[]={"View             ","Balance Sheet","Draft(s)"};
	String s5[]={"Others             ","Logout","Change Password","Contact Developer","Exit"};

    void addPanel1Label(String form){
        JLabel jl1=new JLabel("                                            "+form+"                                               ");
        jl1.setFont(new Font("Verdana",Font.BOLD,30));
        jl1.setForeground(Color.RED);
        add(jl1);
        }
	JComboBox addComboBox(String s[]){
          JComboBox jcb=new JComboBox(s);
          jcb.setFont(new Font("Gabriola",Font.PLAIN,20));
          jcb.setForeground(Color.BLUE);
          return jcb;
          }
   void addPanel1Image(){
	   ImageIcon i1=new ImageIcon(".\\image\\admin.jpg");
	   JLabel jl1=new JLabel(i1);
       add(jl1);
       }
    public void addComponents(working.AdminPanel p,String type,String fn){
        addPanel1Label(fn);
        jcb1=addComboBox(s1);
        jcb1.addActionListener(p.new AdminSelect());
        add(jcb1);
        if(type.equals("ADMIN")){
        jcb2=addComboBox(s2);
        jcb2.addActionListener(p.new AdminSelect());	
        add(jcb2);}
        jcb3=addComboBox(s3);
        jcb3.addActionListener(p.new AdminSelect());
        add(jcb3);
        jcb4=addComboBox(s4);
        add(jcb4);
        jcb4.addActionListener(p.new AdminSelect());
        jcb5=addComboBox(s5);
        add(jcb5);
        jcb5.addActionListener(p.new AdminSelect());
       addPanel1Image();
        }
}
