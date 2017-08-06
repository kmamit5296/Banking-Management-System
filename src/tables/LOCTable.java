package tables;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import connection.CreateConnection;
import GUI.*;
public class LOCTable extends JFrame {
	JPanel jp;
	JTable jt;
	static int a,r;
	JScrollPane jsp;
	public static Object ob[][];
	 void properties(){
	        setSize(900,500);
	        setLocation(200,150);
	        setTitle("LIST OF CUSTOMERS");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("List  Of  Customers");
	        }
	 void addPanel1Name(){
	        FormName fn1=new FormName();
	        fn1.control("LIST  OF  CUSTOMERS");
	        jp.add(fn1);
	         }
	 
	 void addScrollPane(){
		 jt=new JTable(new LOCModel());
		 jt.doLayout();
		 jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		 jp.add(jsp);
		 jt.setPreferredScrollableViewportSize(new Dimension(800,17*r));
		 jt.setFillsViewportHeight(true);
		 jt.getColumnModel().getColumn(3).setPreferredWidth(300);
	 }
	 void addPanel1Components(){
		 addPanel1Name();
		 a=0;
		 LOCTable.getData();
		 addScrollPane();
	 }
	 void addPanel1(){
	        jp=new JPanel();
	        add(jp,BorderLayout.CENTER);
	        jp.setBackground(Color.LIGHT_GRAY);
	        jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	        addPanel1Components();
	        }
	 public static void  getRows(){
		 ResultSet r1;
		 try{
		 r1=CreateConnection.execute("select count(*) from account");
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
	 public static void getData(){LOCTable.getRows();
	 ob=new Object[r][5];
	 ResultSet r1;
	 try{
		 r1=CreateConnection.execute("select account_number,name,phone_number,address,balance from account");
		 while(r1.next()&&a<r){//System.out.println("amit    "+a);
			 ob[a][0]=r1.getString(1);
			 ob[a][1]=r1.getString(2);
			 ob[a][2]=r1.getString(3);
			 ob[a][3]=r1.getString(4);
			 ob[a][4]=r1.getDouble(5);
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
}	 
	