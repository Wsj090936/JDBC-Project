package StudentInformationSystem;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class Teststatement {
@Test
	public void testStatement() throws Exception{//����Statement���и��²���
			Connection con = null;
			Statement state = null;
	try{
	//		1����ȡ���ݿ�����
			con = getConnection();
	//		2�����ɲ����sql���
			String sql = "INSERT INTO animal (id,name,age) VALUES (1,'cat',3)";
	//		3����ȡ����SQL����Statement����
			state = con.createStatement();
	//		4������Statement�����executeUpdate(String  aql)������ִ��sql���
			state.executeUpdate(sql);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//5���ر�Statement����
				if(con != null){
					try {
						state.close();
					} catch (Exception e) {
						e.printStackTrace();
						}
					}
				//6���ر����ݿ�����
				if(con != null){
					con.close();
					}
			}
	}
		public Connection getConnection() throws Exception{//�������ݿ�����
			String driverclass = null;
			String url = null;
			String user = null;
			String password = null;
			
			Properties properties = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(in);
			
			driverclass = properties.getProperty("driver");
			url = properties.getProperty("jdbcurl");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
			Class.forName(driverclass);
			return DriverManager.getConnection(url, user, password);
		}
}
