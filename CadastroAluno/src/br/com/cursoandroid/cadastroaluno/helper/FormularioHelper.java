package br.com.cursoandroid.cadastroaluno.helper;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import br.com.cursoandroid.cadastroaluno.FormularioActivity;
import br.com.cursoandroid.cadastroaluno.R;
import br.com.cursoandroid.cadastroaluno.modelo.bean.Aluno;

/**
 * @author marciopalheta
 *
 */
public class FormularioHelper {
	
	private EditText nome;
	private EditText telefone;
	private EditText endereco;
	private EditText site;
	private EditText email;
	private SeekBar nota;
	private ImageView foto;
	
	private Aluno aluno;

	// Continua...
	/**
	 * Metodo construtor que associa seus atributos a campos da tela
	 * @param activity
	 *            referencia para a tela a ser controlada
	 */
	
	public FormularioHelper(FormularioActivity activity) {
		
		//Associacao de campos da tela a atributos de controle
		nome = (EditText) activity.findViewById(R.id.edNome);
		telefone = (EditText) activity.findViewById(R.id.edFone);
		endereco = (EditText) activity.findViewById(R.id.edEndereco);
		site = (EditText) activity.findViewById(R.id.edSite);
		email = (EditText) activity.findViewById(R.id.edEmail);
		nota = (SeekBar) activity.findViewById(R.id.sbNota);
		foto = (ImageView) activity.findViewById(R.id.foto);
	
		//Criacao do objeto Aluno
		aluno = new Aluno();
	}
	//Continua...
	/**
	 * Metodo que retorna uma referencia para Aluno
	 * @return referencia para aluno com dados da tela
	 */
	public Aluno getAluno() {

		aluno.setNome(nome.getText().toString());
		aluno.setTelefone(telefone.getText().toString());
		aluno.setEndereco(endereco.getText().toString());
		aluno.setSite(site.getText().toString());
		aluno.setEmail(email.getText().toString());
		aluno.setNota(Double.valueOf(nota.getProgress()));

		return aluno;
	}
	
	/**
	 * Metodo que carrega os dados do aluno na tela 
	 * @param aluno
	 */
	public void setAluno(Aluno aluno){
		
		nome.setText(aluno.getNome());
		telefone.setText(aluno.getTelefone());
		endereco.setText(aluno.getEndereco());
		site.setText(aluno.getSite());
		email.setText(aluno.getEmail());
		nota.setProgress(aluno.getNota().intValue());
		
		this.aluno = aluno;
	}
}
