package tatahcorte.jogodaspalavras.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import tatahcorte.jogodaspalavras.R;

public class ActivityUtils {

    public static void showConfirmationDialog(
            Context context
            , @StringRes int titulo
            , @StringRes int mensagem
            , DialogInterface.OnClickListener ok
            , DialogInterface.OnClickListener cancelar){
        new AlertDialog.Builder(context)
            .setTitle(titulo)
            .setMessage(mensagem)
            .setPositiveButton(R.string.ok, ok)
            .setNegativeButton(R.string.cancelar, cancelar)
            .show();
    }
}
