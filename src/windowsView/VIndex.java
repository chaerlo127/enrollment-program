package windowsView;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import valueObject.OIndex;

public class VIndex extends JTable {
	private static final long serialVersionUID = 1L;
	// association
	private CIndex cIndex;
	private DefaultTableModel model;
	private JCheckBox jCheckBox;
	private Object[] row;
	private String name;

	//
	public VIndex() {
		super();
		// 그릇 만들기
		// attributes(구조적으로 변화되지 않는 것)
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components
		this.jCheckBox = new JCheckBox();
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌명");
		// association
	}

	// 초기화되었을 때 초기화 되는 값을 저장
	// 구조에 들어가는 값을 이 곳에 저장한 것(components, association)
	public void initialize() {
		// 데이터 채우기

		// 미리 고정하기 말고, file에서 읽어와야지 column과 row가 변경되게 만들 수 있는 것임.
		model.setNumRows(0);// row 초기화

	}

	public String getData(String fileName) {
		this.cIndex = new CIndex();
		Vector<OIndex> oindices = this.cIndex.getAll(fileName);
		OIndex oIndex1 = new OIndex();
		row = new Object[model.getColumnCount()];// 한 줄이 3개로 구성되어 있음
		for (OIndex oIndex : oindices) {

			row[0] = oIndex.getFileName();
			model.addRow(row);
		}

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					Point point = e.getPoint();
					int column = getSelectedColumn();
					int row = rowAtPoint(point);
					String name = (String) getValueAt(row, column);
					System.out.print(name);
					oIndex1.setFileName(name);
				}
			}

		});
		this.updateUI();// jtable아 ui를 다시 그려라
		return oIndex1.getFileName();

	}


}
