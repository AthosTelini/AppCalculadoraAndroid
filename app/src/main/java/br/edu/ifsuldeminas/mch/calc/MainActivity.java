package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import de.congrace.exp4j.Calculable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button numero_zero,numero_um,numero_dois,numero_tres,numero_quatro,
            numero_cinco,numero_seis,numero_sete,numero_oito,numero_nove,backspace,porcentagem,virgula,
            buttonIgual,soma,substracao,multiplicacao,divisao,limpar;
    private TextView textViewResultado,textViewUltimaExpressao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        numero_zero.setOnClickListener(this);
        numero_um.setOnClickListener(this);
        numero_dois.setOnClickListener(this);
        numero_tres.setOnClickListener(this);
        numero_quatro.setOnClickListener(this);
        numero_cinco.setOnClickListener(this);
        numero_seis.setOnClickListener(this);
        numero_sete.setOnClickListener(this);
        numero_oito.setOnClickListener(this);
        numero_nove.setOnClickListener(this);
        backspace.setOnClickListener(this);
        virgula.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);
        soma.setOnClickListener(this);
        substracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        limpar.setOnClickListener(this);
        porcentagem.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){
                    byte var0=0;
                    int var1=string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                textViewResultado.setText("");
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(textViewUltimaExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();

                    long longResult = (long) resultado;
                    if(resultado == (double) longResult){
                        textViewResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        textViewResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });

    }

    private void IniciarComponentes() {
        numero_zero = findViewById(R.id.buttonZeroID);
        numero_um = findViewById(R.id.buttonUmID);
        numero_dois = findViewById(R.id.buttonDoisID);
        numero_tres = findViewById(R.id.buttonTresID);
        numero_quatro = findViewById(R.id.buttonQuatroID);
        numero_cinco = findViewById(R.id.buttonCincoID);
        numero_seis = findViewById(R.id.buttonSeisID);
        numero_sete = findViewById(R.id.buttonSeteID);
        numero_oito = findViewById(R.id.buttonOitoID);
        numero_nove = findViewById(R.id.buttonNoveID);
        backspace = findViewById(R.id.buttonDeleteID);
        virgula = findViewById(R.id.buttonVirgulaID);
        porcentagem=findViewById(R.id.buttonPorcentoID);
        buttonIgual = findViewById(R.id.buttonIgualID);
        soma = findViewById(R.id.buttonSomaID);
        substracao = findViewById(R.id.buttonSubtracaoID);
        multiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        divisao = findViewById(R.id.buttonDivisaoID);
        limpar = findViewById(R.id.buttonResetID);
        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

    }
    public void AcrescentarUmaExpressao(String string,boolean limpar_Dados){
        if(textViewResultado.getText().equals("")){
            textViewUltimaExpressao.setText(" ");
        }
        if(limpar_Dados){
            textViewResultado.setText(" ");
            textViewUltimaExpressao.append(string);
        }else{
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonZeroID:
                AcrescentarUmaExpressao("0",true);
                break;
            case R.id.buttonUmID:
                AcrescentarUmaExpressao("1",true);
                break;
            case R.id.buttonDoisID:
                AcrescentarUmaExpressao("2",true);
                break;
            case R.id.buttonTresID:
                AcrescentarUmaExpressao("3",true);
                break;
            case R.id.buttonQuatroID:
                AcrescentarUmaExpressao("4",true);
                break;
            case R.id.buttonCincoID:
                AcrescentarUmaExpressao("5",true);
                break;
            case R.id.buttonSeisID:
                AcrescentarUmaExpressao("6",true);
                break;
            case R.id.buttonSeteID:
                AcrescentarUmaExpressao("7",true);
                break;
            case R.id.buttonOitoID:
                AcrescentarUmaExpressao("8",true);
                break;
            case R.id.buttonNoveID:
                AcrescentarUmaExpressao("9",true);
                break;
            case R.id.buttonPorcentoID:
                AcrescentarUmaExpressao("%", false);
                break;
            case R.id.buttonSomaID:
                AcrescentarUmaExpressao("+",true);
                break;
            case R.id.buttonSubtracaoID:
                AcrescentarUmaExpressao("-",true);
                break;
            case R.id.buttonMultiplicacaoID:
                AcrescentarUmaExpressao("*",true);
                break;
            case R.id.buttonDivisaoID:
                AcrescentarUmaExpressao("/",true);
                break;
            case R.id.buttonVirgulaID:
                AcrescentarUmaExpressao(".",true);
                break;
        }
    }
}