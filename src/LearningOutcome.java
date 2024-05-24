
public class LearningOutcome {

	private String title; // a LearningOutcome has-a title
	
	// NOTE: there are two implementations here, one which uses an index and one
	// which uses a String. If I had more time I would clean this up and use just one
	// throughout the program, but as it is now, there are places where one is implemented
	// or the other.
	private ProficiencyLevel level = ProficiencyLevel.getProficiencyLevelForTitle("In-Progress");
	// private ProficiencyLevel level = new ProficiencyLevel(0);
	
	public LearningOutcome(String title) {
		this.title = title;
	}

	public ProficiencyLevel getLevel() {
		return level;
	}

	public void setLevel(int index) {
		this.level = new ProficiencyLevel(index);
	}
	
	public void setLevel(String title) {
		this.level = ProficiencyLevel.getProficiencyLevelForTitle(title);
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
