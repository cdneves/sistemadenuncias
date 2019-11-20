package br.com.fean.si.poo1.sistemadenuncias.modelo;

import java.util.Calendar;

public class DenunciaVirtual extends Denuncia {

    private String ipMaquina;

    public DenunciaVirtual(String ipMaquina, String assunto, String denunciaFato, Pessoa denunciante, Pessoa denunciado) {
        super(assunto, denunciaFato, denunciante, denunciado);
        this.ipMaquina = ipMaquina;
    }

    public String getIpMaquina() {
        return ipMaquina;
    }

    @Override
    public String toString() {
        return "{ " + super.toString() + ", \"ipMaquina\" : \"" + ipMaquina + "\" }"; 
    }
    
    

}
