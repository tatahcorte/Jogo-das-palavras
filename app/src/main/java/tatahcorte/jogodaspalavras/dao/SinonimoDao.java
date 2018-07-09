package tatahcorte.jogodaspalavras.dao;

import android.text.TextUtils;

import java.util.List;

import tatahcorte.jogodaspalavras.contract.SinonimoContract;
import tatahcorte.jogodaspalavras.database.DatabaseHelper;
import tatahcorte.jogodaspalavras.entidade.Sinonimo;

public class SinonimoDao extends AbstractDao<Sinonimo> {
    public SinonimoDao() {
        super(new SinonimoContract(), DatabaseHelper.getInstance());
    }

    public Sinonimo findOneRandom(List<Integer> exceto) {
        return super.findOne(" ID NOT IN (?) ORDER BY RANDOM() LIMIT 1", TextUtils.join(",", exceto));
    }
}
