package usuarios;

public class TestUsuarios {
    public void menu() {

    }

    public void inserirUsuario(String nome, String senha){
        Usuarios usuario = new Usuarios(nome, senha);
    }

    public void listarUsuarios(Usuarios usuarios) {
        System.out.println(usuarios);
    }

    
    public static void main(String[] args) {
        
    }
}
