/*
Dhruv K. Saligram
10/13/18
This class displays the lowest price in a JFrame
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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//Creating class below:
public class BestPriceDisplay extends JFrame implements ActionListener {
    //Creating color below:
    private final Color COLOR = new Color(12, 69, 89);
    //Creating font below:
    private final Font TEXT_FONT = new Font("Merriweather", Font.BOLD | Font.ITALIC, 45);
    //Creating JLabels below:
    private JLabel answerText;
    //Creating JButtons below:
    private JButton exitButton;
    //Creating JPanels below:
    private JPanel buttonPanel;
    private JPanel textPanel;
    //Creating constructor below:
    public BestPriceDisplay(int answer) {
        //Detailing setup for constructor below:
        super("Answer Display");
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
        answerText = new JLabel(" Lowest Price: $" + answer + " ", SwingConstants.CENTER);
        answerText.setFont(TEXT_FONT);
        answerText.setForeground(Color.WHITE);
        //Naming buttons and making sure they perform when clicked below:
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        //Adding JLabels and JButtons to panel below:
        textPanel.add(answerText);
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
        //If close is clicked, the frame is disposed of below:
        if (command.equals("Exit")) {
            this.dispose();
        }
    }
}
