package tables;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import connection.CreateConnection;
import GUI.Header;
public class BalanceSheet extends JFrame{
	JPanel jp;
	JTextField jtf1;
	JComboBox jcb1,jcb2,jcb3;
	JButton jb1;
	int a,r;
	Object ob[][];
	JTable jt;
	JScrollPane jsp,jsp1;
	//static String cnt,da;
	GridBagLayout gb1;
	GridBagConstraints gc1;
	BalanceModel bm1;
	void properties(){
        setSize(1350,500);
        setLocation(10,100);
        setTitle("BALANCE SHEET");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        }
	void addHeader(){
        Header h1=new Header();
        add(h1,BorderLayout.NORTH);
        h1.control("Balance  Sheet");
        }
	void addPanel1Label1(){
		JLabel jl=new JLabel("BALANCE  SHEET");
		jl.setFont(new Font("Candara",Font.BOLD,40));
	    jl.setForeground(Color.RED);
	    gc1.gridx=0;
	    gc1.gridy=0;
	    gc1.gridwidth=GridBagConstraints.REMAINDER;
	    gb1.setConstraints(jl,gc1);
	    jp.add(jl);
		}
	void addPanel1Label(String name,int size,int x,int y){
		JLabel jl=new JLabel(name);
		jl.setFont(new Font("Arial",Font.ITALIC,size));
	    jl.setForeground(Color.BLUE);
	    gc1.gridx=x;
	    gc1.gridy=y;
	    gc1.gridwidth=1;
	    gb1.setConstraints(jl,gc1);
	    jp.add(jl);
		}
	void addPanel1TextField(){
        jtf1=new JTextField(15);
        gc1.gridx=1;
        gc1.gridy=1;
        gc1.anchor=GridBagConstraints.WEST;
        gb1.setConstraints(jtf1,gc1);
        jp.add(jtf1);
       }
    JButton addPanel1Button(int x,int y){
   	 JButton jb=new JButton("DETAILS...");
   	 jb.setFont(new Font("Verdana",Font.BOLD,20));
   	 gc1.gridx=x;
   	 gc1.gridy=y;
   	 gb1.setConstraints(jb,gc1);
   	 return jb;
    }
    void addScrollPane(String a,String b){
    	 getData(b,a);
    	 bm1=new BalanceModel();
		 jt=new JTable(bm1);
		 jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 gc1.gridx=0;
		 gc1.gridy=3;
		 gc1.gridwidth=GridBagConstraints.REMAINDER;
		 gb1.setConstraints(jsp, gc1);
		 jp.add(jsp);
		 jt.setPreferredScrollableViewportSize(new Dimension(1200,17*r));
		 jt.setFillsViewportHeight(true);
	 }
	 void addPanel1Components(){
		 
		 addPanel1Label1();
		 addPanel1Label("ACCOUNT  NUMBER:   ",20,0,1);
		 addPanel1TextField();
		 jb1=addPanel1Button(1,2);
		 jp.add(jb1);
		 jb1.addActionListener(new BalanceSheetWork());
		 addScrollPane("select count(*) from balance_sheet","select * from balance_sheet");
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
	void  getRows(String cnt){
		 ResultSet r1;
		 try{
		 r1=CreateConnection.execute(cnt);
		 if(r1.next())
			 r=r1.getInt(1);
		 r1.close();
		 }
		 catch(SQLException ex){
		 		ex.printStackTrace();
				}
	   	 catch(ClassNotFoundException ex){
			 ex.printStackTrace();
				}
		 CreateConnection.close1();
		

	 }
	 void getData(String da,String cn){getRows(cn);
	 ob=new Object[r][6];	// System.out.println(da+"    "+cn);
	 ResultSet r1;
	 try{
		 r1=CreateConnection.execute(da);
		 while(r1.next()&&a<r){
			 ob[a][0]=r1.getString(1);
			 ob[a][1]=r1.getDate(2);
			 ob[a][2]=r1.getString(3);
			 ob[a][3]=r1.getDouble(4);
			 ob[a][4]=r1.getDouble(5);
			 ob[a][5]=r1.getDouble(6);//System.out.println(ob[a][5]);
			 ++a;
		 	}
		 r1.close();
	 	}
		 catch(SQLException ex){
		 		ex.printStackTrace();
				}
	   	 catch(ClassNotFoundException ex){
			 ex.printStackTrace();
				}
		 CreateConnection.close1();
	}
	public void control(){
	      properties();
	      addHeader();
	      addPanel1();
	      setVisible(true);
	     }
	public class BalanceSheetWork implements ActionListener {
		String cda,cnta;
		boolean checkDigit(){
   		 for(int i=0;i!=cda.length();i++){
   			if(Character.isDigit(cda.charAt(i))){}
   			else{ jtf1.setText("");
   				JOptionPane.showMessageDialog(null, "invalid account number"); 
   				return false;
   				}
   		 }
   		 return true;
   	 }
		boolean checkAccount_no(){
		 if(cda.length()!=10){jtf1.setText("");
		 JOptionPane.showMessageDialog(null, "invalid account number");
		 return false;
	 	}	 
	 return true;
	 }
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jb1){
				cda=jtf1.getText();
				if(checkDigit()&&checkAccount_no()){
					a=0;
					bm1.fireTableChanged(new TableModelEvent(jt.getModel()));
					addScrollPane(new String("select count(*) from balance_sheet where account_number='"+cda+"'"),
							new String("select * from balance_sheet where account_number='"+cda+"'"));
					validate();
				}
			}
		}
	}
	class BalanceModel extends AbstractTableModel{
		 String coln[]={"ACCOUNT_NO","DATE","MODE","DEPOSIT","DEBIT","BALANCE"};
		 public int getRowCount(){
				 return r;
			 }
		 public int getColumnCount(){ 
			return 6;
		 }
		 public String getColumnName(int c){ 
			 return coln[c];
		 }
		 public Object getValueAt(int row,int col){
		 	return ob[row][col];
		 }
		 
	}
}
