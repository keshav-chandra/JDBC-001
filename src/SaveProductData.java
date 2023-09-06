import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SaveProductData {

	public static void main(String[] args) throws Exception {
		 
		//1.load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_001","root","Keshav");
		
		//3.Establish the Statement
		Statement st=con.createStatement();
		
		//4.Create and Excute the query
		String sql="UPDATE product set productname = 'hair gel' where productid=101";
		st.execute(sql);
		String sql1="DELETE FROM product where productid=102";
		st.execute(sql1);
		
		
		//5.close connection
		con.close();
		
		System.out.println("student data inserted sucessfully");

	}

}
