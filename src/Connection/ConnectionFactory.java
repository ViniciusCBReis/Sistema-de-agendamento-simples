package Connection;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.logging.Level; 
import java.util.logging.Logger;

public class ConnectionFactory { 
    //Esta classe é responsavel por passar as informações de conexão
    //Não esqueça de inserir suas informações!!
     
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";// driver de cnx do MySQL com.mysql.cj.jdbc.Driver
    private static final String URL = "jdbc:mysql://localhost:3306/xx"; //Substitua o "xx" para o nome do seu banco de dados. A porta 3306 é a padrão , se tiver alterado em sua maquina , altere aqui também.
    private static final String USER = "root"; private static final String PASS = ""; //Essas são as configurações padrões do MySql


    public static Connection getConnection(){
        //Esta tenta fazer a conexão com o banco MySql através das informações fornecidas por meio de um sistema try-catch.
        try { 
            Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASS); 
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
            // Caso algo de errado. Leia com atenção!!
        } 
    }

    public static void closeConnection(connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection((Connection) con, stmt);
        try{
            if(rs != null) {
                rs.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Para alterar o corpo dos métodos gerados, escolha Ferramentas | Modelos.
    }
}
