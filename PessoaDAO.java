package br.com.dan.minhaagendadan.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.dan.minhaagendadan.dominio.Pessoa;

/**
 * Created by laboratorio on 04/09/17.
 */

public class PessoaDAO extends SQLiteOpenHelper {

    public PessoaDAO(Context context) {
        super(context, "agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE pessoa" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nome TEXT NOT NULL" +
                    ", email TEXT NOT NULL" +
                    ", telefone TEXT NOT NULL" +
                    ", site TEXT NOT NULL" +
                    ", classificacao REAL NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Método para salvar dados no banco
    public void insere(Pessoa pessoa) {
        // Pedir permissão para escrever no banco
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("telefone", pessoa.getTelefone());
        dados.put("site", pessoa.getSite());
        dados.put("classificacao", pessoa.getClassificacao());

        // Executa inserção
        bd.insert("pessoa", null, dados);
    }

    public List<Pessoa> obterDadosPessoa() {
        String sql = "SELECT * FROM pessoa ORDER BY nome";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Pessoa> listaPessoas = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                Pessoa pessoa = new Pessoa();
                //pessoa.setId(cursor.getInt(cursor.getColumnIndex("id")));
                pessoa.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                pessoa.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                pessoa.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
                pessoa.setSite(cursor.getString(cursor.getColumnIndex("site")));
                pessoa.setClassificacao(cursor.getDouble(cursor.getColumnIndex("classificacao")));
                listaPessoas.add(pessoa);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return listaPessoas;
    }
}
