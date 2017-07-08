package StudentInformationSystem;
//JDBC������  �������ݿ�����ӣ����£��رյȹ���
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//JDBC�Ĺ����࣬���ڹر����ݿ����Ӳ��������²����Ͳ�ѯ����
public class JDBCTools {

//	public void select(String sql){//��ѯ��Ϣ
//		Connection con = null;
//		Statement state = null;
//		ResultSet rs = null;
//		
//		try {
//			con = getConnection();
//			
//			state = con.createStatement();
//			
//			rs = state.executeQuery(sql);
//		while(rs.next()){
//			int FlowID = rs.getInt("FlowID");//��ˮ��
//			String Type = rs.getString("Type");//��������
//			String IDcard = rs.getString("IDcard");//���֤��
//			String Examcard = rs.getString("Examcard");//׼��֤����
//			String StudentName = rs.getString("StudentName");//ѧ������
//			String Location = rs.getString("Location");//����
//			int Grade = rs.getInt("Grade");//�ɼ�
//			System.out.print("��ˮ��:"+FlowID+"  ");
//			System.out.print("��������:"+Type+"  ");
//			System.out.print("���֤��:"+IDcard+"  ");
//			System.out.print("׼��֤��:"+Examcard+"  ");
//			System.out.print("ѧ������:"+StudentName+"  ");
//			System.out.print("ѧ�����ڵ�:"+Location+"  ");
//			System.out.print("�ɼ�:"+Grade+"  ");
//			System.out.println();
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally{//�ر�����
//			release(rs, con, state);
//		}
//	}
	public void update1(String sql , Object ... args){
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			for(int i = 0;i<args.length;i++){//�������±��1��ʼ  �����鲻һ��
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			release(con, ps);
		}
	}
	public void update(String sql){//ʵ�����ݿ�ĸ��²��� ʹ��Statement�ӿ�
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
	public Connection getConnection() throws Exception{//�������ݿ�
		String driverClass = null;
		String url = null;
		String user = null;
		String password = null;
		
		Properties properties = new Properties();
		
		InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(in);
		
		driverClass = properties.getProperty("driver");
		url = properties.getProperty("jdbcurl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		Class.forName(driverClass);
		return DriverManager.getConnection(url, user, password);
	} 
	public void release(Connection con , Statement state){//�ر����ݿ�����
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
