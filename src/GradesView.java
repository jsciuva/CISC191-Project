import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GradesView extends JFrame {

	private GradesModel model; // a GradesView has-a GradesModel

	public GradesView(GradesModel gradesModel) {

		model = gradesModel;

		setTitle("CISC 191 Grade Calculator");
		setLayout(new BorderLayout());
		// close program when x button pressed on window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create a panel for the labels of each learning objective (LO)
		JPanel labelPanel = new JPanel(
				new GridLayout(GradesModel.OBJECTIVES_COUNT, 2));
		// labelPanel.setComponentOrientation(); FIXME
		// for-loop to add components for each LO
		for (int i = 0; i < GradesModel.OBJECTIVES_COUNT; ++i) {
			JLabel label = new JLabel(model.getLearningOutcomeTitle(i));
			// Add a drop-down selection box for each proficiency level
			JComboBox<String> box = new JComboBox<String>(
					ProficiencyLevel.TITLES);
			box.addActionListener(new GradesComboBoxListener(box, model.getLearningOutcome(i)));
			labelPanel.add(label);
			labelPanel.add(box);
		}
		
		// right side of the window contains a Calculate Grade button, 
		// and Save and Load buttons, as well as a display window for 
		// the calculated grade
		add(labelPanel, BorderLayout.WEST);
		// Add the calculate grade button
		JPanel buttonPanel = new JPanel();
		JButton calculateGrade = new JButton("Calculate Grade");
		calculateGrade
				.addActionListener(new CalculateGradeButtonListener(model));
		buttonPanel.add(calculateGrade);
		add(buttonPanel, BorderLayout.EAST);
		// display the JFrame window (default is invisible)
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GradesView(new GradesModel());
	}
}
