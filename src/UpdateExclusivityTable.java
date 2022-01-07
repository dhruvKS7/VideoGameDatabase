/*
Dhruv K. Saligram
10/13/18
This class updates the exclusivity table
*/
package videogameapplication;
//Imports below:
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//Creating class with JFrame that accepts user input below:
public class UpdateExclusivityTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel setText;
    private JLabel setPs4CompatibilityText;
    private JLabel setExclusiveTypeText;
    private JLabel setXboxOneCompatibilityText;
    private JLabel setPcCompatibilityText;
    private JLabel whereText;
    private JLabel wherePs4CompatibilityText;
    private JLabel whereXboxOneCompatibilityText;
    private JLabel whereExclusiveTypeText;
    private JLabel wherePcCompatibilityText;
    //Creating JButtons below:
    private JButton updateData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel setExclusiveTypePanel;
    private JPanel setPs4CompatibilityPanel;
    private JPanel setXboxOneCompatibilityPanel;
    private JPanel setPcCompatibilityPanel;
    private JPanel holdingPanel;
    private JPanel wherePs4CompatibilityPanel;
    private JPanel whereExclusiveTypePanel;
    private JPanel whereXboxOneCompatibilityPanel;
    private JPanel wherePcCompatibilityPanel;
    //Creating JTextFields below:
    private JTextField setExclusiveTypeField;
    private JTextField setPs4CompatibilityField;
    private JTextField setXboxOneCompatibilityField;
    private JTextField setPcCompatibilityField;
    private JTextField whereExclusiveTypeField;
    private JTextField wherePs4CompatibilityField;
    private JTextField whereXboxOneCompatibilityField;
    private JTextField wherePcCompatibilityField;
    //Creating constructor below:
    public UpdateExclusivityTable() {
        //Detailing setup for constructor below:
        super("Update Data");
        this.setBounds(1000, 0, 440, 700);
        this.getContentPane().setBackground(COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Making panels below:
        holdingPanel = new JPanel();
        holdingPanel.setLayout(new BoxLayout(holdingPanel, BoxLayout.Y_AXIS));
        holdingPanel.setBackground(COLOR);
        setExclusiveTypePanel = new JPanel(new FlowLayout());
        setExclusiveTypePanel.setBackground(COLOR);
        setPs4CompatibilityPanel = new JPanel(new FlowLayout());
        setPs4CompatibilityPanel.setBackground(COLOR);
        setXboxOneCompatibilityPanel = new JPanel(new FlowLayout());
        setXboxOneCompatibilityPanel.setBackground(COLOR);
        setPcCompatibilityPanel = new JPanel(new FlowLayout());
        setPcCompatibilityPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        wherePs4CompatibilityPanel = new JPanel(new FlowLayout());
        wherePs4CompatibilityPanel.setBackground(COLOR);
        whereExclusiveTypePanel = new JPanel(new FlowLayout());
        whereExclusiveTypePanel.setBackground(COLOR);
        whereXboxOneCompatibilityPanel = new JPanel(new FlowLayout());
        whereXboxOneCompatibilityPanel.setBackground(COLOR);
        wherePcCompatibilityPanel = new JPanel(new FlowLayout());
        wherePcCompatibilityPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        setText = new JLabel(" SET: ", SwingConstants.CENTER);
        setText.setFont(TEXT_FONT);
        setText.setForeground(Color.WHITE);
        whereText = new JLabel(" WHERE: ", SwingConstants.CENTER);
        whereText.setFont(TEXT_FONT);
        whereText.setForeground(Color.WHITE);
        setExclusiveTypeText = new JLabel("Exclusive Type =");
        setExclusiveTypeText.setFont(LABEL_FONT);
        setExclusiveTypeText.setForeground(Color.WHITE);
        setPs4CompatibilityText = new JLabel("PS4 Compatibility =");
        setPs4CompatibilityText.setFont(LABEL_FONT);
        setPs4CompatibilityText.setForeground(Color.WHITE);
        setXboxOneCompatibilityText = new JLabel("Xbox1 Compatibility =");
        setXboxOneCompatibilityText.setFont(LABEL_FONT);
        setXboxOneCompatibilityText.setForeground(Color.WHITE);
        setPcCompatibilityText = new JLabel("PC Compatibility =");
        setPcCompatibilityText.setFont(LABEL_FONT);
        setPcCompatibilityText.setForeground(Color.WHITE);
        wherePs4CompatibilityText = new JLabel("PS4 Compatibility =");
        wherePs4CompatibilityText.setFont(LABEL_FONT);
        wherePs4CompatibilityText.setForeground(Color.WHITE);
        whereExclusiveTypeText = new JLabel("Exclusive Type =");
        whereExclusiveTypeText.setFont(LABEL_FONT);
        whereExclusiveTypeText.setForeground(Color.WHITE);
        whereXboxOneCompatibilityText = new JLabel("Xbox1 Compatibility =");
        whereXboxOneCompatibilityText.setFont(LABEL_FONT);
        whereXboxOneCompatibilityText.setForeground(Color.WHITE);
        wherePcCompatibilityText = new JLabel("PC Compatibility =");
        wherePcCompatibilityText.setFont(LABEL_FONT);
        wherePcCompatibilityText.setForeground(Color.WHITE);
        //Setting JTextFields below:
        setPs4CompatibilityField = new JTextField(8);
        setXboxOneCompatibilityField = new JTextField(8);
        setExclusiveTypeField = new JTextField(8);
        setPcCompatibilityField = new JTextField(8);
        wherePs4CompatibilityField = new JTextField(8);
        whereXboxOneCompatibilityField = new JTextField(8);
        wherePcCompatibilityField = new JTextField(8);
        whereExclusiveTypeField = new JTextField(8);
        //Naming buttons and making sure they perform when clicked below:
        updateData = new JButton("Update Data");
        updateData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(setText);
        setPs4CompatibilityPanel.add(setPs4CompatibilityText);
        setPs4CompatibilityPanel.add(setPs4CompatibilityField);
        setExclusiveTypePanel.add(setExclusiveTypeText);
        setExclusiveTypePanel.add(setExclusiveTypeField);
        setXboxOneCompatibilityPanel.add(setXboxOneCompatibilityText);
        setXboxOneCompatibilityPanel.add(setXboxOneCompatibilityField);
        setPcCompatibilityPanel.add(setPcCompatibilityText);
        setPcCompatibilityPanel.add(setPcCompatibilityField);
        wherePs4CompatibilityPanel.add(wherePs4CompatibilityText);
        wherePs4CompatibilityPanel.add(wherePs4CompatibilityField);
        whereXboxOneCompatibilityPanel.add(whereXboxOneCompatibilityText);
        whereXboxOneCompatibilityPanel.add(whereXboxOneCompatibilityField);
        whereExclusiveTypePanel.add(whereExclusiveTypeText);
        whereExclusiveTypePanel.add(whereExclusiveTypeField);
        wherePcCompatibilityPanel.add(wherePcCompatibilityText);
        wherePcCompatibilityPanel.add(wherePcCompatibilityField);
        holdingPanel.add(setPs4CompatibilityPanel);
        holdingPanel.add(setExclusiveTypePanel);
        holdingPanel.add(setXboxOneCompatibilityPanel);
        holdingPanel.add(setPcCompatibilityPanel);
        holdingPanel.add(whereText);
        holdingPanel.add(wherePs4CompatibilityPanel);
        holdingPanel.add(whereXboxOneCompatibilityPanel);
        holdingPanel.add(whereExclusiveTypePanel);
        holdingPanel.add(wherePcCompatibilityPanel);
        //Adding panels to frame below:
        this.add(textPanel, BorderLayout.NORTH);
        this.add(holdingPanel, BorderLayout.WEST);
        this.add(updateData, BorderLayout.SOUTH);
        //Making frame visible below:
        this.setVisible(true);
    }
    @Override
    //Setting up what happens when something is pressed below:
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //If update is clicked, program carries out code below:
        if (command.equals("Update Data")) {
            //Creating and initializing variables below:
            DatabaseCommands execute = new DatabaseCommands();
            String setPs4Compatibility, setExclusiveType, setXboxOneCompatibility, setPcCompatibility;
            String wherePs4Compatibility, whereXboxOneCompatibility, whereExclusiveType, wherePcCompatibility;
            boolean acceptedValues = false;
            //Setting strings to text from JTextFields below:
            setPs4Compatibility = setPs4CompatibilityField.getText();
            setExclusiveType = setExclusiveTypeField.getText();
            setXboxOneCompatibility = setXboxOneCompatibilityField.getText();
            setPcCompatibility = setPcCompatibilityField.getText();
            wherePs4Compatibility = wherePs4CompatibilityField.getText();
            whereXboxOneCompatibility = whereXboxOneCompatibilityField.getText();
            whereExclusiveType = whereExclusiveTypeField.getText();
            wherePcCompatibility = wherePcCompatibilityField.getText();
            //Sending strings to update exclusivity table below:
            acceptedValues = execute.updateExclusivityTable(setExclusiveType, setPs4Compatibility, setXboxOneCompatibility, setPcCompatibility, whereExclusiveType, wherePs4Compatibility, whereXboxOneCompatibility, wherePcCompatibility);
            //Testing if values are accepted and disposing of frame if values are accepted below:
            if (acceptedValues == true) {
                this.dispose();
            }
            //Giving error message to user if values are not accepted below:
            else {
                setText.setText("Values not accepted");
            }
        }
    }
}