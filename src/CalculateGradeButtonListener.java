import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculateGradeButtonListener implements ActionListener {

	private GradesModel model;
	private GradesView view;

	public CalculateGradeButtonListener(GradesModel model, GradesView view) {
		this.model = model;
		this.view = view;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.displayGrade(model.calculateGrade());

	}

}
