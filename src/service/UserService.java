package src.service;

import src.model.User;

// Sub interface
public interface UserService extends BaseService, LogService {

    int addUser(User user);

    void updateUser(User userId);

    void deleteUser(long userId);
}
