package br.com.heitor.combustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat numberFormat =
        NumberFormat.getCurrencyInstance();

    private double numberG;
    private double numberE;
    private TextView valorGasolinaTextView;
    private SeekBar gasolinaSeekBar;
    private TextView valorEtanolTextView;
    private SeekBar etanolSeekBar;
    private TextView valorResultado;
    private ImageView resultadoImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorGasolinaTextView = findViewById(R.id.valorGasolinaTextView);
        gasolinaSeekBar = findViewById(R.id.gasolinaSeekBar);
        valorEtanolTextView = findViewById(R.id.valorEtanolTextView);
        etanolSeekBar = findViewById(R.id.etanolSeekBar);
        valorResultado = findViewById(R.id.valorResultado);
        resultadoImageView = findViewById(R.id.resultadoImageView);

        gasolinaSeekBar.
                setOnSeekBarChangeListener(seekBarChangeListener);
        etanolSeekBar.
                setOnSeekBarChangeListener(seekBarChangeListener1);
    }
    private void verificacao(){
        double calculo = numberE/numberG;
        if(calculo>=0.7){
            valorResultado.setText(R.string.GasolinaR);
            resultadoImageView.setImageResource(R.drawable.gasolina);

        }
        else {
            resultadoImageView.setImageResource(R.drawable.etanol);
            valorResultado.setText(R.string.EtanolR);
        }
    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener=
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    numberG = progress/100.;
                    valorGasolinaTextView.setText(numberFormat.format(numberG));
                    verificacao();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener1 =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    numberE = progress/100.;
                    valorEtanolTextView.setText(numberFormat.format(numberE));
                    verificacao();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}

