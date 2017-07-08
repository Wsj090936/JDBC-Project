package StudentInformationSystem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//ѧ����Ϣ��������к���
import java.util.Scanner;

import org.junit.Test;



public class RunSystem {
	JDBCTools jdbcTools = new JDBCTools();//JDBC������
	private  Student getInformFromConsole(){//�ӿ���̨����ѧ����Ϣ
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����뿼������ϸ��Ϣ");
		System.out.print("FlowID:");
		student.setFlowID(scanner.nextInt());//����ѧ����ˮ��
		
		System.out.print("Type:");
		student.setType(scanner.next());//���뿼������
		
		System.out.print("IDcard:");
		student.setIDcard(scanner.next());//����ѧ�������֤��
		
		System.out.print("Examcard:");
		student.setExamcard(scanner.next());//����ѧ����׼��֤��
		
		System.out.print("StudentName:");
		student.setStudentName(scanner.next());//����ѧ������
		
		System.out.print("Location:");
		student.setLocation(scanner.next());//����ѧ�����ڵ�
		
		System.out.print("Grade");
		student.setGrade(scanner.nextInt());//����ѧ���ɼ�
		System.out.println("��Ϣ¼��ɹ�");
		return student;
	}
//	public  void addStudent(Student student) {//����ѧ����Ϣ
//		String sql = "INSERT INTO examstudent VALUES ("
//					+student.getFlowID()
//					+",'"+student.getType()
//					+"','"+student.getIDcard()
//					+"','"+student.getExamcard()
//					+"','"+student.getStudentName()
//					+"','"+student.getLocation()
//					+"',"+student.getGrade()+")";
//		jdbcTools.update(sql);
//	}
	public void addStudent1(Student student) {//����PreparedStatement��������ѧ����Ϣ
		String sql = "INSERT INTO examstudent (flowid,type,idcard,examcard,studentname,location,grade) VALUES (?,?,?,?,?,?,?)";
		try {
			jdbcTools.update1(sql, student.getFlowID(),student.getType(),student.getIDcard(),student.getExamcard()
					,student.getStudentName(),student.getLocation(),student.getGrade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Student selectStudent(){//��ѯѧ����Ϣ

		System.out.println("��ѡ����Ҫ���������:");
		System.out.println("a:׼��֤��");
		System.out.println("b:���֤��");
		Scanner scanner = new Scanner(System.in);
		String cur = scanner.next();
		String sql = "SELECT * FROM examstudent WHERE ";
		if(cur.equals("a")){
			System.out.println("������׼��֤��:");
			sql = sql+"Examcard='"+scanner.next()+"'";
		}else if(cur.equals("b")){
			System.out.println("�����뿼������:");
			sql = sql+"IDcard='"+scanner.next()+"'";
		}else{
			System.out.println("�����������������½�����򡣡�����");
			throw new RuntimeException();
		}
		Student student = getStudent(sql);
		return student;
	}
	public Student getStudent(String sql){//����ѧ������
		Student stu = null;
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		
		try {
			con = jdbcTools.getConnection();
			state = con.createStatement();
			rs = state.executeQuery(sql);
			if(rs.next()){
				stu = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcTools.release(rs, con, state);
		}
		return stu;
	}
	public void printStudent(Student stu){
		if( stu != null){
			System.out.println(stu);
		}else {
			System.out.println("û���ҵ����ѧ���йص���Ϣ��");
		}
	}
@Test
		public void test(){
//			Student student = getInformFromConsole();
//			addStudent1(student);
			Student stu = selectStudent();
			printStudent(stu);
		}
			
		
		

}
