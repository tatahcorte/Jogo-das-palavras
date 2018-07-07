package tatahcorte.jogodaspalavras.dao;

import tatahcorte.jogodaspalavras.contract.PontuacaoContract;
import tatahcorte.jogodaspalavras.database.DatabaseHelper;
import tatahcorte.jogodaspalavras.entidade.Pontuacao;

public class PontuacaoDao extends AbstractDao<Pontuacao>{
    public PontuacaoDao() {
        super(new PontuacaoContract(), DatabaseHelper.getInstance());
    }
}
