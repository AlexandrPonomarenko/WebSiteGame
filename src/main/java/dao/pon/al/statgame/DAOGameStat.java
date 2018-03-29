package dao.pon.al.statgame;

import dao.pon.al.util.AbstractDAO;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.UserE;
import hibernate.pon.al.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DAOGameStat extends AbstractDAO<GameStatE, Integer> {

    @Override
    public List<GameStatE> getAll() {
        List<GameStatE> gameStatES = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM test.statisticsgame").addEntity(GameStatE.class);
            gameStatES = query.list();
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method getAll " + e.getMessage());
            return gameStatES;
        }finally {
            session.close();
        }
        return gameStatES;
    }

    @Override
    public GameStatE update(GameStatE entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.update(entity);
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method update GameStatE" + e.getMessage());
            return null;
        }finally {
            session.close();
        }
        return entity;
    }

    @Override
    public GameStatE getEntityById(Integer id) {
        GameStatE gameStatE = new GameStatE();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
//            tx = session.beginTransaction();
            gameStatE = session.load(GameStatE.class, id);
            if (gameStatE != null){
                System.out.println("it is a getEntityById " + gameStatE.toString());
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method getEntityById " + e.getMessage());
        }finally {
            session.close();
        }
        return gameStatE;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            GameStatE gameStatE = session.load(GameStatE.class, id);
            if(gameStatE != null){
                session.delete(gameStatE);
            }
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method delete " + e.getMessage());
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean create(GameStatE entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(entity);
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method create GameStatE" + e.getMessage());
            return false;
        }finally {
            session.close();
        }
        return true;
    }
}
