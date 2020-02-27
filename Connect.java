package  originalbank;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    static Properties prop = new Properties();
    static{
        try {
            InputStream inputStream =
                    Connect.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(inputStream);
            Class.forName(prop.getProperty("driver"));
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
