/*
Dhruv K. Saligram
10/13/18
This class inserts into price table
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
public class InsertPriceTable extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 30);
    private final Font LABEL_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 20);
    //Creating JLabels below:
    private JLabel introduction;
    private JLabel gameEditionText;
    private JLabel ebayPriceText;
    private JLabel gameStopPriceText;
    private JLabel walmartPriceText;
    private JLabel amazonPriceText;
    //Creating JButtons below:
    private JButton insertData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel gameEditionPanel;
    private JPanel gameStopPricePanel;
    private JPanel ebayPricePanel;
    private JPanel walmartPricePanel;
    private JPanel amazonPricePanel;
    private JPanel holdingPanel;
    //Creating JTextFields below:
    private JTextField gameStopPriceField;
    private JTextField gameEditionField;
    private JTextField ebayPriceField;
    private JTextField walmartPriceField;
    private JTextField amazonPriceField;
    //Creating constructor below:
    public InsertPriceTable() {
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
        gameEditionPanel = new JPanel(new FlowLayout());
        gameEditionPanel.setBackground(COLOR);
        gameStopPricePanel = new JPanel(new FlowLayout());
        gameStopPricePanel.setBackground(COLOR);
        ebayPricePanel = new JPanel(new FlowLayout());
        ebayPricePanel.setBackground(COLOR);
        walmartPricePanel = new JPanel(new FlowLayout());
        walmartPricePanel.setBackground(COLOR);
        amazonPricePanel = new JPanel(new FlowLayout());
        amazonPricePanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" Insert your data below: ", SwingConstants.CENTER);
        introduction.setFont(TEXT_FONT);
        introduction.setForeground(Color.WHITE);
        gameEditionText = new JLabel("    Game Edition: ");
        gameEditionText.setFont(LABEL_FONT);
        gameEditionText.setForeground(Color.WHITE);
        ebayPriceText = new JLabel("        Ebay Price: ");
        ebayPriceText.setFont(LABEL_FONT);
        ebayPriceText.setForeground(Color.WHITE);
        gameStopPriceText = new JLabel("GameStop Price: ");
        gameStopPriceText.setFont(LABEL_FONT);
        gameStopPriceText.setForeground(Color.WHITE);
        walmartPriceText = new JLabel("   Walmart Price:");
        walmartPriceText.setFont(LABEL_FONT);
        walmartPriceText.setForeground(Color.WHITE);
        amazonPriceText = new JLabel("    Amazon Price: ");
        amazonPriceText.setFont(LABEL_FONT);
        amazonPriceText.setForeground(Color.WHITE);
        //Creating JTextFields below:
        gameEditionField = new JTextField(15);
        ebayPriceField = new JTextField(15);
        walmartPriceField = new JTextField(15);
        amazonPriceField = new JTextField(15);
        gameStopPriceField = new JTextField(15);
        //Naming buttons and making sure they perform when clicked below:
        insertData = new JButton("Insert Data");
        insertData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(introduction);
        gameEditionPanel.add(gameEditionText);
        gameEditionPanel.add(gameEditionField);
        ebayPricePanel.add(ebayPriceText);
        ebayPricePanel.add(ebayPriceField);
        gameStopPricePanel.add(gameStopPriceText);
        gameStopPricePanel.add(gameStopPriceField);
        walmartPricePanel.add(walmartPriceText);
        walmartPricePanel.add(walmartPriceField);
        amazonPricePanel.add(amazonPriceText);
        amazonPricePanel.add(amazonPriceField);
        holdingPanel.add(gameEditionPanel);
        holdingPanel.add(ebayPricePanel);
        holdingPanel.add(gameStopPricePanel);
        holdingPanel.add(walmartPricePanel);
        holdingPanel.add(amazonPricePanel);
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
            String gameEdition, ebayPrice, gameStopPrice, walmartPrice, amazonPrice;
            boolean acceptedValues = false;
            //Setting strings to text from JTextFields below:
            gameEdition = gameEditionField.getText();
            ebayPrice = ebayPriceField.getText();
            gameStopPrice = gameStopPriceField.getText();
            walmartPrice = walmartPriceField.getText();
            amazonPrice = amazonPriceField.getText();
            //Sending strings to insert into price table below:
            acceptedValues = execute.insertPriceTable(gameEdition, ebayPrice, gameStopPrice, walmartPrice, amazonPrice);
            //Testing if values are accepted and disposing of current frame if values are accepted below:
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