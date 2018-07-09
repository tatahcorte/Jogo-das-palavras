package tatahcorte.jogodaspalavras.entidade;

import java.util.List;

public class Partida {

    private List<Integer> sinonimosAnteriores;
    private Sinonimo sinonimo;
    private String sinonimosDica;
    private String sinonimoEscondido;
    private List<Integer> posicoesReveladas;
    private Long pontuacaoAcumulada;

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
}
