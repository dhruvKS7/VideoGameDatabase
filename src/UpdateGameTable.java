/*
Dhruv K. Saligram
10/13/18
This class updates game table
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
//Creating class with JFrame and allows user input below:
public class UpdateGameTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel setText;
    private JLabel setGameNameText;
    private JLabel setPublisherText;
    private JLabel setGameEditionText;
    private JLabel setExclusiveTypeText;
    private JLabel setYearPublishedText;
    private JLabel setCopiesSoldText;
    private JLabel whereText;
    private JLabel whereGameNameText;
    private JLabel wherePublisherText;
    private JLabel whereGameEditionText;
    private JLabel whereExclusiveTypeText;
    private JLabel whereYearPublishedText;
    private JLabel whereCopiesSoldText;
    //Creating JButtons below:
    private JButton updateData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel setGameNamePanel;
    private JPanel setGameEditionPanel;
    private JPanel setPublisherPanel;
    private JPanel setExclusiveTypePanel;
    private JPanel setYearPublishedPanel;
    private JPanel setCopiesSoldPanel;
    private JPanel holdingPanel;
    private JPanel whereGameNamePanel;
    private JPanel whereGameEditionPanel;
    private JPanel wherePublisherPanel;
    private JPanel whereExclusiveTypePanel;
    private JPanel whereYearPublishedPanel;
    private JPanel whereCopiesSoldPanel;
    //Creating JTextFields below:
    private JTextField setGameEditionField;
    private JTextField setGameNameField;
    private JTextField setPublisherField;
    private JTextField setExclusiveTypeField;
    private JTextField setYearPublishedField;
    private JTextField setCopiesSoldField;
    private JTextField whereGameEditionField;
    private JTextField whereGameNameField;
    private JTextField wherePublisherField;
    private JTextField whereExclusiveTypeField;
    private JTextField whereYearPublishedField;
    private JTextField whereCopiesSoldField;
    //Creating constructor below:
    public UpdateGameTable() {
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
        setGameNamePanel = new JPanel(new FlowLayout());
        setGameNamePanel.setBackground(COLOR);
        setGameEditionPanel = new JPanel(new FlowLayout());
        setGameEditionPanel.setBackground(COLOR);
        setPublisherPanel = new JPanel(new FlowLayout());
        setPublisherPanel.setBackground(COLOR);
        setExclusiveTypePanel = new JPanel(new FlowLayout());
        setExclusiveTypePanel.setBackground(COLOR);
        setYearPublishedPanel = new JPanel(new FlowLayout());
        setYearPublishedPanel.setBackground(COLOR);
        setCopiesSoldPanel = new JPanel(new FlowLayout());
        setCopiesSoldPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        whereGameNamePanel = new JPanel(new FlowLayout());
        whereGameNamePanel.setBackground(COLOR);
        whereGameEditionPanel = new JPanel(new FlowLayout());
        whereGameEditionPanel.setBackground(COLOR);
        wherePublisherPanel = new JPanel(new FlowLayout());
        wherePublisherPanel.setBackground(COLOR);
        whereExclusiveTypePanel = new JPanel(new FlowLayout());
        whereExclusiveTypePanel.setBackground(COLOR);
        whereYearPublishedPanel = new JPanel(new FlowLayout());
        whereYearPublishedPanel.setBackground(COLOR);
        whereCopiesSoldPanel = new JPanel(new FlowLayout());
        whereCopiesSoldPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        setText = new JLabel(" SET: ", SwingConstants.CENTER);
        setText.setFont(TEXT_FONT);
        setText.setForeground(Color.WHITE);
        whereText = new JLabel(" WHERE: ", SwingConstants.CENTER);
        whereText.setFont(TEXT_FONT);
        whereText.setForeground(Color.WHITE);
        setGameNameText = new JLabel("     Game Name =");
        setGameNameText.setFont(LABEL_FONT);
        setGameNameText.setForeground(Color.WHITE);
        setGameEditionText = new JLabel("  Game Edition =");
        setGameEditionText.setFont(LABEL_FONT);
        setGameEditionText.setForeground(Color.WHITE);
        setPublisherText = new JLabel("       Publisher =");
        setPublisherText.setFont(LABEL_FONT);
        setPublisherText.setForeground(Color.WHITE);
        setExclusiveTypeText = new JLabel("Exclusive Type =");
        setExclusiveTypeText.setFont(LABEL_FONT);
        setExclusiveTypeText.setForeground(Color.WHITE);
        setYearPublishedText = new JLabel("Year Published =");
        setYearPublishedText.setFont(LABEL_FONT);
        setYearPublishedText.setForeground(Color.WHITE);
        setCopiesSoldText = new JLabel("     Copies Sold  =");
        setCopiesSoldText.setFont(LABEL_FONT);
        setCopiesSoldText.setForeground(Color.WHITE);
        whereGameNameText = new JLabel("     Game Name =");
        whereGameNameText.setFont(LABEL_FONT);
        whereGameNameText.setForeground(Color.WHITE);
        whereGameEditionText = new JLabel("  Game Edition =");
        whereGameEditionText.setFont(LABEL_FONT);
        whereGameEditionText.setForeground(Color.WHITE);
        wherePublisherText = new JLabel("       Publisher =");
        wherePublisherText.setFont(LABEL_FONT);
        wherePublisherText.setForeground(Color.WHITE);
        whereExclusiveTypeText = new JLabel("Exclusive Type =");
        whereExclusiveTypeText.setFont(LABEL_FONT);
        whereExclusiveTypeText.setForeground(Color.WHITE);
        whereYearPublishedText = new JLabel("Year Published =");
        whereYearPublishedText.setFont(LABEL_FONT);
        whereYearPublishedText.setForeground(Color.WHITE);
        whereCopiesSoldText = new JLabel("     Copies Sold  =");
        whereCopiesSoldText.setFont(LABEL_FONT);
        whereCopiesSoldText.setForeground(Color.WHITE);
        //Setting up JTextFields below:
        setGameNameField = new JTextField(8);
        setPublisherField = new JTextField(8);
        setExclusiveTypeField = new JTextField(8);
        setGameEditionField = new JTextField(8);
        setYearPublishedField = new JTextField(8);
        setCopiesSoldField = new JTextField(8);
        whereGameNameField = new JTextField(8);
        wherePublisherField = new JTextField(8);
        whereExclusiveTypeField = new JTextField(8);
        whereGameEditionField = new JTextField(8);
        whereYearPublishedField = new JTextField(8);
        whereCopiesSoldField = new JTextField(8);
        //Naming buttons and making sure they perform when clicked below:
        updateData = new JButton("Update Data");
        updateData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(setText);
        setGameNamePanel.add(setGameNameText);
        setGameNamePanel.add(setGameNameField);
        setPublisherPanel.add(setPublisherText);
        setPublisherPanel.add(setPublisherField);
        setGameEditionPanel.add(setGameEditionText);
        setGameEditionPanel.add(setGameEditionField);
        setExclusiveTypePanel.add(setExclusiveTypeText);
        setExclusiveTypePanel.add(setExclusiveTypeField);
        setYearPublishedPanel.add(setYearPublishedText);
        setYearPublishedPanel.add(setYearPublishedField);
        setCopiesSoldPanel.add(setCopiesSoldText);
        setCopiesSoldPanel.add(setCopiesSoldField);
        whereGameNamePanel.add(whereGameNameText);
        whereGameNamePanel.add(whereGameNameField);
        wherePublisherPanel.add(wherePublisherText);
        wherePublisherPanel.add(wherePublisherField);
        whereGameEditionPanel.add(whereGameEditionText);
        whereGameEditionPanel.add(whereGameEditionField);
        whereExclusiveTypePanel.add(whereExclusiveTypeText);
        whereExclusiveTypePanel.add(whereExclusiveTypeField);
        whereYearPublishedPanel.add(whereYearPublishedText);
        whereYearPublishedPanel.add(whereYearPublishedField);
        whereCopiesSoldPanel.add(whereCopiesSoldText);
        whereCopiesSoldPanel.add(whereCopiesSoldField);
        holdingPanel.add(setGameNamePanel);
        holdingPanel.add(setPublisherPanel);
        holdingPanel.add(setGameEditionPanel);
        holdingPanel.add(setExclusiveTypePanel);
        holdingPanel.add(setYearPublishedPanel);
        holdingPanel.add(setCopiesSoldPanel);
        holdingPanel.add(whereText);
        holdingPanel.add(whereGameNamePanel);
        holdingPanel.add(wherePublisherPanel);
        holdingPanel.add(whereGameEditionPanel);
        holdingPanel.add(whereExclusiveTypePanel);
        holdingPanel.add(whereYearPublishedPanel);
        holdingPanel.add(whereCopiesSoldPanel);
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
            String setGameName, setPublisher, setGameEdition, setExclusiveType, setYearPublishedString, setCopiesSoldString;
            String whereGameName, wherePublisher, whereGameEdition, whereExclusiveType, whereYearPublishedString, whereCopiesSoldString;
            int setYearPublished, setCopiesSold;
            int whereYearPublished, whereCopiesSold;
            boolean acceptedValues = false;
            //Setting strings to text from JTextFields below:
            setGameName = setGameNameField.getText();
            setPublisher = setPublisherField.getText();
            setGameEdition = setGameEditionField.getText();
            setExclusiveType = setExclusiveTypeField.getText();
            setYearPublishedString = setYearPublishedField.getText();
            setCopiesSoldString = setCopiesSoldField.getText();
            whereGameName = whereGameNameField.getText();
            wherePublisher = wherePublisherField.getText();
            whereGameEdition = whereGameEditionField.getText();
            whereExclusiveType = whereExclusiveTypeField.getText();
            whereYearPublishedString = whereYearPublishedField.getText();
            whereCopiesSoldString = whereCopiesSoldField.getText();
            //Testing for string values to translate to int values below:
            if (setYearPublishedString.equals("")) {
                setYearPublished = 0;
            }
            else {
                setYearPublished = Integer.parseInt(setYearPublishedString);
            }
            //Testing for string values to translate to int values below:
            if (setCopiesSoldString.equals("")) {
                setCopiesSold = 0;
            }
            else {
                setCopiesSold = Integer.parseInt(setCopiesSoldString);
            }
            //Testing for string values to translate to int values below:
            if (whereYearPublishedString.equals("")) {
                whereYearPublished = 0;
            }
            else {
                whereYearPublished = Integer.parseInt(whereYearPublishedString);
            }
            //Testing for string values to translate to int values below:
            if (whereCopiesSoldString.equals("")) {
                whereCopiesSold = 0;
            }
            else {
                whereCopiesSold = Integer.parseInt(whereCopiesSoldString);
            }
            //Sending strings to update game table below:
            acceptedValues = execute.updateGameTable(setGameName, setGameEdition, setPublisher, setExclusiveType, setYearPublished, setCopiesSold, whereGameName, whereGameEdition, wherePublisher, whereExclusiveType, whereYearPublished, whereCopiesSold);
            //Testing if values are accepted and disposing of frame if they are accepted below:
            if (acceptedValues == true) {
                this.dispose();
            }
            //Giving user error message if values are not accepted below:
            else {
                setText.setText("Values not accepted");
            }
        }
    }
}