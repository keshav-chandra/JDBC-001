import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SaveStudentUsingPS {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_001","root","Keshav");
		
		PreparedStatement ps= con.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
		boolean flag=true;
		while(flag) {
			System.out.println("enter the value of the roll number");
			int roll=sc.nextInt();
			sc.nextLine();
			System.out.println("enter the student name");
			String name=sc.nextLine();
			System.out.println("enter the gender");
			String gender=sc.next();
			System.out.println("enter the phone number");
			long phone=sc.nextLong();
			
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setLong(4, phone);
			
			ps.execute();
			System.out.println("student data added successfully");
			
			System.out.println("for exit press 'y' to continue 'h' ");
			char c= sc.next().charAt(0);
			if(c=='y' ||c=='Y') {
				flag=false;
			}
		}
		con.close();
	}
}
