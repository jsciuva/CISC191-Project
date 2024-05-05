import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculateGradeButtonListener implements ActionListener {

	private GradesModel model;

	public CalculateGradeButtonListener(GradesModel model) {
		this.model = model;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Call calculate grade method
		// model.calculateGrade();
		System.out.println(model.calculateGrade());

	}

}
