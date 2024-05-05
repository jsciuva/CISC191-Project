import javax.swing.JComboBox;

public class GradesComboBox extends JComboBox<String > {

	private int proficiencyLevel = 0; // A GradesComboBox has-a proficiencyLevel which is selected from the drop-down box
	private boolean inProgress = true; // The default state of each learning objective is "In-Progress"
	
	public GradesComboBox(String[] array) {
		// Initialize a JComboBox with an array of Integers representing each proficiency level
		super(array);
	}

	public int getProficiencyLevel() {
		return proficiencyLevel;
	}

	public void setProficiencyLevel(int proficiencyLevel) {
		this.proficiencyLevel = proficiencyLevel;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}
	
}
