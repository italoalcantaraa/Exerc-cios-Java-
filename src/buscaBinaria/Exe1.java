package buscaBinaria;

public class Exe1 {
    public static void main(String[] args) {
        int array[] = { 1, 6, 8, 77, 100, 102 };
        int indice = buscarNum(array, 9);
        System.out.println(indice);
    }

    public static int buscarNum(int[] array, int num) {
        int inicio = 0;
        int fim = array.length -1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if(num == array[meio])
                return meio;
            if(num > array[meio])
                inicio = meio + 1;
            else fim = meio -1; 
        }
        return -1;
    }
}
