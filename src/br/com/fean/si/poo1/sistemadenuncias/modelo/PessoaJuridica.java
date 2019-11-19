package br.com.fean.si.poo1.sistemadenuncias.modelo;

public class PessoaJuridica  extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String cnpj, String nome, String email, String telefone) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }
}
