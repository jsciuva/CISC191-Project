import java.util.Hashtable;
import java.util.Scanner;

public class GradesModel {

	public static final int OBJECTIVES_COUNT = 10;

	private LearningOutcome[] learningOutcomes = {
			new LearningOutcome("LO 1: Object Oriented Programming"),
			new LearningOutcome("LO 2: Arrays"),
			new LearningOutcome("LO 3: Objects and Classes"),
			new LearningOutcome("LO 4: Inheritance and Polymorphism"),
			new LearningOutcome("LO 5: Exception Handling"),
			new LearningOutcome("LO 6: File I/O"),
			new LearningOutcome("LO 7: Graphical User Interfaces"),
			new LearningOutcome("LO 8: Collections and Data Structures"),
			new LearningOutcome("LO 9: Recursion"),
			new LearningOutcome("LO 10: Multi-Threading")

	};
	private static final String[] GRADES = { "N/A", "F", "D", "C", "B", "A" };
	
	// public static Hashtable<String, String> gradeTable = new Hashtable<String, String>();
	// populate the hashtable with grades accociated with each achievement title
	// static {
	// for (int i = 0; i < GRADES.length; ++i) {
	// gradeTable.put(ProficiencyLevel.TITLES[i + 1], GRADES[i]);
	// // proficiencyLevelTable.put(TITLES[i], new ProficiencyLevel(i));
	// }
	// }
	private String fileName = "grade.csv";

	public GradesModel() {

	}

	public String toString() {
		String message = "";
		for (int i = 0; i < learningOutcomes.length; ++i) {
			message += learningOutcomes[i] + "\n";
		}
		return message;
	}

	// calculates the students grade based on the number of completed LOs
	// (not "In-Progress")
	public String calculateGrade() {
		String gradeString = "N/A"; // Default grade is "N/A" (all LO's
									// In-Progress)
		// determine how many objectives have been completed
		// by counting all non In-Progress level titles
		int completedObjectives = 0;
		for (int i = 0; i < learningOutcomes.length; ++i) {

			if (learningOutcomes[i].getLevel().getTitle() != "In-Progress") {
				// If any LO has no work submitted, grade is "F"
				if (learningOutcomes[i].getLevel()
						.getTitle() == ProficiencyLevel.TITLES[1]) {
					return GRADES[1];
				}
				++completedObjectives;
			}
		}
		if (completedObjectives == 0) {
			// all LO's are In-Progress, return "N/A"
			return gradeString;
		}
		// proficiencyLevelCount is the sum of the occurrences of the
		// proficiency level at TITLES[i] plus the sum of higher levels
		int proficiencyLevelCount = 0;
		// the outer for-loop cycles through each proficiency level title
		// starting with the highest and going down (does not include "No
		// Evidence"
		for (int i = ProficiencyLevel.TITLES.length - 1; i > 1; --i) {
			// the inner for-loop cycles through each learning objective and
			// counts how many times the proficiency level is achieved
			for (int j = 0; j < learningOutcomes.length; ++j) {
				// don't count "In-Progress" LOs
				if (learningOutcomes[j].getLevel()
						.getTitle() != ProficiencyLevel.TITLES[0]) {
					// count the occurrences of the title at index i
					if (learningOutcomes[j].getLevel()
							.getTitle() == ProficiencyLevel.TITLES[i]) {
						proficiencyLevelCount++;
					}
				}
			}
			// the highest proficiency level achieved on completed objectives -
			// 1
			// is the proficiency level that the final grade will be based on.
			if (proficiencyLevelCount >= completedObjectives - 1
					&& proficiencyLevelCount > 0) {
				return GRADES[i];
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

	public void saveGrade() {
		// create a string of all proficiency level titles
		String gradeString = "";
		for (int i=0; i < learningOutcomes.length; ++i) {
			gradeString += learningOutcomes[i].getLevel().getTitle();
			gradeString += "\n";
		}
		// save the string in a file
		GradeIO.writeGrade(fileName, gradeString);
	}
	
	public void loadGrade() {
		// load the grades from the file 
		Scanner scanner = new Scanner(GradeIO.readGrade(fileName));
		int objectiveNumber = 0;
		while (scanner.hasNextLine()) {
			String level = scanner.nextLine();
			learningOutcomes[objectiveNumber].setLevel(level);
			objectiveNumber++;
		}
	}

}
