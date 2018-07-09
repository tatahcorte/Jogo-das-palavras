package tatahcorte.jogodaspalavras.entidade;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private List<Integer> sinonimosAnteriores = new ArrayList<>();
    private Sinonimo sinonimo;
    private String sinonimosDica;
    private String sinonimoEscondido;
    private List<Integer> posicoesReveladas = new ArrayList<>();
    private Long pontuacaoAcumulada;
    private int coracoes;

    public List<Integer> getSinonimosAnteriores() {
        return sinonimosAnteriores;
    }

    public void setSinonimosAnteriores(List<Integer> sinonimosAnteriores) {
        this.sinonimosAnteriores = sinonimosAnteriores;
    }

    public Sinonimo getSinonimo() {
        return sinonimo;
    }

    public void setSinonimo(Sinonimo sinonimo) {
        this.sinonimo = sinonimo;
    }

    public String getSinonimosDica() {
        return sinonimosDica;
    }

    public void setSinonimosDica(String sinonimosDica) {
        this.sinonimosDica = sinonimosDica;
    }

    public String getSinonimoEscondido() {
        return sinonimoEscondido;
    }

    public void setSinonimoEscondido(String sinonimoEscondido) {
        this.sinonimoEscondido = sinonimoEscondido;
    }

    public List<Integer> getPosicoesReveladas() {
        return posicoesReveladas;
    }

    public void setPosicoesReveladas(List<Integer> posicoesReveladas) {
        this.posicoesReveladas = posicoesReveladas;
    }

    public Long getPontuacaoAcumulada() {
        return pontuacaoAcumulada;
    }

    public void setPontuacaoAcumulada(Long pontuacaoAcumulada) {
        this.pontuacaoAcumulada = pontuacaoAcumulada;
    }

    public int getCoracoes() {
        return coracoes;
    }

    public void setCoracoes(int coracoes) {
        this.coracoes = coracoes;
    }
}
