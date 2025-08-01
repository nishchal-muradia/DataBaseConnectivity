import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/SchoolDb";
    static final String USERNAME = "root";
    static final String PASSWORD = "admin";


    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //1. CREATE : Insert a new Student;

    static void createStudent(String name, int age, String grade, String email) throws SQLException {
        String sql = "INSERT INTO Student (name, age, grade, email) VALUES (?,?,?,?)";
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, grade);
            pst.setString(4, email);
            pst.executeUpdate();

            System.out.println("Student inserted Successfully");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            con.close();
        }
    }


    public static void getStudentById(int id) throws SQLException {

        // Raw SQL query to execute
        String sql = "Select * from Student where id = ?";

        // create the database connection
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // prepare statement
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);

        // execute statement
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Grade: " + rs.getString("grade"));
            System.out.println("Email: " + rs.getString("email"));
        } else {
            System.out.println("Student not found!");
        }

        con.close();

    }


    public static void updateStudentName(int id, String newName) throws SQLException {
        String sql = "UPDATE STUDENT SET name = ? where id = ?";

        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, newName);
        pst.setInt(2, id);

        int rows = pst.executeUpdate();
        System.out.println(rows + "row(s) updated");
        con.close();
    }


    public static void deleteStudent(int id) throws SQLException {
        String sql = "DELETE From Student where id =?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        int rows = pst.executeUpdate();
        System.out.println(rows + "row(s) deleted.");
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Student CRUD Operation Menu ======");
            System.out.println("1. Add Student");
            System.out.println("2. get Student By ID");
            System.out.println("3. Update Student Name");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Name: ");
                    String name = sc.next();

                    System.out.println("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Grade: ");
                    String grade = sc.nextLine();

                    System.out.println("Email: ");
                    String email = sc.nextLine();

                    createStudent(name, age, grade, email);

                }
                case 2 -> {
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    getStudentById(id);

                }
                case 3 -> {
                    System.out.println("Enter id: ");
                    int id = sc.nextInt();

                    System.out.println("Enter new Name");
                    String newName = sc.next();

                    updateStudentName(id, newName);
                }
                case 4 -> {
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    deleteStudent(id);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }


        }

    }


}
