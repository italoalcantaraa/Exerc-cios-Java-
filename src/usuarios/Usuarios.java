package usuarios;

public class Usuarios {
    private String nome;
    private String senha;

    public Usuarios(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuarios() {
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return String.format("{\"%s\", \"%s\"}", nome, senha);
    }
}
