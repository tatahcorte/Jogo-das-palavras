package tatahcorte.jogodaspalavras.contract;

import android.content.ContentValues;

import java.util.Date;

import tatahcorte.jogodaspalavras.entidade.Pontuacao;
import tatahcorte.jogodaspalavras.utils.CursorWrapper;

public class PontuacaoContract implements Contract<Pontuacao> {

    public static final String TABLE_NAME = "TBL_PONTUACAO";
    public static final String ID = "ID";
    public static final String DATA = "DATA";
    public static final String PONTUACAO = "PONTUCAO";
    public static final String NOME = "NOME";
    //Criacao da tabela de Pontuacao
    public static final String DDL =
        "CREATE TABLE " + TABLE_NAME + "(" +
        " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        " " + DATA + " INTEGER, " +
        " " + PONTUACAO + " INTEGER, " +
        " " + NOME + " TEXT " +
        ");";
    //Deserializa para que possa ser usado em tela
    @Override
    public Pontuacao deserialize(CursorWrapper cursor) {
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setId(cursor.getInt(ID, 0));
        pontuacao.setData(new Date(cursor.getLong(DATA, new Date().getTime())));
        pontuacao.setPontuacao(cursor.getLong(PONTUACAO, 0L));
        pontuacao.setNome(cursor.getString(NOME, null));
        return pontuacao;
    }
    //Serializa para que possa ser usado no banco de dados
    @Override
    public ContentValues serialize(Pontuacao entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA, entity.getData().getTime());
        contentValues.put(PONTUACAO, entity.getPontuacao());
        contentValues.put(NOME, entity.getNome());
        return contentValues;
    }
    //Retorna campos da tabela
    @Override
    public String[] getColumns() {
        return new String[]{
            ID
            , DATA
            , PONTUACAO
            , NOME
        };
    }
    //Retorna o nome da tabela
    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
