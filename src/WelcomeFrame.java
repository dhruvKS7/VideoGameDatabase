/*
Dhruv K. Saligram
10/13/18
This class welcomes the user to the database application
Pseudocoode:
    1. Create database and tables
    2. Give user access to 4 other commands + computation command
Delete:
    1. Prompt user which data to delete
    2. Reference command method to delete data
Insert:
    1. Prompt user which data to insert
    2. Reference command method to insert data
Update:
    1. Prompt user which data to update
    2. Reference command method to update data
Best Price:
    1. Prompt user which data to ues for condition
    2. Reference command method to calculate lowest price based on given condition
*/
package videogameapplication;
//Imports below:
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//Creating class to implement JFrame and allow user interaction below:
public class WelcomeFrame extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 45);
    //Creating and sizing image below:
    private final java.net.URL FIRST_IMAGE = getClass().getResource("welcomeImage.png");
    private final ImageIcon WELCOME_PICTURE = new ImageIcon(new ImageIcon(FIRST_IMAGE).getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
    //Creating JLabels below:
    private JLabel introduction1;
    private JLabel introduction2;
    private JLabel introduction3;
    private JLabel introduction4;
    private JLabel imageLabel;
    //Creating JButtons below:
    private JButton startButton;
    private JButton exitButton;
    private JPanel buttonPanel;
    private JPanel textPanel;
    //Creating constructor below:
    public WelcomeFrame() {
        //Detailing setup for constructor below:
        super("Welcome Page");
        this.setBounds(0, 0, 1440, 900);
        this.getContentPane().setBackground(COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Making panels below:
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(COLOR);
        textPanel = new JPanel(new FlowLayout());
        textPanel.setBackground(COLOR);
        //Putting image in label below:
        imageLabel = new JLabel(WELCOME_PICTURE);
        //Setting text, font, and color for JLabels below:
        introduction1 = new JLabel(" Welcome! My name is Dhruv! This application accesess a ", SwingConstants.CENTER);
        introduction1.setFont(TEXT_FONT);
        introduction1.setForeground(Color.WHITE);
        introduction2 = new JLabel("database that holds", SwingConstants.CENTER);
        introduction2.setFont(TEXT_FONT);
        introduction2.setForeground(Color.WHITE);
        introduction3 = new JLabel(" information about various ", SwingConstants.CENTER);
        introduction3.setFont(TEXT_FONT);
        introduction3.setForeground(Color.WHITE);
        introduction4 = new JLabel("games! ", SwingConstants.CENTER);
        introduction4.setFont(TEXT_FONT);
        introduction4.setForeground(Color.WHITE);
        //Naming buttons and making sure they perform when clicked below:
        startButton = new JButton("Access Database");
        startButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        //Adding JLabels to panel below:
        textPanel.add(introduction1);
        textPanel.add(introduction2);
        textPanel.add(introduction3);
        textPanel.add(introduction4);
        textPanel.add(imageLabel);
        //Adding JButton to panel below:
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
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
        //If exit is clicked, disposing current frame below:
        if (command.equals("Exit")) {
            this.dispose();
        }
        //If the user wants to access the database, a new frame is created and this frame is disposed of below:
        else if (command.equals("Access Database")) {
            this.dispose();
            CommandFrame objFrame2 = new CommandFrame();
        }
    }
    //Main class to create first frame below:
    public static void main(String[] args) {
        WelcomeFrame objFrame1 = new WelcomeFrame();
    }
}