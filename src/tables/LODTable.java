package tables;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import connection.CreateConnection;
import GUI.*;
public class LODTable extends JFrame {
	JPanel jp;
	JTable jt;
	static int a,r;
	JScrollPane jsp;
	public static Object ob1[][];
	 void properties(){
	        setSize(900,500);
	        setLocation(200,150);
	        setTitle("LIST OF DRAFT");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
	        }
	 void addHeader(){
	        Header h1=new Header();
	        add(h1,BorderLayout.NORTH);
	        h1.control("List  Of  Draft");
	        }
	 void addPanel1Name(){
	        FormName fn1=new FormName();
	        fn1.control("LIST  OF  DRAFT:");
	        jp.add(fn1);
	         }
	 
	 void addScrollPane(){
		 jt=new JTable(new LODModel());
		 jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		 jp.add(jsp);
		 jt.setPreferredScrollableViewportSize(new Dimension(800,17*r));
		 jt.setFillsViewportHeight(true);
		 jt.getColumnModel().getColumn(1).setPreferredWidth(300);
	 }
	 void addPanel1Components(){
		 addPanel1Name();
		 a=0;
		 LODTable.getData();
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
		 r1=CreateConnection.execute("select count(*) from draft");
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
	 public static void getData(){LODTable.getRows();
	 ob1=new Object[r][4];
	 ResultSet r1;
	 try{
		 r1=CreateConnection.execute("select * from draft");
		 while(r1.next()&&a<r){
			 ob1[a][0]=r1.getString(1);
			 ob1[a][1]=r1.getString(2);
			 ob1[a][2]=r1.getString(3);
			 ob1[a][3]=r1.getDouble(4);
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
		 for(int i=0;i<LODTable.r;i++)
			 for(int j=0;j<4;j++)
				 System.out.println(ob1[i][j]+"    ");
		 System.out.println();
	 }
	 public void control(){
      properties();
      addHeader();
      addPanel1();
      setVisible(true);
     }
}	 
	
