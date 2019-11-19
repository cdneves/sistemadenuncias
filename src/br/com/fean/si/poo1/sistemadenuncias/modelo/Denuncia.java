package br.com.fean.si.poo1.sistemadenuncias.modelo;

import java.util.Calendar;

public class Denuncia {
    private Integer codigo;
    private static Integer contadorDenuncia;
    private Calendar dataRegistro;
    private String assunto;
    private String denunciaFato;
    private Pessoa denunciante;
    private Pessoa denunciado;

    public Denuncia(Calendar dataRegistro, String assunto, String denunciaFato, Pessoa denunciante, Pessoa denunciado) {
        this.codigo = ++contadorDenuncia;
        this.dataRegistro = dataRegistro;
        this.assunto = assunto;
        this.denunciaFato = denunciaFato;
        this.denunciante = denunciante;
        this.denunciado = denunciado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static Integer getContadorDenuncia() {
        return contadorDenuncia;
    }

    public Calendar getDataRegistro() {
        return dataRegistro;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getDenunciaFato() {
        return denunciaFato;
    }

    public Pessoa getDenunciante() {
        return denunciante;
    }

    public Pessoa getDenunciado() {
        return denunciado;
    }

    
    
    
    
    
}
