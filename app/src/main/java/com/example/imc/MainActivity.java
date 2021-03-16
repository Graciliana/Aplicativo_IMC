package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText txtPeso;
    private EditText txtAltura;
    private TextView txtResulatado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtResulatado = findViewById(R.id.txtResulatado);
    }

    //metodo responsavel pelo calculo do imc
    public  void calcularImc (View view){
        //conversão de string
        double peso = Double.parseDouble(txtPeso.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());

        double imc = (double)peso/(altura*altura);
        DecimalFormat df = new DecimalFormat(("0.00"));

        /*formula= IMC= PESO /(ALTURA*ALTURA)
        * <= 18,5 - abaixo do peso
        * entre 18,6 e 24,9 - peso ideal(parabens)
        * entre 25,0 e 29,9 - levemente acima do peso
        * entre 30,0 e 34,9 - Obesidade grau I
        * entre 35,0 e 39,9 - Obesidade grau II(severa)
        * acima de 40 - Obesidade grau III(Mórbida)
        * */
        if (imc < 18.5){
            txtResulatado.setText(df.format(imc) + " Abaixo do Peso");
        }else if (imc >= 18.5 && imc <= 24.99){
            txtResulatado.setText(df.format(imc) + " Peso ideal(Parabéns)");
        }else if(imc >= 25.0 && imc <= 29.99){
            txtResulatado.setText(df.format(imc) + " Levemente acima do Peso ");
        } else if(imc >= 30.0 && imc <= 34.99){
            txtResulatado.setText(df.format(imc) + " Obesidade grau I ");
        }else if(imc >= 35.0 && imc <= 39.99){
            txtResulatado.setText(df.format(imc) + " Obesidade grau II(Severa) ");
        }else if(imc > 40){
            txtResulatado.setText(df.format(imc) + " Obesidade grau III(Mórbida) ");
        }

    }
}