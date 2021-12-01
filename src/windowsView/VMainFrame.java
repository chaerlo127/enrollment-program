package windowsView;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import constants.Conflg.FVMainFrame;

public class VMainFrame extends JFrame {
	//빈 화면에 확장
	
	//attribute
	private static final long serialVersionUID = 1L;

	//변경의 상태를 나타내는 번호 , update
	
	//conponents
	
	private VLogin vLogin;
	public VMainFrame(){
		super();
		
		//attributes
		this.setLocation(FVMainFrame.location);
		this.setSize(FVMainFrame.size);//code를 변경하지 않고 constant로 가서 변경한다. 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components
		this.vLogin = new VLogin();
		JScrollPane pane = new JScrollPane(this.vLogin);
		this.add(pane);
	}
	private void initialize() {
		//variable attributes(변하는 속성 값)
		
		//components initialize
//		this.vLogin.initialize();
	}
	public static void main(String[] args) {//최상위 class
		VMainFrame vMain = new VMainFrame();
		vMain.initialize();
		vMain.setVisible(true);
	}


	}
	
