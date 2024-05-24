import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadButtonListener implements ActionListener {

	private GradesModel model;
	private GradesView view;
	
	public LoadButtonListener(GradesModel model, GradesView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.loadGrade();
		view.updateUI();

	}

}
