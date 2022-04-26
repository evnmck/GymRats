import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class WorkoutWindow {

	JFrame frame;
	//private final JLabel DateLabel = new JLabel("Today is:");
	
	Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String strDate = dateFormat.format(date);

    JLabel DateLabel = new JLabel("Today is: " + strDate);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    WorkoutWindow window = new WorkoutWindow();
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
	public WorkoutWindow() {
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
		DateLabel.setBounds(152, 34, 184, 29);
		frame.getContentPane().add(DateLabel);
		
		JButton startWorkoutButton = new JButton("Start Workout");
		startWorkoutButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        StartWorkout newWO = new StartWorkout();
		        newWO.frame.setVisible(true);
		    }
		});
		startWorkoutButton.setBounds(139, 74, 167, 29);
		frame.getContentPane().add(startWorkoutButton);
		
		JButton pastWorkoutButton = new JButton("View Past Workouts");
		pastWorkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    PastWorkouts pWO = new PastWorkouts();
			    pWO.frame.setVisible(true);
			    frame.setVisible(false);
			}
		});
		pastWorkoutButton.setBounds(139, 116, 167, 29);
		frame.getContentPane().add(pastWorkoutButton);
		
		JButton prStatsButton = new JButton("View Personal Records");
		prStatsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		prStatsButton.setBounds(139, 162, 167, 29);
		frame.getContentPane().add(prStatsButton);
	}
}
