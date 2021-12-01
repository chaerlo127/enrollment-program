package windowsView;

import javax.swing.JPanel;

import constants.Conflg.FVMainPanel;
import valueObject.OHwewon;

public class VMainPanel extends JPanel {
	//attribute
	private static final long serialVersionUID = 1L;//Ãß°¡
	//components
	private VSugangsincheongPanel vSugangsincheongPanel;
	public VMainPanel() {
		super();
		//attributes
		this.setBackground(FVMainPanel.background);
		//components
		this.vSugangsincheongPanel = new VSugangsincheongPanel();
		this.add(this.vSugangsincheongPanel);
	}
	public void initialize(OHwewon oHwewon) {
		this.vSugangsincheongPanel.initialize(oHwewon);
	}

}
