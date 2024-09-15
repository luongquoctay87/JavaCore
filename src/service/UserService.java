package src.service;

import src.model.User;

public interface UserService extends BaseService, LogService {

    int addUser(User user);

    void updateUser(User userId);

    void deleteUser(long userId);
}
