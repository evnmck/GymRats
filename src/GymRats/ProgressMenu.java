package GymRats;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.User;
import javax.swing.JScrollPane;

public class ProgressMenu {

	JFrame frame;
	static User user;
	static ArrayList<String[]> progresses = null;
	private JTable table;
    DefaultTableModel model;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressMenu window = new ProgressMenu(user, progresses);
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
	public ProgressMenu(User user, ArrayList<String[]> progresses) {
	    this.progresses = progresses;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnEntry = new JButton("New Entry");
		btnEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PEntryWindow entry = new PEntryWindow(user, progresses);
				entry.frame.setVisible(true);
			}
		});
		btnEntry.setBounds(195, 75, 97, 25);
		frame.getContentPane().add(btnEntry);

		JLabel pLbl = new JLabel(
				"Progress Page for " + user.getFName().toUpperCase() + " " + user.getLName().toUpperCase());
		pLbl.setBounds(118, 29, 263, 33);
		frame.getContentPane().add(pLbl);

		JButton btnMenu = new JButton("Main Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu men = new MainMenu(user);
				men.frame.setVisible(true);
			}
		});
		btnMenu.setBounds(195, 395, 97, 25);
		frame.getContentPane().add(btnMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 177, 411, 172);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
        model = new DefaultTableModel();
        Object [] column = {"Date", "Chest", "Waist", "Hips", "Bicep", "Thigh", "Weight"};
        
        for (String[] currR : progresses) {
            Object[] row = new Object[7];
            
            //Object[] row = {exName, weight, sets, reps, startW}; //change this to add exercise
            model.setColumnIdentifiers(column);
            table.setModel(model);
            row[0] = "04-28";
            row[1] = currR[0];
            row[2] = currR[1];
            row[3] = currR[2];
            row[4] =  currR[3];
            row[5] =  currR[4];
            row[6] =  currR[5];
            model.addRow(row);
        }
        
		
		
		for (String[] i : progresses) {
		    System.out.println(i[0]);
		}
	}
}
