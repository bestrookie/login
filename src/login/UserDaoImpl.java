package login;

import java.sql.*;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 =null;
	ResultSet rs = null;
	@Override
	public User getUser(User user) {
		DB_Dao dao = new DB_Dao();
		try {
			conn = dao.getCon();
			String sql = "select * from users where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
                        //ִ��ȫ����ѯ
			rs = ps.executeQuery();
			User users = null;
			if(rs.next())
			{
				users = new User();
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				//close(conn,ps,rs);
				return user;
			}
			else 
				{
					//close(conn,ps,rs);
					return null; 
				}
			}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return user;
	}
	@Override
	public boolean setUser(User user) {
		DB_Dao dao = new DB_Dao();
		try {
			conn = dao.getCon();
                        //�жϴ��͹�����username���ݿ����Ƿ��Ѿ�����,��������򷵻�false
			String sql1 = "select count(1) from users where username = ?";
			ps1 = conn.prepareStatement(sql1);
			ps1.setString(1,user.getUsername());
			rs = ps1.executeQuery();
			while(rs.next())
			{
				if(rs.getInt(1)>0)
				{
					//close(conn,ps,rs);
					return false;
				}
			}
			//���û��ע��,ִ�в������
			String sql = "insert into users(username,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
                        //ִ�и���
			ps.executeUpdate();
			//close(conn,ps,rs);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж��˺��Ƿ��ѱ�ע��
			return false;
	}

}
