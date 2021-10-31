package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Db_Home_Page extends JFrame {


    private static final long serVersUID = 1L;
    private JPanel contentPane;
    JButton logoutButton;
    JFrame frame;
    JButton stockButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Db_Home_Page frame = new Db_Home_Page();
                    frame.setVisible(true);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public Db_Home_Page() {

    }

    //The frame for the home page.
    public Db_Home_Page(String user) {
        setBounds(500, 200,1015, 600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //the company stock page
        stockButton = new JButton("Check Stock");
        stockButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        stockButton.setForeground(new Color(0, 0, 0));
        stockButton.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        stockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "Select * from stock;";



            }
        });
        stockButton.setBounds(250, 120, 490, 115);
        stockButton.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        contentPane.add(stockButton);


        //The logout button.
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        logoutButton.setForeground(new Color(0, 0, 0));
        logoutButton.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int a = JOptionPane.showConfirmDialog(logoutButton, "Are you sure you want to logout?");

                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    //only to check if working
                    System.out.println("Options are 'Yes' = 0, 'No' = 1, 'Cancel' = 2");
                    System.out.println("Values Clicked: " + a);
                    System.out.println("GoodBye.");

                    System.exit(0);
                }

                else if (a == JOptionPane.NO_OPTION) {

                    //only to check if working
                    System.out.println("Options are 'Yes' = 0, 'No' = 1, 'Cancel' = 2");
                    System.out.println("Values Clicked: " + a);
                    System.out.println("Logged In...");
                    frame.setVisible(true);
                    return;

                }



                    /*
                    String url = "https://www.google.com/";
                    try {
                        Desktop.getDesktop().browse(java.net.URI.create(url));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                     */

                    System.exit(0);
            }
        });

        logoutButton.setBounds(250, 320, 490, 115);
        logoutButton.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        contentPane.add(logoutButton);

    }
}
