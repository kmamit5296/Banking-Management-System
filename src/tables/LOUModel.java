package tables;
import java.sql.*;
import javax.swing.table.*;
import connection.CreateConnection;
class LOUModel extends AbstractTableModel{
	 String coln[]={"USER_ID","NAME","PHONE_NUMBER","USERNAME","PASSWORD","TYPE"};
	 public int getRowCount(){
			 return LOUTable.r;
		 }
	 public int getColumnCount(){ 
		return 6;
	 }
	 public String getColumnName(int c){ 
		 return coln[c];
	 }
	 public Object getValueAt(int row,int col){
	 	return LOUTable.ob2[row][col];
	 }
	 
}


