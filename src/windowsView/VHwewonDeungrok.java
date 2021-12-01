package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Conflg.FVHwewonDeungrok;
import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel id;
	private JLabel password;
	private JLabel name;
	private JLabel address;
	private JLabel campus;
	private JLabel hwakgwa;
	private JTextField txtID;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtHwakgwa;
	private JTextField txtCampus;
	private JButton button;
	private CHwewonDeungrok cHwewonDeungrok;
	private boolean bCheck;

	public VHwewonDeungrok() {
		super();
		this.cHwewonDeungrok = new CHwewonDeungrok();
		JPanel Hwewon = new JPanel();
		setContentPane(Hwewon);
		setLayout(null);
		
		this.id = new JLabel("ID: ");
		this.id.setBounds(69, 120, 70, 20);
		
		this.txtID = new JTextField(10);
		this.txtID.setBounds(159, 120, 180, 20);
		
		this.password = new JLabel("Password: ");
		this.password.setBounds(69, 140, 70, 20);
		
		this.txtPassword = new JTextField(10);
		this.txtPassword.setBounds(159, 140, 180, 20);
		
		this.name = new JLabel("이름: ");
		this.name.setBounds(69, 160, 70, 20);
		
		this.txtName = new JTextField(10);
		this.txtName.setBounds(159, 160, 180, 20);
		
		
		this.address = new JLabel("주소: ");
		this.address.setBounds(69, 180, 70, 20);
		
		this.txtAddress = new JTextField(10);
		this.txtAddress.setBounds(159, 180, 180, 20);
		
		this.hwakgwa = new JLabel("학과: ");
		this.hwakgwa.setBounds(69, 200, 70, 20);
		
		this.txtHwakgwa = new JTextField(10);
		this.txtHwakgwa.setBounds(159, 200, 180, 20);
		
		this.campus = new JLabel("캠퍼스: ");
		this.campus.setBounds(69, 220, 70, 20);
		
		this.txtCampus = new JTextField(10);
		this.txtCampus.setBounds(159, 220, 180, 20);
		
		this.button = new JButton("회원가입");
		this.button.setBounds(69, 240, 90, 30);
//			
		Hwewon.add(this.id);
		Hwewon.add(this.txtID);
		Hwewon.add(this.password);
		Hwewon.add(this.txtPassword);
		Hwewon.add(this.name);
		Hwewon.add(this.txtName);
		Hwewon.add(this.address);
		Hwewon.add(this.txtAddress);
		Hwewon.add(this.hwakgwa);
		Hwewon.add(this.txtHwakgwa);
		Hwewon.add(this.campus);
		Hwewon.add(this.txtCampus);
		Hwewon.add(this.button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Check();

			}
		});
		this.setSize(FVHwewonDeungrok.size);
		this.setLocation(FVHwewonDeungrok.location);
		this.setVisible(true);
	}

	public void Check() {
		OHwewon oHwewon = new OHwewon();
		oHwewon.setId(this.txtID.getText());
		oHwewon.setPassword(this.txtPassword.getText());
		oHwewon.setName(this.txtName.getText());
		oHwewon.setAddress(this.txtAddress.getText());
		oHwewon.setHwakgwa(this.txtHwakgwa.getText());
		oHwewon.setCampus(this.txtCampus.getText());

		boolean i = this.cHwewonDeungrok.saveHwewon(oHwewon);

		if(i)
		{
			JOptionPane.showMessageDialog(null, "회원가입 성공");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다. 다시 시도해주세요.");
		}
		
	}
	
	  public boolean Hwewon() {     
	        return bCheck;
	    }
	
}
