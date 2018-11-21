package tatahcorte.jogodaspalavras.dao;

import tatahcorte.jogodaspalavras.contract.PontuacaoContract;
import tatahcorte.jogodaspalavras.database.DatabaseHelper;
import tatahcorte.jogodaspalavras.entidade.Pontuacao;
import tatahcorte.jogodaspalavras.servico.PontuacaoServico;
import tatahcorte.jogodaspalavras.servico.UsuarioServico;
// Liga o DAO com o PontuacaoContract(através do Contract será informado qual tabela o AbstractDao irá trabalhar)
// Instancia o Databasehelper
public class PontuacaoDao extends AbstractDao<Pontuacao>{
    public PontuacaoDao() {
        super(new PontuacaoContract(), DatabaseHelper.getInstance());
    }

    // sharedPreferences: persistencia com o setNome para o login com o Google
    @Override
    public Pontuacao insert(Pontuacao entity) {
        entity.setNome(UsuarioServico.getInstance().getUser());
        return super.insert(entity);
    }
}
