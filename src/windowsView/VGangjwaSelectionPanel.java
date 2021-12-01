package windowsView;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import valueObject.OLecture;

public class VGangjwaSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;//추가
	//components
	private VGangjwa vGangjwa;
	private VIndex vCampus;
	private VIndex vCollage;
	private VIndex vHakgwa;
	public VGangjwaSelectionPanel() {
		super();
		//attributes
		
		
		//components
		JScrollPane jScrollPane;
		//layoutManager 만들기

		//boarderlayout이 중심, 캠퍼스, 대학, 학과는 boxlayout을 하나더 만들어서 y축으로
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		
		JPanel index = new JPanel();
		BoxLayout boxLayout = new BoxLayout(index, BoxLayout.Y_AXIS);
		index.setLayout(boxLayout);
		
		this.vCampus = new VIndex();
		jScrollPane = new JScrollPane(this.vCampus);
		jScrollPane.setPreferredSize(new Dimension(200, 50));
		index.add(jScrollPane);
		
		this.vCollage = new VIndex();
		jScrollPane = new JScrollPane(this.vCollage);
		jScrollPane.setPreferredSize(new Dimension(200, 50));
		index.add(jScrollPane);
		
		this.vHakgwa = new VIndex();
		jScrollPane = new JScrollPane(this.vHakgwa);
		jScrollPane.setPreferredSize(new Dimension(200, 50));
		index.add(jScrollPane);
		
		
		this.vGangjwa = new VGangjwa();
		jScrollPane = new JScrollPane(this.vGangjwa);
		jScrollPane.setPreferredSize(new Dimension(200, 50));
		index.add(jScrollPane);
		this.add(index);

		
}
	public void initialize() {
		this.vCampus.initialize();
		this.vCollage.initialize();
		this.vGangjwa.initialize();
		this.vHakgwa.initialize();
	}
	
	
	public void getData(String fileName) {
		
//		OIndex oIndex;
		String FileName = this.vCampus.getData(fileName);
		if(FileName!=null)
		{
			FileName= this.vCollage.getData(FileName);
			if(FileName!= null)
			{
				FileName = this.vHakgwa.getData(FileName);
				OLecture oLecture = this.vGangjwa.getData(FileName);
			}
			
			
		}
		
//		return oLecture;
	}
}
