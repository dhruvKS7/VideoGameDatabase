/*
Dhruv K. Saligram
10/13/18
This class deletes data from the exclusivity table
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
//Creating class with JFrames and user input below:
public class DeleteExclusivityTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel introduction;
    private JLabel exclusiveTypeText;
    private JLabel xboxOneCompatibilityText;
    private JLabel ps4CompatibilityText;
    private JLabel pcCompatibilityText;
    //Creating JButtons below:
    private JButton deleteData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel exclusiveTypePanel;
    private JPanel ps4CompatibilityPanel;
    private JPanel xboxOneCompatibilityPanel;
    private JPanel pcCompatibilityPanel;
    private JPanel holdingPanel;
    //Creating JTextFields below:
    private JTextField ps4CompatibilityField;
    private JTextField exclusiveTypeField;
    private JTextField xboxOneCompatibilityField;
    private JTextField pcCompatibilityField;
    //Creating constructor below:
    public DeleteExclusivityTable() {
        //Detailing setup for constructor below:
        super("Delete Data");
        this.setBounds(1000, 0, 440, 500);
        this.getContentPane().setBackground(COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Making panels below:
        holdingPanel = new JPanel();
        holdingPanel.setLayout(new BoxLayout(holdingPanel, BoxLayout.Y_AXIS));
        holdingPanel.setBackground(COLOR);
        exclusiveTypePanel = new JPanel(new FlowLayout());
        exclusiveTypePanel.setBackground(COLOR);
        ps4CompatibilityPanel = new JPanel(new FlowLayout());
        ps4CompatibilityPanel.setBackground(COLOR);
        xboxOneCompatibilityPanel = new JPanel(new FlowLayout());
        xboxOneCompatibilityPanel.setBackground(COLOR);
        pcCompatibilityPanel = new JPanel(new FlowLayout());
        pcCompatibilityPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" Choose data to delete: ", SwingConstants.CENTER);
        introduction.setFont(TEXT_FONT);
        introduction.setForeground(Color.WHITE);
        exclusiveTypeText = new JLabel("          Where Exclusive Type =");
        exclusiveTypeText.setFont(LABEL_FONT);
        exclusiveTypeText.setForeground(Color.WHITE);
        xboxOneCompatibilityText = new JLabel("Where Xbox1 Compatibility =");
        xboxOneCompatibilityText.setFont(LABEL_FONT);
        xboxOneCompatibilityText.setForeground(Color.WHITE);
        ps4CompatibilityText = new JLabel("     Where PS4 Compatibility =");
        ps4CompatibilityText.setFont(LABEL_FONT);
        ps4CompatibilityText.setForeground(Color.WHITE);
        pcCompatibilityText = new JLabel("       Where PC Compatibility =");
        pcCompatibilityText.setFont(LABEL_FONT);
        pcCompatibilityText.setForeground(Color.WHITE);
        exclusiveTypeField = new JTextField(8);
        xboxOneCompatibilityField = new JTextField(8);
        pcCompatibilityField = new JTextField(8);
        ps4CompatibilityField = new JTextField(8);
        //Naming buttons and making sure they perform when clicked below:
        deleteData = new JButton("Delete Data");
        deleteData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(introduction);
        exclusiveTypePanel.add(exclusiveTypeText);
        exclusiveTypePanel.add(exclusiveTypeField);
        xboxOneCompatibilityPanel.add(xboxOneCompatibilityText);
        xboxOneCompatibilityPanel.add(xboxOneCompatibilityField);
        ps4CompatibilityPanel.add(ps4CompatibilityText);
        ps4CompatibilityPanel.add(ps4CompatibilityField);
        pcCompatibilityPanel.add(pcCompatibilityText);
        pcCompatibilityPanel.add(pcCompatibilityField);
        holdingPanel.add(exclusiveTypePanel);
        holdingPanel.add(xboxOneCompatibilityPanel);
        holdingPanel.add(ps4CompatibilityPanel);
        holdingPanel.add(pcCompatibilityPanel);
        //Adding panels to frame below:
        this.add(textPanel, BorderLayout.NORTH);
        this.add(holdingPanel, BorderLayout.WEST);
        this.add(deleteData, BorderLayout.SOUTH);
        //Making frame visible below:
        this.setVisible(true);
    }
    @Override
    //Setting up what happens when something is pressed below:
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //If delete is clicked, program carries out code below:
        if (command.equals("Delete Data")) {
            //Creating and initializing variables below:
            DatabaseCommands execute = new DatabaseCommands();
            String exclusiveType, xboxOneCompatibility, ps4Compatibility, pcCompatibility;
            boolean acceptedValues = false;
            //Setting strings to text field values below:
            exclusiveType = exclusiveTypeField.getText();
            xboxOneCompatibility = xboxOneCompatibilityField.getText();
            ps4Compatibility = ps4CompatibilityField.getText();
            pcCompatibility = pcCompatibilityField.getText();
            //Passing variables to delete data below:
            acceptedValues = execute.deleteExclusivityTable(exclusiveType, ps4Compatibility, xboxOneCompatibility, pcCompatibility);
            //Testing if user values were accepted and disposing of frame if values are accepted below:
            if (acceptedValues == true) {
                this.dispose();
            }
            //Giving user error message below:
            else {
                introduction.setText("Values not accepted");
            }
        }
    }
}