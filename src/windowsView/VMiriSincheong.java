package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.OLecture;

public class VMiriSincheong extends JTable {
	private static final long serialVersionUID = 1L;
	// association
	private CLecture cLecture;
	private DefaultTableModel model;
	
	//
	public VMiriSincheong() {
		super();
		// 그릇 만들기
		// attributes(구조적으로 변화되지 않는 것)
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌명");
		model.addColumn("강사명");
		model.addColumn("시간");// 직접 붙이는 것, 변화하지 않는 것은 constructer에 저장하는 것
		// association
	}

	// 초기화되었을 때 초기화 되는 값을 저장
	// 구조에 들어가는 값을 이 곳에 저장한 것(components, association)
	public void initialize() {
		// 데이터 채우기
		
		// 미리 고정하기 말고, file에서 읽어와야지 column과 row가 변경되게 만들 수 있는 것임.
		model.setNumRows(0);//row 초기화
		
	}
	public OLecture getData(String fileName) {
		this.cLecture = new CLecture();
//		this.cLecture.Write(fileName, oLectureGet.getId(), oLectureGet);
		Vector<OLecture> oLectures = this.cLecture.MSgetAll(fileName);
		if(oLectures!= null)
		{
			OLecture lecture = new OLecture();
			String[] row = new String[model.getColumnCount()];// 한 줄이 3개로 구성되어 있음
			for (OLecture oLecture : oLectures) {
				row[0] = oLecture.getName();
				row[1] = oLecture.getProfessor();
				row[2] = oLecture.getTime();
				model.addRow(row);
				lecture = oLecture;
				
			}
			return lecture;
		}
		
		this.updateUI();// jtable아 ui를 다시 그려라
		return null;
	}

}
