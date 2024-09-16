public class TestPessoa {
    public static int count = -1;

    public void ordenarPorIdade(Pessoa[] pessoas) {
        Pessoa pessoa;
        boolean controle = false;

        for (int i = 0; i < (count + 1); i++) {
            controle = false;
            for (int j = 0; j < count; j++) {
                if (pessoas[j].getIdade() > pessoas[j + 1].getIdade()) {
                    pessoa = pessoas[j];
                    pessoas[j] = pessoas[j + 1];
                    pessoas[j + 1] = pessoa;
                    controle = true;
                }
                if (controle)
                    return;
            }
        }
    }

    public int buscarPorIdade(int idade, Pessoa[] pessoas) {

        int inicio = 0;
        int meio;
        int fim = count;

        while (inicio < fim) {
            meio = (inicio + fim) / 2;
            if (pessoas[meio].getIdade() == idade)
                return meio;
            if (idade > pessoas[meio].getIdade())
                inicio = meio + 1;
            else
                fim = meio - 1;
        }
        return -1;
    }

}
