package tatahcorte.jogodaspalavras.contract;

import android.content.ContentValues;

import tatahcorte.jogodaspalavras.entidade.Sinonimo;
import tatahcorte.jogodaspalavras.utils.CursorWrapper;

public class SinonimoContract implements Contract<Sinonimo> {

    private static final String TABLE_NAME = "TBL_SINONIMOS";
    private static final String ID = "ID";
    private static final String SINONIMOS = "SINONIMOS";
    //Criacao da tabela de Sinonimo
    public static final String DDL =
        "CREATE TABLE " + TABLE_NAME + "(" +
        " " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        " " + SINONIMOS + " TEXT " +
        ");";
    //Deserializa para que possa ser usado em tela
    @Override
    public Sinonimo deserialize(CursorWrapper cursor) {
        Sinonimo sinonimo = new Sinonimo();
        sinonimo.setId(cursor.getInt(ID, 0));
        sinonimo.setSinonimos(cursor.getString(SINONIMOS, ""));
        return sinonimo;
    }
    //Serializa para que possa ser usado no banco de dados
    @Override
    public ContentValues serialize(Sinonimo entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SINONIMOS, entity.getId());
        return contentValues;
    }
    //Retorna campos da tabela
    @Override
    public String[] getColumns() {
        return new String[]{ ID, SINONIMOS };
    }
    //Retorna o nome da tabela
    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
