package usuario;

public abstract class Usuario {

    private String nome;

    private String email;

    private String senha;

    private boolean logado;

    public Usuario(String nome,
                   String email,
                   String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return getClass().getSimpleName();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void realizarLogin() {
        logado = true;
        System.out.println(nome + " realizou login.");

    }

    public void realizarLogoff() {
        logado = false;
        System.out.println(nome + " realizou logoff.");

    }

    public void alterarDados(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public abstract boolean isAdministrador();

}
