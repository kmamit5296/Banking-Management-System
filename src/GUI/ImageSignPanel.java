package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.*;

import working.DraftForm.DraftWork;
import working.ImageSignForm;
import working.ImageSignForm.ImageWork;

public class ImageSignPanel extends JPanel{
	GridBagLayout gb1;
	GridBagConstraints gc1;
	public JButton jb1,jb2,jb3;
	ImageSignForm i1;
	public JPanel jp2;
	public JLabel jl;
	void addPanel1Name(){
        FormName fn1=new FormName();
        fn1.control("IMAGE  FORM:");
        add(fn1);
         }
	 public void addPanel2Label1(File f,int x,int y){
		ImageIcon i1=new ImageIcon(f.getPath());
		i1.setImage(i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		JLabel jl=new JLabel(i1);
		gc1.gridx=x;
		gc1.gridy=y;
		gb1.setConstraints(jl, gc1);
		jp2.add(jl);
	 }
	 void addPanel2Label(JPanel jp2,String name,int x,int y){
		 jl=new JLabel(name);
		 jl.setFont(new Font("Corbel",Font.ITALIC,20));
		 jl.setForeground(Color.BLUE);
		 gc1.gridx=x;
		 gc1.gridy=y;
		 gc1.anchor=GridBagConstraints.WEST;
		 gb1.setConstraints(jl, gc1);
		 jp2.add(jl);
     }
	 JButton addPanel2Button(String name,int x,int y){
	        JButton jb=new JButton(name);
	        jb.setFont(new Font("Calibri",Font.ITALIC,20));
	        jb.setForeground(Color.BLUE);
	        gc1.gridx=x;
			gc1.gridy=y;
			gb1.setConstraints(jb, gc1);
	        return jb;
	        }
	void addPanel2Components(JPanel jp2){
		ImageWork p=i1.new ImageWork();
		addPanel2Label(jp2,"PHOTO :",0,0);
		jb1=addPanel2Button("BROWSE...",0,2);
		jp2.add(jb1);
		jb1.addActionListener(p);	
		addPanel2Label(jp2,"                              ", 1, 0);
		addPanel2Label(jp2,"SIGN :",2,0);
		jb2=addPanel2Button("BROWSE...",2,2);
		jp2.add(jb2);
		jb2.addActionListener(p);
		jb3=addPanel2Button("     SAVE     ",1,3);
		jp2.add(jb3);
		jb3.addActionListener(p);

	}
	void addPanel1Panel2(){
	        jp2=new JPanel();
	        jp2.setBackground(Color.LIGHT_GRAY);
	        gb1=new GridBagLayout();
	        gc1=new GridBagConstraints();
	        jp2.setLayout(gb1);
	        add(jp2);
	        addPanel2Components(jp2);
	        }
	public void addPanel1Components(ImageSignForm i){
		i1=i;
		addPanel1Name();
		addPanel1Panel2();
		
	} 
}
