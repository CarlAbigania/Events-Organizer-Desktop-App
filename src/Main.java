import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;
	private static JLabel lblUser;
	private static JLabel lblPassword;
	private static JTextField txtUserName;
	private static JPasswordField passwordPass;
	private static JPasswordField Password;
	private static JButton btnEnter;
	public String b;
	public String c;
	public boolean isHave = false;
	
	JComboBox comboBox;
	JTextArea txtrOutput;
	JLabel lblListofEvents;
	JButton btnReserveButton;
	public static void main(String[] args) {
		SplashScreen splashScreen = new SplashScreen();
		splashScreen.setVisible(true);
		
		int counter = 0;
		try {
			while(counter <= 100){
				splashScreen.progressBar.setValue(counter);
				Thread.sleep(70);
				
				if(counter == 100) {
					splashScreen.dispose();
							EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main frame = new Main();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				}
				counter++;
			}
		} catch (InterruptedException e) {		
				e.printStackTrace();
		}
	}
	
	public Main() {
		setTitle("Greetings fellow human!");
		setResizable(false);
 		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUser = new JLabel("Username:");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(10, 50, 110, 40);
		contentPane.add(lblUser);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(10, 101, 110, 40);
		contentPane.add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		txtUserName.setBounds(170, 50, 310, 40);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		Password.setEchoChar('*');
		Password.setBounds(170, 100, 240, 40);
		contentPane.add(Password);
		
		JToggleButton btnShow = new JToggleButton("SHOW");
		Password.setEchoChar('*');
		btnShow.setFocusable(false);
		btnShow.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnShow.isSelected()) {
					Password.setEchoChar((char) (0));
					btnShow.setText("HIDE");
				} else {
					Password.setEchoChar('*');
					Password.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
					btnShow.setText("SHOW");
				}
			}
		});
		btnShow.setBounds(413, 103, 65, 34);
		contentPane.add(btnShow);
		
		btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home reservationSystem = new Home();
				AccManagement accManager = new AccManagement();
				String user = txtUserName.getText();
				String pass = Password.getText();
				if(e.getSource() == btnEnter) {
					if(isHave) {
						for(int i = 0;i < accManager.modelStoredData.getRowCount();i++){
							b = (String) accManager.modelStoredData.getValueAt(i,0);
							c = (String) accManager.modelStoredData.getValueAt(i,1); 
							if(user.equals(b) && pass.equals(c)) {
								JOptionPane.showMessageDialog(null, "LOG IN SUCCESSFUL!");
								reservationSystem.setVisible(true);
								dispose();
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Create ACC");
					}
				}
			}
		});
		
		btnEnter.setBackground(new Color(127, 255, 212));
		btnEnter.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnEnter.setBounds(170, 166, 310, 40);
		contentPane.add(btnEnter);
		
		JButton btnCreateAcc = new JButton("Don't have Acc.?, Create One!");
		btnCreateAcc.setBackground(new Color(192, 192, 192));
		btnCreateAcc.setForeground(new Color(0, 128, 0));
		btnCreateAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register CreateAcc = new Register();
				CreateAcc.show();
				dispose();
			}
		});
		btnCreateAcc.setBounds(159, 265, 232, 27);
		contentPane.add(btnCreateAcc);
		
		JLabel lblBackground1 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/C.jpg"));
		lblBackground1.setIcon(icon);
		lblBackground1.setBounds(0, 0, 539, 333);
		contentPane.add(lblBackground1);
		
		setLocationRelativeTo(null);
	}
}