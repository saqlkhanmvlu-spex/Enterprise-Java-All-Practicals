package EJPracts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.Stateful;
@Stateful
public class MarksEntryBean {
    List<String> details;
    String stuName;
    String sub1;
    String sub2;
    String sub3;
    private Connection conn = null;
    private ResultSet rs;
    private Statement stmt = null;
    private String query = null;
    public void createConnection() {
        try {
            Class.forName(
                "org.gjt.mm.mysql.Driver"
            ).newInstance();
            String connStr =
                "jdbc:mysql://localhost/reg";
            conn =
                DriverManager.getConnection(
                    connStr,
                    "root",
                    "root"
                );
        }
        catch (
            ClassNotFoundException |
            IllegalAccessException |
            InstantiationException |
            SQLException e
        ) {
            System.err.println(
                "Database Error." +
                e.getMessage()
            );
        }
    }
    public void addMarks(
            String stuname,
            String marks1,
            String marks2,
            String marks3) {
        createConnection();
        try {
            stmt = conn.createStatement();
            query =
                "INSERT INTO marks"
                + "(stuName,sub1,sub2,sub3)"
                + "VALUES('"
                + stuname + "','"
                + marks1 + "','"
                + marks2 + "','"
                + marks3 + "')";
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
            System.err.println(
                "Failed to insert." +
                e.getMessage()
            );
        }
    }
}
