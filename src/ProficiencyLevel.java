import java.util.Hashtable;

public class ProficiencyLevel {

	// private final int score;
	private final String title; // a ProficiencyLevel has-a title
	// private final boolean inProgress;
	
	public static final String[] TITLES = {"In-Progress", "No Evidence", "Intern", "Junior", "Middle", "Senior"};
	
	
	public static Hashtable<String, ProficiencyLevel> proficiencyLevelTable = new Hashtable<String, ProficiencyLevel>();
	
	// private to ensure... WHAT?
	public ProficiencyLevel(int index) {
		//this.score = scoreTable.get(title);
		this.title = TITLES[index];
		//inProgress = score < 0;
	}
	
	public static ProficiencyLevel getProficiencyLevelForTitle(String title) {
		return proficiencyLevelTable.get(title);
	}
	
	public String toString() {
		return title;
	}
	
	public int getIndex(String title) {
		int index = -1;
		for (int i=0; i < TITLES.length; ++i) {
			if (TITLES[i] == title) {
				index = i;
			}
		}
		return index;
	}
	
//	public int getScore() {
//		return score;
//	}

	public String getTitle() {
		return title;
	}
	
//	public boolean isInProgress() {
//		return inProgress;
//	}
	
//	public void setLevel(String) {
//	}
	
}
