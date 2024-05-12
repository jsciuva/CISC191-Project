import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadButtonListener implements ActionListener {

	private GradesModel model;
	
	public LoadButtonListener(GradesModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		model.loadGrade();

	}

}
