package login;

import java.sql.*;

public class DB_Dao {
	static final String url = "jdbc:mysql://localhost/users";
	static final String user = "root";
	static final String pass = "root";
	static final String driver = "com.mysql.jdbc.Driver";
	Connection conn = null;
	
	//Dao
	public Connection getCon() throws ClassNotFoundException, SQLException {
		//ע������
		Class.forName(driver);
		//��������
		conn = DriverManager.getConnection(url, user, pass);
		
		return conn;
	}
	
	//�ر���Դ����������쳣
	public static void close(Connection con, PreparedStatement ps , ResultSet rs)
	{
		if(rs != null)
		{
			try 
			{
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(ps != null)
		{
			try {
				ps.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(con != null)
		{
			try {
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
