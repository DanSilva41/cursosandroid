package br.com.dan.minhaagendadan.dominio;

/**
 * Created by laboratorio on 28/08/17.
 */

public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String site;
    private Double classificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Double classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return "Pessoa \n ["+ (nome != null ? "Nome = "+ nome + ", " : "")
                            + (email != null ? "Email = "+ nome + ", " : "")
                            + (telefone != null ? "Telefone = "+ telefone+ ", " : "")
                            + (site != null ? "Site = "+ site + ", " : "")
                            + (classificacao != null ? "Classificacao = "+ classificacao + ", " : "") + "]";
    }
}

