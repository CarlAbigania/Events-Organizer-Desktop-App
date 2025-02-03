import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class AccManagement extends JFrame {

	public JPanel contentPane;
	public JTextField txtUserName;
	public JTextField txtCPNumber;
	public JTextField txtEmailAddress;
	public JTextField txtPassword;
	private JLabel lblAccNumber;
	public JComboBox<Object> cboCivilStatus;
	public JComboBox<Object> cboGender;
	public JComboBox<Object> cboNationality;
	public JTable tblStoredData;
	private JLabel lblDataRecord;
	private JButton btnNew,btnUpdate,btnDelete,btnSave,btnCancel;
	private String[] columns = {"UserName","Name","Nationality","Gender","CPNumber","EmailAddress","CivilStatus","Acc.Number"};
	public static DefaultTableModel modelStoredData = new DefaultTableModel();
	private int Accnumber = 1;
	private boolean isNew = false, isUpdate = false, isDelete = false;
	private JLabel lblBackground3;

	public AccManagement() {
		setTitle("Account Managment");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(80, 160, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContentManager = new JLabel("Account Manager");
		lblContentManager.setBackground(new Color(255, 255, 255));
		lblContentManager.setForeground(new Color(255, 255, 255));
		lblContentManager.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 40));
		lblContentManager.setBounds(133, 22, 490, 63);
		contentPane.add(lblContentManager);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved data will be GONE!", "Do you want to leave?", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					
					Home home = new Home();
					home.setVisible(true);
					dispose();
				}
			}
		});
		
		JLabel lblPersonalInformation = new JLabel("PERSONAL INFORMATION");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(Color.WHITE);
		lblPersonalInformation.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblPersonalInformation.setBounds(241, 95, 611, 63);
		contentPane.add(lblPersonalInformation);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHome.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHome.setBackground(UIManager.getColor("Button.shadow"));
		btnHome.setBounds(38, 24, 65, 63);
		contentPane.add(btnHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 313, 832, 191);
		contentPane.add(scrollPane);
		
		modelStoredData.setColumnIdentifiers(columns);
		tblStoredData = new JTable(modelStoredData){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tblStoredData.setEnabled(false);
		tblStoredData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblStoredData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isUpdate == true || isDelete == true) {
					int selectedRow = tblStoredData.getSelectedRow();
					txtUserName.setText(modelStoredData.getValueAt(selectedRow, 0).toString());
					txtPassword.setText(modelStoredData.getValueAt(selectedRow, 1).toString());
					cboNationality.setSelectedItem(modelStoredData.getValueAt(selectedRow, 2).toString());
					cboGender.setSelectedItem(modelStoredData.getValueAt(selectedRow, 3).toString());
					txtCPNumber.setText(modelStoredData.getValueAt(selectedRow, 4).toString());
					txtEmailAddress.setText(modelStoredData.getValueAt(selectedRow, 5).toString());
					cboCivilStatus.setSelectedItem(modelStoredData.getValueAt(selectedRow, 6).toString());
					lblAccNumber.setText(modelStoredData.getValueAt(selectedRow, 7).toString());
				}
			}
		});
		modelStoredData.setColumnIdentifiers(columns);
		scrollPane.setViewportView(tblStoredData);
		tblStoredData.getTableHeader().setReorderingAllowed(false);
		
		lblDataRecord = new JLabel("Records : 0");
		lblDataRecord.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataRecord.setBounds(827, 514, 107, 13);
		contentPane.add(lblDataRecord);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newRow();
			}
		});
		btnNew.setBounds(18, 311, 85, 21);
		contentPane.add(btnNew);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateRow();
				
			}
		});
		btnUpdate.setBounds(18, 342, 85, 21);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnDelete.setBounds(18, 373, 85, 21);
		contentPane.add(btnDelete);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveRow();
			}
		});
		btnSave.setBounds(18, 404, 85, 21);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		btnCancel.setBounds(18, 435, 85, 21);
		contentPane.add(btnCancel);
		tblStoredData.setEnabled(false);
		
		txtUserName = new JTextField();
		txtUserName.setEnabled(false);
		txtUserName.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtUserName.setColumns(10);
		txtUserName.setBounds(187, 185, 188, 19);
		contentPane.add(txtUserName);
		
		txtPassword = new JTextField();
		txtPassword.setEnabled(false);
		txtPassword.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(187, 209, 188, 19);
		contentPane.add(txtPassword);
		
		cboNationality = new JComboBox();
		cboNationality.setEnabled(false);
		cboNationality.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboNationality.setBounds(187, 234, 188, 21);
		cboNationality.addItem("Filipino");
		contentPane.add(cboNationality);
		
		cboGender = new JComboBox();
		cboGender.setEnabled(false);
		cboGender.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboGender.setBounds(187, 262, 188, 21);
		cboGender.addItem("Male");
		cboGender.addItem("Female");
		contentPane.add(cboGender);
		
		txtCPNumber = new JTextField();
		txtCPNumber.setEnabled(false);
		txtCPNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String CPNumber = txtCPNumber.getText();
				int length = CPNumber.length();
				char c = e.getKeyChar();
				
				if(e.getKeyChar()>='0'&& e.getKeyChar()<='9') {
					if(length<11) {
						txtCPNumber.setEditable(true);
					}else {
						txtCPNumber.setEditable(false);
					}
				}else 
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtCPNumber.setEditable(true);
					}else {
						txtCPNumber.setEditable(false);
					}	
				}
			}
		});
		txtCPNumber.setText("09");
		txtCPNumber.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtCPNumber.setColumns(10);
		txtCPNumber.setBounds(668, 185, 188, 19);
		contentPane.add(txtCPNumber);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setEnabled(false);
		txtEmailAddress.setFont(new Font("Dubai", Font.PLAIN, 14));
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(668, 209, 188, 19);
		contentPane.add(txtEmailAddress);
		
		cboCivilStatus = new JComboBox();
		cboCivilStatus.setEnabled(false);
		cboCivilStatus.setFont(new Font("Dubai", Font.PLAIN, 14));
		cboCivilStatus.setBounds(668, 234, 188, 21);
		cboCivilStatus.addItem("Single");
		cboCivilStatus.addItem("Married");
		cboCivilStatus.addItem("In a Relationship");
		contentPane.add(cboCivilStatus);
		
		JLabel lblNewLabel1 = new JLabel("ACC. NUMBER");
		lblNewLabel1.setForeground(Color.WHITE);
		lblNewLabel1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel1.setBounds(468, 266, 155, 13);
		contentPane.add(lblNewLabel1);
		
		lblAccNumber = new JLabel("");
		lblAccNumber.setForeground(Color.WHITE);
		lblAccNumber.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblAccNumber.setBounds(668, 266, 155, 13);
		contentPane.add(lblAccNumber);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(38, 185, 155, 13);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("PASSWORD :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel.setBounds(38, 209, 155, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNationality = new JLabel("NATIONALITY :");
		lblNationality.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNationality.setForeground(new Color(255, 255, 255));
		lblNationality.setBounds(38, 234, 155, 13);
		contentPane.add(lblNationality);
		
		JLabel lblGender = new JLabel("GENDER :");
		lblGender.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setBounds(38, 262, 155, 13);
		contentPane.add(lblGender);
		
		JLabel lblContactNumber = new JLabel("CONTACT NUMBER |PH:");
		lblContactNumber.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblContactNumber.setForeground(new Color(255, 255, 255));
		lblContactNumber.setBounds(468, 187, 167, 13);
		contentPane.add(lblContactNumber);
		
		JLabel lblEmailAddress = new JLabel("EMAIL ADDRESS :");
		lblEmailAddress.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblEmailAddress.setForeground(new Color(255, 255, 255));
		lblEmailAddress.setBounds(468, 209, 155, 13);
		contentPane.add(lblEmailAddress);
		
		JLabel lblCivilStatus = new JLabel("CIVIL STATUS :");
		lblCivilStatus.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblCivilStatus.setForeground(new Color(255, 255, 255));
		lblCivilStatus.setBounds(468, 234, 155, 13);
		contentPane.add(lblCivilStatus);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(126, 87, 832, 79);
		contentPane.add(lblNewLabel_1);
		
		lblBackground3 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/D.jpg"));
		lblBackground3.setIcon(icon);
		lblBackground3.setBounds(0, 0, 1010, 539);
		contentPane.add(lblBackground3);
		
		setLocationRelativeTo(null);
	}
	
	public void newRow() {
		isNew = true;
		lblAccNumber.setText(String.valueOf(Accnumber));
		txtUserName.setEnabled(true);
		txtPassword.setEnabled(true);
		cboNationality.setEnabled(true);
		cboGender.setEnabled(true);
		txtCPNumber.setEnabled(true);
		txtEmailAddress.setEnabled(true);
		cboCivilStatus.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}
	
	public void updateRow() {
		if(modelStoredData.getRowCount() > 0) {
			isUpdate = true;
			tblStoredData.setEnabled(true);
			txtUserName.setEnabled(true);
			txtPassword.setEnabled(true);
			cboNationality.setEnabled(true);
			cboGender.setEnabled(true);
			txtCPNumber.setEnabled(true);
			txtEmailAddress.setEnabled(true);
			cboCivilStatus.setEnabled(true);
			txtUserName.setText(modelStoredData.getValueAt(0, 0).toString());
			txtPassword.setText(modelStoredData.getValueAt(0, 1).toString());
			cboNationality.setSelectedItem(modelStoredData.getValueAt(0, 2).toString());
			cboGender.setSelectedItem(modelStoredData.getValueAt(0, 3).toString());
			txtCPNumber.setText(modelStoredData.getValueAt(0, 4).toString());
			txtEmailAddress.setText(modelStoredData.getValueAt(0, 5).toString());
			cboCivilStatus.setSelectedItem(modelStoredData.getValueAt(0, 6).toString());
			lblAccNumber.setText(modelStoredData.getValueAt(0, 7).toString());
			tblStoredData.getSelectionModel().addSelectionInterval(0, 0);
			btnNew.setEnabled(false);
			btnDelete.setEnabled(false);
		}else {
			JOptionPane.showMessageDialog(contentPane, "The update operation cannot be completed. There is no existing record!");
		}
	}
	
	public void deleteRow() {
		if(modelStoredData.getRowCount()>0) {
			isDelete = true;
			tblStoredData.setEnabled(true);
			txtUserName.setEnabled(false);
			txtPassword.setEnabled(false);
			cboNationality.setEnabled(false);
			cboGender.setEnabled(false);
			txtCPNumber.setEnabled(false);
			txtEmailAddress.setEnabled(false);
			cboCivilStatus.setEnabled(false);
			txtUserName.setText(modelStoredData.getValueAt(0, 0).toString());
			txtPassword.setText(modelStoredData.getValueAt(0, 1).toString());
			cboNationality.setSelectedItem(modelStoredData.getValueAt(0, 2).toString());
			cboGender.setSelectedItem(modelStoredData.getValueAt(0, 3).toString());
			txtCPNumber.setText(modelStoredData.getValueAt(0, 4).toString());
			txtEmailAddress.setText(modelStoredData.getValueAt(0, 5).toString());
			cboCivilStatus.setSelectedItem(modelStoredData.getValueAt(0, 6).toString());
			lblAccNumber.setText(modelStoredData.getValueAt(0, 7).toString());
			tblStoredData.getSelectionModel().addSelectionInterval(0, 0);
			btnNew.setEnabled(false);
			btnUpdate.setEnabled(false);
		}else {
			JOptionPane.showMessageDialog(contentPane, "It is not possible to erase. there are no existing rows!");
		}
	}
	
	void saveRow(){
		lblDataRecord.setText("RECORDS : " + modelStoredData.getRowCount());
		if(isNew) {
			
			String USERNAME = txtUserName.getText();
			String PASSWORD = txtPassword.getText();
			String CPNUMBER = txtCPNumber.getText();
			String EMAILADDRESS = txtEmailAddress.getText();
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
				Object[] rowData = new Object[8];
				rowData[0] = txtUserName.getText();
				rowData[1] = txtPassword.getText();
				rowData[2] = cboNationality.getSelectedItem();
				rowData[3] = cboGender.getSelectedItem();
				rowData[4] = txtCPNumber.getText();
				rowData[5] = txtEmailAddress.getText();
				rowData[6] = cboCivilStatus.getSelectedItem();
				rowData[7] = lblAccNumber.getText();
				modelStoredData.addRow(rowData);
				Accnumber++;
				lblDataRecord.setText("RECORDS : " + modelStoredData.getRowCount());
				clearControls();
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				JOptionPane.showMessageDialog(contentPane, "New row Saved!");
				txtUserName.setEnabled(false);
				txtPassword.setEnabled(false);
				cboNationality.setEnabled(false);
				cboGender.setEnabled(false);
				txtCPNumber.setEnabled(false);
				txtEmailAddress.setEnabled(false);
				cboCivilStatus.setEnabled(false);
			}
		}
		if(isUpdate) {
			int selectedRow = tblStoredData.getSelectedRow();
			modelStoredData.setValueAt(txtUserName.getText(), selectedRow, 0);
			modelStoredData.setValueAt(txtPassword.getText(), selectedRow, 1);
			modelStoredData.setValueAt(cboNationality.getSelectedItem(), selectedRow, 2);
			modelStoredData.setValueAt(cboGender.getSelectedItem(), selectedRow, 3);
			modelStoredData.setValueAt(txtCPNumber.getText(), selectedRow, 4);
			modelStoredData.setValueAt(txtEmailAddress.getText(), selectedRow, 5);
			modelStoredData.setValueAt(cboCivilStatus.getSelectedItem(), selectedRow, 6);
			clearControls();
			btnNew.setEnabled(true);
			btnDelete.setEnabled(true);
			JOptionPane.showMessageDialog(contentPane, "Selected row Updated!");
		}if(isDelete) {
			int result = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to remove the selected row?");
			txtUserName.setEnabled(false);
			txtPassword.setEnabled(false);
			cboNationality.setEnabled(false);
			cboGender.setEnabled(false);
			txtCPNumber.setEnabled(false);
			txtEmailAddress.setEnabled(false);
			cboCivilStatus.setEnabled(false);
			if(result==JOptionPane.YES_OPTION) {
				modelStoredData.removeRow(tblStoredData.getSelectedRow());
				lblDataRecord.setText("RECORDS : " + modelStoredData.getRowCount());
				clearControls();
				btnNew.setEnabled(true);
				btnUpdate.setEnabled(true);
				JOptionPane.showMessageDialog(contentPane, "Account deleted");
			}
		}
	}
	
	public void clearControls() {
		isNew = false;
		isUpdate = false;
		isDelete = false;
		txtUserName.setText("");
		txtPassword.setText("");
		cboNationality.setSelectedItem("");
		cboGender.setSelectedItem("");
		txtCPNumber.setText("");
		txtEmailAddress.setText("");
		cboCivilStatus.setSelectedItem("");
		lblAccNumber.setText("");
		tblStoredData.clearSelection();
		tblStoredData.setEnabled(false);
	}
}