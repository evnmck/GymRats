import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProgressMenu {

    JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProgressMenu window = new ProgressMenu();
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
    public ProgressMenu() {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 520, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton btnEntry = new JButton("New Entry");
        btnEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                PEntryWindow entry = new PEntryWindow();
                entry.frame.setVisible(true);
            }
        });
        btnEntry.setBounds(195, 75, 97, 25);
        frame.getContentPane().add(btnEntry);
        
        JLabel pLbl = new JLabel("Progress Page for FIRST_NAME LAST_NAME");
        pLbl.setBounds(118, 29, 263, 33);
        frame.getContentPane().add(pLbl);
        
        JComboBox progressBox = new JComboBox();
        progressBox.setBounds(114, 152, 286, 25);
        frame.getContentPane().add(progressBox);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"", null, null, null, null, null, null, null, null},
            },
            new String[] {
                "Date", "TrackingID", "Weight", "Chest", "Bicep", "Hips", "Waist", "Thigh", "New column"
            }
        ) {
            Class[] columnTypes = new Class[] {
                String.class, String.class, Float.class, Float.class, Float.class, Float.class, Float.class, Float.class, Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.setBounds(141, 347, 221, -105);
        frame.getContentPane().add(table);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(new Object[] {1, 2, 3});
    }
}
