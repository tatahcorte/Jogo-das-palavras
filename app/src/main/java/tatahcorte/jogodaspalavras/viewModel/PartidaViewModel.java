package tatahcorte.jogodaspalavras.viewModel;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

import tatahcorte.jogodaspalavras.dao.SinonimoDao;
import tatahcorte.jogodaspalavras.entidade.Partida;
import tatahcorte.jogodaspalavras.servico.PalavrasSortidasServico;

/**
 * O viewMoel implementa a logica que roda por tras da tela de jogo.
 * E como se fosse o Controller to padrao MVC. A diference e que esta
 * classe nao e destruida junto com a activity, ou seja, o viewModel
 * nao sofre os efeitos do ciclo de vida da activity.
 */
public class PartidaViewModel extends ViewModel {

    private Partida partidaAtual;
    private SinonimoDao sinonimoDao = new SinonimoDao();
    private PalavrasSortidasServico servico = new PalavrasSortidasServico();

    public void atualizaDadosDaPartida(ActivityJogoInterface activity){
        if(partidaAtual == null){
            partidaAtual = servico.criarNovaPartida(
                null
                , sinonimoDao.findOneRandom(new ArrayList<Integer>())
                , 0
            );
        }
        activity.setDica(partidaAtual.getSinonimosDica());
        activity.setPalavraOculta(servico.montarPalavraOculta(partidaAtual));
        activity.setCoracoes(partidaAtual.getCoracoes());
        activity.setNivel(partidaAtual.getSinonimosAnteriores().size() + 1);
        activity.setPontos(partidaAtual.getPontuacaoAcumulada());
    }

    public void onRespostaClick(ActivityJogoInterface activity, String resposta){

    }

    private void onPartidaGanha(ActivityJogoInterface activity){

    }

    private void onPartidaPerdida(ActivityJogoInterface activity){

    }

    public interface ActivityJogoInterface{
        void setDica(String dica);
        void setPalavraOculta(String palavraOculta);
        void setCoracoes(int coracoes);
        void setPontos(long pontos);
        void setNivel(int nivel);
    }
}
