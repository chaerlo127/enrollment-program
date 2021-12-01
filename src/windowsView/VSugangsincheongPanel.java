package windowsView;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.Conflg.FVCampus;
import constants.Conflg.FVMainPanel;
import valueObject.OHwewon;

public class VSugangsincheongPanel extends JPanel {
	// attribute
	private static final long serialVersionUID = 1L;// 추가

	// components
	private VGangjwaSelectionPanel vGangjwaSelectionPanel;
	private VMiriSincheong vMiridamgi;
	private VMiriSincheong vSincheong;

	public VSugangsincheongPanel() {
		super();
		// attributes
		this.setBackground(FVMainPanel.background);
		
		// components

		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		
		this.vGangjwaSelectionPanel = new VGangjwaSelectionPanel();
		this.add(this.vGangjwaSelectionPanel, BorderLayout.WEST);
		
		
		// class를 따로 만들지 않음.
		JPanel mirisincheongPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(mirisincheongPanel, BoxLayout.Y_AXIS);
		mirisincheongPanel.setLayout(boxLayout);
		
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(300, 100));
		this.vMiridamgi = new VMiriSincheong();
		jScrollPane = new JScrollPane(this.vMiridamgi);
		jScrollPane.setPreferredSize(new Dimension(300, 200));
		mirisincheongPanel.add(jScrollPane);

		this.vSincheong = new VMiriSincheong();
		jScrollPane = new JScrollPane(this.vSincheong);
		jScrollPane.setPreferredSize(new Dimension(300, 200));
		mirisincheongPanel.add(jScrollPane);
		this.add(mirisincheongPanel, BorderLayout.EAST);
		

	}

	public void initialize(OHwewon oHwewon) {
		this.vGangjwaSelectionPanel.initialize();
//		OLecture oLecture =
		this.vGangjwaSelectionPanel.getData(FVCampus.FirstFileName);
		this.vMiridamgi.initialize();
		this.vMiridamgi.getData(oHwewon.getId()+"M");
		this.vSincheong.initialize();
		this.vSincheong.getData(oHwewon.getId()+"S");
	}

}
