package tatahcorte.jogodaspalavras.dao;

import android.text.TextUtils;

import java.util.List;

import tatahcorte.jogodaspalavras.contract.SinonimoContract;
import tatahcorte.jogodaspalavras.database.DatabaseHelper;
import tatahcorte.jogodaspalavras.entidade.Sinonimo;
// Liga o DAO com o SinonimoContract(através do Contract será informado qual tabela o AbstractDao irá trabalhar)
// Instancia o Databasehelper
public class SinonimoDao extends AbstractDao<Sinonimo> {
    public SinonimoDao() {
        super(new SinonimoContract(), DatabaseHelper.getInstance());
    }
    // Procurar Sinonimo Random no banco
    public Sinonimo findOneRandom(List<Integer> exceto) {
        String where = null;
        String[] parameters = null;
        if(exceto != null && exceto.size() > 0){
            where = " ID NOT IN (?) ";
            parameters = new String[]{ TextUtils.join(",", exceto) };
        }
        return super.findOne(where, parameters, "RANDOM() LIMIT 1");
    }
}