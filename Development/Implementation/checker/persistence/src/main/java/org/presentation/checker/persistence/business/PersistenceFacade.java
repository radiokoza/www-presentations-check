package org.presentation.checker.persistence.business;

import java.util.List;
import org.presentation.checker.persistence.model.Checkup;
import org.presentation.checker.persistence.model.Login;
import org.presentation.checker.persistence.model.User;

/**
 *
 * @author radio.koza
 */
public interface PersistentFacade {

    boolean createNewUser(String email, String pass, String name, String surname);

    void createNewCheckup(Checkup checkup);

    void addUserLogin(User user, String address);

    void editUser(User user);

    User findUser(Integer userId);

    User findUser(String email);

    List<Checkup> findUserCheckings(User user);

    Checkup findCheckup(Integer checkId);

    void updateCheckup(Checkup checkup);

    List<Login> findUserLogins(User user);

    Login findLastUserLogin(User user);

}