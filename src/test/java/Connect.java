import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Ray on 2016/5/20.
 */
public class Connect {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            String userName = "root";
            String password = "uisecret";

            String url = "jdbc:mysql://localhost:3306/manchey";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {}
            }
        }
    }
}