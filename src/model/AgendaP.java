package model;


//Classe de transferência , responsável por fazer a conexão e a troca de informação entre as áreas de interação direta do usuário com as áreas em conexão com o banco de dados.

public class AgendaP {
    private int AgCod;
    private String Clinte;
    private String Veiculo;
    private String Ctt;
    private String Data;
    private String Hora;
    private String Resp;
    private String Soli;
    private String Obs;

    public int getAgCod() {
        return AgCod;
    }

    public void setAgCod(int AgCod) {
        this.AgCod = AgCod;
    }

    public String getClinte() {
        return Clinte;
    }

    public void setClinte(String Clinte) {
        this.Clinte = Clinte;
    }

    public String getVeiculo() {
        return Veiculo;
    }

    public void setVeiculo(String Veiculo) {
        this.Veiculo = Veiculo;
    }

    public String getCtt() {
        return Ctt;
    }

    public void setCtt(String Ctt) {
        this.Ctt = Ctt;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getResp() {
        return Resp;
    }

    public void setResp(String Resp) {
        this.Resp = Resp;
    }

    public String getSoli() {
        return Soli;
    }

    public void setSoli(String Soli) {
        this.Soli = Soli;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }
    
    
}
