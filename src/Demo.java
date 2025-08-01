import java.sql.*; // Importing all classes from the java.sql package for database operations
public class Demo {
    public static void main(String[] args) throws SQLException {
        // SQL query to select all columns from the Student table where the id is 20
        String sql = "select * from Student where id = 20";

        // JDBC URL to connect to the MySQL database named SchoolDb on localhost and port 3306
        String url = "jdbc:mysql://localhost:3306/SchoolDb";
        // Username for the database
        String username = "root";
        // Password for the database
        String password = "admin";
        // Establishing a connection to the database using the given URL, username, and password
        Connection con = DriverManager.getConnection(url, username, password);

        // Creating a Statement object to send SQL queries to the database
        Statement st = con.createStatement();

        // Executing the SQL query and storing the result in a ResultSet
        ResultSet resultSet = st.executeQuery(sql);
        // Moving the cursor to the first row of the result set
        resultSet.next();
        // Retrieving values from the result set using column indices
        String id = resultSet.getString(1);      // Getting the value of the 1st column (id)
        String name = resultSet.getString(2);    // Getting the value of the 2nd column (name)
        String age = resultSet.getString(3);     // Getting the value of the 3rd column (age)
        String grade = resultSet.getString(4);   // Getting the value of the 4th column (grade)
        String email = resultSet.getString(5);   // Getting the value of the 5th column (email)
        // Printing the retrieved values to the console
        System.out.println(id + " " + name + " " + age + " " + grade + " " + email);
        // Closing the connection to free database resources
        con.close();
    }
}
