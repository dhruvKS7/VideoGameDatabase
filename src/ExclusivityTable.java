/*
Dhruv K. Saligram
10/13/18
This class displays the exclusivity table
*/
package videogameapplication;
//Imports below:
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
//Creating class with JFrame and user input below:
public class ExclusivityTable extends JFrame implements ActionListener {
    //Declarations below:
    private JButton closeButton;
    private final String[] COLUMN_NAMES = {"Exclusive Type", "PS4 Compatability", "XBox One Compatibility", "PC Compatibility"};
    private final Color COLOR = new Color(12, 69, 89);
    private JTable gameInfoTable;
    private JScrollPane tablePane;
    private JTableHeader header;
    private TableColumn column;
    private JPanel buttonPanel;
    //Setting up contructor with parameters below:
    public ExclusivityTable(Object[][] displayTable) {
        //Creating setup of frame below:
        super("Exclusivity");
        this.setBounds(0, 690, 1000, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        closeButton = new JButton("Close Table");
        closeButton.addActionListener(this);
        //Making panel below:
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(COLOR);
        buttonPanel.add(closeButton);
        //Creating JTable below:
        gameInfoTable = new JTable(displayTable, COLUMN_NAMES);
        gameInfoTable.setForeground(Color.WHITE);
        gameInfoTable.setGridColor(Color.WHITE);
        gameInfoTable.setBackground(COLOR);
        //Setting JTable Header below:
        header = gameInfoTable.getTableHeader();
        header.setBackground(Color.GRAY);
        header.setForeground(Color.WHITE);
        column = null;
        column = gameInfoTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(20);
        column = gameInfoTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(200);
        gameInfoTable.setRowHeight(70);
        tablePane = new JScrollPane();
        tablePane.getViewport().add(gameInfoTable);
        gameInfoTable.setFillsViewportHeight(true);
        //Adding panel and JTable to frame below:
        this.add(tablePane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //If user closes tables, disposes of current frame below:
        if (command.equals("Close Table")) {
            this.dispose();
        }
    }
}
