package GUI;
import java.awt.*;
import javax.swing.*;
import working.*;
public class MoneyTransferPanel extends JPanel {
	 public JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	 public JButton jb1,jb2;
	 MoneyTransfer m1;
	 void addPanel1Name(){
	        FormName fn1=new FormName();
	        fn1.control("MONEY  TRANSFER  FORM:");
	        add(fn1);
	         }
	 JTextField addPanel2TextField(GridBagLayout gb1,GridBagConstraints gc1,int x,int y){
	         JTextField jtf=new JTextField(13);
	         gc1.gridx=x;
	         gc1.gridy=y;
	         gc1.anchor=GridBagConstraints.EAST;
	         gb1.setConstraints(jtf, gc1);
	         return jtf;
	        }
	 void addPanel2Label(JPanel jp2,String name,GridBagLayout gb1,GridBagConstraints gc1,int y){
	        JLabel jl=new JLabel(name);
	        jl.setFont(new Font("Corbel",Font.ITALIC,20));
	        jl.setForeground(Color.BLUE);
	        gc1.gridx=0;
	        gc1.gridy=y;
	        gc1.anchor=GridBagConstraints.WEST;
	        gb1.setConstraints(jl, gc1);
	        jp2.add(jl);
	        }
	 void addPanel2Button(JPanel jp2,GridBagLayout gb1,GridBagConstraints gc1){
	        jb1=new JButton("SHOW DETAILS");
	        jb1.setFont(new Font("Calibri",Font.BOLD,20));
	        jb1.setForeground(Color.BLACK);
	        gc1.gridx=2;
	        gc1.gridy=0;
	        gc1.anchor=GridBagConstraints.EAST;
	        gb1.setConstraints(jb1, gc1);
	        jp2.add(jb1);
	        jb1.addActionListener(m1.new MoneyTransferWork());
	        }   
	 void addPanel2Components(JPanel jp2,GridBagLayout gb1,GridBagConstraints gc1){
	        addPanel2Label(jp2,"ENTER ACCOUNT NUMBER:", gb1, gc1,0);
	        jtf1=addPanel2TextField(gb1, gc1, 1, 0);
	        jp2.add(jtf1);
	        addPanel2Button(jp2, gb1, gc1);
	        addPanel2Label(jp2,"NAME:", gb1, gc1,1);
	        jtf2=addPanel2TextField(gb1, gc1, 1, 1);
	        jp2.add(jtf2);
	        addPanel2Label(jp2,"CURRENT AMOUNT:", gb1, gc1,2);
	        jtf3=addPanel2TextField(gb1, gc1, 1, 2);
	        jp2.add(jtf3);
	        addPanel2Label(jp2,"DESTINATION ACCOUNT:", gb1, gc1,3);
	        jtf4=addPanel2TextField(gb1, gc1, 1, 3);
	        jp2.add(jtf4);
	        addPanel2Label(jp2,"AMOUNT:", gb1, gc1,4);
	        jtf5=addPanel2TextField(gb1, gc1, 1, 4);
	        jp2.add(jtf5);
	    	}
	 void addPanel1Panel2(){
	        JPanel jp2=new JPanel();
	        jp2.setBackground(Color.LIGHT_GRAY);
	        GridBagLayout gb1=new GridBagLayout();
	        GridBagConstraints gc1=new GridBagConstraints();
	        jp2.setLayout(gb1);
	        add(jp2);
	        addPanel2Components(jp2,gb1,gc1);
	        }
	 void addPanel1Button(){
	        jb2=new JButton("UPDATE");
	        jb2.setFont(new Font("Calibri",Font.BOLD,20));
	        jb2.setForeground(Color.BLACK);
	        getRootPane().setDefaultButton(jb2);
	        add(jb2);
	        jb2.addActionListener(m1.new MoneyTransferWork());
	        }
	 public void addPanel1Components(MoneyTransfer m){
		 m1=m;;
      addPanel1Name();
      addPanel1Panel2();
      addPanel1Button();
	 	}
	 
	 
}
