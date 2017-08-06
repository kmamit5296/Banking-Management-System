package GUI;
import java.awt.*;

import javax.swing.*;

public class ContactMe extends JFrame {
	JScrollPane jsp1;
	JPanel jp;
	GridBagConstraints gc1;
	GridBagLayout gb1;
	 void properties(){
	        setSize(850,500);
	        setLocation(20,50);
	        setTitle("CONTACT DEVELOPER");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("Contact Information");
	        }
	 JLabel addLabel(String a,int bi,int size,Color col,int x,int y){
		 JLabel jl=new JLabel(a);
		 jl.setFont(new Font("Candara",bi,size));
		 jl.setForeground(col);
		 gc1.gridx=x;
		 gc1.gridy=y;
		 gc1.anchor=GridBagConstraints.WEST;
		 gb1.setConstraints(jl, gc1);
		 return jl;
	 }
	 void addPanel1Components(){
		 jp.add(addLabel("AMIT KUMAR:",Font.BOLD,40,Color.RED,0,0));
		 jp.add(addLabel("*MOBILE:    8604888643",Font.ITALIC,20,Color.BLACK,0,1));
		 jp.add(addLabel("*EMAIL-ID:    amitkumar05021996@gmail,com",Font.ITALIC,20,Color.BLACK,0,2));
		 jp.add(addLabel("*ADDRESS:    Vishvaraya Hostel IET Campus Sitapur Road Lucknow",Font.ITALIC,20,Color.black,0,3));
		 jp.add(addLabel("                    Pin:226021",Font.ITALIC,20,Color.BLACK,0,4));
		 jp.add(addLabel("SPECIAL THANKS TO:",Font.ITALIC,40,Color.RED,0,5));
		 jp.add(addLabel("*My java teacher Mr. Alok Kumar",Font.ITALIC,20,Color.black,0,6));
		 jp.add(addLabel("*My Parents For their Blessings",Font.ITALIC,20,Color.black,0,7));
		 jp.add(addLabel("*All My Friends",Font.ITALIC,20,Color.black,0,8));
		 
		 
	 }
	 void addPanel1(){
			jsp1=new JScrollPane();
	        jp=new JPanel();
	        jsp1.setViewportView(jp);
	        add(jsp1,BorderLayout.CENTER);
	        jp.setBackground(Color.LIGHT_GRAY);
	        gb1=new GridBagLayout();
	        gc1=new GridBagConstraints();
	        jp.setLayout(gb1);
	        addPanel1Components();
	        }
	 public void control(){
		 properties();
		 addHeader();
		 addPanel1();
		 setVisible(true);
	 }
}
