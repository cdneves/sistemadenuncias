package br.com.fean.si.poo1.sistemadenuncias.modelo;
// virou abstract pq tem um metodo abstrato que significa incompleto.
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
}

