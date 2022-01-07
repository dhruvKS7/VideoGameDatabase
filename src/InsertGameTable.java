/*
Dhruv K. Saligram
10/13/18
This class inserts into game table
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
//Creating class with JFrame and accepts user input below:
public class InsertGameTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel introduction;
    private JLabel gameNameText;
    private JLabel gameEditionText;
    private JLabel publisherText;
    private JLabel exclusiveTypeText;
    private JLabel yearPublishedText;
    private JLabel copiesSoldText;
    //Creating JButtons below:
    private JButton insertData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel gameNamePanel;
    private JPanel gameEditionPanel;
    private JPanel exclusiveTypePanel;
    private JPanel publisherPanel;
    private JPanel yearPublishedPanel;
    private JPanel copiesSoldPanel;
    private JPanel holdingPanel;
    //Creating JTextFields below:
    private JTextField gameNameField;
    private JTextField exclusiveTypeField;
    private JTextField gameEditionField;
    private JTextField publisherField;
    private JTextField yearPublishedField;
    private JTextField copiesSoldField;
    //Creating constructor below:
    public InsertGameTable() {
        //Detailing setup for constructor below:
        super("Insert Data");
        this.setBounds(1000, 0, 440, 500);
        this.getContentPane().setBackground(COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Making panels below:
        holdingPanel = new JPanel();
        holdingPanel.setLayout(new BoxLayout(holdingPanel, BoxLayout.Y_AXIS));
        holdingPanel.setBackground(COLOR);
        gameNamePanel = new JPanel(new FlowLayout());
        gameNamePanel.setBackground(COLOR);
        gameEditionPanel = new JPanel(new FlowLayout());
        gameEditionPanel.setBackground(COLOR);
        exclusiveTypePanel = new JPanel(new FlowLayout());
        exclusiveTypePanel.setBackground(COLOR);
        publisherPanel = new JPanel(new FlowLayout());
        publisherPanel.setBackground(COLOR);
        yearPublishedPanel = new JPanel(new FlowLayout());
        yearPublishedPanel.setBackground(COLOR);
        copiesSoldPanel = new JPanel(new FlowLayout());
        copiesSoldPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" Insert your data below: ", SwingConstants.CENTER);
        introduction.setFont(TEXT_FONT);
        introduction.setForeground(Color.WHITE);
        gameNameText = new JLabel("     Game Name: ");
        gameNameText.setFont(LABEL_FONT);
        gameNameText.setForeground(Color.WHITE);
        gameEditionText = new JLabel("  Game Edition: ");
        gameEditionText.setFont(LABEL_FONT);
        gameEditionText.setForeground(Color.WHITE);
        publisherText = new JLabel("       Publisher: ");
        publisherText.setFont(LABEL_FONT);
        publisherText.setForeground(Color.WHITE);
        exclusiveTypeText = new JLabel("Exclusive Type:");
        exclusiveTypeText.setFont(LABEL_FONT);
        exclusiveTypeText.setForeground(Color.WHITE);
        yearPublishedText = new JLabel("Year Published:");
        yearPublishedText.setFont(LABEL_FONT);
        yearPublishedText.setForeground(Color.WHITE);
        copiesSoldText = new JLabel("     Copies Sold: ");
        copiesSoldText.setFont(LABEL_FONT);
        copiesSoldText.setForeground(Color.WHITE);
        //Creating JTextFields below:
        gameNameField = new JTextField(15);
        gameEditionField = new JTextField(15);
        publisherField = new JTextField(15);
        yearPublishedField = new JTextField(15);
        copiesSoldField = new JTextField(15);
        exclusiveTypeField = new JTextField(15);
        //Naming buttons and making sure they perform when clicked below:
        insertData = new JButton("Insert Data");
        insertData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(introduction);
        gameNamePanel.add(gameNameText);
        gameNamePanel.add(gameNameField);
        gameEditionPanel.add(gameEditionText);
        gameEditionPanel.add(gameEditionField);
        publisherPanel.add(publisherText);
        publisherPanel.add(publisherField);
        exclusiveTypePanel.add(exclusiveTypeText);
        exclusiveTypePanel.add(exclusiveTypeField);
        yearPublishedPanel.add(yearPublishedText);
        yearPublishedPanel.add(yearPublishedField);
        copiesSoldPanel.add(copiesSoldText);
        copiesSoldPanel.add(copiesSoldField);
        holdingPanel.add(gameNamePanel);
        holdingPanel.add(gameEditionPanel);
        holdingPanel.add(publisherPanel);
        holdingPanel.add(exclusiveTypePanel);
        holdingPanel.add(yearPublishedPanel);
        holdingPanel.add(copiesSoldPanel);
        //Adding panels to frame below:
        this.add(textPanel, BorderLayout.NORTH);
        this.add(holdingPanel, BorderLayout.WEST);
        this.add(insertData, BorderLayout.SOUTH);
        //Making frame visible below:
        this.setVisible(true);
    }
    @Override
    //Setting up what happens when something is pressed below:
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //If insert is clicked, program carries out code below:
        if (command.equals("Insert Data")) {
            //Creating and initializing variables below:
            DatabaseCommands execute = new DatabaseCommands();
            String gameName, gameEdition, publisher, exclusiveType, yearPublishedString, copiesSoldString;
            boolean acceptedValues = false;
            int copiesSold = 0;
            int yearPublished = 0;
            //Setting strings to values in text fields below:
            gameName = gameNameField.getText();
            gameEdition = gameEditionField.getText();
            publisher = publisherField.getText();
            exclusiveType = exclusiveTypeField.getText();
            yearPublishedString = yearPublishedField.getText();
            copiesSoldString = copiesSoldField.getText();
            try {
                //Converting string to int below:
                copiesSold = Integer.parseInt(copiesSoldString);
                yearPublished = Integer.parseInt(yearPublishedString);
                //Sending variables to insert into game table below:
                acceptedValues = execute.insertGameTable(gameName, gameEdition, publisher, exclusiveType, yearPublished, copiesSold);
                //Testing if values are accepted and disposing of frame is values are accepted below:
                if (acceptedValues == true) {
                    this.dispose();    
                }
                //Catching exceptions and giving user error message below:
                else {
                    introduction.setText("Values not accepted");
                }
            }
            //Catching number exceptions and giving user error message below:
            catch (NumberFormatException i) {
                introduction.setText("Values not accepted");
            }
        }
    }
}