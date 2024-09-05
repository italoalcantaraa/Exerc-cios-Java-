package Ordenacao;

public class Exe {
    public static void main(String[] args) {
        int array[] = { 13, 1, 4, 5, 6, 2, 0 };

        System.out.println("Lista não ordenada: ");
        for (int i : array)
            System.out.print(i + " - ");

        System.out.println("\nLista ordenada em ordem crescente: ");

        array = ordenaCrescente(array);
        for (int i : array) {
            System.out.print(i + " - ");
        }

        System.out.println("\nLista ordenada em ordem decrescente: ");

        array = ordenaDecrescente(array);

        for (int i : array) {
            System.out.print(i + " - ");
        }
    }

    public static int[] ordenaCrescente(int[] array) {
        int aux;
        boolean controle;

        for (int i = 0; i < array.length; i++) {
            controle = true;
            for (int j = 0; j < (array.length - 1); j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    controle = false;
                }
            }
            if (controle)
                return array;
        }
        return array;
    }

    public static int[] ordenaDecrescente(int[] array) {
        int aux;
        boolean controle;

        for (int i = 0; i < array.length; i++) {
            controle = true;
            for (int j = 0; j < (array.length - 1); j++) {
                if (array[j] < array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    controle = false;
                }
            }
            if (controle)
                return array;
        }
        return array;
    }
}
