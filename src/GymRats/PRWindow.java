package GymRats;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PRWindow {

	JFrame frame;
	private JTable table;
	static User user;

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
	 */
	public PRWindow(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 473, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPR = new JLabel("Here are your current PR's:");
		lblPR.setBounds(128, 40, 176, 42);
		frame.getContentPane().add(lblPR);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "Exercise", "PR" }));
		table.setBounds(55, 95, 357, 255);
		frame.getContentPane().add(table);

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
	}
}
