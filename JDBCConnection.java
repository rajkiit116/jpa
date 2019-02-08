public class JDBCConnection {
	public static void main(String[] args) {
		System.out.println("inside main");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from EMPLOYEES");
			
			while (rs.next())
				System.out.println(rs.getRow()+ " - " + rs.getInt(1)+ " - "+ rs.getString(2));
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
