package tatahcorte.jogodaspalavras.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.DialogInterface;

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
    private PalavrasSortidasServico servico = new PalavrasSortidasServico();

    public void atualizaDadosDaPartida(ActivityJogoInterface activity){
        if(partidaAtual == null){
            partidaAtual = servico.criarNovaPartida(
                null
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
        if(partidaAtual.getSinonimoEscondido().equals(resposta)){
            onPartidaGanha(activity);
        } else {
            onRespostaErrada(activity);
        }
    }

    private void onPartidaGanha(final ActivityJogoInterface activity){
        final long pontos = servico.calculaPontos(partidaAtual);
        activity.mostrarMensagemParabens(partidaAtual.getSinonimoEscondido(), pontos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                partidaAtual = servico.criarNovaPartida(partidaAtual, pontos);
                atualizaDadosDaPartida(activity);
            }
        });
    }

    private void onRespostaErrada(ActivityJogoInterface activity){
        if(partidaAtual.getCoracoes() == 1){
            onPartidaPerdida(activity);
            return;
        }
        partidaAtual.setCoracoes(partidaAtual.getCoracoes()-1);
        servico.revelarPosicao(partidaAtual);
        atualizaDadosDaPartida(activity);
    }

    private void onPartidaPerdida(final ActivityJogoInterface activity){
        partidaAtual.setCoracoes(0);
        activity.mostrarMensagemDeFimDePartida(partidaAtual.getSinonimoEscondido(), partidaAtual.getPontuacaoAcumulada(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                partidaAtual = servico.criarNovaPartida(null, 0);
                atualizaDadosDaPartida(activity);
            }
        });
    }

    public interface ActivityJogoInterface{
        void setDica(String dica);
        void setPalavraOculta(String palavraOculta);
        void setCoracoes(int coracoes);
        void setPontos(long pontos);
        void setNivel(int nivel);
        void mostrarMensagemDeFimDePartida(String sinonimoEscondido, long pontos, DialogInterface.OnClickListener callback);
        void mostrarMensagemParabens(String sinonimoEscondido, long pontos, DialogInterface.OnClickListener callback);
    }
}
