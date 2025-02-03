import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class GeneratingReport extends JFrame {

	private JPanel contentPane;
	public JTextField txtUserName1;
	public JTextField txtCPNumber1;
	public JTextField txtEmailAddress1;

	public GeneratingReport() {
		setResizable(false);
		setTitle("Report Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(80, 160, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONAL INFORMATION");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(26, 79, 346, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Name:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(26, 127, 85, 39);
		contentPane.add(lblUsername);
		
		JLabel lblContactNo = new JLabel("Contact No.:");
		lblContactNo.setForeground(new Color(255, 255, 255));
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblContactNo.setBounds(484, 127, 151, 39);
		contentPane.add(lblContactNo);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setForeground(new Color(255, 255, 255));
		lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmailAddress.setBounds(484, 89, 151, 39);
		contentPane.add(lblEmailAddress);
		
		txtUserName1 = new JTextField();
		txtUserName1.setBackground(new Color(192, 192, 192));
		txtUserName1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUserName1.setBounds(100, 131, 364, 39);
		contentPane.add(txtUserName1);
		txtUserName1.setColumns(10);
		
		txtCPNumber1 = new JTextField("09");
		txtCPNumber1.setBackground(new Color(192, 192, 192));
		txtCPNumber1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String CPNumber = txtCPNumber1.getText();
				int length = CPNumber.length();
				char c = e.getKeyChar();
				
				if(e.getKeyChar()>='0'&& e.getKeyChar()<='9') {
					if(length<11) {
						txtCPNumber1.setEditable(true);
					}else {
						txtCPNumber1.setEditable(false);
					}
				}else 
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtCPNumber1.setEditable(true);
					}	
				}
			}
		});
		String Contact = txtCPNumber1.getText();
		int length = Contact.length();
		txtCPNumber1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCPNumber1.setColumns(10);
		txtCPNumber1.setBounds(645, 131, 307, 39);
		contentPane.add(txtCPNumber1);
		
		txtEmailAddress1 = new JTextField();
		txtEmailAddress1.setBackground(new Color(192, 192, 192));
		txtEmailAddress1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmailAddress1.setColumns(10);
		txtEmailAddress1.setBounds(645, 79, 307, 39);
		contentPane.add(txtEmailAddress1);
		
		JLabel lblEvents = new JLabel("EVENTS:");
		lblEvents.setForeground(new Color(255, 255, 255));
		lblEvents.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEvents.setBounds(26, 191, 151, 39);
		contentPane.add(lblEvents);
		
		JRadioButton rdbtnEventProgram = new JRadioButton("Event Program");
		rdbtnEventProgram.setBackground(new Color(192, 192, 192));
		JRadioButton rdbtnBubbleRun = new JRadioButton("Bubble Run");
		rdbtnBubbleRun.setBackground(new Color(192, 192, 192));
		JRadioButton rdbtnKessokuBandConcert = new JRadioButton("Kessoku Band Concert");
		rdbtnKessokuBandConcert.setBackground(new Color(192, 192, 192));
		JRadioButton rdbtnCosplayConvention = new JRadioButton("Cosplay Convention");
		rdbtnCosplayConvention.setBackground(new Color(192, 192, 192));
		JRadioButton rdbtnTalentShow = new JRadioButton("Talent Show");
		rdbtnTalentShow.setBackground(new Color(192, 192, 192));
		
		rdbtnEventProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEventProgram.isSelected()) {
					rdbtnBubbleRun.setSelected(false);
					rdbtnKessokuBandConcert.setSelected(false);
					rdbtnCosplayConvention.setSelected(false);
					rdbtnTalentShow.setSelected(false);
				}
			}
		});
		rdbtnEventProgram.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnEventProgram.setBounds(26, 237, 169, 33);
		contentPane.add(rdbtnEventProgram);
		
		rdbtnBubbleRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBubbleRun.isSelected()){
					rdbtnKessokuBandConcert.setSelected(false);
					rdbtnCosplayConvention.setSelected(false);
					rdbtnTalentShow.setSelected(false);
					rdbtnEventProgram.setSelected(false);
				}
			}
		});
		rdbtnBubbleRun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnBubbleRun.setBounds(26, 283, 169, 33);
		contentPane.add(rdbtnBubbleRun);
		
		rdbtnKessokuBandConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnKessokuBandConcert.isSelected()) {
					rdbtnCosplayConvention.setSelected(false);
					rdbtnTalentShow.setSelected(false);
					rdbtnEventProgram.setSelected(false);
					rdbtnBubbleRun.setSelected(false);
				}
			}
		});
		rdbtnKessokuBandConcert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnKessokuBandConcert.setBounds(26, 331, 254, 33);
		contentPane.add(rdbtnKessokuBandConcert);
		
		rdbtnCosplayConvention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCosplayConvention.isSelected()) {
					rdbtnTalentShow.setSelected(false);
					rdbtnEventProgram.setSelected(false);
					rdbtnBubbleRun.setSelected(false);
					rdbtnKessokuBandConcert.setSelected(false);
				}
			}
		});
		rdbtnCosplayConvention.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnCosplayConvention.setBounds(26, 378, 254, 33);
		contentPane.add(rdbtnCosplayConvention);

		rdbtnTalentShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTalentShow.isSelected()) {
					rdbtnEventProgram.setSelected(false);
					rdbtnBubbleRun.setSelected(false);
					rdbtnKessokuBandConcert.setSelected(false);
					rdbtnCosplayConvention.setSelected(false);
				}
			}
		});
		rdbtnTalentShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnTalentShow.setBounds(26, 427, 254, 33);
		contentPane.add(rdbtnTalentShow);
		
		JCheckBox chckbxJune = new JCheckBox("June 8/2023");
		chckbxJune.setBackground(new Color(192, 192, 192));
		JCheckBox chckbxAugust = new JCheckBox("August 10/2023");
		chckbxAugust.setBackground(new Color(192, 192, 192));
		JCheckBox chckbxOctober = new JCheckBox("October  27/2023");
		chckbxOctober.setBackground(new Color(192, 192, 192));
		JCheckBox chckbxMay = new JCheckBox("May  30/2023");
		chckbxMay.setBackground(new Color(192, 192, 192));
		JCheckBox chckbxNovember = new JCheckBox("November 15/2023");
		chckbxNovember.setBackground(new Color(192, 192, 192));
		
		chckbxJune.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxJune.isSelected()) {
					chckbxAugust.setSelected(false);
					chckbxOctober.setSelected(false);
					chckbxMay.setSelected(false);
					chckbxNovember.setSelected(false);
				}
			}
		});
		chckbxJune.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxJune.setBounds(302, 237, 169, 33);
		contentPane.add(chckbxJune);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(302, 191, 151, 39);
		contentPane.add(lblDate);
		
		chckbxAugust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAugust.isSelected()) {
					chckbxOctober.setSelected(false);
					chckbxMay.setSelected(false);
					chckbxNovember.setSelected(false);
					chckbxJune.setSelected(false);
				}
			}
		});
		chckbxAugust.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxAugust.setBounds(302, 283, 169, 33);
		contentPane.add(chckbxAugust);
		
		chckbxOctober.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxOctober.isSelected()) {
					chckbxMay.setSelected(false);
					chckbxNovember.setSelected(false);
					chckbxJune.setSelected(false);
					chckbxAugust.setSelected(false);
				}
			}
		});
		chckbxOctober.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxOctober.setBounds(302, 331, 181, 33);
		contentPane.add(chckbxOctober);
		
		chckbxMay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxMay.isSelected()) {
					chckbxNovember.setSelected(false);
					chckbxJune.setSelected(false);
					chckbxAugust.setSelected(false);
					chckbxOctober.setSelected(false);
				}
			}
		});
		chckbxMay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxMay.setBounds(302, 378, 186, 33);
		contentPane.add(chckbxMay);
		
		chckbxNovember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNovember.isSelected()) {
					chckbxJune.setSelected(false);
					chckbxAugust.setSelected(false);
					chckbxOctober.setSelected(false);
					chckbxMay.setSelected(false);
				}
			}
		});
		chckbxNovember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxNovember.setBounds(302, 427, 208, 33);
		contentPane.add(chckbxNovember);
		
		TextArea textReportSummary = new TextArea();
		textReportSummary.setEditable(false);
		textReportSummary.setBackground(new Color(128, 128, 128));
		textReportSummary.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		textReportSummary.setBounds(558, 237, 394, 292);
		contentPane.add(textReportSummary);
		
		Button buttonGenerateReport = new Button("GENERATE REPORT");
		buttonGenerateReport.setForeground(new Color(0, 128, 0));
		buttonGenerateReport.setBackground(new Color(192, 192, 192));
		buttonGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	

				String venue1= "Unversity of Cabuyao - Katapatan Laguna",venue2= "CABS - Katapatan, Cabuyao, Laguna" , venue3= "Philippine Arena - Santa Maria, Bulacan",venue4= "Ayala Malls Circuit - Makati, Manila", venue5="SM Mall of Asia Arena - Pasay, Manila", venue = " ";
				String event1= "Event Program", event2 = "Bubble Run", event3 = "KessokuBandConcert", event4 = "CosplayConvention", event5= "TalentShow", event = " ";
				int price1 = 8000, price2 = 9000, price3 = 10000, price4 = 12500, price5 = 11800, price = 0;
				
	
				if (rdbtnEventProgram.isSelected()) {
				    price = price1;
				    venue = venue1;    
				    event = event1;
				} else if (rdbtnBubbleRun.isSelected()) {
				    price = price2;
				    venue = venue2;
				    event = event2;
				} else if (rdbtnKessokuBandConcert.isSelected()) {
				    price = price3;
				    venue = venue3;
				    event = event3;
				} else if (rdbtnCosplayConvention.isSelected()) {
				    price = price4;
				    venue = venue4;
				    event = event4;
				} else if (rdbtnTalentShow.isSelected()) {
				    price = price5;
				    venue = venue5;
				    event = event5;
				}

				textReportSummary.setText("Email :\t" + txtEmailAddress1.getText()+ "\n" +
				                          "Name :\t" + txtUserName1.getText() + "\n" +
				                          "Contact :\t" + txtCPNumber1.getText()  + "\n" +
				                          "\nEvent Program :\t" + event + "\n" + 
				                          "\nLocation :\t" + venue + "\n" +
				                          "\nTotal Price :\t" + price);
				txtUserName1.setText("");
				txtCPNumber1.setText("");
				txtEmailAddress1.setText("");
			}
		});
		buttonGenerateReport.setFont(new Font("Dialog", Font.BOLD, 18));
		buttonGenerateReport.setBounds(164, 474, 208, 55);
		contentPane.add(buttonGenerateReport);
		
		
		
		JLabel lblReportSummary = new JLabel("REPORT SUMMARY");
		lblReportSummary.setForeground(new Color(255, 255, 255));
		lblReportSummary.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReportSummary.setBounds(632, 191, 254, 39);
		contentPane.add(lblReportSummary);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHome.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHome.setBackground(SystemColor.controlShadow);
		btnHome.setBounds(38, 10, 65, 63);
		contentPane.add(btnHome);
		
		JLabel lblBackground7 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/F.jpg"));
		lblBackground7.setIcon(icon);
		lblBackground7.setBounds(0, 0, 1010, 539);
		contentPane.add(lblBackground7);
		
		setLocationRelativeTo(null);
	}
}
