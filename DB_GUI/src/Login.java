//Cuong


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
import controllers.UserController;

//import controller.DatabaseHandler;
//import model.User;

public class Login {
    static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    static String dbUsername = "root"; // replace with your username (most likely "root")
    static String dbPassword = ""; // replace with your password
    
    
	private JFrame frame;
	private JTextField email;
	private JPasswordField password;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Open DatabaseHandler
//		DatabaseHandler db = new DatabaseHandler();
//		User newUser2 = new User("Samie", "samiea@vt.edu", true, "1234", 0);
//		db.writeUserToDatabase(newUser2);
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
                    if (userManager.getUser(Integer.parseInt(em)) != null) {
                    	JOptionPane.showMessageDialog(frame, "Logging in...");
                    	
                    	// Go to UserMenu screen
//					UserMenu men = new UserMenu();
//					men.setVisible(true);
                    	frame.setVisible(false);
                    }
                    
                    else {
                    	JOptionPane.showMessageDialog(frame, "Invalid email or password");
                    }
                }
                catch (NumberFormatException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                catch (HeadlessException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                catch (ClassNotFoundException e1) {
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
		

	}
}