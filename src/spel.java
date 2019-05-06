import java.sql.*;
    /*import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    */


public class spel {
    //Härifrån ska jag hämta all statistik samt texter från databasen.



        public static final String DEFAULT_DRIVER_CLASS = "com.mysql.jdbc.Driver";
        public static String hostname = "localhost";
        public static String dbName = "Guessr";
        public static int port = 3306;
        public static final String DEFAULT_URL = "jdbc:mysql://"+ hostname +":"+port+"/"+dbName;
        private static final String DEFAULT_USERNAME = "elias";
        private static final String DEFAULT_PASSWORD = "secure";

        public static void main(String[] args) {

            try {
                Class.forName(DEFAULT_DRIVER_CLASS);
                Connection connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

                // SQL queries goes here
                Statement ps = connection.createStatement();
                //ResultSet rs = null;
                //ps = ("SELECT `id`, `word`, `clue1`, `clue2`, `clue3`, `clue4`, `clue5`, `created_at`, `updated_at` FROM `words` WHERE 1");
                ResultSet rs = ps.executeQuery("SELECT * FROM words WHERE id=1");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("word");
                    String address = rs.getString("clue1");
                    System.out.println(firstName + " , " + address);

                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }


