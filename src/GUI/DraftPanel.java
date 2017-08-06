package GUI;
import java.awt.*;
import javax.swing.*;
public class DraftPanel extends JPanel {
	 public JTextField jtf1,jtf2,jtf3;
	 public JTextArea jta;
	 public JButton jb;
	 void addPanel1Name(){
	        FormName fn1=new FormName();
	        fn1.control("DRAFT  FORM:");
	        add(fn1);
	         }
	 JTextArea addPanel2TextArea(GridBagLayout gb1,GridBagConstraints gc1,int x,int y){
      JTextArea jt=new JTextArea(5,13);
      gc1.gridx=x;
      gc1.gridy=y;
      gc1.anchor=GridBagConstraints.EAST;
      gb1.setConstraints(jt, gc1);
      return jt;
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
	 void addPanel2Components(JPanel jp2,GridBagLayout gb1,GridBagConstraints gc1){
	        addPanel2Label(jp2,"DRAFT NUMBER:", gb1, gc1,0);
	        jtf1=addPanel2TextField(gb1, gc1, 1, 0);
	        jp2.add(jtf1);
	        addPanel2Label(jp2,"IN FAVOUR OF:", gb1, gc1,1);
	        jta=addPanel2TextArea(gb1, gc1, 1, 1);
	        jp2.add(jta);
	        addPanel2Label(jp2,"ACCOUNT NUMBER:", gb1, gc1,2);
	        jtf2=addPanel2TextField(gb1, gc1, 1, 2);
	        jp2.add(jtf2);
	        addPanel2Label(jp2,"AMOUNT:", gb1, gc1,3);
	        jtf3=addPanel2TextField(gb1, gc1, 1, 3);
	        jp2.add(jtf3);
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
	 void addPanel1Button(working.DraftForm d1){
	        jb=new JButton("SAVE DRAFT");
	        jb.setFont(new Font("Calibri",Font.BOLD,20));
	        jb.setForeground(Color.BLACK);
	        getRootPane().setDefaultButton(jb);
	        add(jb);
	        jb.addActionListener(d1.new DraftWork());
	        }
	 public void addPanel1Components(working.DraftForm d1){
      addPanel1Name();
      addPanel1Panel2();
      addPanel1Button(d1);
	 	}
}
