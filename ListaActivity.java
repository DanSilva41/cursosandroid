package br.com.dan.minhaagendadan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.dan.minhaagendadan.dao.PessoaDAO;
import br.com.dan.minhaagendadan.dominio.Pessoa;

public class ListaActivity extends AppCompatActivity {

    ListView lista;
    Button  botao;
    List<Pessoa> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        /* ---- Forma antiga e de teste

        String[] contatos = {"Ana", "Maria", "Paulo"};

        lista = (ListView)findViewById(R.id.lista_list_pessoas);

        contatos = new ArrayList<>();

        Pessoa dan = new Pessoa();
        dan.setNome("Danilo S.");
        dan.setTelefone("1515");

        contatos.add(dan);


        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,contatos);

        lista.setAdapter(adapter);

        */

        botao = (Button)findViewById(R.id.lista_btn_adicionar);

        botao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiParaForm = new Intent(ListaActivity.this,
                        FormularioActivity.class);
                startActivity(intentVaiParaForm);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        PessoaDAO dao = new PessoaDAO(ListaActivity.this);

        contatos = dao.obterDadosPessoa();
        lista = (ListView)findViewById(R.id.lista_list_pessoas);

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,contatos);

        lista.setAdapter(adapter);

        dao.close();
    }
}
