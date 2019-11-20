package br.com.fean.si.poo1.sistemadenuncias.modelo;
// Virou abstract porque tem um metodo abstrato que significa incompleto 
// (não possui implementação, apenas a assinatura do método).

public abstract class Pessoa {

    private String nome;
    private String email;
    private String telefone;

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public abstract String getDocumento();

    @Override
    // Método sobrescrito da classe object
    // Converso o objeto para uma String no formato Json
    public String toString() {
        return "\"nome\" : \"" + this.getNome() + "\", \"email\" : \""
                + this.getEmail() + "\", \"telefone\" : \"" + this.getTelefone() + "\"";
    }

}
