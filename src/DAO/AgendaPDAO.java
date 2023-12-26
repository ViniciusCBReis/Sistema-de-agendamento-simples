
package DAO;

import Connection.ConnectionFactory;
//import java.awt.List;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AgendaP;

public class AgendaPDAO {
    // De maneira simples e resumida, essa classe é responsavel por inserir e receber dados do banco de dados.

    public void create(AgendaP a){
        //Como o nome já diz , este é um método que recebe os dados da área de transferência e executa um insert desses dados ao banco de dados.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO agenda (Cliente, Veiculo, Contato, Data, Hora, Responsavel, Solicitacao, Obs)VALUES(?,?,?,?,?,?,?,?)");
                stmt.setString(1,a.getClinte());
                stmt.setString(2,a.getVeiculo());
                stmt.setString(3, a.getCtt());
                stmt.setString(4,a.getData());
                stmt.setString(5,a.getHora());
                stmt.setString(6,a.getResp());
                stmt.setString(7,a.getSoli());
                stmt.setString(8,a.getObs());
                
                stmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        }catch (SQLException ex) {
            //Se ocorrer algum problema no processo será informado aqui por meio deste.
            JOptionPane.showMessageDialog(null, "Erro ao salvar "+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void update (AgendaP c){
        //Método responsável por receber as alterações feitas no agendamento tendo como referencial comparativo o código de identificação do agendamento , realizando dessa forma um update no banco de dados com as informações atualizadas.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE agenda SET Cliente = ?, Veiculo = ?, Contato = ?, Data = ?, Hora = ?, Responsavel = ?, Solicitacao = ?, Obs = ?  WHERE idAgenda = ?");
            stmt.setString(1,c.getClinte());
            stmt.setString(2,c.getVeiculo());
            stmt.setString(3, c.getCtt());
            stmt.setString(4,c.getData());
            stmt.setString(5,c.getHora());
            stmt.setString(6,c.getResp());
            stmt.setString(7,c.getSoli());
            stmt.setString(8,c.getObs());
            stmt.setInt(9, c.getAgCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");
        }catch (SQLException ex) {
            //Se ocorrer algum problema no processo será informado aqui por meio deste.
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt)
        }
    }
    public void delete (AgendaP c){ 
        //Exclui o agendamento da aplicação e do banco de dados tendo como referência o código do agendamento.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM agenda WHERE idAgenda = ?");
            stmt.setInt(1,c.getAgCod());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso.");
        }catch (SQLException ex) {
            //Se ocorrer algum problema no processo será informado aqui por meio deste.
            JOptionPane.showMessageDialog(null, "Erro ao exlcuir "+ex);
        }
        finally{
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<AgendaP> read() {
        //Método que busca os dados do banco por meio de um SELECT na tabela , faz a leitura de todos eles e os formata em lista.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AgendaP> agendamento = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM agenda ");
            rs = stmt.executeQuery();
            while (rs.next()){
                AgendaP agend = new AgendaP();
                agend.setAgCod(rs.getInt("idAgenda"));
                agend.setClinte(rs.getString("Cliente"));
                agend.setVeiculo(rs.getString("Veiculo"));
                agend.setCtt(rs.getString("Contato"));
                agend.setData(rs.getString("Data"));
                agend.setHora(rs.getString("Hora"));
                agend.setResp(rs.getString("Responsavel"));
                agend.setSoli(rs.getString("Solicitacao"));
                agend.setObs(rs.getString("Obs"));
                
                agendamento.add(agend);
            }
        }catch (SQLException ex){
            //Se ocorrer algum problema no processo será informado aqui por meio deste.
            Logger.getLogger(AgendaPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{}
        return agendamento;
    }
    
    public List<AgendaP> PesqData(String Data){
        //Faz o mesmo que o método anterior porém a busca ocorre através de um parâmetro , neste caso o parâmetro em questão é data do agendamento. 

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AgendaP> agendamento = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM agenda WHERE Data = ? ");
            stmt.setString(1, Data);
            rs = stmt.executeQuery();
            while (rs.next()){
                AgendaP agend = new AgendaP();
                agend.setAgCod(rs.getInt("idAgenda"));
                agend.setClinte(rs.getString("Cliente"));
                agend.setVeiculo(rs.getString("Veiculo"));
                agend.setCtt(rs.getString("Contato"));
                agend.setData(rs.getString("Data"));
                agend.setHora(rs.getString("Hora"));
                agend.setResp(rs.getString("Responsavel"));
                agend.setSoli(rs.getString("Solicitacao"));
                agend.setObs(rs.getString("Obs"));
                
                agendamento.add(agend);
            }
        }catch (SQLException ex){
            Logger.getLogger(AgendaPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{}
        return agendamento;
    }
    public List<AgendaP> PesqCli(String Cliente){
        //Método de busca e formatação em lista , tendo como parâmetro de busca o nome do cliente.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<AgendaP> agendamento = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM agenda WHERE Cliente = ? ");
            stmt.setString(1, Cliente);
            rs = stmt.executeQuery();
            while (rs.next()){
                AgendaP agend = new AgendaP();
                agend.setAgCod(rs.getInt("idAgenda"));
                agend.setClinte(rs.getString("Cliente"));
                agend.setVeiculo(rs.getString("Veiculo"));
                agend.setCtt(rs.getString("Contato"));
                agend.setData(rs.getString("Data"));
                agend.setHora(rs.getString("Hora"));
                agend.setResp(rs.getString("Responsavel"));
                agend.setSoli(rs.getString("Solicitacao"));
                agend.setObs(rs.getString("Obs"));
                
                agendamento.add(agend);
            }
        }catch (SQLException ex){
            //Se ocorrer algum problema no processo será informado aqui por meio deste.
            Logger.getLogger(AgendaPDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{}
        return agendamento;
    }

    public AgendaP buscar(int Cod){
        //Método de busca e formatação em lista , tendo como parâmetro de busca o código do agendamento.
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM agenda WHERE idAgenda = ? ");
            stmt.setInt(1, Cod);
            ResultSet rs = stmt.executeQuery();
            AgendaP agend = new AgendaP();
            rs.next();
            agend.setAgCod(rs.getInt("idAgenda"));
            agend.setClinte(rs.getString("Cliente"));
            agend.setVeiculo(rs.getString("Veiculo"));
            agend.setCtt(rs.getString("Contato"));
            agend.setData(rs.getString("Data"));
            agend.setHora(rs.getString("Hora"));
            agend.setResp(rs.getString("Responsavel"));
            agend.setSoli(rs.getString("Solicitacao"));
            agend.setObs(rs.getString("Obs"));
            return agend;
            
        }catch (SQLException ex){
            //Se ocorrer algum problema no processo será informado aqui por meio deste.
            Logger.getLogger(AgendaPDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
        
    }
}
