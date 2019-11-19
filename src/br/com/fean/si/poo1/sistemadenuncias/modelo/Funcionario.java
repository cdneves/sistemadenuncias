package br.com.fean.si.poo1.sistemadenuncias.modelo;

public class Funcionario extends PessoaFisica {
    private String matricula;
    private String cargo;

    public Funcionario(String matricula, String cargo, String cpf, String nome, String email, String telefone) {
        super(cpf, nome, email, telefone);
        this.matricula = matricula;
        this.cargo = cargo;
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public String getCargo() {
        return cargo;
    }

    
    
    
}
