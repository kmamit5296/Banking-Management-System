package tables;
import java.sql.*;
import javax.swing.table.*;
import connection.CreateConnection;
class LODModel extends AbstractTableModel{
	 String coln[]={"DRAFT_NO","FAVOUR_OF","ACCOUNT_NUMBER","AMOUNT"};
	 public int getRowCount(){
			 return LODTable.r;
		 }
	 public int getColumnCount(){ 
		return 4;
	 }
	 public String getColumnName(int c){ 
		 return coln[c];
	 }
	 public Object getValueAt(int row,int col){
	 	return LODTable.ob1[row][col];
	 }
	 
}

