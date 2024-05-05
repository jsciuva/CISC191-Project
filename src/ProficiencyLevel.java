import java.util.Hashtable;

public class ProficiencyLevel {

	private final int score;
	private final String title;
	private final boolean inProgress;
	
	public static final String[] TITLES = {"In-Progress", "No Evidence", "Intern", "Junior", "Middle", "Senior"};
	public static Hashtable<String, Integer> scoreTable = new Hashtable<String, Integer>();
	public static Hashtable<String, ProficiencyLevel> proficiencyLevelTable = new Hashtable<String, ProficiencyLevel>();
	// populate the hashtable with numerical scores for each achievement title
	// note: this will be important when saving/loading date from a file
	// Question: can we get away with only using titles, not scores or a hashtable???
	static {
		for (int i=0; i < TITLES.length; ++i) {
			scoreTable.put(TITLES[i], i-1);
			proficiencyLevelTable.put(TITLES[i], new ProficiencyLevel(TITLES[i]));
		}
	}
	// private to ensure
	private ProficiencyLevel(String title) {
		this.score = scoreTable.get(title);
		this.title = title;
		inProgress = score < 0;
	}
	
	public static ProficiencyLevel getProficiencyLevelForTitle(String title) {
		return proficiencyLevelTable.get(title);
	}
	
	public String toString() {
		return title;
	}
	
	public int getScore() {
		return score;
	}

//	public void setScore(int score) {
//		this.score = score;
//	}

	public String getTitle() {
		return title;
	}

//	public void setTitle(String title) {
//		this.title = title;
//	}
	
	public boolean isInProgress() {
		return inProgress;
	}
	
	// Question: should score and title be able to be set independently
	// of each other, or should there be one function for setting both
	// together???
	
//	public void setLevel(String) {
//	}
	
}
