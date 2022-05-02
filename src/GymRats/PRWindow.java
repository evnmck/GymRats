package GymRats;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controllers.UserWorkoutController;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PRWindow {

	JFrame frame;
	static User user;
	private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    private static String dbUsername = "root"; // replace with your username (most likely "root")
    private static String dbPassword = "@Tuan_1010"; // replace with your password

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRWindow window = new PRWindow(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public PRWindow(User user) throws ClassNotFoundException {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 473, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPR = new JLabel("Here are your current PR's:");
		lblPR.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPR.setBounds(82, 39, 266, 53);
		frame.getContentPane().add(lblPR);

		JButton btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu men = new MainMenu(user);
				men.frame.setVisible(true);
			}
		});
		btnMenu.setBounds(183, 363, 97, 25);
		frame.getContentPane().add(btnMenu);
		
		UserWorkoutController con = new UserWorkoutController(connectionUrl, dbUsername, dbPassword);
		
		// @TODO: Add ERROR CHECKS OR SQUAT BENCH DL
		String squat = "Squat: " + con.getMax(user.getUId(), "squat");
		String bench = "Bench: " + con.getMax(user.getUId(), "bench");
		String deadlift = "Deadlift: " + con.getMax(user.getUId(), "deadlift");
		
		
		JLabel lblSquat = new JLabel(squat);
		lblSquat.setBounds(169, 105, 56, 16);
		frame.getContentPane().add(lblSquat);
		
		JLabel lblBench = new JLabel(bench);
		lblBench.setBounds(169, 141, 56, 16);
		frame.getContentPane().add(lblBench);
		
		JLabel lblDL = new JLabel(deadlift);
		lblDL.setBounds(169, 177, 56, 16);
		frame.getContentPane().add(lblDL);
	}
}
