package exercicios.people;

public class People {
    private String name;
    private String email;
    private String rg;

    public People(String name, String email, String rg) {
        this.name = name;
        this.email = email;
        this.rg = rg;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return String.format("{nome:\"%s\", email:\"%s\", rg: \"%s\"}", name, email, rg);
    }
}
