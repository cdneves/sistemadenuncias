package br.com.fean.si.poo1.sistemadenuncias.view;

import br.com.fean.si.poo1.sistemadenuncias.modelo.Funcionario;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CadastroAtendentes {

    private Map<String, Funcionario> atendentes;

    public CadastroAtendentes(Map<String, Funcionario> atendentes) {
        this.atendentes = atendentes;
    }

    public void mostrarMenu() {
        int opcao = 0;
        String opUsuario = null;
        do {
            opUsuario = JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Incluir funcionário\n"
                    + "2 - Listar funcionários\n"
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
        String cpf = JOptionPane.showInputDialog("Informe o CPF do funcionário:");
        String nome = JOptionPane.showInputDialog("Informe o nome do funcionário :");
        String email = JOptionPane.showInputDialog("Informe o e-mail do funcionário:");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do funcionário:");
        String matricula = JOptionPane.showInputDialog("Informe a matrícula do funcionário:");
        String cargo = JOptionPane.showInputDialog("Informe o cargo do funcionário:");

        Funcionario f = new Funcionario(matricula, cargo, cpf, nome, email, telefone);
        this.atendentes.put(matricula, f);
    }

    private void listar() {
        String dadosAtendentes = "";

        boolean primeiralinha = true;
        for (Funcionario atendente : atendentes.values()) {
            if (primeiralinha) {
                primeiralinha = false;
            } else {
                dadosAtendentes += "\n";
            }
            dadosAtendentes += atendente;
        }

        JTextArea textArea = new JTextArea(20, 80);
        textArea.setText(dadosAtendentes);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);
    }

}
