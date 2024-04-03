
package sena.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lau
 */
public class ConnectionMysql {
    private final String driver ="com.mysql.jdbc.Driver";
    private final  String database="login_system";
    private final  String hostname="localhost";
    private final  String port="3306";
    private final  String username="root";
    private final  String password="Jp!7kT@z$Pm&";
    public Connection connectMysql() throws SQLException{
        String url="jdbc:mysql://"+ hostname + ":" + port + "/" + database + "?useSSL=false";
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
                 
        } catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return connection;
    }
    public void CloseConnectionMysql (Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se ha cerrado la conexión");
}
            
           
}
