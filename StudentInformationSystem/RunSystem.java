package StudentInformationSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
//	public  void addStudent(Student student) {//插入学生信息
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
	public void addStudent1(Student student) {//利用PreparedStatement方法增加学生信息
		String sql = "INSERT INTO examstudent (flowid,type,idcard,examcard,studentname,location,grade) VALUES (?,?,?,?,?,?,?)";
		try {
			jdbcTools.update1(sql, student.getFlowID(),student.getType(),student.getIDcard(),student.getExamcard()
					,student.getStudentName(),student.getLocation(),student.getGrade());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Student selectStudent(){//查询学生信息

		System.out.println("请选择您要输入的类型:");
		System.out.println("a:准考证号");
		System.out.println("b:身份证号");
		Scanner scanner = new Scanner(System.in);
		String cur = scanner.next();
		String sql = "SELECT * FROM examstudent WHERE ";
		Student student = null;
		if(cur.equals("a")){
			System.out.println("请输入准考证号:");
			sql = sql+"Examcard=?";
			student = getStudent(sql,scanner.next());
		}else if(cur.equals("b")){
			System.out.println("请输入身份证号:");
			sql = sql+"IDcard=?";
			student = getStudent(sql,scanner.next());
		}else{
			System.out.println("您的输入有误，请重新进入程序。。。。");
			throw new RuntimeException();
		}
		return student;
	}
	public Student getStudent(String sql,Object ... args){//返回学生对象
		Student stu = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = jdbcTools.getConnection();
			ps = con.prepareStatement(sql);
			for(int i = 0 ; i < args.length ; ++i){
				ps.setObject(i + 1,args[i]);
			}
			rs = ps.executeQuery();
			if(rs.next()){
				stu = new Student();
						stu.setFlowID(rs.getInt(1));
						stu.setType(rs.getString(2)); 
						stu.setIDcard(rs.getString(3));
						stu.setExamcard(rs.getString(4)); 
						stu.setStudentName(rs.getString(5)); 
						stu.setLocation(rs.getString(6)); 
						stu.setGrade(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcTools.release(rs, con, ps);
		}
		return stu;
	}
	public void printStudent(Student stu){
		if( stu != null){
			System.out.println(stu);
		}else {
			System.out.println("没有找到与该学生有关的信息！");
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
