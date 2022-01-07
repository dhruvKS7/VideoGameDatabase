/*
Dhruv K. Saligram
10/13/18
This class deletes data from price table
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
//Creating class with JFrame and user input below:
public class DeletePriceTable extends JFrame implements ActionListener {
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
    private JLabel amazonPriceText;
    private JLabel walmartPriceText;
    //Creating JButtons below:
    private JButton deleteData;
    //Creating JPanels below:
    private JPanel textPanel;
    private JPanel gameEditionPanel;
    private JPanel gameStopPricePanel;
    private JPanel ebayPricePanel;
    private JPanel amazonPricePanel;
    private JPanel walmartPricePanel;
    private JPanel holdingPanel;
    //Creating JTextFields below:
    private JTextField gameStopPriceField;
    private JTextField gameEditionField;
    private JTextField ebayPriceField;
    private JTextField amazonPriceField;
    private JTextField walmartPriceField;

    //Creating constructor below:
    public DeletePriceTable() {
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
        gameEditionPanel = new JPanel(new FlowLayout());
        gameEditionPanel.setBackground(COLOR);
        gameStopPricePanel = new JPanel(new FlowLayout());
        gameStopPricePanel.setBackground(COLOR);
        ebayPricePanel = new JPanel(new FlowLayout());
        ebayPricePanel.setBackground(COLOR);
        amazonPricePanel = new JPanel(new FlowLayout());
        amazonPricePanel.setBackground(COLOR);
        walmartPricePanel = new JPanel(new FlowLayout());
        walmartPricePanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Setting text, font, and color for JLabels below:
        introduction = new JLabel(" Choose data to delete: ", SwingConstants.CENTER);
        introduction.setFont(TEXT_FONT);
        introduction.setForeground(Color.WHITE);
        gameEditionText = new JLabel("Where Game Edition =");
        gameEditionText.setFont(LABEL_FONT);
        gameEditionText.setForeground(Color.WHITE);
        ebayPriceText = new JLabel("Where Ebay Price =");
        ebayPriceText.setFont(LABEL_FONT);
        ebayPriceText.setForeground(Color.WHITE);
        gameStopPriceText = new JLabel("Where GameStop Price =");
        gameStopPriceText.setFont(LABEL_FONT);
        gameStopPriceText.setForeground(Color.WHITE);
        amazonPriceText = new JLabel("Where Amazon Price =");
        amazonPriceText.setFont(LABEL_FONT);
        amazonPriceText.setForeground(Color.WHITE);
        walmartPriceText = new JLabel("Where Walmart Price =");
        walmartPriceText.setFont(LABEL_FONT);
        walmartPriceText.setForeground(Color.WHITE);
        //Creating JTextFields below:
        gameEditionField = new JTextField(8);
        ebayPriceField = new JTextField(8);
        amazonPriceField = new JTextField(8);
        gameStopPriceField = new JTextField(8);
        walmartPriceField = new JTextField(8);
        //Naming buttons and making sure they perform when clicked below:
        deleteData = new JButton("Delete Data");
        deleteData.addActionListener(this);
        //Adding to panel below:
        textPanel.add(introduction);
        gameEditionPanel.add(gameEditionText);
        gameEditionPanel.add(gameEditionField);
        ebayPricePanel.add(ebayPriceText);
        ebayPricePanel.add(ebayPriceField);
        gameStopPricePanel.add(gameStopPriceText);
        gameStopPricePanel.add(gameStopPriceField);
        amazonPricePanel.add(amazonPriceText);
        amazonPricePanel.add(amazonPriceField);
        walmartPricePanel.add(walmartPriceText);
        walmartPricePanel.add(walmartPriceField);
        holdingPanel.add(gameEditionPanel);
        holdingPanel.add(ebayPricePanel);
        holdingPanel.add(gameStopPricePanel);
        holdingPanel.add(amazonPricePanel);
        holdingPanel.add(walmartPricePanel);
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
            String gameEdition, ebayPrice, gameStopPrice, amazonPrice, walmartPrice;
            boolean acceptedValues = false;
            //Setting strings to JTextField values below:
            gameEdition = gameEditionField.getText();
            ebayPrice = ebayPriceField.getText();
            gameStopPrice = gameStopPriceField.getText();
            amazonPrice = amazonPriceField.getText();
            walmartPrice = walmartPriceField.getText();
            //Passing strings to delete data from price table below:
            acceptedValues = execute.deletePriceTable(gameEdition, ebayPrice, gameStopPrice, walmartPrice, amazonPrice);
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