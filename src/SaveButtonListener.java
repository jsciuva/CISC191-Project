import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButtonListener implements ActionListener {
	
	private GradesModel model;
	
	public SaveButtonListener(GradesModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("from SaveButtonListener");
		model.saveGrade();

	}

}
