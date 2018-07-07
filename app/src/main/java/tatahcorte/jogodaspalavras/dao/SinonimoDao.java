package tatahcorte.jogodaspalavras.dao;

import tatahcorte.jogodaspalavras.contract.SinonimoContract;
import tatahcorte.jogodaspalavras.database.DatabaseHelper;
import tatahcorte.jogodaspalavras.entidade.Sinonimo;

public class SinonimoDao extends AbstractDao<Sinonimo> {
    public SinonimoDao() {
        super(new SinonimoContract(), DatabaseHelper.getInstance());
    }
}
