


import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import GymRats.Login;
import controllers.*;
import models.*;


//import controller.DatabaseHandler;
//import model.User;

public class Login {
	private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
	private static String dbUsername = "root"; // replace with your username (most likely "root")
	private static String dbPassword = "382682498Mck!"; // replace with your password

	JFrame frame;
	private JTextField email;
	private JPasswordField password;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) throws ClassNotFoundException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login(connectionUrl, dbUsername, dbPassword);
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
	public Login(String url, String name, String pword) {
		this.connectionUrl = url;
		this.dbUsername = name;
		this.dbPassword = pword;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		UserController userManager = new UserController(connectionUrl, dbUsername, dbPassword);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(34, 87, 171, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(34, 119, 77, 16);
		frame.getContentPane().add(lblPassword);

		email = new JTextField();
		email.setBounds(174, 84, 171, 22);
		frame.getContentPane().add(email);
		email.setColumns(10);

		password = new JPasswordField();
		password.setBounds(174, 116, 171, 22);
		frame.getContentPane().add(password);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String em = email.getText();
				String pw = password.getText();

				try {
				    // TEST LINKING PAGES TOGETHER
                    // DELETE WHEN ACTUAL DB IS LINKED
//				    boolean testing = true; // TESTING PURPOSES
				    
					User user = userManager.getUserByUsername(em);
//					if (testing) {
//                       JOptionPane.showMessageDialog(frame, "Logging in...");
//                       MainMenu men = new MainMenu();
//                       frame.setVisible(false);
//                       men.frame.setVisible(true); 
//					}
					if (user != null && user.getPWord().equals(pw)) {
						JOptionPane.showMessageDialog(frame, "Logging in...");

						// Go to UserMenu screen
    					MainMenu men = new MainMenu();
    					men.frame.setVisible(true);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Invalid email or password");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(248, 151, 97, 25);
		frame.getContentPane().add(btnLogin);

		lblNewLabel_1 = new JLabel("Welcome, please log in to continue");
		lblNewLabel_1.setBounds(108, 38, 237, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
                // Go to UserMenu screen
                  Register regScreen = new Register();
                  regScreen.frame.setVisible(true);
                  frame.setVisible(false);
                  //frame.dispose();
                //frame.setVisible(false);
		    }
		});
		btnRegister.setBounds(248, 187, 97, 25);
		frame.getContentPane().add(btnRegister);

	}
}