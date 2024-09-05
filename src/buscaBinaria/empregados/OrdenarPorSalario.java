package buscaBinaria.empregados;

import java.util.Comparator;

public class OrdenarPorSalario implements Comparator<Empregado> {
    @Override
    public int compare(Empregado p1, Empregado p2) {
        return (int) (p1.getSalario() - p2.getSalario());
    }
}
