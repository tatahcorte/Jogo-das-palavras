package tatahcorte.jogodaspalavras.entidade;

import java.util.Date;

public class Pontuacao {
    private int id;
    private Date data;
    private long pontuacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }
}