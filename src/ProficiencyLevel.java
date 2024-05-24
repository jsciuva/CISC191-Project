import java.util.Hashtable;

public class ProficiencyLevel {

	private final String title; // a ProficiencyLevel has-a title
	
	public static final String[] TITLES = {"In-Progress", "No Evidence", "Intern", "Junior", "Middle", "Senior"};
	
	public static Hashtable<String, ProficiencyLevel> proficiencyLevelTable = new Hashtable<String, ProficiencyLevel>();
	
	static {
		for (int i=0; i < TITLES.length; ++i) {
			proficiencyLevelTable.put(TITLES[i], new ProficiencyLevel(i));
		}
	}
	
	public ProficiencyLevel(int index) {
		this.title = TITLES[index];
	}
	
	public ProficiencyLevel(String title) {
		this.title = title;
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

	public String getTitle() {
		return title;
	}
	

	
}
