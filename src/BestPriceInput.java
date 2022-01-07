/*
Dhruv K. Saligram
10/13/18
This class lets the user choose the condition under which the best price will be calculated
*/
package videogameapplication;
//Imports below:
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//Creating class with implements 
public class BestPriceInput extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font INTRODUCTION_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 35);
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 15);
    //Creating JLabels below:
    private JLabel introduction;
    //Creating JButtons below:
    private JButton exitButton;
    private JButton bestPriceButton;
    private JPanel buttonPanel;
    //Creating JPanel thought;?
    private JPanel textPanel;
    private JPanel inputPanel;
    private JLabel equalSign;
    private String[] attributes = {"Game Name", "Game Edition", "Publisher", "Exclusive Type", "Year Published"};
    private JComboBox comboTables;
    private JTextField allInput;
    //Creating local variabes below:s
    private boolean gameNameInput;
    private boolean gameEditionInput;
    private boolean exclusiveTypeInput;
    private boolean publisherInput;
    private boolean yearPublishedInput;
    //Creating constructor below:
    public BestPriceInput() {
        //Detailing setup for constructor below:
        super("Input Page");
        this.setBounds(1000, 0, 440, 200);
        this.getContentPane().setBackground(COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Making panels below:
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" BEST PRICE WHERE: ", SwingConstants.CENTER);
        introduction.setFont(INTRODUCTION_FONT);
        introduction.setForeground(Color.WHITE);
        equalSign = new JLabel("=", SwingConstants.CENTER);
        equalSign.setFont(INTRODUCTION_FONT);
        equalSign.setForeground(Color.WHITE);
        comboTables = new JComboBox(attributes);
        comboTables.addActionListener(this);
        //Naming buttons and making sure they perform when clicked below:
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        bestPriceButton = new JButton("Calculate Best Price");
        bestPriceButton.addActionListener(this);
        //Setting up JTextField below:
        allInput = new JTextField(15);
        //Setting all booleans to false as a rest below:
        gameNameInput = false;
        gameEditionInput = false;
        exclusiveTypeInput = false;
        publisherInput = false;
        yearPublishedInput = false;
        //Adding JLabels to panel below:
        textPanel.add(introduction);
        inputPanel.add(comboTables);
        inputPanel.add(equalSign);
        inputPanel.add(allInput);
        buttonPanel.add(bestPriceButton);
        buttonPanel.add(exitButton);
        //Adding panels to frame below:
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(inputPanel, FlowLayout.CENTER);
        this.add(textPanel, BorderLayout.NORTH);
        //Making frame visible below:
        this.setVisible(true);
    }
    @Override
    //Setting up what happens when something is pressed below:
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //If user exits, disposing of current frame below:
        if (command.equals("Exit")) {
            this.dispose();
        }
        //If user selects best price, programs carries out code below:
        else if (command.equals("Calculate Best Price")) {
            //Creating and initializing variables below:
            DBMySQLAccess dbObj = new DBMySQLAccess();
            dbObj.setDbConn();
            String input = allInput.getText();
            int bestPrice;
            //Testing which user given condition was used below:
            if  (comboTables.getSelectedItem() == "Game Name") {
                gameNameInput = true;
            }
            else if  (comboTables.getSelectedItem() == "Game Edition") {
                gameEditionInput = true;
            }
            else if  (comboTables.getSelectedItem() == "Publisher") {
                publisherInput = true;
            }
            else if  (comboTables.getSelectedItem() == "Exclusive Type") {
                exclusiveTypeInput = true;
            }
            else if  (comboTables.getSelectedItem() == "Year Published") {
                yearPublishedInput = true;
            }
            //Passing values to find best price below:
            BestPriceFinder findBestPrice = new BestPriceFinder();
            bestPrice = findBestPrice.calculateBestPrice(gameNameInput, gameEditionInput, publisherInput, exclusiveTypeInput, yearPublishedInput, input);
            //Resetting all booleans below:
            yearPublishedInput = false;
            gameNameInput = false;
            gameEditionInput = false;
            publisherInput = false;
            exclusiveTypeInput = false;
            //Creating object of display frame class below:
            BestPriceDisplay bestPriceDisplayFrame = new BestPriceDisplay(bestPrice);
        }
    }
}