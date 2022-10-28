package PP_31._boot.service;

import PP_31._boot.entity.User;

import java.util.List;

public interface UserService {
    public List<User> showUsers();

    public User showUserById(int id);

    public void addUser(User user);

    public void updateUser(int id, User user);

    public void deleteUser(int id);
}
