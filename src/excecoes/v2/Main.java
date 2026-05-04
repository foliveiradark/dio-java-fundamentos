package excecoes.v2;

import excecoes.v2.exception.ValidatorException;
import excecoes.v2.dao.UserDAO;
import excecoes.v2.exception.BusinessException;
import excecoes.v2.userModel.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static excecoes.v2.validator.UserValidator.validate;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserDAO dao = new UserDAO();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String [] args) {

        while (true) {
            try {
                showMenu();
                int option = readInt();

                switch (option) {
                    case 1 -> save();
                    case 2 -> update();
                    case 3 -> delete();
                    case 4 -> findById();
                    case 5 -> findAll();
                    case 6 -> exit();
                    default -> System.out.println("Opção inválida.");
                }
            } catch (ValidatorException e){
                System.out.println("Erro de validação: " + e.getMessage());
            } catch (BusinessException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado:");
                e.printStackTrace();
            }
        }
    }

    private static void showMenu(){
        System.out.println("===|Bem-vindo ao cadastro de usuários|===");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Bucar por ID");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");
        System.out.print("Selecione a operação desejada: ");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Digite um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void save() throws ValidatorException {
        UserModel user = readUserData(0);
        dao.save(user);
        System.out.println("Usuário salvo com sucesso!");
    }

    private static void update() throws ValidatorException {
        System.out.print("Informe o ID: ");
        long id = readInt();

        UserModel user = readUserData(id);
        dao.update(user);

        System.out.println("Usuário atualizado com sucesso!");
    }

    private static void delete() {
        System.out.print("Informe o ID: ");
        long id = readInt();

        dao.delete(id);
        System.out.println("Usuário removido.");
    }

    private static void findById() {
        System.out.print("Informe o ID: ");
        long id = readInt();

        var user = dao.findById(id);
        System.out.println(user);
    }

    private static void findAll() {
        var users = dao.findAll();

        if (users.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado");
            return;
        }

        users.forEach(System.out::println);
    }

    private static void exit() {
        System.out.println("Saindo...");
        System.exit(0);
    }

    private static UserModel readUserData(long id) throws ValidatorException {

        System.out.print("Nome: ");
        String name = scanner.next();

        System.out.print("e-mail: ");
        String email = scanner.next();

        System.out.print("Data de Nascimento (dd/MM/yyyy: ");
        String date = scanner.next();

        LocalDate birthday = LocalDate.parse(date, formatter);

        UserModel user = new UserModel(id, name, email, birthday);

        validate(user);

        return user;
    }
}