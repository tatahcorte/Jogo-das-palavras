package tatahcorte.jogodaspalavras.contract;

import android.content.ContentValues;

import tatahcorte.jogodaspalavras.utils.CursorWrapper;
// Marca o que deverá ter no Contract
public interface Contract<T> {
    T deserialize(CursorWrapper cursor);
    ContentValues serialize(T entity);
    String[] getColumns();
    String getTableName();
}
