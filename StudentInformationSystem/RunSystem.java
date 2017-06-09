package StudentInformationSystem;

import java.util.Scanner;

import org.junit.Test;



public class RunSystem {
	private  Student getInformFromConsole(){//从控制台输入学生信息
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("FlowID:");
		student.setFlowID(scanner.nextInt());//输入学生流水号
		
		System.out.print("Type:");
		student.setType(scanner.next());//输入考试类型
		
		System.out.print("IDcard:");
		student.setIDcard(scanner.next());//输入学生的身份证号
		
		System.out.print("Examcard:");
		student.setExamcard(scanner.next());//输入学生的准考证号
		
		System.out.print("StudentName:");
		student.setStudentName(scanner.next());//输入学生姓名
		
		System.out.print("Location:");
		student.setLocation(scanner.next());//输入学生所在地
		
		System.out.print("Grade");
		student.setGrade(scanner.nextInt());//输入学生成绩
		
		return student;
	}
	public  void addStudent(Student student) {//插入学生信息
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
