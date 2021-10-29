package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Db_Sign_In extends JFrame {

    // These are needed to connect to database.
    String url = "jdbc:mysql://localhost: 3306/getting_data";
    String username = "root";
    String password = "peter";
    Connection con;

    private static final long serVersUID= 1L;
    private JTextField textF;
    private JPasswordField pwField;
    private JButton loginButton;
    private JLabel label;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Db_Sign_In frame = new Db_Sign_In();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Creating the frame.
    public Db_Sign_In() {
        setBounds(500, 200, 1000, 600);
        setResizable(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating the login label.
        JLabel loginLb = new JLabel("Login");
        loginLb.setBounds(430, 15, 280, 100);
        loginLb.setForeground(Color.BLACK);
        contentPane.add(loginLb);

        //Creating the Username label.
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(250, 165, 195, 50);
        usernameLabel.setBackground(Color.BLACK);
        usernameLabel.setForeground(Color.BLACK);
        contentPane.add(usernameLabel);

        //The username text field.
        textF = new JTextField();
        textF.setBounds(480, 170, 280, 68);
        textF.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        textF.setColumns(10);
        contentPane.add(textF);

        //The password label
        JLabel pwLabel = new JLabel("Password");
        pwLabel.setBounds(250, 286, 195, 50);
        pwLabel.setBackground(Color.BLACK);
        pwLabel.setForeground(Color.BLACK);
        contentPane.add(pwLabel);

        //The password field
        pwField = new JPasswordField();
        pwField.setBounds(481, 286, 281, 68);
        pwField.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        contentPane.add(pwField);

        //The login button
        loginButton = new JButton("Login");
        loginButton.setBounds(550, 395, 165, 55);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textF.getText();
                String pw = pwField.getText();

                // Try{}catch{} is used to connect to the database ,'getting_data', through a localhost and
                // retrieve data from a table.
                try {

                    //Opening a JDBC connection.
                    con = DriverManager.getConnection(url, username, password);

                    //Getting the login information.
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement("Select emp_name, emp_password from emp_login where emp_name=? and emp_password=?");

                    pst.setString(1, userName);
                    pst.setString(2, pw);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next()) {
                        dispose();
                        Db_Home_Page newUser =  new Db_Home_Page(userName);
                        newUser.setTitle("Database Homepage!");
                        newUser.setVisible(true);
                        JOptionPane.showMessageDialog(loginButton, "Login successful!");

                    } else {
                        JOptionPane.showMessageDialog(loginButton, "Login not successful!");
                    }
                } catch (SQLException er) {
                    er.printStackTrace();

                }
            }
        });

        contentPane.add(loginButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}
