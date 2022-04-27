package GymRats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import models.User;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecordWorkout {

	JFrame frame;
	private JTextField exNameTF;
	private JTextField weightTF;
	private JTextField setsTF;
	private JTextField repsTF;
	private JTextField startWTF;
	static User user = null;
	static String woName = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordWorkout window = new RecordWorkout(user, "");
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
	public RecordWorkout(User user, String woName) {
		this.user = user;
		this.woName = woName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel newWLabel = new JLabel("Enter exercises for: " + woName);
		newWLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		newWLabel.setBounds(33, 32, 415, 16);
		frame.getContentPane().add(newWLabel);

		JLabel exNameLabel = new JLabel("Exercise name:");
		exNameLabel.setBounds(43, 70, 105, 16);
		frame.getContentPane().add(exNameLabel);

		JLabel weightLabel = new JLabel("Weight:");
		weightLabel.setBounds(43, 98, 61, 16);
		frame.getContentPane().add(weightLabel);

		JLabel setsLabel = new JLabel("Number of sets:");
		setsLabel.setBounds(43, 126, 136, 16);
		frame.getContentPane().add(setsLabel);

		JLabel repsLabel = new JLabel("Number of reps:");
		repsLabel.setBounds(43, 159, 105, 16);
		frame.getContentPane().add(repsLabel);

		JLabel startWLabel = new JLabel("Starting weight:");
		startWLabel.setBounds(43, 198, 105, 16);
		frame.getContentPane().add(startWLabel);

		exNameTF = new JTextField();
		exNameTF.setBounds(162, 65, 130, 26);
		frame.getContentPane().add(exNameTF);
		exNameTF.setColumns(10);

		weightTF = new JTextField();
		weightTF.setBounds(162, 93, 130, 26);
		frame.getContentPane().add(weightTF);
		weightTF.setColumns(10);

		setsTF = new JTextField();
		setsTF.setBounds(162, 126, 130, 26);
		frame.getContentPane().add(setsTF);
		setsTF.setColumns(10);

		repsTF = new JTextField();
		repsTF.setBounds(162, 154, 130, 26);
		frame.getContentPane().add(repsTF);
		repsTF.setColumns(10);

		startWTF = new JTextField();
		startWTF.setBounds(162, 193, 130, 26);
		frame.getContentPane().add(startWTF);
		startWTF.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 262, 472, 207);
		frame.getContentPane().add(scrollPane);

		JButton addEntryButton = new JButton("Add Entry");
		addEntryButton.setBounds(331, 193, 117, 29);
		frame.getContentPane().add(addEntryButton);

		JButton btnEnd = new JButton("End Workout");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Good job!");
				frame.dispose();
				MainMenu main = new MainMenu(user);
				main.frame.setVisible(true);
			}
		});
		btnEnd.setBounds(220, 482, 130, 25);
		frame.getContentPane().add(btnEnd);
	}
}
