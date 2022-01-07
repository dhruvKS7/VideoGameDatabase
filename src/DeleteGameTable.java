/*
Dhruv K. Saligram
10/13/18
This class deletes data from game table
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
//Creayes class with JFrame and user input below:
public class DeleteGameTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel introduction;
    private JLabel gameNameText;
    private JLabel publisherText;
    private JLabel gameEditionText;
    private JLabel exclusiveTypeText;
    private JLabel yearPublishedText;
    private JLabel copiesSoldText;
    //Creating JButtons below:
    private JButton deleteData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel gameNamePanel;
    private JPanel gameEditionPanel;
    private JPanel publisherPanel;
    private JPanel exclusiveTypePanel;
    private JPanel yearPublishedPanel;
    private JPanel copiesSoldPanel;
    private JPanel holdingPanel;
    //Creating JTextFields below:
    private JTextField gameEditionField;
    private JTextField gameNameField;
    private JTextField publisherField;
    private JTextField exclusiveTypeField;
    private JTextField yearPublishedField;
    private JTextField copiesSoldField;
    //Creating constructor below:
    public DeleteGameTable() {
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
        gameNamePanel = new JPanel(new FlowLayout());
        gameNamePanel.setBackground(COLOR);
        gameEditionPanel = new JPanel(new FlowLayout());
        gameEditionPanel.setBackground(COLOR);
        publisherPanel = new JPanel(new FlowLayout());
        publisherPanel.setBackground(COLOR);
        exclusiveTypePanel = new JPanel(new FlowLayout());
        exclusiveTypePanel.setBackground(COLOR);
        yearPublishedPanel = new JPanel(new FlowLayout());
        yearPublishedPanel.setBackground(COLOR);
        copiesSoldPanel = new JPanel(new FlowLayout());
        copiesSoldPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" Choose data to delete: ", SwingConstants.CENTER);
        introduction.setFont(TEXT_FONT);
        introduction.setForeground(Color.WHITE);
        gameNameText = new JLabel("     Where Game Name =");
        gameNameText.setFont(LABEL_FONT);
        gameNameText.setForeground(Color.WHITE);
        gameEditionText = new JLabel("  Where Game Edition =");
        gameEditionText.setFont(LABEL_FONT);
        gameEditionText.setForeground(Color.WHITE);
        publisherText = new JLabel("       Where Publisher =");
        publisherText.setFont(LABEL_FONT);
        publisherText.setForeground(Color.WHITE);
        exclusiveTypeText = new JLabel("Where Exclusive Type =");
        exclusiveTypeText.setFont(LABEL_FONT);
        exclusiveTypeText.setForeground(Color.WHITE);
        yearPublishedText = new JLabel("Where Year Published =");
        yearPublishedText.setFont(LABEL_FONT);
        yearPublishedText.setForeground(Color.WHITE);
        copiesSoldText = new JLabel("     Where Copies Sold  =");
        copiesSoldText.setFont(LABEL_FONT);
        copiesSoldText.setForeground(Color.WHITE);
        //Creating JTextFields below:
        gameNameField = new JTextField(8);
        publisherField = new JTextField(8);
        exclusiveTypeField = new JTextField(8);
        gameEditionField = new JTextField(8);
        yearPublishedField = new JTextField(8);
        copiesSoldField = new JTextField(8);
        //Naming buttons and making sure they perform when clicked below:
        deleteData = new JButton("Delete Data");
        deleteData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(introduction);
        gameNamePanel.add(gameNameText);
        gameNamePanel.add(gameNameField);
        publisherPanel.add(publisherText);
        publisherPanel.add(publisherField);
        gameEditionPanel.add(gameEditionText);
        gameEditionPanel.add(gameEditionField);
        exclusiveTypePanel.add(exclusiveTypeText);
        exclusiveTypePanel.add(exclusiveTypeField);
        yearPublishedPanel.add(yearPublishedText);
        yearPublishedPanel.add(yearPublishedField);
        copiesSoldPanel.add(copiesSoldText);
        copiesSoldPanel.add(copiesSoldField);
        holdingPanel.add(gameNamePanel);
        holdingPanel.add(publisherPanel);
        holdingPanel.add(gameEditionPanel);
        holdingPanel.add(exclusiveTypePanel);
        holdingPanel.add(yearPublishedPanel);
        holdingPanel.add(copiesSoldPanel);
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
            String gameName, publisher, gameEdition, exclusiveType, yearPublishedString, copiesSoldString;
            int yearPublished, copiesSold;
            boolean acceptedValues = false;
            //Setting strings to JTextField values below:
            gameName = gameNameField.getText();
            publisher = publisherField.getText();
            gameEdition = gameEditionField.getText();
            exclusiveType = exclusiveTypeField.getText();
            yearPublishedString = yearPublishedField.getText();
            copiesSoldString = copiesSoldField.getText();
            //Testing if strings are null and translating to int below:
            if (yearPublishedString.equals("")) {
                yearPublished = 0;
            }
            else {
                yearPublished = Integer.parseInt(yearPublishedString);
            }
            //Testing if strings are null and translating to int below:
            if (copiesSoldString.equals("")) {
                copiesSold = 0;
            }
            else {
                copiesSold = Integer.parseInt(copiesSoldString);
            }
            //Passing variables to delete data from game table below:
            acceptedValues = execute.deleteGameTable(gameName, gameEdition, publisher, exclusiveType, yearPublished, copiesSold);
            //Testing if values are accepted and disposing of frame if values are accepted below:
            if (acceptedValues == true) {
                this.dispose();
            }
            //Giving user error message if values are not accepted below:
            else {
                introduction.setText("Values not accepted");
            }
        }
    }
}