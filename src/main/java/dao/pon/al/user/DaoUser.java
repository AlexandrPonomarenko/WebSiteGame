package dao.pon.al.user;

import dao.pon.al.util.AbstractDAO;
import dao.pon.al.util.DAOUserInterface;
import hibernate.pon.al.entity.UserE;
import hibernate.pon.al.util.HibernateUtil;
import hibernate.pon.al.util.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DaoUser extends AbstractDAO<UserE, Integer> implements DAOUserInterface{
    private SessionUtil sessionUtil;

    public DaoUser(){
    }

    @Override
    public List<UserE> getAll() {
        List<UserE> users = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM test.users").addEntity(UserE.class);
            users = query.list();
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method getAll " + e.getMessage());
            return users;
        }finally {
            System.out.println("Sesion close getAll - in class USER");
            session.close();
        }
        return users;
    }

    @Override
    public UserE update(UserE entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.update(entity);
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method update " + e.getMessage());
            return null;
        }finally {
            System.out.println("Sesion close update - in class USER");
            session.close();
        }
        return entity;
    }

    @Override
    public UserE getEntityById(Integer id) {
        UserE userE = new UserE();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
//            tx = session.beginTransaction();
            userE = session.load(UserE.class, id);
            if (userE != null){
                System.out.println("it is a getEntityById " + userE.toString());
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method getEntityById " + e.getMessage());
        }finally {
            System.out.println("Sesion close getEntityById - in class USER");
            session.close();
        }
        return userE;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            UserE user = session.get(UserE.class, id);
            if(user != null){
                session.delete(user);
            }
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method delete " + e.getMessage());
            return false;
        }finally {
            System.out.println("Sesion close delete - in class USER");
            session.close();
        }
        return true;
    }

    @Override
    public boolean create(UserE entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(entity);
//            session.flush();
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method create " + e.getMessage());
            return false;
        }finally {
            System.out.println("Sesion close create - in class USER");
            session.close();
        }
        return true;
    }

    @Override
    public UserE findUserByNickName(String nickname) {
        UserE userE = new UserE();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            userE = (UserE) session.createCriteria(UserE.class).add(Restrictions.eq("nickname", nickname)).uniqueResult();
            if(userE != null) {
                System.out.println(" IT IS FROM findUserByNickName = " +userE.toString());
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method findUserByNickName " + e.getMessage());
        }finally {
            System.out.println("Sesion close findUserByNickName - in class USER");
            session.close();
        }

        return userE;
    }

    @Override
    public UserE findConfirmKey(String key) {
        UserE userE = new UserE();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            userE = (UserE) session.createCriteria(UserE.class).add(Restrictions.eq("key", key)).uniqueResult();
            if(userE != null) {
                System.out.println(userE.toString());
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method confirmKey " + e.getMessage());
        }finally {
            System.out.println("Sesion close findConfirmKey - in class USER");
            session.close();
        }

        return userE;
    }
}
