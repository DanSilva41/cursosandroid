package br.com.dan.minhaagendadan.dominio;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.dan.minhaagendadan.FormularioActivity;
import br.com.dan.minhaagendadan.R;

/**
 * Created by laboratorio on 04/09/17.
 */

public class FormularioHelper {

    EditText nome, email, telefone, site;
    RatingBar classificacao;

    public FormularioHelper(FormularioActivity activity) {
        nome = (EditText) activity.findViewById(R.id.form_txt_nome);
        email = (EditText) activity.findViewById(R.id.form_txt_email);
        telefone = (EditText) activity.findViewById(R.id.form_txt_telefone);
        site = (EditText) activity.findViewById(R.id.form_txt_site);
        classificacao = (RatingBar) activity.findViewById(R.id.form_classificacao);

    }

    public Pessoa obterDados() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome.getText().toString());
        pessoa.setEmail(email.getText().toString());
        pessoa.setTelefone(telefone.getText().toString());
        pessoa.setSite(site.getText().toString());
        pessoa.setClassificacao(Double.parseDouble(String.valueOf(classificacao.getProgress())));

        return pessoa;
    }
}
