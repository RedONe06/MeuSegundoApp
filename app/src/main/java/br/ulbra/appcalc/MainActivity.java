package br.ulbra.appcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtValor1, edtValor2;
    Button btnSomar, btnSubtrair, btnMultiplicar, btnDividir;

    public double somar(double valor1, double valor2) {
        double resultado = valor1 + valor2;
        return resultado;
    }

    public double subtrair(double valor1, double valor2) {
        double resultado = valor1 - valor2;
        return resultado;
    }

    public double multiplicar(double valor1, double valor2) {
        double resultado = valor1 * valor2;
        return resultado;
    }

    public double dividir(double valor1, double valor2) {
        double r=0;
        try {
            r = valor1 / valor2;
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Erro: "+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        return r;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
        btnSomar = findViewById(R.id.btnSomar);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText
                        (MainActivity.this,
                                "Soma: " + somar(Double.parseDouble(edtValor1.getText().toString()),
                                        Double.parseDouble(edtValor2.getText().toString())),
                                Toast.LENGTH_SHORT).show();
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText
                        (MainActivity.this,
                                "Subtração: " + subtrair(Double.parseDouble(edtValor1.getText().toString()),
                                        Double.parseDouble(edtValor2.getText().toString())),
                                Toast.LENGTH_SHORT).show();
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText
                        (MainActivity.this,
                                "Multiplicação: " + multiplicar(Double.parseDouble(edtValor1.getText().toString()),
                                        Double.parseDouble(edtValor2.getText().toString())),
                                Toast.LENGTH_SHORT).show();
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText
                        (MainActivity.this,
                                "Divisão: " + dividir(Double.parseDouble(edtValor1.getText().toString()),
                                        Double.parseDouble(edtValor2.getText().toString())),
                                Toast.LENGTH_SHORT).show();
            }
        });

    }


}