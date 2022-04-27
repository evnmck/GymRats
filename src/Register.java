import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import controllers.UserController;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register {
    private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    private static String dbUsername = "root"; // replace with your username (most likely "root")
    private static String dbPassword = "@Tuan_1010"; // replace with your password
    
    protected JFrame frame;
    private JTextField fNameF;
    private JTextField lNameF;
    private JTextField uNameF;
    private JTextField roleF;
    private JPasswordField pwF;
    private JPasswordField cpwF;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register window = new Register();
                    window.frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public Register() {
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
        
        JLabel lblFname = new JLabel("First Name");
        lblFname.setBounds(77, 91, 68, 16);
        frame.getContentPane().add(lblFname);
        
        JLabel lblLname = new JLabel("Last Name");
        lblLname.setBounds(77, 120, 68, 16);
        frame.getContentPane().add(lblLname);
        
        JLabel lblUname = new JLabel("Username");
        lblUname.setBounds(77, 150, 68, 16);
        frame.getContentPane().add(lblUname);
        
        JLabel lblPw = new JLabel("Password");
        lblPw.setBounds(77, 179, 68, 16);
        frame.getContentPane().add(lblPw);
        
        JLabel lblPw2 = new JLabel("Confirm Password");
        lblPw2.setBounds(35, 209, 110, 16);
        frame.getContentPane().add(lblPw2);
        
        JLabel lblRole = new JLabel("Role");
        lblRole.setBounds(109, 238, 36, 16);
        frame.getContentPane().add(lblRole);
        
        fNameF = new JTextField();
        fNameF.setBounds(169, 88, 229, 22);
        frame.getContentPane().add(fNameF);
        fNameF.setColumns(10);
        
        lNameF = new JTextField();
        lNameF.setColumns(10);
        lNameF.setBounds(169, 117, 229, 22);
        frame.getContentPane().add(lNameF);
        
        uNameF = new JTextField();
        uNameF.setColumns(10);
        uNameF.setBounds(169, 147, 229, 22);
        frame.getContentPane().add(uNameF);
        
        roleF = new JTextField();
        roleF.setColumns(10);
        roleF.setBounds(169, 235, 229, 22);
        frame.getContentPane().add(roleF);
        
        pwF = new JPasswordField();
        pwF.setBounds(169, 176, 229, 22);
        frame.getContentPane().add(pwF);
        
        cpwF = new JPasswordField();
        cpwF.setBounds(169, 206, 229, 22);
        frame.getContentPane().add(cpwF);
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String fName = fNameF.getText();
                String lName = lNameF.getText();
                String uName = uNameF.getText();
                String pass = pwF.getText();
                String cPass = cpwF.getText();
                String role = roleF.getText();
                UserController userManager = new UserController(connectionUrl, dbUsername, dbPassword);
                if (!pass.equals(cPass)) {
                    JOptionPane.showMessageDialog(frame, "Password does not match");
                }
                else if (uName.equals("") || fName.equals("") || lName.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields");
                }
                else {
                    try {
                        User user = userManager.getUserByUsername(uName);
                        if (user == null) {
                            user = new User(fName, lName, uName, pass, role);
                            userManager.addUser(user);
                            JOptionPane.showMessageDialog(frame, "Success: New User " + user.getUName() + " created"); 
                            frame.dispose();
                            Login newLog = new Login(connectionUrl, dbUsername, dbPassword);
                            newLog.frame.setVisible(true);
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "ERROR: Username " + user.getUName() + " already exists");
                        }
                    }
                    catch (ClassNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
                
                
            }
        });
        registerButton.setBounds(301, 270, 97, 25);
        frame.getContentPane().add(registerButton);
        

    }
}
