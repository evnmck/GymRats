import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileWindow {

    protected JFrame frame;
    private JTextField fNameF;
    private JTextField lNameF;
    private JTextField roleF;
    private JPasswordField pwF;
    private JPasswordField cpwF;
    private JButton btnSave;
    private JLabel nameLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProfileWindow window = new ProfileWindow();
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
    public ProfileWindow() {
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
        
        roleF = new JTextField();
        roleF.setColumns(10);
        roleF.setBounds(169, 186, 229, 80);
        frame.getContentPane().add(roleF);
        
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
                String role = cpwF.getText();
                if (!pass.equals(cPass)) {
                    JOptionPane.showMessageDialog(frame, "Password does not match");
                }
                /*
                 * CHECK TO SEE IF USER EXISTS HERE
                 * 
                */
                //UserController controller;
//                else if (user exists) {
//                    JOptionPane.showMessageDialog(frame, "User already exists");
//                }
                else {
                    JOptionPane.showMessageDialog(frame, "Success. Your changes have been saved");
                    //frame.dispose();
                }   
                
            }
        });
        btnSave.setBounds(301, 279, 97, 25);
        frame.getContentPane().add(btnSave);
        
        nameLabel = new JLabel("Edit profile for FIRST_NAME LAST_NAME");
        nameLabel.setBounds(105, 13, 238, 43);
        frame.getContentPane().add(nameLabel);
    }

}
