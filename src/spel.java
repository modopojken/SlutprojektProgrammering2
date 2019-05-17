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
        private String word;
        private String clue1;
        private String clue2;
        private String clue3;
        private String clue4;
        private String clue5;

        public String getWord(){
            return word;
        }
        public String getClue1(){
        return clue1;
        }
        public String getClue2(){
            return clue2;
        }
        public String getClue3(){
            return clue3;
        }
        public String getClue4(){
            return clue4;
        }
        public String getClue5(){
            return clue5;
        }
        public void setWord(String newWord){
            this.word = newWord;
        }
        public void setClue1(String newClue1){
            this.clue1 = newClue1;
        }
        public void setClue2(String newClue2){
            this.clue2 = newClue2;
        }
        public void setClue3(String newClue3){
            this.clue3 = newClue3;
        }
        public void setClue4(String newClue4){
            this.clue4 = newClue4;
         }
        public void setClue5(String newClue5){
            this.clue5 = newClue5;
        }

        public static void main(String[] args) {
            spel s = new spel();
            s.init();
        }

        public void init() {
            try {

                Class.forName(DEFAULT_DRIVER_CLASS);
                Connection connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

                // SQL queries goes here
                Statement ps = connection.createStatement();
                //ResultSet rs = null;
                //ps = ("SELECT `id`, `word`, `clue1`, `clue2`, `clue3`, `clue4`, `clue5`, `created_at`, `updated_at` FROM `words` WHERE 1");
                ResultSet rs = ps.executeQuery("SELECT * FROM words WHERE id=1");   //Hämtar häm från databasen

                while (rs.next()) {


                    int id = rs.getInt("id");
                    word = rs.getString("word");
                    clue1 = rs.getString("clue1"); //Sätter hämtad clueX till clueX
                    clue2 = rs.getString("clue2");
                    clue3 = rs.getString("clue3");
                    clue4 = rs.getString("clue4");
                    clue5 = rs.getString("clue5");
                    System.out.println(word + " , " + clue1 + " , " + clue2 + " , " + clue3 + " , " + clue4 + " , " + clue5);

                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }


