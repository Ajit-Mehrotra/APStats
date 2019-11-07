import java.util.ArrayList;


public class APStats {
	private int awardLevel;
	private double averageGrade;
	private boolean RequirementForScholar;
	boolean RequirementForHonors;
	private int totalYears = 0;
	

	//postcondition: the award level is computed and returned,
	//    as follows: 0 for no award, 1 for  AP Scholar,
	//    and 2 for AP Scholar with Honor. 
	public int getAwardLevel(APStudent student){
		double numberOf3orHigher = 0;
		ArrayList <APExam> examsTaken = student.getExams();
		averageGrade = student.getAverageGrade();


		


		for(APExam examNum: examsTaken){
			if(examNum.getGrade() >= 3 ){
				totalYears += examNum.getLevel();
				if( examNum.getLevel() == 1){
				numberOf3orHigher+= 0.5;
				}else{
					numberOf3orHigher++;
				}
			}


		}

		if( totalYears >= 6 && numberOf3orHigher >= 3){
			RequirementForScholar = true;
			if ( numberOf3orHigher >= 4 && (totalYears >= 8) && (averageGrade >= 3.25)){
				RequirementForHonors = true;
			}
		}
		if(RequirementForScholar && RequirementForHonors){
			awardLevel = 2;
		}else if(RequirementForScholar){
			awardLevel = 1;
		}else{
			awardLevel = 0;
		}


		return awardLevel;



		//Complete this method for part A.
	}


	//precondition:  list.size() > 0
	//postcondition: returns an array percents of legnth 3;
	//               percents[0], percents[1], and percents[2]
	//               are filled with perecentages of all students 
	//               from the list with no award, APScholars,
	//               and APScholars with Honor, respectfully
	public double[] getStats( ArrayList<APStudent> list ){
		double[] percents = {0.0,0.0,0.0};
		double totalNoAward = 0;
		double totalAward = 0;
		double totalHonors = 0;
		APStats stats = new APStats();
		double size = list.size();
		for(APStudent student: list){
			System.out.println("Student:" + student.getName() + " " + stats.getAwardLevel(student) );
			if(stats.getAwardLevel(student) == 0){

				totalNoAward++ ;
				//System.out.println("Award Level: 0");
				//System.out.println("TotalNoAward: " + totalNoAward);
			}else if(stats.getAwardLevel(student) == 1){
				totalAward++ ;
				//System.out.println("Award Level: 1");
				//System.out.println("TotalAward: " + totalAward);
			}else if(stats.getAwardLevel(student) == 2){

				//System.out.println("Award Level Expected : 2"+ "Actual:" + (stats.getAwardLevel(student)));
				totalHonors++ ;
				//System.out.println("TotalHonors: " + totalHonors);

			}


		}
		System.out.println("Number of Students with No Award: " + totalNoAward);
		System.out.println("Number of Students with  Award: " + totalAward);
		System.out.println("Number of Students with Honors Award: " + totalHonors);

		percents[0] = totalNoAward/size*100;
		percents[1] = totalAward/size* 100;
		percents[2] = totalHonors/size* 100 ;
		return percents;



	}
	public static APStudent me(){
		APStats stats = new APStats();
		APStudent Me = new APStudent("Me");
		Me.getExams().add(new APExam("Chemistry", 1, 2));
		Me.getExams().add(new APExam("Chemistry", 1, 2));
		Me.getExams().add(new APExam("Chemistry", 1, 2));
		Me.getExams().add(new APExam("Chemistry", 1, 5));
		Me.getExams().add(new APExam("Chemistry", 1, 5));
		Me.getExams().add(new APExam("Chemistry", 1, 5));
		Me.getExams().add(new APExam("Chemistry", 1, 5));
		return Me;
	}

	public static APStudent you(){
		APStats stats = new APStats();
		APStudent you = new APStudent("You");
		you.getExams().add(new APExam("Chemistry", 2, 5));
		you.getExams().add(new APExam("Chemistry", 1, 2));
		you.getExams().add(new APExam("Chemistry", 2, 2));
		you.getExams().add(new APExam("Chemistry", 1, 3));
		you.getExams().add(new APExam("Chemistry", 2, 4));
		you.getExams().add(new APExam("Chemistry", 2, 2));
		you.getExams().add(new APExam("Chemistry", 1, 4));
		return you;
	}

	public static APStudent Jeffrey(){
		APStats stats = new APStats();
		APStudent Jeffrey = new APStudent("Jeffrey");
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 2));
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 2));
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 2));
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 5));
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 5));
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 5));
		Jeffrey.getExams().add(new APExam("Chemistry", 2, 5));
		return Jeffrey;
	}

	public static APStudent Robert(){

		APStudent Robert = new APStudent("Robert");
		Robert.getExams().add(new APExam("Chemistry", 1, 2));
		Robert.getExams().add(new APExam("Chemistry", 1, 2));
		Robert.getExams().add(new APExam("Chemistry", 1, 2));
		Robert.getExams().add(new APExam("Chemistry", 1, 5));
		Robert.getExams().add(new APExam("Chemistry", 1, 5));
		Robert.getExams().add(new APExam("Chemistry", 1, 5));
		Robert.getExams().add(new APExam("Chemistry", 1, 5));
		Robert.getExams().add(new APExam("Chemistry", 1, 5));
		return Robert;
	}

	// Do not run this until you are sure it works!!!
	public static void runAPStatsAcceptanceTest(){
		(new APStatsProblemTester()).generateCasesAndRun();
	}
	public static void main(String[] args) {
		runAPStatsAcceptanceTest();

	}


}
