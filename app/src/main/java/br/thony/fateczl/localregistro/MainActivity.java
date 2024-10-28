package br.thony.fateczl.localregistro;

import static android.content.ClipData.newIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etCpf, etNome;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCpf = findViewById(R.id.etCpf);
        etCpf.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etNome = findViewById(R.id.etNome);
        etNome.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnBuscar = findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(op -> buscar());
    }

    private void buscar() {
        String cpf = etCpf.getText().toString();
        String nome = etNome.getText().toString();

        if (cpf.isEmpty() || nome.isEmpty()) {
            Toast.makeText(this, "CPF ou Nome faltando", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, LocalizacaoActivity.class);
        intent.putExtra("cpf", cpf);
        intent.putExtra("nome", nome);
        startActivity(intent);
    }
}