/*
Dhruv K. Saligram
10/13/18
This class allows the user to update the price table
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
//Creating class to extend JFrame and allow for user input below:
public class UpdatePriceTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel setText;
    private JLabel setAmazonPriceText;
    private JLabel setGameEditionText;
    private JLabel setGameStopPriceText;
    private JLabel setWalmartPriceText;
    private JLabel setEbayPriceText;
    private JLabel whereText;
    private JLabel whereAmazonPriceText;
    private JLabel whereGameStopPriceText;
    private JLabel whereGameEditionText;
    private JLabel whereEbayPriceText;
    private JLabel whereWalmartPriceText;
    //Creating JButtons below:
    private JButton updateData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel setGameEditionPanel;
    private JPanel setAmazonPricePanel;
    private JPanel setGameStopPricePanel;
    private JPanel setWalmartPricePanel;
    private JPanel setEbayPricePanel;
    private JPanel holdingPanel;
    private JPanel whereAmazonPricePanel;
    private JPanel whereGameEditionPanel;
    private JPanel whereGameStopPricePanel;
    private JPanel whereEbayPricePanel;
    private JPanel whereWalmartPricePanel;
    //Creating JTextFields below:
    private JTextField setGameEditionField;
    private JTextField setAmazonPriceField;
    private JTextField setGameStopPriceField;
    private JTextField setWalmartPriceField;
    private JTextField setEbayPriceField;
    private JTextField whereGameEditionField;
    private JTextField whereAmazonPriceField;
    private JTextField whereGameStopPriceField;
    private JTextField whereEbayPriceField;
    private JTextField whereWalmartPriceField;
    //Creating constructor below:
    public UpdatePriceTable() {
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
        setGameEditionPanel = new JPanel(new FlowLayout());
        setGameEditionPanel.setBackground(COLOR);
        setAmazonPricePanel = new JPanel(new FlowLayout());
        setAmazonPricePanel.setBackground(COLOR);
        setGameStopPricePanel = new JPanel(new FlowLayout());
        setGameStopPricePanel.setBackground(COLOR);
        setWalmartPricePanel = new JPanel(new FlowLayout());
        setWalmartPricePanel.setBackground(COLOR);
        setEbayPricePanel = new JPanel(new FlowLayout());
        setEbayPricePanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        whereAmazonPricePanel = new JPanel(new FlowLayout());
        whereAmazonPricePanel.setBackground(COLOR);
        whereGameEditionPanel = new JPanel(new FlowLayout());
        whereGameEditionPanel.setBackground(COLOR);
        whereGameStopPricePanel = new JPanel(new FlowLayout());
        whereGameStopPricePanel.setBackground(COLOR);
        whereEbayPricePanel = new JPanel(new FlowLayout());
        whereEbayPricePanel.setBackground(COLOR);
        whereWalmartPricePanel = new JPanel(new FlowLayout());
        whereWalmartPricePanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        setText = new JLabel(" SET: ", SwingConstants.CENTER);
        setText.setFont(TEXT_FONT);
        setText.setForeground(Color.WHITE);
        whereText = new JLabel(" WHERE: ", SwingConstants.CENTER);
        whereText.setFont(TEXT_FONT);
        whereText.setForeground(Color.WHITE);
        setGameEditionText = new JLabel("  Game Edition =");
        setGameEditionText.setFont(LABEL_FONT);
        setGameEditionText.setForeground(Color.WHITE);
        setAmazonPriceText = new JLabel("       Amazon Price =");
        setAmazonPriceText.setFont(LABEL_FONT);
        setAmazonPriceText.setForeground(Color.WHITE);
        setGameStopPriceText = new JLabel("GameStop Price =");
        setGameStopPriceText.setFont(LABEL_FONT);
        setGameStopPriceText.setForeground(Color.WHITE);
        setWalmartPriceText = new JLabel("Walmart Price =");
        setWalmartPriceText.setFont(LABEL_FONT);
        setWalmartPriceText.setForeground(Color.WHITE);
        setEbayPriceText = new JLabel("     Ebay Price  =");
        setEbayPriceText.setFont(LABEL_FONT);
        setEbayPriceText.setForeground(Color.WHITE);
        whereAmazonPriceText = new JLabel("     Amazon Price =");
        whereAmazonPriceText.setFont(LABEL_FONT);
        whereAmazonPriceText.setForeground(Color.WHITE);
        whereGameEditionText = new JLabel("  Game Edition =");
        whereGameEditionText.setFont(LABEL_FONT);
        whereGameEditionText.setForeground(Color.WHITE);
        whereGameStopPriceText = new JLabel("       GameStop Price =");
        whereGameStopPriceText.setFont(LABEL_FONT);
        whereGameStopPriceText.setForeground(Color.WHITE);
        whereEbayPriceText = new JLabel("Ebay Price =");
        whereEbayPriceText.setFont(LABEL_FONT);
        whereEbayPriceText.setForeground(Color.WHITE);
        whereWalmartPriceText = new JLabel("Walmart Price =");
        whereWalmartPriceText.setFont(LABEL_FONT);
        whereWalmartPriceText.setForeground(Color.WHITE);
        //Creating JTextFields below:
        setAmazonPriceField = new JTextField(8);
        setGameStopPriceField = new JTextField(8);
        setGameEditionField = new JTextField(8);
        setWalmartPriceField = new JTextField(8);
        setEbayPriceField = new JTextField(8);
        whereAmazonPriceField = new JTextField(8);
        whereGameStopPriceField = new JTextField(8);
        whereEbayPriceField = new JTextField(8);
        whereGameEditionField = new JTextField(8);
        whereWalmartPriceField = new JTextField(8);
        //Naming buttons and making sure they perform when clicked below:
        updateData = new JButton("Update Data");
        updateData.addActionListener(this);
        //Adding JTextField and JLabels to panel below:
        textPanel.add(setText);
        setAmazonPricePanel.add(setAmazonPriceText);
        setAmazonPricePanel.add(setAmazonPriceField);
        setGameEditionPanel.add(setGameEditionText);
        setGameEditionPanel.add(setGameEditionField);
        setGameStopPricePanel.add(setGameStopPriceText);
        setGameStopPricePanel.add(setGameStopPriceField);
        setWalmartPricePanel.add(setWalmartPriceText);
        setWalmartPricePanel.add(setWalmartPriceField);
        setEbayPricePanel.add(setEbayPriceText);
        setEbayPricePanel.add(setEbayPriceField);
        whereAmazonPricePanel.add(whereAmazonPriceText);
        whereAmazonPricePanel.add(whereAmazonPriceField);
        whereGameStopPricePanel.add(whereGameStopPriceText);
        whereGameStopPricePanel.add(whereGameStopPriceField);
        whereGameEditionPanel.add(whereGameEditionText);
        whereGameEditionPanel.add(whereGameEditionField);
        whereEbayPricePanel.add(whereEbayPriceText);
        whereEbayPricePanel.add(whereEbayPriceField);
        whereWalmartPricePanel.add(whereWalmartPriceText);
        whereWalmartPricePanel.add(whereWalmartPriceField);
        holdingPanel.add(setAmazonPricePanel);
        holdingPanel.add(setGameEditionPanel);
        holdingPanel.add(setGameStopPricePanel);
        holdingPanel.add(setWalmartPricePanel);
        holdingPanel.add(setEbayPricePanel);
        holdingPanel.add(whereText);
        holdingPanel.add(whereAmazonPricePanel);
        holdingPanel.add(whereGameStopPricePanel);
        holdingPanel.add(whereGameEditionPanel);
        holdingPanel.add(whereEbayPricePanel);
        holdingPanel.add(whereWalmartPricePanel);
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
        //If update is selected, program carries out code below:
        if (command.equals("Update Data")) {
            //Creating object of command class below:
            DatabaseCommands execute = new DatabaseCommands();
            //Creating and initializing variables below:
            String setAmazonPrice, setGameEdition, setGameStopPrice, setWalmartPrice, setEbayPrice;
            String whereAmazonPrice, whereGameStopPrice, whereGameEdition, whereEbayPrice, whereWalmartPrice;
            boolean acceptedValues = false;
            //Setting strings to text from text fields below:
            setAmazonPrice = setAmazonPriceField.getText();
            setGameEdition = setGameEditionField.getText();
            setGameStopPrice = setGameStopPriceField.getText();
            setWalmartPrice = setWalmartPriceField.getText();
            setEbayPrice = setEbayPriceField.getText();
            whereAmazonPrice = whereAmazonPriceField.getText();
            whereGameStopPrice = whereGameStopPriceField.getText();
            whereGameEdition = whereGameEditionField.getText();
            whereEbayPrice = whereEbayPriceField.getText();
            whereWalmartPrice = whereWalmartPriceField.getText();
            //Sending strings to update price table below:
            acceptedValues = execute.updatePriceTable(setGameEdition, setEbayPrice, setGameStopPrice, setWalmartPrice, setAmazonPrice, whereGameEdition, whereEbayPrice, whereGameStopPrice, whereWalmartPrice, whereAmazonPrice);
            //Checking if values were accepted below, and disposing of frame if values are correct below:
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