package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StockPage extends JFrame {

    private static final long serVersUID= 1L;
    JPanel contentPane;
    JButton stockButton1;

    public StockPage() {
        setBounds(500, 200, 1000, 600);
        setResizable(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //the company stock page
        stockButton1 = new JButton("Check Stock");
        stockButton1.setBackground(UIManager.getColor("Button.disabledForeground"));
        stockButton1.setForeground(new Color(0, 0, 0));
        stockButton1.setFont(new Font("Times New Roman", Font.ITALIC, 40));
        contentPane.add(stockButton1);


    }

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



}
