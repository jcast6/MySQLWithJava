package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StockPage extends JFrame {
    JPanel contentPane;
    JButton displayStock;
    JFrame frame;
    JButton stockButton1;

    // These are needed to connect to database.
    String url = "jdbc:mysql://localhost: 3306/getting_data";
    String username = "root";
    String password = "peter";
    Connection con;
    Statement st1;
    ResultSet rs1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StockPage frame = new StockPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StockPage() {

    }

    //The frame for the stock page.
    public StockPage(String user) {
        setBounds(500, 200, 1015, 600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //the company stock page
        stockButton1 = new JButton("Display all inventory");
        stockButton1.setBounds(430, 15, 280, 100);
        stockButton1.setBackground(UIManager.getColor("Button.disabledForeground"));
        stockButton1.setForeground(new Color(0, 0, 0));
        stockButton1.setFont(new Font("Times New Roman", Font.TYPE1_FONT, 15));
        contentPane.add(stockButton1);
        stockButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(stockButton1, "All stock", "All inventory", JOptionPane.YES_NO_OPTION);

                if (a == JOptionPane.YES_OPTION) {
                    try {

                        con = DriverManager.getConnection(url, username, password);

                        // Statement is the object used to execute a SQL statement and returns the result.
                        // This line creates the statement "st".
                        st1 = con.createStatement();

                        // ResultSet is a table of data representing a database result set.
                        // It is created by executing a SQL query.
                        // Here we create the ResultSet, rs, followed by st.executeQuery.
                        rs1 = st1.executeQuery("select * from stock_inventory;");

                        String columns[] = {"SKU", "product_name"};
                        String data[][] = new String[200][5];

                        int i = 0;

                        while(rs1.next()) {
                            String sku = rs1.getString("SKU");
                            String prod_name = rs1.getString("product_name");
                            data[i][0] = sku;
                            data[i][1] = prod_name;
                            i++;
                        }

                        DefaultTableModel newTable = new DefaultTableModel(data, columns);
                        JTable table = new JTable(newTable);
                        table.setShowGrid(true);
                        table.setShowVerticalLines(true);
                        JScrollPane pane = new JScrollPane(table);
                        JFrame f = new JFrame("Populate the table from database");
                        JPanel panel = new JPanel();
                        panel.add(pane);
                        f.add(panel);
                        f.setSize(500, 300);
                        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f.setVisible(true);


                        /**
                         *
                         * This will be displayed in the console not gui.
                         *
                        System.out.println("Stock: ");
                        while (rs1.next()) {
                            // Here we create variables according to the table column names, and
                            // the appropriate data type. rs.getInt/String("column_name_in_database");
                            String sku = rs1.getString("SKU");
                            String product_name = rs1.getString("product_name");


                            //Format the output.
                            System.out.format("%s, %s\n", sku, product_name);

                        }
                         */
                    } catch (SQLException ec) {

                        //The printStackTrace() method is used to handle exceptions and errors.
                        ec.printStackTrace();

                    }
                    //only to check if working
                    System.out.println("Options are 'Yes' = 0, 'No' = 1,");
                    System.out.println("Values Clicked: " + a);
                    System.out.println("All stock displayed.");

                } else if (a == JOptionPane.NO_OPTION) {

                    //only to check if working
                    System.out.println("Options are 'Yes' = 0, 'No' = 1");
                    System.out.println("Values Clicked: " + a);
                    System.out.println("Goodbye!");

                }
            }
        });
    }
}
