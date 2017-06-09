package StudentInformationSystem;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//JDBC�Ĺ����࣬���ڹر����ݿ����Ӳ��������²����Ͳ�ѯ����
public class JDBCTools {

	public static void update(String sql){//ʵ�����ݿ�ĸ��²���
		Connection con = null;
		Statement state = null;
		
		try {
			con = getConnection();
			
			state = con.createStatement();
			
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			release(con,state);
		}
		
	}
	public static Connection getConnection() throws Exception{//�������ݿ�
		String driverClass = null;
		String url = null;
		String user = null;
		String password = null;
		
		Properties properties = new Properties();
		
		InputStream in = Review.class.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(in);
		
		driverClass = properties.getProperty("driver");
		url = properties.getProperty("jdbcurl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		Class.forName(driverClass);
		return DriverManager.getConnection(url, user, password);
	} 
	public static void release(Connection con , Statement state){//�ر����ݿ�����
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void release(ResultSet rs , Connection con , Statement state){//�ر����ݿ�����
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
