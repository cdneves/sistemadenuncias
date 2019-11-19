package br.com.fean.si.poo1.sistemadenuncias.modelo;

import java.util.Calendar;

public class DenunciaVirtual extends Denuncia {

    private String ipMaquina;

    public DenunciaVirtual(String ipMaquina, Calendar dataRegistro, String assunto, String denunciaFato, Pessoa denunciante, Pessoa denunciado) {
        super(dataRegistro, assunto, denunciaFato, denunciante, denunciado);
        this.ipMaquina = ipMaquina;
    }

    public String getIpMaquina() {
        return ipMaquina;
    }

}
