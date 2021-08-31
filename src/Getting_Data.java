import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Getting_Data {
    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://localhost: 3306/getting_data";
            String username = "root";
            String password = "peter";
            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from employee;");

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String fName = rs.getString("emp_f_name");
                String lName = rs.getString("emp_l_name");
                String dob = rs.getString("emp_dob");

                System.out.format("%s, %s %s, %s\n", id, fName, lName, dob);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}