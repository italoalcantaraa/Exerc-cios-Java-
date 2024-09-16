package exercicios.people;

import javax.swing.JOptionPane;

public class TestPeople {

    static int count = -1;

    // Menu de opções
    public void menu(People[] people) {
        String optionsMenu = "1 - Inserir usuario"
                + "\n2 - Exibir usuarios "
                + "\n3 - Classificar por nome (Selection Sort)"
                + "\n4 - Classificar por nome (Insert Sort)"
                + "\n5 - Classificar por RG (Selection Sort)"
                + "\n6 - Classificar por RG (Insert Sort)"
                + "\n7 - Buscar um RG (Busca Binária)"
                + "\n8 - Buscar um nome (Busca Binária)"
                + "\n9 - Encerrar";
        String optionUser, rg, name;
        int pos;

        while (true) {
            optionUser = JOptionPane.showInputDialog(null, optionsMenu);
            switch (optionUser) {
                case "1":
                    insertPerson(people);
                    break;
                case "2":
                    showPeople(people);
                    break;
                case "3":
                    sortByNameSelectionSort(people);
                    break;
                case "4":
                    sortByNameInsertSort(people);
                    break;
                case "5":
                    sortByRgSelectionSort(people);
                    break;
                case "6":
                    sortByRgInsertSort(people);
                    break;
                case "7":
                    rg = JOptionPane.showInputDialog(null, "Informe o RG: ");
                    pos = searchByRg(people, rg);

                    if (pos >= 0)
                        JOptionPane.showMessageDialog(null, people[pos]);
                    else
                        JOptionPane.showMessageDialog(null, "Não encontrado");

                    break;
                case "8":
                    name = JOptionPane.showInputDialog(null, "Informe o nome: ");
                    pos = searchByName(people, name);

                    if (pos >= 0)
                        JOptionPane.showMessageDialog(null, people[pos]);
                    else
                        JOptionPane.showMessageDialog(null, "Não encotrado");
                        
                    break;
                case "9":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }

    // Ordenar por rg (Insert Sort)
    public void sortByRgInsertSort(People[] people) {
        People aux;
        int j;

        for (int i = 1; i < (count + 1); i++) {
            aux = people[i];
            j = i - 1;

            while (j >= 0 && (people[j].getRg().compareToIgnoreCase(aux.getRg())) >= 1) {
                people[j + 1] = people[j];
                j--;
            }

            people[j + 1] = aux;
        }

    }

    // Ordenar por nome (Insert Sort)
    public void sortByNameInsertSort(People[] people) {
        People aux;
        int j;

        for (int i = 1; i < (count + 1); i++) {
            aux = people[i];
            j = i - 1;

            while (j >= 0 && people[j].getName().charAt(0) > aux.getName().charAt(0)) {
                people[j + 1] = people[j];
                j--;
            }

            people[j + 1] = aux;
        }

    }

    // Exibir pessoas
    public void showPeople(People[] people) {
        JOptionPane.showMessageDialog(null, people);
    }

    // Classificar por rg (Selection sort)
    public void sortByRgSelectionSort(People[] people) {
        People aux;
        int lowestPosition;

        for (int i = 0; i < (count + 1); i++) {
            lowestPosition = i;
            for (int j = i + 1; j < (count + 1); j++) {
                int value = (int) people[lowestPosition].getRg().compareTo(people[j].getRg());

                if (value >= 1)
                    lowestPosition = j;

            }
            aux = people[i];
            people[i] = people[lowestPosition];
            people[lowestPosition] = aux;
        }
    }

    // Classificar por nome (Selection sort)
    public void sortByNameSelectionSort(People[] people) {
        People aux;
        int lowestPosition;

        for (int i = 0; i < (count + 1); i++) {
            lowestPosition = i;
            for (int j = i + 1; j < (count + 1); j++) {
                if (people[lowestPosition].getName().charAt(0) > people[j].getName().charAt(0))
                    lowestPosition = j;

                aux = people[i];
                people[i] = people[lowestPosition];
                people[lowestPosition] = aux;
            }
        }
    }

    // Inserir pessoa
    public void insertPerson(People[] people) {
        count++;

        if (count == 5)
            return;

        people[count] = new People(
                JOptionPane.showInputDialog(null, "Informe o nome: "),
                JOptionPane.showInputDialog(null, "Informe o e-mail: "),
                JOptionPane.showInputDialog(null, "Informe o RG: "));
    }

    // Pesquisar pessoa por nome
    public int searchByName(People[] people, String name) {
        int start = 0;
        int middle;
        int end = count;

        while (start <= end) {
            middle = (start + end) / 2;

            if (people[middle].getName().equalsIgnoreCase(name))
                return middle;
            if (name.charAt(0) > people[middle].getName().charAt(0))
                start = middle++;
            else
                end = middle--;

        }
        return -1;
    }

    // Pesquisar pessoa por RG
    public int searchByRg(People[] people, String rg) {
        int start = 0;
        int middle;
        int end = count;

        while (start <= end) {
            middle = (start + end) / 2;

            if (people[middle].getRg().equalsIgnoreCase(rg))
                return middle;

            if (rg.compareTo(people[middle].getRg()) > 0)
                start = middle++;
            else
                end = middle--;

        }
        return -1;
    }

    public static void main(String[] args) {
        People[] people = new People[5];
        TestPeople testPeople = new TestPeople();
        testPeople.menu(people);
    }
}
