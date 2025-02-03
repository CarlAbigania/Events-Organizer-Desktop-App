import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class Home extends JFrame {

	private JPanel contentPane;
	
	public Home() {
		setResizable(false);
		setTitle("Events Management and Reservation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(80, 160, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnEvents = new JButton("Events");
		btnEvents.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				Events event = new Events();
				event.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(75, 97, 870, 94);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("\t\t\t\t (What can we do for you?)");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(0, 117, 1008, 94);
		contentPane.add(lblNewLabel_1_1);
		
		btnEvents.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEvents.setForeground(new Color(0, 0, 0));
		btnEvents.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEvents.setBackground(UIManager.getColor("Button.shadow"));
		btnEvents.setBounds(168, 230, 226, 71);
		contentPane.add(btnEvents);
		
		JButton btnReservations = new JButton("Generating Report");
		btnReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GeneratingReport GR = new GeneratingReport();
				GR.setVisible(true);
				dispose();
			}
		});
		btnReservations.setForeground(new Color(0, 0, 0));
		btnReservations.setBackground(UIManager.getColor("Button.shadow"));
		btnReservations.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnReservations.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnReservations.setBounds(598, 230, 226, 71);
		contentPane.add(btnReservations);
		
		JButton btnAccount = new JButton("My Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccManagement AccManagementSystem = new AccManagement();
				AccManagementSystem.saveRow();
				AccManagementSystem.setVisible(true);
				dispose();
			}
		});
		btnAccount.setBackground(UIManager.getColor("Button.shadow"));
		btnAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAccount.setForeground(new Color(0, 0, 0));
		btnAccount.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAccount.setBounds(380, 380, 226, 71);
		contentPane.add(btnAccount);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHome.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHome.setBackground(UIManager.getColor("Button.shadow"));
		btnHome.setBounds(38, 24, 65, 63);
		contentPane.add(btnHome);
		
		

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(0, 0, 0));
		btnLogOut.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogOut.setBackground(UIManager.getColor("Button.shadow"));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(confirmation == JOptionPane.YES_OPTION) {
						
						JOptionPane.showMessageDialog(null, "Log out success!");
						
						Main LogInConsole = new Main();
						LogInConsole.isHave = true;
						LogInConsole.setVisible(true);
						dispose();
						
					}
				}
		});
		btnLogOut.setBounds(860, 30, 103, 49);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("\t\t    Welcome to Events Management and Reservation System \r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 73, 1008, 94);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBackground4 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/B.jpg"));
		lblBackground4.setIcon(icon);
		lblBackground4.setBounds(0, 0, 1008, 539);
		contentPane.add(lblBackground4);
		
		setLocationRelativeTo(null);
	}
}