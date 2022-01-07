/*
Dhruv K. Saligram
10/13/18
This class allows the user to choose which database command to execute
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
import javax.swing.SwingConstants;
//Creating class with JFrame and user input below:
public class CommandFrame extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font INTRODUCTION_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 45);
    //Creating JLabels below:
    private JLabel introduction;
    //Creating JButtons below:
    private JButton viewButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton insertButton;
    private JButton exitButton;
    private JButton bestPriceButton;
    //Creating JPanel below:
    private JPanel buttonPanel;
    private JPanel textPanel;
    //Declaring variables for JComboBox below:
    private String[] tables = {"Game Table", "Price Table", "Compatibility Table"};
    private JComboBox comboTables;
    //Creating objects of display classes below:
    private GameTable gameInfoFrame;
    private PriceTable priceInfoFrame;
    private ExclusivityTable exclusivityInfoFrame;
    //Creating booleans below:
    private boolean firstGameTable;
    private boolean firstPriceTable;
    private boolean firstExclusivityTable;
    //Creating constructor below:
    public CommandFrame() {
        //Detailing setup for constructor below:
        super("Command Page");
        this.setBounds(0, 0, 1000, 200);
        this.getContentPane().setBackground(COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Making panels below:
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" DATABASE COMMANDS ", SwingConstants.CENTER);
        introduction.setFont(INTRODUCTION_FONT);
        introduction.setForeground(Color.WHITE);
        //Creating JComboBox below:
        comboTables = new JComboBox(tables);
        comboTables.addActionListener(this);
        //Naming buttons and making sure they perform when clicked below:
        viewButton = new JButton("View");
        viewButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        insertButton = new JButton("Insert");
        insertButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        bestPriceButton = new JButton("Best Price");
        bestPriceButton.addActionListener(this);
        //Setting booleans to true below:
        firstGameTable = true;
        firstPriceTable = true;
        firstExclusivityTable = true;
        //Adding JLabels to panel below:
        textPanel.add(introduction);
        buttonPanel.add(comboTables);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(insertButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(bestPriceButton);
        //Adding panels to frame below:
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(textPanel, FlowLayout.CENTER);
        //Making frame visible below:
        this.setVisible(true);
    }
    @Override
    //Setting up what happens when something is pressed below:
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //If user exits, disposing of frame below:
        if (command.equals("Exit")) {
            this.dispose();
        }
        //Testing if user selected view below:
        else if (command.equals("View")) {
            //Creating connection to database below:
            DBMySQLAccess dbObj = new DBMySQLAccess("videoGameDB");
            dbObj.setDbConn();
            Object[][] data;
            //Testing if user wants to view from game table below:
            if (comboTables.getSelectedItem() == "Game Table") {
                String[] tableAttributes = {"gameName", "gameEdition", "publisher", "exclusiveType", "yearPublished", "copiesSold"};
                data = dbObj.getData("gameInfo", tableAttributes);
                //Testing if it is the first time user has opened frame below:
                if (firstGameTable == true) {
                    gameInfoFrame = new GameTable(data);
                    firstGameTable = false;
                }
                else {
                    gameInfoFrame.dispose();
                    gameInfoFrame = new GameTable(data);
                }
            }
            //Testing if user wants to view from price table below:
            else if (comboTables.getSelectedItem() == "Price Table") {
                String[] tableAttributes = {"gameEdition", "gameStopPrice", "ebayPrice", "amazonPrice", "walmartPrice"};
                data = dbObj.getData("priceInfo", tableAttributes);
                //Testing if it is the first time user has opened frame below:
                if (firstPriceTable == true) {
                    priceInfoFrame = new PriceTable(data);
                    firstPriceTable = false;
                }
                else {
                    priceInfoFrame.dispose();
                    priceInfoFrame = new PriceTable(data);
                }
            }
            //Testing if user wants to view from exclusivity table below:
            else if (comboTables.getSelectedItem() == "Compatibility Table") {
                String[] tableAttributes = {"exclusiveType", "ps4Compatibility", "xboxOneCompatibility", "pcCompatibility"};
                data = dbObj.getData("exclusivity", tableAttributes);
                //Testing if it is the first time user has opened frame below:
                if (firstExclusivityTable == true) {
                    exclusivityInfoFrame = new ExclusivityTable(data);
                    firstExclusivityTable = false;
                }
                else {
                    exclusivityInfoFrame.dispose();
                    exclusivityInfoFrame = new ExclusivityTable(data);
                }
            }
        }
        //Testing if user selected delete command below:
        else if (command.equals("Delete")) {
            //Creating connection to database below:
            DBMySQLAccess dbObj = new DBMySQLAccess();
            dbObj.setDbConn();
            //Testing if user selected game table below:
            if (comboTables.getSelectedItem() == "Game Table") {
                //Creating object of frame class below:
                DeleteGameTable deleteGameTableFrame = new DeleteGameTable();
            }
            //Testing if user selected price table below:
            else if (comboTables.getSelectedItem() == "Price Table") {
                //Creating object of frame class below:
                DeletePriceTable deletePriceTableFrame = new DeletePriceTable();
            }
            //Testing if user selected exclusivity table below:
            else if (comboTables.getSelectedItem() == "Compatibility Table") {
                //Creating object of frame class below:
                DeleteExclusivityTable deleteExclusivityTableFrame = new DeleteExclusivityTable();
            }
        }
        //Testing if user selected update command below:
        else if (command.equals("Update")) {
            //Creaing connection to database below:
            DBMySQLAccess dbObj = new DBMySQLAccess();
            dbObj.setDbConn();
            //Testing if user selected game table below:
            if (comboTables.getSelectedItem() == "Game Table") {
                //Creating object of frame class below:
                UpdateGameTable updateGameTableFrame = new UpdateGameTable();
            }
            //Testing if user selected price table below:
            else if (comboTables.getSelectedItem() == "Price Table") {
                //Creating object of frame class below:
                UpdatePriceTable updatePriceTableFrame = new UpdatePriceTable();
            }
            //Testing if user selected exclusivity table below:
            else if (comboTables.getSelectedItem() == "Compatibility Table") {
                //Creating object of frame class below:
                UpdateExclusivityTable updateExclusivityTableFrame = new UpdateExclusivityTable();
            }
        }
        //Testing if user selected insert command below:
        else if (command.equals("Insert")) {
            //Testing if user selected game table below:
            if (comboTables.getSelectedItem() == "Game Table") {
                //Creating object of frame class below:
                InsertGameTable insertGameInfoFrame = new InsertGameTable();
            }
            //Testing if user selected price table below:
            else if (comboTables.getSelectedItem() == "Price Table") {
                //Creating object of frame class below:
                InsertPriceTable insertPriceInfoFrame = new InsertPriceTable();
            }
            //Testing if user selected exclusivity table below:
            else if (comboTables.getSelectedItem() == "Compatibility Table") {
                //Creating object of frame class below:
                InsertExclusivityTable insertExclusivityInfoFrame = new InsertExclusivityTable();
            }
        }
        //Testing if user selected best price command below:
        else if (command.equals("Best Price")) {
            //Creating object of frame class below:
            BestPriceInput bestPriceInputFrame = new BestPriceInput();
        }
    }
}