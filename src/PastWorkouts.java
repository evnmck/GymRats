import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import models.User;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PastWorkouts {

    JFrame frame;
    private JTextField textField;
    static User user;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PastWorkouts window = new PastWorkouts(user);
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
    public PastWorkouts(User user) {
        this.user = user;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 491, 571);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(29, 82, 183, 21);
        frame.getContentPane().add(comboBox);
        
        JLabel trainerLabel = new JLabel("Trainer Comments:");
        trainerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        trainerLabel.setBounds(40, 313, 166, 16);
        frame.getContentPane().add(trainerLabel);
        
        textField = new JTextField();
        textField.setBounds(29, 341, 407, 103);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton viewWButton = new JButton("View Workout");
        viewWButton.setBounds(248, 78, 117, 29);
        frame.getContentPane().add(viewWButton);
        
        JLabel subtitleLabel = new JLabel("Choose a workout to view:");
        subtitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        subtitleLabel.setBounds(40, 54, 183, 16);
        frame.getContentPane().add(subtitleLabel);
        
        JLabel titleLabel = new JLabel("View Past Workouts");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        titleLabel.setBounds(166, 26, 199, 16);
        frame.getContentPane().add(titleLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 151, 407, 142);
        frame.getContentPane().add(scrollPane);
        
        JButton btnMenu = new JButton("Main Menu");
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainMenu men = new MainMenu(user);
                men.frame.setVisible(true);
            }
        });
        btnMenu.setBounds(184, 472, 97, 25);
        frame.getContentPane().add(btnMenu);
    }
}