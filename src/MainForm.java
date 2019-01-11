import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class MainForm extends JPanel
{
    JTable jt;

    // Constructors are usually used to initialize components in classes.
    // That's it. This example is a bad practice. Use functions instead for
    // production code
    public MainForm()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // Columns for table
        String[] columns = {"ФИО", "Группа", "Средний балл"};

        // 2D array is used for data in table
        String[][] data = {
                {"Семёнов Евгений Александрович", "ПЭ-171", "5"},
                {"Семёнов Евгений Александрович", "ПЭ-171", "5"},
                {"Семёнов Евгений Александрович", "ПЭ-171", "5"},
                {"Семёнов Евгений Александрович", "ПЭ-171", "5"},
        };

        // Creates Table
        jt = new JTable(data, columns)
        {
            // Determines if data can be entered by users
            public boolean isCellEditable(int data, int columns)
            {
                return false;
            }

            //  Creates cells for the table
            public Component prepareRenderer(
                    TableCellRenderer r, int data, int columns)
            {
                Component c = super.prepareRenderer(r, data, columns);

                // Every even numbers
                if (data % 2 == 0)
                    c.setBackground(Color.WHITE);

                else
                    c.setBackground(Color.LIGHT_GRAY);

                return c;
            }
        };

        // Set size of table
        jt.setPreferredScrollableViewportSize(new Dimension(450, 63));

        // This will resize the height of the table automatically
        // to all data without scrolling.
        jt.setFillsViewportHeight(true);

        JScrollPane jps = new JScrollPane(jt);
        add(jps);
        JCheckBox fullNameCheckBox = new JCheckBox("Свернуть ФИО");
        JCheckBox groupCheckBox = new JCheckBox("Свернуть группы");
        JCheckBox avgCheckBox = new JCheckBox("Свернуть средний балл");

        add(fullNameCheckBox);
        add(groupCheckBox);
        add(avgCheckBox);
        fullNameCheckBox.addActionListener(e -> {
            TableColumn col = jt.getColumnModel().getColumn(0);
            if (fullNameCheckBox.isSelected()) {
                col.setMaxWidth(0);
            }
            if(!fullNameCheckBox.isSelected()){
                col.setMaxWidth(200);
                col.setWidth(200);
                col.setPreferredWidth(200);
                col.setMaxWidth(200);
            }
        });
        groupCheckBox.addActionListener(e -> {
            TableColumn col = jt.getColumnModel().getColumn(1);
            if (groupCheckBox.isSelected()) {
                col.setMaxWidth(0);
            }
            if(!groupCheckBox.isSelected()){
                col.setMaxWidth(200);
                col.setWidth(200);
                col.setPreferredWidth(200);
                col.setMaxWidth(200);
            }
        });
        avgCheckBox.addActionListener(e -> {
            TableColumn col = jt.getColumnModel().getColumn(2);
            if (avgCheckBox.isSelected()) {
                col.setMaxWidth(0);
            }
            if(!avgCheckBox.isSelected()){
                col.setMaxWidth(200);
                col.setWidth(200);
                col.setPreferredWidth(200);
                col.setMaxWidth(200);
            }
        });


    }

    // Creates Window
    public static void main(String[] args)
    {
        JFrame jf = new JFrame("Some title");
        MainForm t = new MainForm();
        jf.setSize(900, 900);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
//        jf.add(italicBox);
    }
}