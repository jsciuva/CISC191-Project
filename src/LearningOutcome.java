
public class LearningOutcome {

	private String title; // a LearningOutcome has-a title
	// a LearningOutcome has-a ProficiencyLevel
	// private ProficiencyLevel level = ProficiencyLevel.getProficiencyLevelForTitle("In-Progress");
	
	private ProficiencyLevel level = new ProficiencyLevel(0);
	
	public LearningOutcome(String title) {
		this.title = title;
	}

	public ProficiencyLevel getLevel() {
		return level;
	}

	public void setLevel(int index) {
		this.level = new ProficiencyLevel(index);
		// this.level = ProficiencyLevel.getProficiencyLevelForTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title + " " + level;
	}
	
	
	
}
