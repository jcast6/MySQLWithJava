package Main;

import java.sql.*;

public class Getting_Data {

    public static void main(String[] args) {

        // These are needed to connect to database.
        String url = "jdbc:mysql://localhost: 3306/getting_data";
        String username = "root";
        String password = "peter";

        Connection con = null;

        Statement st = null;
        Statement st2 = null;

        ResultSet rs = null;
        ResultSet rs2 = null;

        // Try{}catch{} is used to connect to the database ,'getting_data', through a localhost and
        // retrieve data from a table.
        try {

            //Opening a JDBC connection.
            con = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            e.printStackTrace();

        }
        try {

            // Statement is the object used to execute a SQL statement and returns the result.
            // This line creates the statement "st".
            assert con != null;
            st = con.createStatement();

            // ResultSet is a table of data representing a database result set.
            // It is created by executing a SQL query.
            // Here we create the ResultSet, rs, followed by st.executeQuery.
            rs = st.executeQuery("select * from employee;");

            System.out.println("Table 1: ");
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
        } catch (SQLException e) {

            //The printStackTrace() method is used to handle exceptions and errors.
            e.printStackTrace();

        }
        try {

            st2 = con.createStatement();

            rs2 = st2.executeQuery("select * from people;");

            System.out.println("\nTable 2: ");
            while (rs2.next()) {
                // Here we create variables according to the table column names, and
                // the appropriate data type. rs.getInt/String("column_name_in_database");
                int id = rs2.getInt("id");
                String fName = rs2.getString("f_name");
                String lName = rs2.getString("l_name");
                String address = rs2.getString("address");
                String employer = rs2.getString("employer");

                //Format the output.
                System.out.format("%s, %s %s, %s\n", id, fName, lName, address, employer);

            }
        } catch (SQLException e) {

            //The printStackTrace() method is used to handle exceptions and errors.
            e.printStackTrace();

        }
        finally { //Closing all connections.
            if(rs2 != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(st2 != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}