import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtRUsername;
	private JTextField txtRPasword;
	private JTextField txtRCPNumber;
	private JTextField txtREmailAddress;

	public Register() {
		setTitle("Account Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(80, 160, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setBounds(65, 20, 490, 63);
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 108, 874, 332);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(192, 192, 192));
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Dubai", Font.BOLD, 15));
		
		txtRUsername = new JTextField();
		txtRUsername.setText("");
		txtRUsername.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtRUsername.setEditable(true);
		txtRUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Dubai", Font.BOLD, 15));
		lblPassword.setBackground(Color.WHITE);
		
		txtRPasword = new JTextField();
		txtRPasword.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtRPasword.setColumns(10);
		
		JLabel lblNationality = new JLabel("NATIONALITY :");
		lblNationality.setForeground(new Color(0, 0, 0));
		lblNationality.setFont(new Font("Dubai", Font.BOLD, 15));
		
		JComboBox cboRNationality = new JComboBox();
		cboRNationality.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboRNationality.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboRNationality.addItem("Filipino");
		
		JLabel lblGender = new JLabel("GENDER :");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setFont(new Font("Dubai", Font.BOLD, 15));
		
		JComboBox cboRGender = new JComboBox();
		cboRGender.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboRGender.addItem("Male");
		cboRGender.addItem("Female");
		
		JLabel lblContactNumber = new JLabel("CONTACT NUMBER |PH:");
		lblContactNumber.setForeground(new Color(0, 0, 0));
		lblContactNumber.setFont(new Font("Dubai", Font.BOLD, 15));
		
		txtRCPNumber = new JTextField();
		txtRCPNumber.setText("09");
		txtRCPNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String CPNumber = txtRCPNumber.getText();
				int length = CPNumber.length();
				char c = e.getKeyChar();
				
				if(e.getKeyChar()>='0'&& e.getKeyChar()<='9') {
					if(length<11) {
						txtRCPNumber.setEditable(true);
					}else {
						txtRCPNumber.setEditable(false);
					}
				}else 
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtRCPNumber.setEditable(true);
					}else {
						txtRCPNumber.setEditable(false);
					}	
				}
			}
		});
		txtRCPNumber.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtRCPNumber.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("EMAIL ADDRESS :");
		lblEmailAddress.setForeground(new Color(0, 0, 0));
		lblEmailAddress.setFont(new Font("Dubai", Font.BOLD, 15));
		
		txtREmailAddress = new JTextField();
		txtREmailAddress.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtREmailAddress.setColumns(10);
		
		JLabel lblCivilStatus = new JLabel("CIVIL STATUS :");
		lblCivilStatus.setForeground(new Color(0, 0, 0));
		lblCivilStatus.setFont(new Font("Dubai", Font.BOLD, 15));
		
		JComboBox cboRCivilStatus = new JComboBox();
		cboRCivilStatus.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboRCivilStatus.addItem("Single");
		cboRCivilStatus.addItem("Married");
		cboRCivilStatus.addItem("In a Relationship");
		cboRCivilStatus.getSelectedItem();
		
		JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccManagement Pass = new AccManagement();
				
				Pass.txtUserName.setText(txtRUsername.getText());
				Pass.txtPassword.setText(txtRPasword.getText());
				Pass.txtCPNumber.setText(txtRCPNumber.getText());
				Pass.txtEmailAddress.setText(txtREmailAddress.getText());
				Pass.cboNationality.setSelectedItem(cboRNationality.getSelectedItem());
				Pass.cboCivilStatus.setSelectedItem(cboRCivilStatus.getSelectedItem());
				Pass.cboGender.setSelectedItem(cboRGender.getSelectedItem());
				
				String USERNAME = txtRUsername.getText();
				String PASSWORD = txtRPasword.getText();
				String CPNUMBER = txtRCPNumber.getText();
				String EMAILADDRESS = txtREmailAddress.getText();
				if(USERNAME.equals("")) {
					JOptionPane.showMessageDialog(null, "Username is Required");
				}
				if(PASSWORD.equals("")) {
					JOptionPane.showMessageDialog(null, "Password is Required");
				}
				if(CPNUMBER.equals("")) {
					JOptionPane.showMessageDialog(null, "CPNumber is Required");
				}
				if(EMAILADDRESS.equals("")) {
					JOptionPane.showMessageDialog(null, "EmailAddress is Required");
				}
				else {
					Pass.setVisible(true);
					JOptionPane.showMessageDialog(null, "Click the NEW button then SAVE");
					dispose();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(txtRUsername, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(lblEmailAddress, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtREmailAddress, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(txtRPasword, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(lblCivilStatus, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(cboRCivilStatus, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNationality, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(cboRNationality, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(213)
							.addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(cboRGender, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblContactNumber, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtRCPNumber, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblUsername))
						.addComponent(txtRUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblEmailAddress))
						.addComponent(txtREmailAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPassword))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(txtRPasword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCivilStatus))
						.addComponent(cboRCivilStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNationality))
						.addComponent(cboRNationality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblGender))
						.addComponent(cboRGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblContactNumber))
						.addComponent(txtRCPNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(lblCreateAccount);
		contentPane.add(scrollPane);
		
		JButton btnHaveAccount = new JButton("Have an Account?");
		btnHaveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main LogInConsole = new Main();
				LogInConsole.show();
				dispose();
			}
		});
		btnHaveAccount.setForeground(new Color(128, 0, 0));
		btnHaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHaveAccount.setBackground(new Color(192, 192, 192));
		btnHaveAccount.setBounds(416, 476, 151, 27);
		contentPane.add(btnHaveAccount);
		
		JLabel lblBackground2 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/E.jpg"));
		lblBackground2.setIcon(icon);
		lblBackground2.setBounds(0, 0, 1010, 539);
		contentPane.add(lblBackground2);
		
		setLocationRelativeTo(null);
	}
}
