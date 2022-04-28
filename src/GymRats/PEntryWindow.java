package GymRats;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PEntryWindow {

	//JFrame frame;
	private JTextField weightTF;
	private JTextField chestTF;
	private JTextField bicepTF;
	private JTextField hipsTF;
	private JTextField waistTF;
	private JTextField thighTF;
	//static User user;

	JFrame frame;
	static User user = null;
	private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
	private static String dbUsername = "root"; // replace with your username (most likely "root")
	private static String dbPassword = "pranav123"; // replace with your password
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PEntryWindow window = new PEntryWindow(user);
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
	public PEntryWindow(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(171, 63, 56, 16);
		frame.getContentPane().add(lblWeight);

		JLabel lblChest = new JLabel("Chest");
		lblChest.setBounds(171, 92, 56, 16);
		frame.getContentPane().add(lblChest);

		JLabel lblBicep = new JLabel("Bicep");
		lblBicep.setBounds(171, 121, 56, 16);
		frame.getContentPane().add(lblBicep);

		JLabel lblHip = new JLabel("Hips");
		lblHip.setBounds(171, 150, 56, 16);
		frame.getContentPane().add(lblHip);

		JLabel lblWaist = new JLabel("Waist");
		lblWaist.setBounds(171, 179, 56, 16);
		frame.getContentPane().add(lblWaist);

		JLabel lblThigh = new JLabel("Thigh");
		lblThigh.setBounds(171, 208, 56, 16);
		frame.getContentPane().add(lblThigh);

		weightTF = new JTextField();
		weightTF.setBounds(252, 60, 116, 22);
		frame.getContentPane().add(weightTF);
		weightTF.setColumns(10);

		chestTF = new JTextField();
		chestTF.setColumns(10);
		chestTF.setBounds(252, 89, 116, 22);
		frame.getContentPane().add(chestTF);

		bicepTF = new JTextField();
		bicepTF.setColumns(10);
		bicepTF.setBounds(252, 118, 116, 22);
		frame.getContentPane().add(bicepTF);

		hipsTF = new JTextField();
		hipsTF.setColumns(10);
		hipsTF.setBounds(252, 147, 116, 22);
		frame.getContentPane().add(hipsTF);

		waistTF = new JTextField();
		waistTF.setColumns(10);
		waistTF.setBounds(252, 176, 116, 22);
		frame.getContentPane().add(waistTF);

		thighTF = new JTextField();
		thighTF.setColumns(10);
		thighTF.setBounds(252, 205, 116, 22);
		frame.getContentPane().add(thighTF);

		JButton btnEntry = new JButton("Add Entry");
		btnEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "New progress added");
				frame.dispose();
				ProgressMenu retMen = new ProgressMenu(user);
				retMen.frame.setVisible(true);
			}
		});
		btnEntry.setBounds(198, 256, 97, 25);
		frame.getContentPane().add(btnEntry);
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);

		JLabel lblDate = new JLabel("Add a new progress report for: " + strDate);
		lblDate.setBounds(133, 13, 278, 32);
		frame.getContentPane().add(lblDate);
		
		
		
		
		
		
		
		
		
	}
}
