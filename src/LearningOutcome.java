
public class LearningOutcome {

	private String title; // a LearningOutcome has-a title
	// a LearningOutcome has-a ProficiencyLevel
	private ProficiencyLevel level = ProficiencyLevel.getProficiencyLevelForTitle("In-Progress");
	
	public LearningOutcome(String title) {
		this.title = title;
	}

	public ProficiencyLevel getLevel() {
		return level;
	}

	public void setLevel(String title) {
		
		this.level = ProficiencyLevel.getProficiencyLevelForTitle(title);;
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
