package EJPracts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
@Stateless
public class VStatelessBean {
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    private String query = null;
    @PostConstruct
    public void connect() {
        try {
            Class.forName(
                "com.mysql.jdbc.Driver"
            ).newInstance();
            String connStr =
                "jdbc:mysql://localhost/reg";
            conn = DriverManager.getConnection(
                connStr,
                "root",
                "root"
            );\
System.out.println(
                "Connection Success."
            );
        }
        catch (
            ClassNotFoundException |
            InstantiationException |
            IllegalAccessException |
            SQLException e
        ) {
            System.err.println(
                "Connection failed."
            );
        }
    }
    @PreDestroy
    public void disconnect() {
        try {
            conn.close();
            System.out.println(
                "Connection closed."
            );
        }
        catch (SQLException e) {
            System.err.println(
                "Not able to close connection: "
                + e.getMessage()
            );
        }
    }
    public void addVisitor(String host) {
        try {
            stmt = conn.createStatement();
            query =
                "INSERT INTO visitorstat "
                + "(host,visitcount) "
                + "VALUES('" + host + "',1)";
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
            try {
                stmt = conn.createStatement();
                query =
                    "UPDATE visitorstat "
                    + "SET visitcount = visitcount + 1 "
                    + "WHERE host = '" + host + "'";
                stmt.executeUpdate(query);
            }
            catch (SQLException ex) {
                System.err.println(
                    "Cannot execute update: "
                    + ex.getMessage()
                );
            }
        }
    }
}
