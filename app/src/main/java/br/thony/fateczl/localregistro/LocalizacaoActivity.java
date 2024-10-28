package br.thony.fateczl.localregistro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LocalizacaoActivity extends AppCompatActivity {

    private TextView lblRegiao;
    private TextView lblCpf;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_localizacao);

        lblRegiao = findViewById(R.id.lblRegiao);
        lblCpf = findViewById(R.id.lblCpf);
        lblCpf.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnVoltar = findViewById(R.id.bntVoltar);

        Intent intent = getIntent();
        String cpf = intent.getStringExtra("cpf");
        String nome = intent.getStringExtra("nome");

        String regiao = getRegistro(cpf);
        lblRegiao.setText(regiao);
        lblCpf.setText(cpf + "\n" + nome);

        btnVoltar.setOnClickListener(op -> resonator());
    }

    private String getRegistro(String cpf) {
        if (cpf != null && cpf.length() >= 9)  {
            char valor = cpf.charAt(8);
            switch (valor) {
                case '0': return "Rio Grande do Sul";
                case '1': return "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
                case '2': return "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima";
                case '3': return "Ceará, Maranhão e Piauí";
                case '4': return "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas";
                case '5': return "Bahia e Sergipe";
                case '6': return "Minas Gerais";
                case '7': return "Rio de Janeiro e Espírito Santo";
                case '8': return "São Paulo";
                case '9': return "Paraná e Santa Catarina";
                default: return "CPF não correspondente";
            }
        } else {
            return "CPF não correspondente";
        }
    }

    private void resonator() {
        Intent resonator = new Intent(this, MainActivity.class);
        resonator.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(resonator);
    }
}
