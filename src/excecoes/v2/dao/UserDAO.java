package excecoes.v2.dao;

import excecoes.v2.userModel.UserModel;
import excecoes.v2.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private long nextId = 1L;
    private final List<UserModel> users = new ArrayList<>();

    //CREATE
    public UserModel save(UserModel user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    // READ ALL
    public List<UserModel> findAll() {
        return new ArrayList<>(users);
    }

    //READ BY ID
    public UserModel findById(long id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new UserNotFoundException("Usuário não encontrado para o ID: " + id));
    }

    //UPDATE
    public UserModel update(UserModel user) {
        for(int i = 0; i < users.size(); i++) {
            if ( users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return user;
            }
        }
        throw  new UserNotFoundException("Usuário não encontrado para o ID: " + user.getId());
    }

    //DELETE
    public void delete(long id) {
        UserModel existing = findById(id);
        users.remove(existing);
    }
}
