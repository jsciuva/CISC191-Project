
public class GradesModel {

	public static final int OBJECTIVES_COUNT = 10;
	
	private LearningOutcome[] learningOutcomes = { 
			new LearningOutcome("LO 1"), new LearningOutcome("LO 2"),
			new LearningOutcome("LO 3"), new LearningOutcome("LO 4"), new LearningOutcome("LO 5"), 
			new LearningOutcome("LO 6"), new LearningOutcome("LO 7"), new LearningOutcome("LO 8"),
			new LearningOutcome("LO 9"), new LearningOutcome("LO 10") 
			
	};


	public GradesModel() {

	}
	
//	public static void main(String[] args) {
//		
//		GradesModel gradesModel = new GradesModel();
//		gradesModel.learningOutcomes[2].setLevel(new ProficiencyLevel("Intern"));
//		System.out.println(gradesModel);
//		System.out.println("Grade: " + gradesModel.calculateGrade());
//		
//	}
	
	public String toString() {
		String message = "";
		for (int i=0; i < learningOutcomes.length; ++i) {
			message += learningOutcomes[i] + "\n";
		}
		return message;
	}
	
	public String calculateGrade() {
		
		String gradeString = "In-Progress";
		
		for (int i=0; i < learningOutcomes.length; ++i) {
			if (!learningOutcomes[i].getLevel().isInProgress()) {
				gradeString = "N/A";
			}
		}
		
		return gradeString;
	}

	public String getLearningOutcomeTitle(int i) {
		return learningOutcomes[i].getTitle();
	}
	
	public LearningOutcome getLearningOutcome(int i) {
		return learningOutcomes[i];
	}
	
// TODO Add method for view to set level
	public void setLevel() {

	}

}
