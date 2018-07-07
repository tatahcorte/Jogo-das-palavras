package tatahcorte.jogodaspalavras.contract;

import android.content.ContentValues;

import java.util.Date;

import tatahcorte.jogodaspalavras.entidade.Pontuacao;
import tatahcorte.jogodaspalavras.utils.CursorWrapper;

public class PontuacaoContract implements Contract<Pontuacao> {

    private static final String TABLE_NAME = "TBL_PONTUACAO";
    private static final String ID = "ID";
    private static final String DATA = "DATA";
    private static final String PONTUACAO = "PONTUCAO";

    public static final String DDL =
        "CREATE TABLE " + TABLE_NAME + "(" +
        " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        " " + DATA + " INTEGER, " +
        " " + PONTUACAO + " INTEGER " +
        ");";

    @Override
    public Pontuacao deserialize(CursorWrapper cursor) {
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setId(cursor.getInt(ID, 0));
        pontuacao.setData(new Date(cursor.getLong(DATA, new Date().getTime())));
        pontuacao.setPontuacao(cursor.getLong(PONTUACAO, 0L));
        return pontuacao;
    }

    @Override
    public ContentValues serialize(Pontuacao entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA, entity.getData().getTime());
        contentValues.put(PONTUACAO, entity.getPontuacao());
        return contentValues;
    }

    @Override
    public String[] getColumns() {
        return new String[]{
            ID
            , DATA
            , PONTUACAO
        };
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
