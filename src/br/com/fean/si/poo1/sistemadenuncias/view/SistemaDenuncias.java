package br.com.fean.si.poo1.sistemadenuncias.view;

import br.com.fean.si.poo1.sistemadenuncias.modelo.Denuncia;
import br.com.fean.si.poo1.sistemadenuncias.modelo.DenunciaPresencial;
import br.com.fean.si.poo1.sistemadenuncias.modelo.DenunciaVirtual;
import br.com.fean.si.poo1.sistemadenuncias.modelo.Funcionario;
import br.com.fean.si.poo1.sistemadenuncias.modelo.Pessoa;
import br.com.fean.si.poo1.sistemadenuncias.modelo.PessoaFisica;
import br.com.fean.si.poo1.sistemadenuncias.modelo.PessoaJuridica;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class SistemaDenuncias {

    private Map<String, Pessoa> pessoas;
    private Map<Integer, Denuncia> denuncias;
    private Map<String, Funcionario> atendentes;
    private CadastroAtendentes cadastroAtendentes;
    private CadastroPessoa cadastroPessoa;
    private CadastroDenuncia cadastroDenuncia;

    public SistemaDenuncias() {
        this.atendentes = new HashMap<>();
        this.denuncias = new HashMap<>();
        this.pessoas = new HashMap<>();
        this.cadastroAtendentes = new CadastroAtendentes(atendentes);
        this.cadastroPessoa = new CadastroPessoa(pessoas);
        this.cadastroDenuncia = new CadastroDenuncia(pessoas, denuncias, atendentes);
    }

    public static void main(String[] args) {
        SistemaDenuncias sistemaDenuncias = new SistemaDenuncias();
        sistemaDenuncias.popular();
        sistemaDenuncias.mostrarMenu();
    }

    public void mostrarMenu() {
        String opcao = "";
        do {
            opcao = JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Gerenciar pessoas \n2 - Gerenciar atendentes  \n3 - Gerenciar denuncias\n"
                    + "99 - Sair");

            switch (opcao) {
                case "1":
                    cadastroPessoa.mostrarMenu();
                    break;
                case "2":
                    cadastroAtendentes.mostrarMenu();
                    break;
                case "3":
                    cadastroDenuncia.mostrarMenu();
                    break;
                case "99":
                    Object[] options = {"Sim", "Não"};
                    int confirma = JOptionPane.showOptionDialog(null, "Encerrar o programa?", "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (confirma != 0) {
                        opcao = "";
                    }
            }
        } while (!opcao.equals("99"));
    }

    public void popular() {
        // Carrega dados iniciais de teste no sistema
        Funcionario atendente1 = new Funcionario("1", "Diretor", "11111111111", "Valdecir Lima", "valdecirlima@gmail.com", "48111111111");
        this.atendentes.put(atendente1.getMatricula(), atendente1);
        Funcionario atendente2 = new Funcionario("2", "Faxineiro", "22222222222", "Irivaldo Mota", "irivaldo@gmail.com", "48222222222");
        this.atendentes.put(atendente2.getMatricula(), atendente2);
        
        Pessoa pessoa1 = new PessoaFisica("3", "Mauro Antunes", "mauro@gmail.com", "681237612093");
        this.pessoas.put(pessoa1.getDocumento(), pessoa1);
        Pessoa pessoa2 = new PessoaJuridica("4", "FEAN", "fean@gmail.com", "065987634976");
        this.pessoas.put(pessoa2.getDocumento(), pessoa2);
        
        Denuncia denuncia1 = new DenunciaPresencial("Delegacia da Trindade", atendente1, "Assalto", "Assalto a mão armada no ônibus", pessoa2, pessoa1);
        this.denuncias.put(denuncia1.getCodigo(), denuncia1);
        Denuncia denuncia2 = new DenunciaVirtual("200.15.1.300", "Perturbação de Silêncio", "Som insuportável", pessoa1, pessoa2);
        this.denuncias.put(denuncia2.getCodigo(), denuncia2);
    }
}
