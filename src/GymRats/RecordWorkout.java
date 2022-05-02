package GymRats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ExerciseController;
import controllers.WorkoutController;
import models.Exercise;
import models.User;
import models.Workout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class RecordWorkout {

    JFrame frame;
    private JTextField exNameTF;
    private JTextField weightTF;
    private JTextField setsTF;
    private JTextField repsTF;
    private JTextField startWTF;
    static User user = null;
    static String woName = null;
    static String woID = null;
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
                    RecordWorkout window = new RecordWorkout(user, "", "");
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
    public RecordWorkout(User user, String woName, String woID) throws ClassNotFoundException {
        this.user = user;
        this.woName = woName;
        this.woID = woID;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws ClassNotFoundException 
     */
    private void initialize() throws ClassNotFoundException {
        frame = new JFrame();
        frame.setBounds(100, 100, 572, 572);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel newWLabel = new JLabel("Enter exercises for: " + woName);
        newWLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        newWLabel.setBounds(33, 32, 415, 16);
        frame.getContentPane().add(newWLabel);

        JLabel exNameLabel = new JLabel("Exercise name:");
        exNameLabel.setBounds(43, 70, 105, 16);
        frame.getContentPane().add(exNameLabel);

        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setBounds(43, 98, 61, 16);
        frame.getContentPane().add(weightLabel);

        JLabel setsLabel = new JLabel("Number of sets:");
        setsLabel.setBounds(43, 126, 136, 16);
        frame.getContentPane().add(setsLabel);

        JLabel repsLabel = new JLabel("Number of reps:");
        repsLabel.setBounds(43, 159, 105, 16);
        frame.getContentPane().add(repsLabel);

        JLabel startWLabel = new JLabel("Starting weight:");
        startWLabel.setBounds(43, 198, 105, 16);
        frame.getContentPane().add(startWLabel);

        exNameTF = new JTextField();
        exNameTF.setBounds(162, 65, 130, 26);
        frame.getContentPane().add(exNameTF);
        exNameTF.setColumns(10);

        weightTF = new JTextField();
        weightTF.setBounds(162, 93, 130, 26);
        frame.getContentPane().add(weightTF);
        weightTF.setColumns(10);

        setsTF = new JTextField();
        setsTF.setBounds(162, 126, 130, 26);
        frame.getContentPane().add(setsTF);
        setsTF.setColumns(10);

        repsTF = new JTextField();
        repsTF.setBounds(162, 154, 130, 26);
        frame.getContentPane().add(repsTF);
        repsTF.setColumns(10);

        startWTF = new JTextField();
        startWTF.setBounds(162, 193, 130, 26);
        frame.getContentPane().add(startWTF);
        startWTF.setColumns(10);




        JButton btnEnd = new JButton("End Workout");
        btnEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Good job!");
                frame.dispose();
                MainMenu main = new MainMenu(user);
                main.frame.setVisible(true);
            }
        });
        btnEnd.setBounds(220, 482, 130, 25);
        frame.getContentPane().add(btnEnd);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(38, 275, 496, 195);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        model = new DefaultTableModel();
        Object [] column = {"Exercise Name", "Weight", "# of sets", "# of reps", "Starting weight"};
    
    
        Object[] row = new Object[5];
        
        
        //Object[] row = {exName, weight, sets, reps, startW}; //change this to add exercise
        model.setColumnIdentifiers(column);
        table.setModel(model);
        
        
        
        ExerciseController myExercise = new ExerciseController(connectionUrl, dbUsername, dbPassword);
        //Exercise currEx = new Exercise(startW);
        JButton addEntryButton = new JButton("Add Entry");
        WorkoutController myWorkoutController = new WorkoutController(connectionUrl, dbUsername, dbPassword);

        int uID = user.getUId();
        int wID = Integer.parseInt(woID);
        //Workout(int workout, int exercise, int user, String name, int start, int end, int reps, int sets, int time) {
        

        addEntryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exName = exNameTF.getText();
                String weight = weightTF.getText();
                String sets = setsTF.getText();
                String reps = repsTF.getText();
                String startW = startWTF.getText();
                
                Exercise currExercise = null;
                try {
                    System.out.println("NAME: " + exName);
                    currExercise = myExercise.getExerciseByExerciseName(exName);
                } catch (ClassNotFoundException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                int exID = currExercise.getEId();
                Workout myWorkout = new Workout(wID, exID, uID);                

                myWorkout.setEWeight(Integer.parseInt(weight));
                myWorkout.setSets(Integer.parseInt(sets));
                myWorkout.setReps(Integer.parseInt(reps));
                myWorkout.setSWeight(Integer.parseInt(startW));
                myWorkout.setTime(0);
                myWorkout.setName(woName);
                
                try {
                    myWorkoutController.addWorkout(myWorkout);
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                
                row[0] = exNameTF.getText();
                row[1] = weightTF.getText();
                row[2] = setsTF.getText();
                row[3] = repsTF.getText();
                row[4] =  startWTF.getText();
                model.addRow(row);
            }
        });
        addEntryButton.setBounds(331, 193, 117, 29);
        frame.getContentPane().add(addEntryButton);
        
    }
}
