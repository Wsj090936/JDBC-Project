package StudentInformationSystem;
//学生信息管理的运行函数
import java.util.Scanner;

import org.junit.Test;



public class RunSystem {
	JDBCTools jdbcTools = new JDBCTools();//JDBC工具类
	private  Student getInformFromConsole(){//从控制台输入学生信息
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入考生的详细信息");
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
		System.out.println("信息录入成功");
		return student;
	}
	public  void addStudent(Student student) {//插入学生信息
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
	public void addStudent1(Student student) {//利用PreparedStatement方法增加学生信息
		String sql = "INSERT INTO examstudent (flowid,type,idcard,examcard,studentname,location,grade) VALUES (?,?,?,?,?,?,?)";
		try {
			jdbcTools.update1(sql, student.getFlowID(),student.getType(),student.getIDcard(),student.getExamcard()
					,student.getStudentName(),student.getLocation(),student.getGrade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectStudent(){
		System.out.println("请选择您要输入的类型:");
		System.out.println("a:准考证号");
		System.out.println("b:所在地区");
		Scanner scanner = new Scanner(System.in);
		String cur = scanner.next();
		String sql;
		if(cur.equals("a")){
			System.out.println("请输入准考证号:");
			sql = "SELECT * FROM examstudent WHERE Examcard='"+scanner.next()+"'";
			jdbcTools.select(sql);
		}else if(cur.equals("b")){
			System.out.println("请输入考生地区:");
			sql = "SELECT * FROM examstudent WHERE Location='"+scanner.next()+"'";
			jdbcTools.select(sql);
		}else
			System.out.println("您的输入有误，请重新进入程序。。。。");
	}

@Test
		public void test(){
			Student student = getInformFromConsole();
			addStudent1(student);
		}
			
		
		

}
