package tables;
import java.sql.*;
import javax.swing.table.*;
import connection.CreateConnection;
class LOCModel extends AbstractTableModel{
	 String coln[]={"ACCOUNT_NO","NAME","PHONE_NO","ADDRESS","BAL"};
	 public int getRowCount(){
			 return LOCTable.r;
		 }
	 public int getColumnCount(){ 
		return 5;
	 }
	 public String getColumnName(int c){ 
		 return coln[c];
	 }
	 public Object getValueAt(int row,int col){
	 	return LOCTable.ob[row][col];
	 }
	 
}

