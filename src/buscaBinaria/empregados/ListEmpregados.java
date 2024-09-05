package buscaBinaria.empregados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEmpregados {
    private List<Empregado> empregados;

    public ListEmpregados() {
        empregados = new ArrayList<>();
    }

    public void addEmpregados(String nome, double salario) {
        empregados.add(new Empregado(nome, salario));
    }

    public void exibirEmpregadoos() {
        if (empregados.isEmpty())
            return;

        System.out.println(empregados);
    }

    public void ordenarEmpregadosPorNome() {
        if (empregados.isEmpty())
            return;

        Collections.sort(empregados, new OrdenarPorNome());
    }

    public void ordenarEmpregadosPorSalario() {
        if (empregados.isEmpty())
            return;

        Collections.sort(empregados, new OrdenarPorSalario());
    }

    public Empregado buscarEmpregadoPorSalario(double salario) {
        if (empregados.isEmpty())
            return null;

        Empregado empregado = new Empregado();
        int inicio = 0;
        int meio;
        int fim = empregados.size() - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (empregados.get(meio).getSalario() == salario) {
                empregado.setNome(empregados.get(meio).getNome());
                empregado.setSalario(empregados.get(meio).getSalario());
                return empregado;
            }

            if (salario > empregados.get(meio).getSalario())
                inicio = meio + 1;
            else
                fim = meio - 1;
        }
        return null;
    }

    public Empregado buscarEmpregadoPorNome(String nome) {
        Empregado empregado = new Empregado();
        if (!empregados.isEmpty()) {
            int inicio = 0;
            int meio;
            int fim = empregados.size() - 1;

            while (inicio <= fim) {
                meio = (inicio + fim) / 2;

                if (empregados.get(meio).getNome().equalsIgnoreCase(nome)) {
                    empregado.setNome(empregados.get(meio).getNome());
                    empregado.setSalario(empregados.get(meio).getSalario());
                    return empregado;
                }

                if (nome.charAt(meio) > empregados.get(meio).getNome().charAt(meio))
                    inicio = meio + 1;
                else
                    fim = meio - 1;
            }
        }
        return empregado;
    }

    public void removerEmpregado(String nome) {
        if (empregados.isEmpty())
            return;
        int inicio = 0;
        int meio;
        int fim = empregados.size() - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (empregados.get(meio).getNome().equalsIgnoreCase(nome)) {
                empregados.remove(empregados.get(meio));
                return;
            }

            if (nome.charAt(0) > empregados.get(meio).getNome().charAt(0))
                inicio = meio + 1;
            else {
                fim = meio - 1;
            }
        }
    }
}
