import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	public static JProgressBar progressBar;

	public SplashScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loading...");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(322, 501, 149, 21);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(128, 128, 128));
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		progressBar.setBounds(86, 543, 620, 21);
		contentPane.add(progressBar);
		
		JLabel lblImage = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/Loading.gif"));
		lblImage.setIcon(icon);
		lblImage.setBounds(0, 0, 800, 600);
		contentPane.add(lblImage);
		
		setLocationRelativeTo(null);
	}
}
