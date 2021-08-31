import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Getting_Data {
    public static void main(String[] args) {

        // Try{}catch{} is used to connect to the database ,'getting_data', through a localhost and
        // retrieve data from a table.
        try {

            // These are needed to connect to database.
            String url = "jdbc:mysql://localhost: 3306/getting_data";
            String username = "root";
            String password = "peter";

            //Opening a JDBC connection.
            Connection con = DriverManager.getConnection(url, username, password);

            // Statement is the object used to execute a SQL statement and returns the result.
            // This line creates the statement "st".
            Statement st = con.createStatement();

            // ResultSet is a table of data representing a database result set.
            // It is created by executing a SQL query.
            // Here we create the ResultSet, rs, followed by st.executeQuery.
            ResultSet rs = st.executeQuery("select * from employee;");


            while (rs.next()) {
                // Here we create variables according to the table column names, and
                // the appropriate data type. rs.getInt/String("column_name_in_database");
                int id = rs.getInt("emp_id");
                String fName = rs.getString("emp_f_name");
                String lName = rs.getString("emp_l_name");
                String dob = rs.getString("emp_dob");

                //Format the output.
                System.out.format("%s, %s %s, %s\n", id, fName, lName, dob);

            }

            con.close();
        }catch (Exception e) {
            //The printStackTrace() method is used to handle exceptions and errors.
            e.printStackTrace();

        }
    }
}