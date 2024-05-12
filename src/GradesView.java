import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradesView extends JFrame {

	private GradesModel model; // a GradesView has-a GradesModel
	JLabel displayGrade; // label for displaying the grade after calculation

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
			JLabel objectiveLabel = new JLabel(model.getLearningOutcomeTitle(i));
			// Add a drop-down selection box for each proficiency level
			JComboBox<String> box = new JComboBox<String>(
					ProficiencyLevel.TITLES);
			box.addActionListener(new GradesComboBoxListener(box, model.getLearningOutcome(i)));
			labelPanel.add(objectiveLabel);
			labelPanel.add(box);
		}
		add(labelPanel, BorderLayout.WEST);
		
		// right side of the window contains a Calculate Grade button, 
		// and Save and Load buttons, as well as a display window for 
		// the calculated grade
		// Add the calculate grade button
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1, 0, 20));
		JButton calculateGrade = new JButton("Calculate Grade");
		calculateGrade
				.addActionListener(new CalculateGradeButtonListener(model, this));
		JButton saveButton = new JButton("Save");
		JButton loadButton = new JButton("Load");
		JLabel gradeLabel = new JLabel("    Grade:   ");
		displayGrade = new JLabel();
		
		
		saveButton.addActionListener(new SaveButtonListener(model));
		loadButton.addActionListener(null); // FIXME create and add action listener
		
		buttonPanel.add(calculateGrade);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(gradeLabel);
		buttonPanel.add(displayGrade);
		
		
		add(buttonPanel, BorderLayout.EAST);
		
		// add some space between the two application panels
		JPanel spacePanel = new JPanel();
		JLabel spaceLabel = new JLabel("             ");
		spacePanel.add(spaceLabel);
		add(spacePanel, BorderLayout.CENTER);
		
		// display the JFrame window (default is invisible)
		pack();
		setVisible(true);
	}
	
	public void updateUI(String gradeString) {
		displayGrade.setText(gradeString);
	}

	public static void main(String[] args) {
		new GradesView(new GradesModel());
	}
}
