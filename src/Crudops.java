import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class Crudops {
	public static void main(String[]args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_001","root","Keshav");
		Statement st= con.createStatement();
        ResultSet rs;
        String objName;
		int objCount;
		st.execute("CREATE TABLE KESHAV (objectname varchar(20),objectcount numeric);");
		st.execute("INSERT INTO KESHAV VALUES ('hand',2)");
		st.execute("INSERT INTO KESHAV VALUES ('legs',2)");
		st.execute("INSERT INTO KESHAV VALUES ('mouth',1)");
		st.execute("INSERT INTO KESHAV VALUES ('brain',0)");
		
		rs=st.executeQuery("select * from KESHAV");
		while(rs.next()) {
			objName=rs.getString(1);
			objCount=rs.getInt(2);
			System.out.println(objName+"\t"+objCount);
		}
		
		st.execute("update KESHAV SET objectcount=1 where objectname='brain'");
		
		st.execute("delete  From KESHAV where  objectname='mouth'");
		st.execute("select * from KESHAV");
		System.out.println();
		rs=st.executeQuery("select * from KESHAV");
		while(rs.next()) {
			objName=rs.getString(1);
			objCount=rs.getInt(2);
			System.out.println(objName+"\t"+objCount);
		}
		
		st.close();
	
		
	}

}
