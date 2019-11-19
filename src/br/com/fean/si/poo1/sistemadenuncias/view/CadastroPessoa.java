package br.com.fean.si.poo1.sistemadenuncias.view;

import br.com.fean.si.poo1.sistemadenuncias.modelo.Pessoa;
import br.com.fean.si.poo1.sistemadenuncias.modelo.PessoaFisica;
import br.com.fean.si.poo1.sistemadenuncias.modelo.PessoaJuridica;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CadastroPessoa {

    private Map<String, Pessoa> pessoas;

    public CadastroPessoa(Map<String, Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void mostrarMenu() {
        int opcao = 0;
        String opUsuario = null;
        do {
            opUsuario = JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Incluir Pessoa\n"
                    + "2 - Listar Pessoas\n"
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
        String nome = JOptionPane.showInputDialog("Informe o nome da Pessoa:");
        String email = JOptionPane.showInputDialog("Informe o email da Pessoa :");
        String telefone = JOptionPane.showInputDialog("Informe o telefone da Pessoa:");
        String tipoPessoa = JOptionPane.showInputDialog("Informe o Tipo da Pessoa (1- Fisica, 2- Juridica):");
        Pessoa p = null;
        String documento = null;
        if (tipoPessoa.equals("1")) {

            documento = JOptionPane.showInputDialog("Informe o cpf da Pessoa :");
            p = new PessoaFisica(documento, nome, email, telefone);
        } 
        else if (tipoPessoa.equals("2")) {
           documento = JOptionPane.showInputDialog("Informe o cnpj da Pessoa :");
            p = new PessoaJuridica(documento, nome, email, telefone);
        }
         this.pessoas.put(documento, p);
    }

    private void listar() {
        String dadosPessoas = "";

        for (Pessoa pessoa : pessoas.values()) {
            dadosPessoas += pessoa.getDocumento()+ ", " + pessoa.getNome() + ", "
                    + pessoa.getEmail() + ", " + pessoa.getTelefone() + "\n";
        }

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(dadosPessoas);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);
    }

}

