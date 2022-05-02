package GymRats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.UserWorkoutController;
import controllers.WorkoutController;
import models.User;
import models.UserWorkout;
import models.Workout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.ActionEvent;


public class PastWorkouts {

    JFrame frame;
    private JTextField textField;
    static User user;
    private JTable table;
    private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    private static String dbUsername = "root"; // replace with your username (most likely "root")
    private static String dbPassword = "@Tuan_1010"; // replace with your password
    
    DefaultTableModel model;

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
     * @throws ClassNotFoundException 
     */
    public PastWorkouts(User user) throws ClassNotFoundException {
        this.user = user;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws ClassNotFoundException 
     */
    private void initialize() throws ClassNotFoundException {
        frame = new JFrame();
        frame.setBounds(100, 100, 491, 571);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);



        JLabel trainerLabel = new JLabel("Trainer Comments:");
        trainerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        trainerLabel.setBounds(40, 313, 166, 16);
        frame.getContentPane().add(trainerLabel);

        textField = new JTextField();
        textField.setBounds(29, 341, 407, 103);
        frame.getContentPane().add(textField);
        textField.setColumns(10);




        JLabel subtitleLabel = new JLabel("Choose a workout to view:");
        subtitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        subtitleLabel.setBounds(40, 54, 183, 16);
        frame.getContentPane().add(subtitleLabel);

        JLabel titleLabel = new JLabel("View Past Workouts");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        titleLabel.setBounds(166, 26, 199, 16);
        frame.getContentPane().add(titleLabel);

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
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 158, 391, 128);
        frame.getContentPane().add(scrollPane);
        
        
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        model = new DefaultTableModel();
        Object [] column = {"Exercise Name", "Weight", "# of sets", "# of reps", "Starting weight"};
        
    
        Object[] row = new Object[5];
        
        
        
        //Object[] row = {exName, weight, sets, reps, startW}; //change this to add exercise
        model.setColumnIdentifiers(column);
        table.setModel(model);
        
        WorkoutController myWorkoutController = new WorkoutController(connectionUrl, dbUsername, dbPassword);
        //UserWorkoutController myWorkoutController = new UserWorkoutController(connectionUrl, dbUsername, dbPassword);

        //myWorkoutController.getWorkout(0, 0, 0)
        //ArrayList<UserWorkout> workoutList = myWorkoutController.getUserWorkouts();
        
        
        int uID = user.getUId();
        
        ArrayList<Workout> workoutList = myWorkoutController.getAllWorkoutforUser(uID);
        HashSet<Integer> woID = new HashSet<>();
        ArrayList<String> uniqueWO = new ArrayList<String>(); 
        
        for (Workout currW : workoutList) {
            if (woID.add(currW.getWId())) {
                String currI = currW.getName() + " " + currW.getDate();
                uniqueWO.add(currI);
            }
        }
        
        JButton viewWButton = new JButton("View Workout");
        viewWButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                
                model.addRow(row);
                
                
                
            }
        });
        
        viewWButton.setBounds(248, 78, 117, 29);
        frame.getContentPane().add(viewWButton);
        ArrayList<String> dropDList = new ArrayList<>();
        
        
        ArrayList<String> dummyData = new ArrayList<>();
        dummyData.add("Legs 04/28/2022");
        
        String[] woSelection = uniqueWO.toArray(new String[uniqueWO.size()]);
        JComboBox comboBox = new JComboBox(woSelection);
        
        comboBox.setBounds(29, 82, 183, 21);
        frame.getContentPane().add(comboBox);
        
        
        
    }
}