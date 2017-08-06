package GUI;
import java.awt.*;
import javax.swing.*;
import working.*;
public class UpdateUserPanel extends JPanel {
	GridBagLayout gb1;
	GridBagConstraints gc1;
	public JTextField jtf1,jtf2,jtf3,jtf4;
	public JTextArea jta;
	public JRadioButton jrb1,jrb2;
	public JComboBox jcb1,jcb2,jcb3;
	public JButton jb1,jb2,jb3;
	public ButtonGroup bg;
	UpdateUserForm u1;
	void addPanel1Name(){
		FormName fn1=new FormName();
        fn1.control("UPDATE USER FORM:");
        add(fn1);
        }
	 JTextField addPanel2TextField(int x,int y){
         JTextField jtf=new JTextField(13);
         gc1.gridx=x;
         gc1.gridy=y;
         gc1.anchor=GridBagConstraints.WEST;
         gb1.setConstraints(jtf, gc1);
         return jtf;
        }
	 void addPanel2Label(JPanel jp2,String name,int y){
		 JLabel jl=new JLabel(name);
		 jl.setFont(new Font("Corbel",Font.ITALIC,20));
		 jl.setForeground(Color.BLUE);
		 gc1.gridx=0;
		 gc1.gridy=y;
		 gc1.anchor=GridBagConstraints.WEST;
		 gb1.setConstraints(jl, gc1);
		 jp2.add(jl);
        }
	 JButton addPanel2Button(String name,int x,int y){
		JButton jb=new JButton(name);
		jb.setFont(new Font("Calibri",Font.BOLD,20));
        jb.setForeground(Color.BLACK);
        gc1.gridx=x;
        gc1.gridy=y;
        gb1.setConstraints(jb, gc1);
		return jb;
	 	}
	 void addPanel2GroupBox(JPanel jp2){
			jrb1=new JRadioButton("MALE");
			bg=new ButtonGroup();
			gc1.gridx=1;
			gc1.gridy=3;
			gb1.setConstraints(jrb1,gc1);
			bg.add(jrb1);
			jp2.add(jrb1);
			jrb2=new JRadioButton("FEMALE");
			gc1.gridx=2;
			gc1.gridy=3;
			gc1.anchor=GridBagConstraints.WEST;
			gb1.setConstraints(jrb2, gc1);
			bg.add(jrb2);
			jp2.add(jrb2);
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
        jp3.setLayout(new FlowLayout(FlowLayout.LEFT,3,3));
		gc1.gridx=1;
		gc1.gridy=4;
		gc1.gridwidth=GridBagConstraints.REMAINDER;
		gb1.setConstraints(jp3,gc1);
        jp2.add(jp3);
        addPanel3Combobox1(jp3);
        addPanel3Combobox2(jp3);
        addPanel3Combobox3(jp3);
		}
	 void addPanel2TextBox(JPanel jp2){
		 jta=new JTextArea(5,13);
         gc1.gridx=1;
         gc1.gridy=6;
         gc1.anchor=GridBagConstraints.WEST;
         gb1.setConstraints(jta, gc1);
         jp2.add(jta);
        }
	 void addPanel2Components(JPanel jp2){
		addPanel2Label(jp2,"USER ID:",0);
		jtf1=addPanel2TextField(1,0);
		jp2.add(jtf1);
		jb1=addPanel2Button("DETAILS",2,0);
		jp2.add(jb1);
		jb1.addActionListener(u1.new UpdateUserWork());
        addPanel2Label(jp2,"USER NAME:",1);
        jtf2=addPanel2TextField(1, 1);
        jp2.add(jtf2);
        
        addPanel2Label(jp2,"NAME:",2);
        jtf3=addPanel2TextField(1, 2);
        jp2.add(jtf3);
        addPanel2Label(jp2,"GENDER:",3);
        addPanel2GroupBox(jp2);
        addPanel2Label(jp2,"DATE OF BIRTH:",4);
        addPanel2Panel3(jp2);
        addPanel2Label(jp2,"PHONE:",5);
        jtf4=addPanel2TextField(1, 5);
        jp2.add(jtf4);
        addPanel2Label(jp2,"ADDRESS:",6);
        addPanel2TextBox(jp2);
        jb2=addPanel2Button("UPDATE",0,7);
        jp2.getRootPane().setDefaultButton(jb2);
        jp2.add(jb2);
        jb2.addActionListener(u1.new UpdateUserWork());
        jb3=addPanel2Button("DELETE",2,7);
        jp2.add(jb3);
        jb3.addActionListener(u1.new UpdateUserWork());
	 	}
	 void addPanel1Panel2(){
		JPanel jp2=new JPanel();
     	jp2.setBackground(Color.LIGHT_GRAY);
     	gb1=new GridBagLayout();
     	gc1=new GridBagConstraints();
     	jp2.setLayout(gb1);
     	add(jp2);
     	addPanel2Components(jp2);
     	}
	public void addPanel1Components(UpdateUserForm u){
		u1=u;
		addPanel1Name();
		addPanel1Panel2();
 		}
}
