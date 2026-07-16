import usuario.Atendente;
import usuario.Gerente;
import usuario.Usuario;
import usuario.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String SEPARADOR =
            "=================================";

    public static void main(String[] args) {

        Gerente gerente = new Gerente(
                "Ana",
                "ana@email.com",
                "123"
        );

        Vendedor vendedor = new Vendedor(
                "Carlos",
                "carlos@email.com",
                "456"
        );

        Atendente atendente = new Atendente(
                "Mariana",
                "mariana@email.com",
                "789"
        );

        vendedor.realizarVenda();
        vendedor.realizarVenda();
        vendedor.realizarVenda();


        atendente.receberPagamento(100);
        atendente.receberPagamento(50);


        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(gerente);
        usuarios.add(vendedor);
        usuarios.add(atendente);


        for (Usuario usuario : usuarios) {

            System.out.println(SEPARADOR);
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Cargo: " + usuario.getTipoUsuario());
            System.out.println("Administrador: "
                    + usuario.isAdministrador());
            System.out.println(SEPARADOR);
        }

        System.out.println("\n=== Demonstração dos métodos específicos ===");

        System.out.println("\n[usuario.Vendedor]");
        vendedor.consultarVendas();

        System.out.println("\n[usuario.Atendente]");
        atendente.fecharCaixa();

        System.out.println("\n[usuario.Gerente]");
        gerente.gerarRelatorioFinanceiro();

        System.out.println(SEPARADOR);

    }
}