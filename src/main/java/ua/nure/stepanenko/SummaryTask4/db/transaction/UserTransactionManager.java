package ua.nure.stepanenko.SummaryTask4.db.transaction;

import ua.nure.stepanenko.SummaryTask4.exception.db.DBException;
import ua.nure.stepanenko.SummaryTask4.model.constant.Role;
import ua.nure.stepanenko.SummaryTask4.model.entyty.User;

/**
 * Created by eugen on 21.05.2017.
 */
public interface UserTransactionManager {

    boolean createUser(User user) throws DBException;

    User getUserByLogin(String login) throws DBException;

    User getUserByLoginAndPassword(String login, String password) throws DBException;

    boolean updateUserByLogin(User user, String oldLogin) throws DBException;

    boolean setUserFieldRoleByUserLogin(Role role, String userLogin) throws DBException;

    boolean setUserFieldPassportByUserLogin(String passport, String userLogin) throws DBException;

    boolean setUserFieldBlockedByUserLogin(boolean blocked, String userLogin) throws DBException;
}
