package buscaBinaria;

public class Exe2 {
    public static void main(String[] args) {
        String[] array = { "Ana", "Italo", "João", "Mirella", "Rayssa" };
        int indice = buscarNome(array, "ITALO");

        System.out.println(array[indice]);
    }

    public static int buscarNome(String[] array, String nome) {
        int inicio = 0;
        int meio;
        int fim = array.length - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (array[meio] .equalsIgnoreCase(nome))
                return meio;
            if (nome.charAt(0) > array[meio].charAt(0))
                inicio = meio + 1;
            else
                fim = meio - 1;
        }
        return -1;
    }
}
