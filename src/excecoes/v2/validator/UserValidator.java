package excecoes.v2.validator;

import excecoes.v2.userModel.UserModel;
import excecoes.v2.exception.ValidatorException;

public class UserValidator {

    private UserValidator(){

    }

    public static void validate(UserModel user) throws ValidatorException {

        if (isBlank(user.getName())){
            throw new ValidatorException("Nome não pode ser vazio.");
        }
        if (user.getName().length() < 2) {
            throw new ValidatorException("Nome deve ter pelo menos 2 caracteres.");
        }
        if (isBlank(user.getEmail())) {
            throw new ValidatorException("E-mail não pode ser vazio.");
        }
        if (!user.getEmail().contains("@") || !user.getEmail().contains(".")) {
            throw new ValidatorException("E-mail inválido.");
        }
        if (user.getBirthday() == null) {
            throw new ValidatorException("Data de nascimento é obrigatória.");
        }
    }
    private static boolean isBlank(String value){
        return value == null || value.isBlank();
    }
}