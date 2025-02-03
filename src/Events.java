import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Events extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JLabel lblListofEvents;
	public static JComboBox cboListEvents;
	JTextArea txtrOutput;
	JButton btnReserveButton;
	private JTextField textField;
	public int count;
	public JTextField txtTransactEvent;
	private JTextArea txtAVenue;
	private JTextField txtDate;
	private JTextArea txtrTranslabel;
	private JLabel lblContentManager;
	JLabel lblNotice;
	private JLabel lblListEvents;
	private JButton btnCancelEvent;
	public String[] columns = {"Events", "Date", "Venue"};;
	public DefaultTableModel modelStoredData = new DefaultTableModel();
	private JTable tblReservedEvents;
	private JScrollPane scrollPane;
	private JLabel lblBackground5;
	
	public Events() {
		setResizable(false);
		setTitle("Events Management and Reservation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(80, 160, 160));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblListofEvents = new JLabel("List of Events:");
		lblListofEvents.setBorder(null);
		lblListofEvents.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lblListofEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblListofEvents.setOpaque(true);
		lblListofEvents.setBackground(new Color(0, 0, 0));
		lblListofEvents.setForeground(new Color(255, 255, 255));
		lblListofEvents.setBounds(203, 121, 629, 34);
		contentPane.add(lblListofEvents);
		
		lblContentManager = new JLabel("Event Manager");
		lblContentManager.setForeground(new Color(0, 0, 0));
		lblContentManager.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 40));
		lblContentManager.setBounds(133, 22, 490, 63);
		contentPane.add(lblContentManager);
		
		txtrOutput = new JTextArea();
		txtrOutput.setForeground(new Color(255, 255, 255));
		txtrOutput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtrOutput.setBackground(new Color(192, 192, 192));
		txtrOutput.setEditable(false);
		txtrOutput.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrOutput.setText("\n\n\n\n\n\n\t\t\t    Please select an event.");
		txtrOutput.setBounds(133, 226, 745, 282);
		contentPane.add(txtrOutput);
		
		String [] Events = {"Concert", "Kpop", "JMusic"};
		cboListEvents = new JComboBox(Events);
		cboListEvents.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboListEvents.setModel(new DefaultComboBoxModel(new String[] {"--------", "Event Program", "Fun Bubble Run" , "Kessoku Band Concert", "Cosplay Convention", "Talent Show"}));
		cboListEvents.addActionListener(this);
		cboListEvents.setBounds(203, 155, 629, 60);
		contentPane.add(cboListEvents);
				
		btnReserveButton = new JButton("Reserve now");
		btnReserveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReserveButton.setBackground(new Color(255, 255, 255));
		btnReserveButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnReserveButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (cboListEvents.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please select an event first");
					txtTransactEvent.setText("No reserved events yet.");
					txtDate.setText("");
					txtAVenue.setText("");
					btnCancelEvent.setEnabled(true);
				}
				else {
					
				int confirm = JOptionPane.showConfirmDialog(null, "Do you want to reserve for the [" + cboListEvents.getSelectedItem() + "] event?", "Confirmation", JOptionPane.YES_NO_OPTION);
				
					if(confirm == JOptionPane.YES_OPTION) {
						
						JOptionPane.showMessageDialog(null, "You have successfully reserved an event!");
						
						if (cboListEvents.getSelectedIndex()==1) {		//Event Program
							txtTransactEvent.setText("Event Program");
							txtDate.setText("June - 8 - 2023");
							txtAVenue.setText("Unversity of Cabuyao - Katapatan Laguna");
							btnCancelEvent.setEnabled(true);
							insertTable();
						}
						if(cboListEvents.getSelectedIndex()==2) {	//Fun Bubble Run
							txtTransactEvent.setText("Bubble Run");
							txtDate.setText("August - 10 - 2023");
							txtAVenue.setText("CABS - Katapatan, Cabuyao, Laguna");
							btnCancelEvent.setEnabled(true);
							insertTable();
						}
					
						if(cboListEvents.getSelectedIndex()==3) {	//Kessoku Band Concert
							txtTransactEvent.setText("Kessoku Band Concert");
							txtDate.setText("October - 27 - 2023");
							txtAVenue.setText("Philippine Arena - Santa Maria, Bulacan");
							btnCancelEvent.setEnabled(true);
							insertTable();
						}
						 
						if(cboListEvents.getSelectedIndex()==4) {	//Cosplay Convention
							txtTransactEvent.setText("Cosplay Convention");
							txtDate.setText("May - 30 - 2023");
							txtAVenue.setText("Ayala Malls Circuit - Makati, Manila");
							btnCancelEvent.setEnabled(true);
							insertTable();
						}
						 
						if(cboListEvents.getSelectedIndex()==5) {	//Talent Show
							txtTransactEvent.setText("Talent Show");
							txtDate.setText("November - 15 - 2023");
							txtAVenue.setText("SM Mall of Asia Arena - Pasay, Manila");
							btnCancelEvent.setEnabled(true);
							insertTable();
						}
					}
				}
			}
		});
		btnReserveButton.setBounds(888, 302, 110, 78);
		contentPane.add(btnReserveButton);
		btnReserveButton.setEnabled(false);
		
		if (btnReserveButton.isEnabled()) {
			txtTransactEvent.setText("");
		}
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				Home hometab = new Home();
				hometab.show();
				dispose();
			}
		});
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnHome.setBackground(UIManager.getColor("Button.shadow"));
		btnHome.setBounds(38, 24, 65, 63);
		contentPane.add(btnHome);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setBounds(0, 98, 1008, 13);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtTransactEvent = new JTextField();
		txtTransactEvent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTransactEvent.setText("No reserved events yet.");
		txtTransactEvent.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTransactEvent.setEditable(false);
		txtTransactEvent.setBounds(273, 204, 490, 70);
		txtTransactEvent.setColumns(10);
		
		txtAVenue = new JTextArea();
		txtAVenue.setEditable(false);
		txtAVenue.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAVenue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAVenue.setText("");
		txtAVenue.setBounds(273, 406, 490, 70);
		
		txtDate = new JTextField();
		txtDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDate.setText("");
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(273, 304, 490, 70);
		//contentPane.add(txtDate);
		txtDate.setVisible(false);
		
		JToggleButton btnSwitchTabs = new JToggleButton("-->");
		btnSwitchTabs.setBackground(UIManager.getColor("Button.shadow"));
		btnSwitchTabs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSwitchTabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnSwitchTabs.isSelected()) {
					txtrTranslabel.setText("\n      Event Manager");
					lblContentManager.setText("Reserved Events");
					txtrTranslabel.setBounds(800, 7, 203, 47);
					cboListEvents.setVisible(false);
					lblListofEvents.setVisible(false);
					txtrOutput.setVisible(false);
					btnReserveButton.setVisible(false);
					
					btnSwitchTabs.setText("<--");
					lblListEvents.setVisible(true);
					lblNotice.setVisible(true);
					scrollPane.setVisible(true);
					btnCancelEvent.setVisible(true);
				}
				else {
					txtrTranslabel.setText("   View Reserved Event/\r\n       Transaction");
					lblContentManager.setText("Event Manager");
					txtrTranslabel.setBounds(800, 11, 203, 47);
					cboListEvents.setVisible(true);
					lblListofEvents.setVisible(true);
					txtrOutput.setVisible(true);
					btnReserveButton.setVisible(true);
					
					btnSwitchTabs.setText("-->");
					lblListEvents.setVisible(false);
					lblNotice.setVisible(false);
					scrollPane.setVisible(false);
					btnCancelEvent.setVisible(false);
				}
			}
		});
		btnSwitchTabs.setBounds(853, 51, 92, 34);
		contentPane.add(btnSwitchTabs);
		
		txtrTranslabel = new JTextArea();
		txtrTranslabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrTranslabel.setEditable(false);
		txtrTranslabel.setOpaque(false);
		txtrTranslabel.setText("   View Reserved Event/\r\n       Transaction");
		txtrTranslabel.setBounds(795, 11, 203, 47);
		contentPane.add(txtrTranslabel);
		
		lblListEvents = new JLabel("List of Reserved Events");
		lblListEvents.setBackground(new Color(0, 0, 0));
		lblListEvents.setOpaque(true);
		lblListEvents.setForeground(new Color(255, 255, 255));
		lblListEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblListEvents.setFont(new Font("Monospaced", Font.BOLD, 19));
		lblListEvents.setBounds(208, 122, 518, 40);
		lblListEvents.setVisible(false);
		contentPane.add(lblListEvents);
		
		btnCancelEvent = new JButton("Cancel Reservation");
		btnCancelEvent.setBackground(new Color(255, 255, 255));
		btnCancelEvent.setVisible(false);
		btnCancelEvent.setEnabled(false);
		btnCancelEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int sure =JOptionPane.showConfirmDialog(null, "Do you want to delete the reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);
			
				if(sure == JOptionPane.YES_OPTION) {
					
					DefaultTableModel tableModel = (DefaultTableModel) tblReservedEvents.getModel();
					
					if(tblReservedEvents.getSelectedRowCount()==1) { //if the user selected 1 row
						tableModel.removeRow(tblReservedEvents.getSelectedRow());
						
						JOptionPane.showMessageDialog(null, "Event successfully removed");
						tblReservedEvents.setEnabled(false);					}
					else {
						if(tblReservedEvents.getRowCount()==0) {
							JOptionPane.showMessageDialog(null, "No events to be deleted!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Select an event to delete.");
							tblReservedEvents.setEnabled(true);
						}
					}
				}
			}
		});
		btnCancelEvent.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancelEvent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelEvent.setBounds(838, 300, 135, 82);
		contentPane.add(btnCancelEvent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 173, 704, 327);
		contentPane.add(scrollPane);
		
		modelStoredData.setColumnIdentifiers(columns);
		tblReservedEvents = new JTable(modelStoredData){
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		
		scrollPane.setViewportView(tblReservedEvents);
		scrollPane.setVisible(false);
		tblReservedEvents.setEnabled(false);
		
		lblNotice = new JLabel("Please proceed to the venue to complete your transaction");
		lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotice.setForeground(Color.WHITE);
		lblNotice.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 11));
		lblNotice.setBounds(182, 497, 544, 29);
		lblNotice.setVisible(false);
		contentPane.add(lblNotice);
		
		lblBackground5 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/A.jpg"));
		lblBackground5.setIcon(icon);
		lblBackground5.setBounds(0, 0, 1010, 539);
		contentPane.add(lblBackground5);
		
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== cboListEvents) {
			
			if(cboListEvents.getSelectedIndex()==1) {		//Event Program
				txtrOutput.setText("Info about the Event :\n\nDate : June - 8 - 2023\n\nVenue : Unversity of Cabuyao, Katapatan - Cabuyao - Laguna\n\n(Lakan and Lakambini 2023) -  Pamantasan ng Cabuyao-University of Cabuyao (PnC-UC)\nestablish a nostalgic event through beauty brains on a rampage against each\ndepartment.");
				btnReserveButton.setEnabled(true);
			}
			else if(cboListEvents.getSelectedIndex()==2) {		//Fun Bubble Run
				txtrOutput.setText("Info about the Event :\n\nDate : August - 10 - 2023\n\nVenue : Cabuyao Athletes Basic School, Katapatan - Cabuyao - Laguna\n\nJoin us as at the University of Cabuyao (Pamantasan ng Cabuyao) Platinum Fun\nBubble Run on August 10, 2023, at the Cabuyao Athletes Basic School (CABS)!");
				btnReserveButton.setEnabled(true);
			}
			else if(cboListEvents.getSelectedIndex()==3) {		//Kessoku Band Concert
				txtrOutput.setText("Info about the Event :\n\nDate : October - 27 - 2023\n\nVenue : Philippine Arena,\nCiudad de Victoria, Santa Maria, Bulacan\n\nWatch, have fun, and feel the connection with the performance of Kessoku Band.\nOctober 27 2023 at the Philippine Arena, remember the date and be sure not to miss it!");
				btnReserveButton.setEnabled(true);
			}
			else if(cboListEvents.getSelectedIndex()==4) {		//Cosplay Convention
				txtrOutput.setText("Info about the Event :\n\nDate : May - 30 - 2023\n\nVenue : Activity Center - Ayala Malls Circuit, Makati - Manila\n\nWitness the best cosplay convention(Fanfes Circuit 2023) - will be returning this\nyear on May 30, 2023 at the Activity Center and beyond, Ayala Malls, Circuit\nMakati! Watch out for more details soon!");
				btnReserveButton.setEnabled(true);
			}
			else if(cboListEvents.getSelectedIndex()==5) {		//Talent Show
				txtrOutput.setText("Info about the Event :\n\nDate : November - 15 - 2023\n\nVenue : SM Mall of Asia Arena - J.W. Diokno Blvd, Pasay, Manila\n\nCheck the date on your calendar because on November 15 2023 you will be witnessing\noutstanding showcase of performances and talents at the SM Mall of Asia Arena!");
				btnReserveButton.setEnabled(true);
			}
			else {
				txtrOutput.setText("\n\n\n\n\n\n\t\t\t    Please select an event.");
			}
		}
	}
	private void insertTable() {
		
		Object[] rowData = new Object[3];
		
		rowData [0] = cboListEvents.getSelectedItem();
		rowData [1] = txtDate.getText();
		rowData [2] = txtAVenue.getText();
		
		modelStoredData.addRow(rowData);
	}
}