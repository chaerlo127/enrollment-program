package control;

import java.util.Vector;

import dataAccessObject.DIndex;
import valueObject.OIndex;

public class CIndex {
	private DIndex dIndex;

	public CIndex() {
		this.dIndex = new DIndex();
	}

	public Vector<OIndex> getAll(String fileName) {
		Vector<OIndex> indices = this.dIndex.readAll(fileName);
		return indices;
	}

	//회원 첫 화면에서 학과 읽는 것
	public Vector<OIndex> HakgwaGetAll(String fileName) {
		Vector<OIndex> indices = this.dIndex.HakgwareadAll(fileName);
		return indices;
	}

	public Vector<OIndex> HakgwaGet(String fileName) {
		Vector<OIndex> indices = this.dIndex.HakgwaGet(fileName);
		return indices;
	}

}
