package br.com.dan.minhaagendadan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import br.com.dan.minhaagendadan.dao.PessoaDAO;
import br.com.dan.minhaagendadan.dominio.FormularioHelper;
import br.com.dan.minhaagendadan.dominio.Pessoa;

public class FormularioActivity extends AppCompatActivity {

    EditText nome, email, telefone, site;
    RatingBar classificacao;
    Button  salvar;

    FormularioHelper formHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //*---------- Capturar dados ---------*
        nome = (EditText) findViewById(R.id.form_txt_nome);
        email = (EditText) findViewById(R.id.form_txt_email);
        telefone = (EditText) findViewById(R.id.form_txt_telefone);
        site = (EditText) findViewById(R.id.form_txt_site);
        classificacao = (RatingBar) findViewById(R.id.form_classificacao);
        salvar = (Button) findViewById(R.id.form_btn_salvar);

        //-------------------------------------*

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                formHelper = new FormularioHelper(FormularioActivity.this);

                Pessoa pessoa = formHelper.obterDados();
                PessoaDAO dao = new PessoaDAO(FormularioActivity.this);

                dao.insere(pessoa);

                dao.close();

                //exibir uma mensagem
                Toast.makeText(FormularioActivity.this,
                        "Contato Salvo", Toast.LENGTH_SHORT);
                //para de Activity (mudar de tela)
                Intent intentVaiParaLista = new Intent(FormularioActivity.this,
                        ListaActivity.class);
                startActivity(intentVaiParaLista);
                finish();

            }
        });
    }
}
