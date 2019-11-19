package br.com.fean.si.poo1.sistemadenuncias.modelo;

import java.util.Calendar;

public class DenunciaPresencial  extends  Denuncia{
    private String localRegistro;
    private Funcionario responsavelAtendimento;

    public DenunciaPresencial(String localRegistro, Funcionario responsavelAtendimento, Calendar dataRegistro, String assunto, String denunciaFato, Pessoa denunciante, Pessoa denunciado) {
        super(dataRegistro, assunto, denunciaFato, denunciante, denunciado);
        this.localRegistro = localRegistro;
        this.responsavelAtendimento = responsavelAtendimento;
    }
        
    public String getLocalRegistro() {
        return localRegistro;
    }

    public Funcionario getResponsavelAtendimento() {
        return responsavelAtendimento;
    }
    
    
    
    
    
}
