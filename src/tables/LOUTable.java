package tables;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import connection.CreateConnection;
import GUI.*;
public class LOUTable extends JFrame {
	JPanel jp;
	JTable jt;
	static int a,r;
	JScrollPane jsp;
	public static Object ob2[][];
	 void properties(){
	        setSize(900,500);
	        setLocation(200,150);
	        setTitle("LIST OF USERS");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("List  Of  Users");
	        }
	 void addPanel1Name(){
	        FormName fn1=new FormName();
	        fn1.control("LIST  OF  USERS:");
	        jp.add(fn1);
	         }
	 
	 void addScrollPane(){
		 jt=new JTable(new LOUModel());
		 jt.doLayout();
		 jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		 jp.add(jsp);
		 jt.setPreferredScrollableViewportSize(new Dimension(800,17*r));
		 jt.setFillsViewportHeight(true);
		 //jt.getColumnModel().getColumn(1).setPreferredWidth(300);
	 }
	 void addPanel1Components(){
		 addPanel1Name();
		 a=0;
		 LOUTable.getData();
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
		 r1=CreateConnection.execute("select count(*) from user");
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
	 public static void getData(){LOUTable.getRows();
	 ob2=new Object[r][6];
	 ResultSet r1;
	 try{
		 r1=CreateConnection.execute("select user_id,name,phone,username,password,type from user");
		 while(r1.next()&&a<r){
			 ob2[a][0]=r1.getInt(1);
			 ob2[a][1]=r1.getString(2);
			 ob2[a][2]=r1.getString(3);
			 ob2[a][3]=r1.getString(4);
			 ob2[a][4]=r1.getString(5);
			 ob2[a][5]=r1.getString(6);
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
	 void show1(){
		 for(int i=0;i<LOUTable.r;i++)
			 for(int j=0;j<4;j++)
				 System.out.println(ob2[i][j]+"    ");
		 System.out.println();
	 }
	 public void control(){
      properties();
      addHeader();
      addPanel1();
      setVisible(true);
     }
}	 
	
