package GUI;
import java.awt.*;
import javax.swing.*;
public class Header extends JPanel{
    void addLabel1(GridBagLayout gb1,GridBagConstraints gc1){
        JLabel jl=new JLabel("BANKING MANAGEMENT SYSTEM");
        jl.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        jl.setForeground(Color.white);
        gc1.gridx=GridBagConstraints.REMAINDER;
        gc1.gridy=0;
        gc1.weightx=1;
        gc1.weighty=1;
        gb1.setConstraints(jl, gc1);
        add(jl);
        }
    void addLabel2(GridBagLayout gb1,GridBagConstraints gc1,String v1){
        JLabel jl2=new JLabel(v1);
        jl2.setFont(new Font("Arial",Font.ITALIC,15));
        jl2.setForeground(Color.RED);
        gc1.gridx=1;
        gc1.gridy=1;
        gc1.weightx=0.01;
        gc1.weighty=0.3;
        gc1.anchor=GridBagConstraints.SOUTHEAST;
        gb1.setConstraints(jl2, gc1);
        add(jl2);
        }
    void Layout(String v1){
        GridBagLayout gb1=new GridBagLayout();
        GridBagConstraints gc1=new GridBagConstraints();
        setLayout(gb1);
        addLabel1(gb1,gc1);
        addLabel2(gb1, gc1,v1);
        }
    public void control(String v1){
        setBackground(Color.BLUE);
        Layout(v1);
        }
}
