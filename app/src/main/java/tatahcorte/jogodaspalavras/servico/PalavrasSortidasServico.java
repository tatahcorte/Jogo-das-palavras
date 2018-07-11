package tatahcorte.jogodaspalavras.servico;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tatahcorte.jogodaspalavras.entidade.Partida;
import tatahcorte.jogodaspalavras.entidade.Sinonimo;

public class PalavrasSortidasServico {

    private Random random = new Random();

    public Partida criarNovaPartida(Partida partidaExistente, Sinonimo sinonimo, int pontuacao){
        if(partidaExistente == null){
            partidaExistente = new Partida();
        }

        if(partidaExistente.getSinonimo() != null){
            partidaExistente.getSinonimosAnteriores().add(partidaExistente.getSinonimo().getId());
        }

        partidaExistente.setSinonimo(sinonimo);

        List<String> listaDeSinonimos = partidaExistente.getSinonimo().toList();
        int index = getNewRand(0, listaDeSinonimos.size()-1);
        partidaExistente.setSinonimoEscondido(listaDeSinonimos.get(index));

        listaDeSinonimos.remove(index);
        partidaExistente.setSinonimosDica(TextUtils.join(", ", listaDeSinonimos));

        partidaExistente.setPosicoesReveladas(new ArrayList<Integer>());

        partidaExistente.setCoracoes(5);
        return partidaExistente;
    }

    public int revelarPosicao(Partida partida){
        List<Integer> posicoes = listPosicoes(partida.getSinonimoEscondido());
        posicoes.removeAll(partida.getPosicoesReveladas());
        int posicao = posicoes.get(getNewRand(0, posicoes.size()-1));
        partida.getPosicoesReveladas().add(posicao);
        return posicao;
    }

    public long calculaPontos(Partida partida){
        long pontos = 10000;
        if(partida.getCoracoes() <= 4){
            pontos =  pontos / 2;
        }
        if(partida.getCoracoes() <= 3){
            pontos =  pontos / 2;
        }
        if(partida.getCoracoes() <= 2){
            pontos =  pontos / 2;
        }
        if(partida.getCoracoes() <= 1){
            pontos =  pontos / 2;
        }
        if(partida.getCoracoes() == 0){
            pontos = 0;
        }
        return pontos;
    }

    public String montarPalavraOculta(Partida partida){
        StringBuilder resultado = new StringBuilder();
        List<Integer> posicoesReveladas = partida.getPosicoesReveladas();
        int count = partida.getSinonimoEscondido().length();
        for(int x=0; x < count; x++){
            if(posicoesReveladas.contains(x)){
                resultado.append(partida.getSinonimoEscondido().charAt(x));
            } else {
                resultado.append("_");
            }
        }
        return resultado.toString();
    }

    private int getNewRand(int min, int max){
        return random.nextInt(max-min+1)+min;
    }

    private List<Integer> listPosicoes(String str){
        List<Integer> posicoes = new ArrayList<>();
        for(int x=0; x < str.length(); x++){
            posicoes.add(x);
        }
        return posicoes;
    }
}
