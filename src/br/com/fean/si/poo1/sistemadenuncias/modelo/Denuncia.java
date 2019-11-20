package br.com.fean.si.poo1.sistemadenuncias.modelo;

import java.text.DateFormat;
import java.util.Calendar;

public class Denuncia {

    private Integer codigo;
    private static int contadorDenuncia;
    private Calendar dataRegistro;
    private String assunto;
    private String denunciaFato;
    private Pessoa denunciante;
    private Pessoa denunciado;

    public Denuncia(String assunto, String denunciaFato, Pessoa denunciante, Pessoa denunciado) {
        this.codigo = ++contadorDenuncia;
        this.dataRegistro = Calendar.getInstance();
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
    
    public String getDataRegistroFormatada() {
        return DateFormat.getDateInstance().format( dataRegistro.getTime() );
    }

    @Override
    public String toString() {
        return "\"codigo\" : " + this.getCodigo() + ", \"dataRegistro\" : \"" + this.getDataRegistroFormatada() + 
                "\", \"assunto\" : \"" + this.assunto + "\", \"descricaoFato\" : \"" + 
                this.denunciaFato + "\", \"nomeDenunciante\" : \"" + this.getDenunciante().getNome() + 
                "\", \"nomeDenunciado\" : \"" + this.getDenunciado().getNome() + "\"";
    }

}
