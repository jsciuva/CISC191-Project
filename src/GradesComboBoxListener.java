import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class GradesComboBoxListener implements ActionListener {

	private JComboBox<String> box;
	private LearningOutcome objective;

	public GradesComboBoxListener(JComboBox<String> gradesBox, LearningOutcome lo) {

		box = gradesBox;
		objective = lo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// when a selection is made from the comboBox, update the state of associated
		// proficiency level
		// i.e. call setProficiencyLevel()
		// the action listener needs to be able to access the ProficiencyLevel set
		// TODO set title of ProficiencyLevel
		// Question: Is it okay to cast to String like this???
		String state = (String)box.getItemAt(box.getSelectedIndex());
		objective.setLevel(state);
		
		

	}

}
