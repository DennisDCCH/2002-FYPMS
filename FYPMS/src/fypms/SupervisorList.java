package fypms;

public class SupervisorList {
	private Supervisor[] supervisor;
	
	public SupervisorList() {
		supervisor = new Supervisor[11];
		
		supervisor[0] = new Supervisor(1, "ASMADHUKUMAR", "A S Madhukumar");
		supervisor[1] = new Supervisor(2, "ASSOURIN", "Alexei Sourin");
		supervisor[2] = new Supervisor(3, "ARVINDE", "Arvind Easwaran");
		supervisor[3] = new Supervisor(4, "BOAN", "Bo An");
		supervisor[4] = new Supervisor(5, "ASWTCAI", "Cai Wentong");
		supervisor[5] = new Supervisor(6, "CCLOY", "Chen Change Loy");
		supervisor[6] = new Supervisor(7, "ASLTCHIA", "Chia Liang Tien");
		supervisor[7] = new Supervisor(8, "GAOCONG", "Cong Gao");
		supervisor[8] = new Supervisor(9, "ASDOUGLAS", "Douglas Leslie Maskell");
		supervisor[9] = new Supervisor(10, "DNIYATO", "Dusit Niyato");
		supervisor[10] = new Supervisor(11, "YPKE", "Ke Yiping, Kelly");
	}
	
	public Supervisor checkDomain(String userID){
		for (Supervisor s: supervisor) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
	
	//Setter Getter
	public Supervisor getSupervisor(int index) {
		int i = 0;
		for(Supervisor s: supervisor) {
			if(i == index)
				return s;
			i++;
		}
		return null;
	}
}
