package StudentInformationSystem;

import java.util.Scanner;

import org.junit.Test;



public class RunSystem {
	private  Student getInformFromConsole(){//�ӿ���̨����ѧ����Ϣ
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		
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
		
		return student;
	}
	public  void addStudent(Student student) {//����ѧ����Ϣ
		String sql = "INSERT INTO examsrudent VALUES ("
					+student.getFlowID()
					+",'"+student.getType()
					+"','"+student.getIDcard()
					+"','"+student.getExamcard()
					+"','"+student.getStudentName()
					+"','"+student.getLocation()
					+"',"+student.getGrade()+")";
		JDBCTools.update(sql);
	}

@Test
		public void test(){
			Student student = getInformFromConsole();
			addStudent(student);
		}
			
		
		

}
