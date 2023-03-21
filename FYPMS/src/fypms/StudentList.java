package fypms;

public class StudentList {
	Student[] student;
	
	public StudentList() {
		student = new Student[11];
		
		student[0] = new Student("YCHERN", "CHERN");
		student[1] = new Student("KOH1", "KOH");
		student[2] = new Student("BR015", "BRANDON");
		student[3] = new Student("CT113", "CALVIN");
		student[4] = new Student("YCN019", "CHAN");
		student[5] = new Student("DL007", "DENISE");
		student[6] = new Student("DON84", "DONG");
		student[7] = new Student("ELI34", "ERNEST");
		student[8] = new Student("LE51", "LEE");
		student[9] = new Student("SL22", "LIU");
		student[10] = new Student("AKY013", "RAWAL");
	}
	
	public Student checkDomain(String userID){
		for (Student s: student) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
}
