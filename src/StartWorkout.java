import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.User;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StartWorkout {

    static User user = null;
	JFrame frame;
	private JTextField nameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWorkout window = new StartWorkout(user);
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
	public StartWorkout(User user) {
	    this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("Enter workout name:");
		nameLabel.setBounds(45, 54, 147, 16);
		frame.getContentPane().add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(221, 49, 130, 26);
		frame.getContentPane().add(nameTF);
		nameTF.setColumns(10);
		
		JLabel exLabel = new JLabel("ex: \"legs\", \"upper\", \"push\", etc. ");
		exLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		exLabel.setBounds(203, 87, 163, 16);
		frame.getContentPane().add(exLabel);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String wName = nameTF.getText();
                if (wName.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Invalid Workout Name");
                }
                else {
                    RecordWorkout rWO = new RecordWorkout(user, wName);
                    rWO.frame.setVisible(true);
                    frame.dispose();
                }
            }
        });
		
		continueButton.setBounds(277, 205, 117, 29);
		frame.getContentPane().add(continueButton);
	}
}
