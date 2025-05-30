package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Query;

public class UserDao {

    public String addUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
            return "DATA SAVED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            session.close();
            return "DATA UPDATED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            session.close();
            return "DATA DELETED SUCCESSFULLY";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            User u = (User) session.get(User.class, user.getId());
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User getUserByUsername(String username) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.createQuery("FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
        session.close();
        return user;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    public List<User> getAllUsers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<User> users = session.createQuery("SELECT u FROM User u").list();
            session.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User authenticate(String username, String password) {
    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.createQuery("select u FROM User u WHERE u.username = :username AND u.password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
        session.close();
        return user;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


} 

