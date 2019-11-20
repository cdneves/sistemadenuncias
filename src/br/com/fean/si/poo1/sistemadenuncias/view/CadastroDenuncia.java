package br.com.fean.si.poo1.sistemadenuncias.view;

import br.com.fean.si.poo1.sistemadenuncias.modelo.Denuncia;
import br.com.fean.si.poo1.sistemadenuncias.modelo.DenunciaPresencial;
import br.com.fean.si.poo1.sistemadenuncias.modelo.DenunciaVirtual;
import br.com.fean.si.poo1.sistemadenuncias.modelo.Funcionario;
import br.com.fean.si.poo1.sistemadenuncias.modelo.Pessoa;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CadastroDenuncia {

    private Map<String, Pessoa> pessoas;
    private Map<Integer, Denuncia> denuncias;
    private Map<String, Funcionario> atendentes;

    public CadastroDenuncia(Map<String, Pessoa> pessoas, Map<Integer, Denuncia> denuncias, Map<String, Funcionario> atendentes) {
        this.pessoas = pessoas;
        this.denuncias = denuncias;
        this.atendentes = atendentes;
    }

    public void mostrarMenu() {
        int opcao = 0;
        String opUsuario = null;
        do {
            opUsuario = JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Incluir denúncia\n"
                    + "2 - Listar denúncias\n"
                    + "9 - Menu principal");
            if (opUsuario != null) {
                opcao = new Integer(opUsuario);
                switch (opcao) {
                    case 1:
                        incluir();
                        break;
                    case 2:
                        listar();
                        break;
                    default:
                        if (opcao != 9) {
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                        }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma opção.");
            }
        } while (opcao != 9);
    }

    private void incluir() {
        String documentoDenunciado = JOptionPane.showInputDialog("Informe o documento do denunciado: ");
        String documentoDenunciante = JOptionPane.showInputDialog("Informe o documento do denunciante: ");
        String assunto = JOptionPane.showInputDialog("Informe o assunto da denúncia:");
        String descricaoFato = JOptionPane.showInputDialog("Descreva o fato : ");
        String tipoDenuncia = JOptionPane.showInputDialog("Informe o tipo da denúncia (1- presencial, 2- virtual):");
        Pessoa denunciante = this.pessoas.get(documentoDenunciante);
        Pessoa denunciado = this.pessoas.get(documentoDenunciado);

        Denuncia d = null;
        String documento = null;
        if (tipoDenuncia.equals("1")) {

            String localRegistro = JOptionPane.showInputDialog("Informe o local de registro ");
            String matriculaAtendente = JOptionPane.showInputDialog("Informe o matrícula do atendente:");
            Funcionario atendente = this.atendentes.get(matriculaAtendente);
            d = new DenunciaPresencial(localRegistro, atendente, assunto, descricaoFato, denunciante, denunciado);

        } else if (tipoDenuncia.equals("2")) {

            String ipMaquina = JOptionPane.showInputDialog("Informe o IP da máquina: ");
            d = new DenunciaVirtual(ipMaquina, assunto, descricaoFato, denunciante, denunciado);

        }
        this.denuncias.put(d.getCodigo(), d);
    }

    private void listar() {
        String dadosDenuncias = "";

        boolean primeiraLinha = true;
        for (Denuncia denuncia : denuncias.values()) {
            if (primeiraLinha) {
                primeiraLinha = false;
            } else {
                dadosDenuncias += "\n";
            }
            dadosDenuncias += denuncia;
        }

        JTextArea textArea = new JTextArea(20, 80);
        textArea.setText(dadosDenuncias);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
