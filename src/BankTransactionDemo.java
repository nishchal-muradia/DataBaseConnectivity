import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankTransactionDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/SchoolDb";
        String username = "root";
        String password = "admin";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);

            String sql1 = "UPDATE accounts SET balance =balance-500 where id =1";
            String sql2 = "UPDATE accounts SET balance =balance+500 where id =2";

            PreparedStatement dbstatement1 = con.prepareStatement(sql1);
            PreparedStatement dbstatement2 = con.prepareStatement(sql2);

            //execute both the operations
            dbstatement1.executeUpdate();
            dbstatement2.executeUpdate();

            con.commit();


            System.out.println("Transaction committed successfully");


        } catch (Exception e) {

            if (con != null) {
                con.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            }
        }finally {
            if(con !=null){
                con.setAutoCommit(true);
            }
            if(con!=null){
                con.close();
            }
        }


    }
}
