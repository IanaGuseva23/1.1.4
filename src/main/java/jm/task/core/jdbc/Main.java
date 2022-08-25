package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getSessionFactory();
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("Maria", "Ivanova", (byte) 46);
        userDao.saveUser("Petr", "Petrov", (byte) 23);
        userDao.saveUser("Anna", "Sidorova", (byte) 34);
        userDao.saveUser("Sasha", "Smirnov", (byte) 18);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}