package GUI;

import java.awt.*;
import javax.swing.*;
import working.UserInformationForm;;
public class UserInformationPanel extends JPanel{
	GridBagLayout gb1;
	GridBagConstraints gc1;
	public JTextField jtf1,jtf2,jtf3,jtf4;
	public JPasswordField jpf;
	public JTextArea jta;
	public JComboBox jcb1,jcb2,jcb3,jcb4;
	public JRadioButton jrb1,jrb2;
	public JButton jb;
	public ButtonGroup bg;
	UserInformationForm u1;
	void addPanel1Name(){
        FormName fn1=new FormName();
        fn1.control("USER  INFORMATION  FORM:");
        add(fn1);
         }
	 void addPanel2TextBox(JPanel jp2,int x,int y){
         jta=new JTextArea(5,13);
         gc1.gridx=x;
         gc1.gridy=y;
         gc1.anchor=GridBagConstraints.WEST;
         gb1.setConstraints(jta, gc1);
         jp2.add(jta);
        }
	 JTextField addPanel23TextField(int x,int y){
         JTextField jtf=new JTextField(13);
         gc1.gridx=x;
         gc1.gridy=y;
         gc1.gridwidth=GridBagConstraints.REMAINDER;      
         gc1.anchor=GridBagConstraints.WEST;
         gb1.setConstraints(jtf, gc1);
         return jtf;
        }
	 void addPanel23Label(JPanel jp,String name,int y){
		 JLabel jl=new JLabel(name);
		 jl.setFont(new Font("Corbel",Font.ITALIC,20));
		 jl.setForeground(Color.BLUE);
		 gc1.gridx=0;
		 gc1.gridy=y;
		 gc1.anchor=GridBagConstraints.WEST;
		 gb1.setConstraints(jl, gc1);
		 jp.add(jl);
        }
	void addPanel2GroupBox(JPanel jp2){
		jrb1=new JRadioButton("MALE");
		bg=new ButtonGroup();
		gc1.gridx=1;
		gc1.gridy=2;
		gc1.gridwidth=1;
		gb1.setConstraints(jrb1,gc1);
		bg.add(jrb1);
		jp2.add(jrb1);
		jrb2=new JRadioButton("FEMALE");
		gc1.gridx=2;
		gc1.gridy=2;
		gc1.anchor=GridBagConstraints.EAST;
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
        jp3.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
		gc1.gridx=1;
		gc1.gridy=3;
		gc1.gridwidth=GridBagConstraints.REMAINDER;
		gb1.setConstraints(jp3,gc1);
        jp2.add(jp3);
        addPanel3Combobox1(jp3);
        addPanel3Combobox2(jp3);
        addPanel3Combobox3(jp3);
		}
	void addPanel2Components(JPanel jp2,GridBagLayout gb1,GridBagConstraints gc1){
		addPanel23Label(jp2,"USER ID:",0);
		jtf4=addPanel23TextField(1,0);
		jp2.add(jtf4);
		addPanel23Label(jp2,"NAME:",1);
		jtf1=addPanel23TextField(1,1);
		jp2.add(jtf1);
		addPanel23Label(jp2,"GENDER:   ",2);
		addPanel2GroupBox(jp2);
		addPanel23Label(jp2,"DATE OF BIRTH:   ",3);
		addPanel2Panel3(jp2);
		addPanel23Label(jp2,"PHONE:",4);
		jtf2=addPanel23TextField(1,4);
		jp2.add(jtf2);
		addPanel23Label(jp2,"ADDRESS:",5);
		addPanel2TextBox(jp2,1,5);
		}
	void addPanel1Panel2(){
	        JPanel jp2=new JPanel();
	        jp2.setBackground(Color.LIGHT_GRAY);
	        gb1=new GridBagLayout();
	        gc1=new GridBagConstraints();
	        jp2.setLayout(gb1);
	        add(jp2);
	        addPanel2Components(jp2,gb1,gc1);
	        }
	void addPanel3PasswordField(JPanel jp3,int x,int y){
		jpf=new JPasswordField(13);
		gc1.gridx=x;
		gc1.gridy=y;
		gc1.anchor=GridBagConstraints.WEST;
		gb1.setConstraints(jpf, gc1);
		jp3.add(jpf);
		}
	void addPanel3ComboBox(JPanel jp3){
		String type[]={"select","ADMIN","EMPLOYEE"};
		jcb4=new JComboBox(type);
		gc1.gridx=1;
		gc1.gridy=2;
		gc1.anchor=GridBagConstraints.WEST;
		gb1.setConstraints(jcb4, gc1);
		jp3.add(jcb4);
		}
	void addPanel3Components(JPanel jp3){
		addPanel23Label(jp3,"USER NAME:",0);
		jtf3=addPanel23TextField(1,0);
		jp3.add(jtf3);
		addPanel23Label(jp3,"PASSWORD:",1);
		addPanel3PasswordField(jp3,1,1);
		addPanel23Label(jp3,"USER TYPE:",2);
		addPanel3ComboBox(jp3);
		}
	void addPanel1Panel3(){
        JPanel jp3=new JPanel();
        jp3.setBackground(Color.LIGHT_GRAY);
        gb1=new GridBagLayout();
        gc1=new GridBagConstraints();
        jp3.setLayout(gb1);
        add(jp3);
        addPanel3Components(jp3);
        }
	 void addPanel1Button(){
	        jb=new JButton("  SAVE  ");
	        jb.setFont(new Font("Calibri",Font.BOLD,20));
	        jb.setForeground(Color.BLACK);
	        getRootPane().setDefaultButton(jb);
	        add(jb);
	        jb.addActionListener(u1.new UserInformationWork());
	        }
	 public void addPanel1Components(UserInformationForm u){
		 u1=u;
         addPanel1Name();
         addPanel1Panel2();
         addPanel1Panel3();
         addPanel1Button();
	 	}
}
