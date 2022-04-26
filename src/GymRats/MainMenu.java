package GymRats;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import com.ibm.icu.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MainMenu {

    JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu window = new MainMenu();
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
    public MainMenu() {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 525, 491);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = dateFormat.format(date);
//        //String date = "4/26/2022";
        
        JLabel mainLbl = new JLabel("WELCOME");
        mainLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainLbl.setBounds(174, 28, 157, 46);
        frame.getContentPane().add(mainLbl);
        
        JButton addWOButton = new JButton("Workouts");
        addWOButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                frame.setVisible(false);
                WorkoutWindow wo = new WorkoutWindow();
                wo.frame.setVisible(true);
                
            }
        });
        addWOButton.setBounds(196, 146, 109, 25);
        frame.getContentPane().add(addWOButton);
        
        JButton progressButton = new JButton("Progress");
        progressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ProgressMenu men = new ProgressMenu();
                men.frame.setVisible(true);
            }
        });
        progressButton.setBounds(196, 195, 109, 25);
        frame.getContentPane().add(progressButton);
        
        JButton profileButton = new JButton("Edit Profile");
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfileWindow pro = new ProfileWindow();
                pro.frame.setVisible(true);
            }
        });
        profileButton.setBounds(196, 245, 109, 25);
        frame.getContentPane().add(profileButton);
        
        JButton trainerButton = new JButton("Trainer Tab");
        trainerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        trainerButton.setBounds(196, 290, 109, 25);
        frame.getContentPane().add(trainerButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Login log = new Login("", "", "");
                log.frame.setVisible(true);
            }
        });
        logoutButton.setBounds(12, 406, 109, 25);
        frame.getContentPane().add(logoutButton);
    }
}
