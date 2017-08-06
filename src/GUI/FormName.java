package GUI;
import java.awt.*;
import java.util.*;

import javax.swing.*;
public class FormName  extends JPanel{
    void addLabel(String name){
        JLabel jl1=new JLabel(name);
        jl1.setFont(new Font("Candara",Font.BOLD,30));
        jl1.setForeground(Color.RED);
        add(jl1);
        }
    void addPanel1DateField(JPanel jp3){
        JLabel jl2=new JLabel("Date:    ");
        JTextField jtf1=new JTextField(9);
        Calendar d1=Calendar.getInstance();
        jtf1.setText(d1.get(Calendar.YEAR)+"-"+(d1.get(Calendar.MONTH)+1)+"-"+d1.get(Calendar.DAY_OF_MONTH));
        jp3.add(jl2);
        jp3.add(jtf1);
        }
    void addPanel1(){
        JPanel jp3=new JPanel();
        jp3.setBackground(Color.LIGHT_GRAY);
        jp3.setLayout(new FlowLayout());
        add(jp3); 
        addPanel1DateField(jp3);
        }
    public void control(String name){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT,400,10));
         addLabel(name);
         addPanel1();
         }
        
    }
