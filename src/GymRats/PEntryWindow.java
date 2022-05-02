package GymRats;

import java.awt.EventQueue;
import controllers.BodyProgressController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.BodyProgress;

public class PEntryWindow {

    //JFrame frame;
    private JTextField weightTF;
    private JTextField chestTF;
    private JTextField bicepTF;
    private JTextField hipsTF;
    private JTextField waistTF;
    private JTextField thighTF;
    
    //static User user;

    JFrame frame;
    static User user = null;
    private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gymrats"; // could be different
    private static String dbUsername = "root"; // replace with your username (most likely "root")
    private static String dbPassword = "pranav123"; // replace with your password
    static ArrayList<String[]> cProg;
    

    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PEntryWindow window = new PEntryWindow(user, cProg);
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
    public PEntryWindow(User user, ArrayList<String[]> cProg) {
        this.cProg = cProg;
        this.user = user;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 529, 367);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWeight = new JLabel("Weight");
        lblWeight.setBounds(171, 63, 56, 16);
        frame.getContentPane().add(lblWeight);

        JLabel lblChest = new JLabel("Chest");
        lblChest.setBounds(171, 92, 56, 16);
        frame.getContentPane().add(lblChest);

        JLabel lblBicep = new JLabel("Bicep");
        lblBicep.setBounds(171, 121, 56, 16);
        frame.getContentPane().add(lblBicep);

        JLabel lblHip = new JLabel("Hips");
        lblHip.setBounds(171, 150, 56, 16);
        frame.getContentPane().add(lblHip);

        JLabel lblWaist = new JLabel("Waist");
        lblWaist.setBounds(171, 179, 56, 16);
        frame.getContentPane().add(lblWaist);

        JLabel lblThigh = new JLabel("Thigh");
        lblThigh.setBounds(171, 208, 56, 16);
        frame.getContentPane().add(lblThigh);

        weightTF = new JTextField();
        weightTF.setBounds(252, 60, 116, 22);
        frame.getContentPane().add(weightTF);
        weightTF.setColumns(10);

        chestTF = new JTextField();
        chestTF.setColumns(10);
        chestTF.setBounds(252, 89, 116, 22);
        frame.getContentPane().add(chestTF);

        bicepTF = new JTextField();
        bicepTF.setColumns(10);
        bicepTF.setBounds(252, 118, 116, 22);
        frame.getContentPane().add(bicepTF);

        hipsTF = new JTextField();
        hipsTF.setColumns(10);
        hipsTF.setBounds(252, 147, 116, 22);
        frame.getContentPane().add(hipsTF);

        waistTF = new JTextField();
        waistTF.setColumns(10);
        waistTF.setBounds(252, 176, 116, 22);
        frame.getContentPane().add(waistTF);

        thighTF = new JTextField();
        thighTF.setColumns(10);
        thighTF.setBounds(252, 205, 116, 22);
        frame.getContentPane().add(thighTF);

        JButton btnEntry = new JButton("Add Entry");
        btnEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BodyProgress prog = null;
                int uID = user.getUId();
                BodyProgress myBody = new BodyProgress(uID);
                
                
                myBody.setBiceps(uID);
                myBody.setChest(uID);
                myBody.setHeight(uID);
                myBody.setHips(uID);
                myBody.setThigh(uID);
                myBody.setWaist(uID);
                myBody.setWeight(uID);
                    ;
                String[] row = new String[6];
                
                row[0] = chestTF.getText();
                row[1] = waistTF.getText();
                row[2] = hipsTF.getText();
                row[3] = bicepTF.getText();
                row[4] = thighTF.getText();
                row[5] = weightTF.getText();
                cProg.add(row);
      
                JOptionPane.showMessageDialog(frame, "New progress added");
                frame.dispose();
                ProgressMenu retMen = new ProgressMenu(user, cProg);
                retMen.frame.setVisible(true);
            }
        });
        btnEntry.setBounds(198, 256, 97, 25);
        frame.getContentPane().add(btnEntry);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);

        JLabel lblDate = new JLabel("Add a new progress report for: " + strDate);
        lblDate.setBounds(133, 13, 278, 32);
        frame.getContentPane().add(lblDate);
        
        
        //BodyProgressController adding = new BodyProgressController(connectionUrl,dbUsername, dbPassword);
        
        btnEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                BodyProgress prog = null;
//                int uID = user.getUId();
//                BodyProgress myBody = new BodyProgress(uID);
//                
//                
//                myBody.setBiceps(uID);
//                myBody.setChest(uID);
//                myBody.setHeight(uID);
//                myBody.setHips(uID);
//                myBody.setThigh(uID);
//                myBody.setWaist(uID);
//                myBody.setWeight(uID);
////                    myBody.setChest(Integer.parseInt(myBody.setChest(uID)));
////                    myBody.setBiceps(Integer.parseInt(myBody.setBiceps(uID)));
////                    myBody.setBiceps(Integer.parseInt(myBody.setBiceps(uID)));
////                    myBody.setBiceps(Integer.parseInt(myBody.setBiceps(uID)));
//
//                    ;
//                //String[] row = null;
//                
//                row.add(lblChest.getText());
//                row.add(lblWaist.getText());
//                row.add(lblHip.getText());
//                row.add(lblBicep.getText());
//                row.add(lblThigh.getText());
//                row.add(lblWeight.getText());
////              row[0] = lblChest.getText();
////                row[1] = lblWaist.getText();
////                row[2] = lblHip.getText();
////                row[3] = lblBicep.getText();
////                row[4] = lblThigh.getText();
////                row[5] = lblWeight.getText();
//      
            }
        });
        
        
        
        
        
        
    }
}
