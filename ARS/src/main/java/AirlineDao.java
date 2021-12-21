import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class AirlineDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/air";
	private String dbUname = "root";
	private String dbPassword = "Karthi33";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(AirlineVo airline) {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String result="Data entered Successfully";
		String sql="insert into  oldtable values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, airline.getFirstname());
			ps.setString(2, airline.getLastname());
			ps.setString(3, airline.getAddress());
			ps.setString(4, airline.getCity());
			ps.setString(5, airline.getState());
			ps.setString(6, airline.getCountry());
			ps.setString(7, airline.getGender());
			ps.setString(8, airline.getContactno());
			ps.setString(9, airline.getEmail_id());
			ps.setString(10, airline.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Data not entered";
		}
		
		return result;
		
	}

}
