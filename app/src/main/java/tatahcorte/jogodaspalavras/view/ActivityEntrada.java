package tatahcorte.jogodaspalavras.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import tatahcorte.jogodaspalavras.R;
import tatahcorte.jogodaspalavras.servico.PontuacaoServico;
import tatahcorte.jogodaspalavras.utils.ActivityUtils;

public class ActivityEntrada extends AppCompatActivity {

    private ImageButton abrirHistorico;
    private ImageButton limparHistorico;
    private Button comecarPartida;

    private final PontuacaoServico pontuacaoServico = new PontuacaoServico();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        comecarPartida = findViewById(R.id.btnStart);
        abrirHistorico = findViewById(R.id.btnViewScores);
        limparHistorico = findViewById(R.id.btnLimparHistorico);

        comecarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarParaPartida = new Intent(ActivityEntrada.this, ActivityJogo.class);
                startActivity(navegarParaPartida);
            }
        });

        abrirHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegarParaPartida = new Intent(ActivityEntrada.this, ActivityHistorico.class);
                startActivity(navegarParaPartida);
            }
        });

        limparHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.mostrarDialogoConfirmacao(
                    ActivityEntrada.this
                    , R.string.cuidado
                    , R.string.apagar_dados_historico
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pontuacaoServico.limparTabela();
                    }
                }, null);
            }
        });
    }
}