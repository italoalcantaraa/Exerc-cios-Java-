package buscaBinaria.empregados;

public class TesteEmpregados {
    public static void main(String[] args) {
        ListEmpregados empregados = new ListEmpregados();

        empregados.addEmpregados("Italo", 1000);
        empregados.addEmpregados("Maria", 100);
        empregados.addEmpregados("Pedro", 200);
        empregados.addEmpregados("Giovanna", 2000);
        empregados.addEmpregados("Pablo", 10000);

        empregados.exibirEmpregadoos();

        empregados.ordenarEmpregadosPorNome();
        empregados.ordenarEmpregadosPorSalario();

        System.out.println("************");
        System.out.println(empregados.buscarEmpregadoPorNome("italo"));
        System.out.println("++++++++++++++++++");
        System.out.println(empregados.buscarEmpregadoPorSalario(10000));
    }
}
