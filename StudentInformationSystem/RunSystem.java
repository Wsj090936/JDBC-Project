package StudentInformationSystem;
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
	public  void addStudent(Student student) {//����ѧ����Ϣ
		String sql = "INSERT INTO examstudent VALUES ("
					+student.getFlowID()
					+",'"+student.getType()
					+"','"+student.getIDcard()
					+"','"+student.getExamcard()
					+"','"+student.getStudentName()
					+"','"+student.getLocation()
					+"',"+student.getGrade()+")";
		jdbcTools.update(sql);
	}
	public void addStudent1(Student student) {//����PreparedStatement��������ѧ����Ϣ
		String sql = "INSERT INTO examstudent (flowid,type,idcard,examcard,studentname,location,grade) VALUES (?,?,?,?,?,?,?)";
		try {
			jdbcTools.update1(sql, student.getFlowID(),student.getType(),student.getIDcard(),student.getExamcard()
					,student.getStudentName(),student.getLocation(),student.getGrade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectStudent(){
		System.out.println("��ѡ����Ҫ���������:");
		System.out.println("a:׼��֤��");
		System.out.println("b:���ڵ���");
		Scanner scanner = new Scanner(System.in);
		String cur = scanner.next();
		String sql;
		if(cur.equals("a")){
			System.out.println("������׼��֤��:");
			sql = "SELECT * FROM examstudent WHERE Examcard='"+scanner.next()+"'";
			jdbcTools.select(sql);
		}else if(cur.equals("b")){
			System.out.println("�����뿼������:");
			sql = "SELECT * FROM examstudent WHERE Location='"+scanner.next()+"'";
			jdbcTools.select(sql);
		}else
			System.out.println("�����������������½�����򡣡�����");
	}

@Test
		public void test(){
			Student student = getInformFromConsole();
			addStudent1(student);
		}
			
		
		

}
