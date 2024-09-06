package usuarios;

import javax.swing.*;

public class TestUsuarios {

    static int contador = -1;

    public void menu(Usuarios[] usuarios) {
        String opcoes = "1 - Inserir usuario "
                + "\n2 - Listar usuários"
                + "\n3 - Ordenar usuários"
                + "\n4 - Buscar usuários por nome"
                + " \n5 - Sair";

        String opcaoSelecionada, nome, senha;

        while (true) {
            opcaoSelecionada = JOptionPane.showInputDialog(null, opcoes);

            switch (opcaoSelecionada) {
                case "1":
                    nome = JOptionPane.showInputDialog(null, "Informe o nome: ");
                    senha = JOptionPane.showInputDialog(null, "Informe a senha: ");
                    inserirUsuario(nome, senha, usuarios);
                    break;
                case "2":
                    listarUsuarios(usuarios);
                    break;
                case "3":
                    ordenar(usuarios);
                    break;
                case "4":
                    nome = JOptionPane.showInputDialog(null, "Informe a nome: ");
                    ordenar(usuarios);
                    int pos = buscarUsuarioPorNome(nome, usuarios);

                    if (pos > -1)
                        JOptionPane.showMessageDialog(null, usuarios[pos]);
                    else
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");

                    break;
                case "5":
                    return;
                default:
                    JOptionPane.showInputDialog(null, "Opção inválida!");
                    break;
            }
        }
    }

    public void inserirUsuario(String nome, String senha, Usuarios[] usuarios) {
        if (contador == 5)
            return;

        contador++;
        usuarios[contador] = new Usuarios(nome, senha);
    }

    public void listarUsuarios(Usuarios[] usuarios) {
        JOptionPane.showMessageDialog(null, usuarios);
    }

    public void ordenar(Usuarios[] usuarios) {
        Usuarios aux;
        boolean controle;

        for (int i = 0; i < (contador + 1); i++) {
            controle = false;
            for (int j = 0; j < contador; j++) {
                if (usuarios[j].getNome().charAt(0) > usuarios[j + 1].getNome().charAt(0)) {
                    aux = usuarios[j];
                    usuarios[j] = usuarios[j + 1];
                    usuarios[j + 1] = aux;
                    controle = true;
                }
            }
            if (controle)
                return;
        }
    }

    public int buscarUsuarioPorNome(String nome, Usuarios[] usuarios) {
        int inicio = 0;
        int meio;
        int fim = contador;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (nome.intern().equalsIgnoreCase(usuarios[meio].getNome()))
                return meio;

            if (nome.charAt(0) > usuarios[meio].getNome().charAt(0))
                inicio = meio + 1;
            else
                fim = meio - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Usuarios[] usuarios = new Usuarios[5];

        TestUsuarios testUsuarios = new TestUsuarios();
        testUsuarios.menu(usuarios);
    }
}
