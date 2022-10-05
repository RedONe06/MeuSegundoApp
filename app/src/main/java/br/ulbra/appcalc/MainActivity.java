package br.ulbra.appcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNomeAluno, edtDisciplina, edtNAulas, edtNFaltas, edtNota1, edtNota2;
    Button btnResultado, btnLimpar;
    static boolean isAprovado = true;


    public double calcularMedia(double nota1, double nota2){
        double media = ((nota1*2) + (nota2*4)) / 6;
        return media;
    }

    public int calcularFrequencia(double quantidadeAulas, double quantidadeFaltas){
        int frequencia = (int) ((quantidadeAulas-quantidadeFaltas)/quantidadeAulas) * 100;
        return frequencia;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtDisciplina = findViewById(R.id.edtDisciplina);
        edtNomeAluno = findViewById(R.id.edtNome);
        edtNAulas = findViewById(R.id.edtNumeroAulas);
        edtNFaltas = findViewById(R.id.edtNumeroFaltas);
        edtNota1 = findViewById(R.id.edtNota1);
        edtNota2 = findViewById(R.id.edtNota2);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnResultado = findViewById(R.id.btnResultado);

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAprovado = calcularFrequencia(Double.parseDouble(edtNAulas.toString()),
                        Double.parseDouble(edtNFaltas.toString())) > 75
                        && calcularMedia(Double.parseDouble(edtNota1.toString()),
                        Double.parseDouble(edtNota2.toString())) >= 7.0;
              if(isAprovado){
                  Toast.makeText(MainActivity.this, "Parabéns, você foi aprovado :)", Toast.LENGTH_SHORT).show();
                } else {
                  Toast.makeText(MainActivity.this, "Parabéns, você foi reprovado :(", Toast.LENGTH_SHORT).show();
              }
            }

        });
    }

}