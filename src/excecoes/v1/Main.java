package excecoes.v1;

import excecoes.v1.UserModel.MenuOption;
import excecoes.v1.UserModel.UserModel;
import excecoes.v1.dao.UserDAO;
import excecoes.v1.exception.CustomExeption;
import excecoes.v1.exception.EmptyStorageExeption;
import excecoes.v1.exception.UserNotFoundException;
import excecoes.v1.exception.ValidatorException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static excecoes.v1.validator.UserValidator.verifyModel;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("===|Bem-vindo ao cadastro de usuários|===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Bucar por Id");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            System.out.print("Selecione a operação desejada: ");
            var userInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[userInput -1];
            switch (selectedOption){
                case SAVE -> {
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("Usuário Cadastrado: %s", user);
                    }catch (CustomExeption ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case UPDATE -> {
                    try{
                        var user = dao.update(requestToUpdate());
                        System.out.printf("Usuário atualizado: %s", user);
                    }catch (UserNotFoundException | EmptyStorageExeption ex){
                        System.out.println(ex.getMessage());
                    }catch (CustomExeption ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }finally {
                        System.out.println("==================");
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestID());
                        System.out.println("Usuário Excluído");
                    }catch (UserNotFoundException | EmptyStorageExeption ex){
                        System.out.println(ex.getMessage());
                    }finally {
                        System.out.println("////////////////");
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestID();
                        var user = dao.findById(id);
                        System.out.printf("Usuário com id %s", id);
                        System.out.println(user);
                    }catch (UserNotFoundException | EmptyStorageExeption ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_ALL -> {
                    try {
                        var users = dao.findAll();
                        System.out.println("====|Usuários Cadastrados|====");
                        users.forEach(System.out::println);
                        System.out.println("=============|FIM|============");
                    }catch (UserNotFoundException | EmptyStorageExeption ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case EXIT -> System.exit(0);
            }
        }

    }

    private static UserModel requestToSave(){
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static UserModel validateInputs(final long id, final String name,
                                     final String email, final LocalDate birthday){
        var user = new UserModel(0, name, email, birthday);
        try {
            verifyModel(user);
            return user;
        }catch (ValidatorException ex){
            throw new CustomExeption("O seu usuário contêm erros: " + ex.getMessage(), ex);
        }
    }

    private static UserModel requestToUpdate(){
        System.out.println("Informe o id do usuário");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static long requestID(){
        System.out.println("Informe o id do usuário");
        return scanner.nextLong();
    }
}
