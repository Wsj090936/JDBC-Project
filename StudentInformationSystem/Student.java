package StudentInformationSystem;
//ѧ����  ���ڴ洢ѧ����Ϣ
public class Student {
	public int FlowID;//��ˮ��
	public String Type;//��������
	public String IDcard;//���֤��
	public String Examcard;//׼��֤����
	public String StudentName;//ѧ������
	public String Location;//����
	public int Grade;//�ɼ�
	
	public int getFlowID() {
		return FlowID;
	}
	public void setFlowID(int flowID) {
		FlowID = flowID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}
	public String getExamcard() {
		return Examcard;
	}
	public void setExamcard(String examcard) {
		Examcard = examcard;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public Student() {
		super();
	}
	public Student(int flowID, String type, String iDcard, String examcard, String studentName, String location,
			int grade) {
		super();
		FlowID = flowID;
		Type = type;
		IDcard = iDcard;
		Examcard = examcard;
		StudentName = studentName;
		Location = location;
		Grade = grade;
	}
	@Override
	public String toString() {
		return "Student [FlowID=" + FlowID + ", Type=" + Type + ", IDcard=" + IDcard + ", Examcard=" + Examcard
				+ ", StudentName=" + StudentName + ", Location=" + Location + ", Grade=" + Grade + "]";
	}
	
}
