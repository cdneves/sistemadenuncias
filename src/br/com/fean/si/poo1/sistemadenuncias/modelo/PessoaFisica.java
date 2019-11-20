package br.com.fean.si.poo1.sistemadenuncias.modelo;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String cpf, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String getDocumento() {
        return cpf;
    }

    @Override
    public String toString() {
        return "{ \"cpf\" : \"" + this.cpf + "\", " + super.toString() + " }";
    }
    
    
}
