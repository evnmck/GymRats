package GymRats;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controllers.UserController;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileWindow {

    private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    private static String dbUsername = "root"; // replace with your username (most likely "root")
    private static String dbPassword = "@Tuan_1010"; // replace with your password
    
	protected JFrame frame;
	private JTextField fNameF;
	private JTextField lNameF;
	private JTextField bioF;
	private JPasswordField pwF;
	private JPasswordField cpwF;
	private JButton btnSave;
	private JLabel nameLabel;
	static User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileWindow window = new ProfileWindow(user);
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
	public ProfileWindow(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		nameLabel = new JLabel("Edit profile for " + user.getFName().toUpperCase() + " " + user.getLName().toUpperCase()
				+ " (" + user.getUName() + ")");
		nameLabel.setBounds(105, 13, 264, 43);
		frame.getContentPane().add(nameLabel);

		JLabel lblFname = new JLabel("First Name");
		lblFname.setBounds(77, 69, 68, 16);
		frame.getContentPane().add(lblFname);

		JLabel lblLname = new JLabel("Last Name");
		lblLname.setBounds(77, 98, 68, 16);
		frame.getContentPane().add(lblLname);

		JLabel lblPw = new JLabel("New Password");
		lblPw.setBounds(55, 130, 90, 16);
		frame.getContentPane().add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm Password");
		lblPw2.setBounds(35, 160, 110, 16);
		frame.getContentPane().add(lblPw2);

		JLabel lblBio = new JLabel("Bio");
		lblBio.setBounds(109, 189, 36, 16);
		frame.getContentPane().add(lblBio);

		fNameF = new JTextField();
		fNameF.setBounds(169, 66, 229, 22);
		frame.getContentPane().add(fNameF);
		fNameF.setColumns(10);

		lNameF = new JTextField();
		lNameF.setColumns(10);
		lNameF.setBounds(169, 95, 229, 22);
		frame.getContentPane().add(lNameF);

		bioF = new JTextField();
		bioF.setColumns(10);
		bioF.setBounds(169, 186, 229, 80);
		frame.getContentPane().add(bioF);

		pwF = new JPasswordField();
		pwF.setBounds(169, 127, 229, 22);
		frame.getContentPane().add(pwF);

		cpwF = new JPasswordField();
		cpwF.setBounds(169, 157, 229, 22);
		frame.getContentPane().add(cpwF);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fName = fNameF.getText();
				String lName = lNameF.getText();
				String pass = pwF.getText();
				String cPass = cpwF.getText();
				String bio = bioF.getText();
				
				try {
                    UserController controller = new UserController(connectionUrl, dbUsername, dbPassword);
                    if (!pass.equals(cPass)) {
                        JOptionPane.showMessageDialog(frame, "Password does not match");
                    } else {
                        /*
                         * @TODO: ADD DB LOGIC TO MODIFY EXISTING USER HERE
                         * 
                         * Check if fName, lName, or bio needs to be modified. If any of the fields is
                         * not blank, update user in DB with new attribute. If BLANK, then don't modify
                         * 
                         * BACKEND: NEED TO HAVE SETTERS in user to MODIFY fname, lname, etc.. or delete
                         * private for each field in user to make it quicker i.e "private String fName"
                         * becomes "String fname"
                         * 
                         * and need a function to update user in DB with modified ATTRIBUTES
                         */
                        if (!fName.equals("")) {
                            controller.changeFName(user.getUId(), fName);
                        }
                        if (!lName.equals("")) {
                            controller.changeLName(user.getUId(), lName);
                        }
                        if (!pass.equals("")) {
                            controller.changePassword(user.getUId(), pass);
                        }
                        if (!bio.equals("")) {
                            controller.changeBio(user.getUId(), bio);
                        }
                        // Dispose current frame and return to Main menu
                        JOptionPane.showMessageDialog(frame, "Success. Your changes have been saved");
                        frame.dispose();
                        MainMenu retMen = new MainMenu(controller.getUser(user.getUId()));
                        retMen.frame.setVisible(true);
                    }
				
				
				}
                catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
				

			}
		});
		btnSave.setBounds(301, 279, 97, 25);
		frame.getContentPane().add(btnSave);

	}
}
