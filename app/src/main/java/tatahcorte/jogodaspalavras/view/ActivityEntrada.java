package tatahcorte.jogodaspalavras.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import tatahcorte.jogodaspalavras.R;
import tatahcorte.jogodaspalavras.dao.SinonimoDao;

public class ActivityEntrada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        SinonimoDao teste = new SinonimoDao();
        Log.d(ActivityEntrada.class.getSimpleName(), String.valueOf(teste.query().size()));

    }
}