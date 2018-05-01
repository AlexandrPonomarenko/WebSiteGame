package dao.pon.al.role;

import dao.pon.al.util.AbstractDAO;
import dao.pon.al.util.DAORoleInterface;
import hibernate.pon.al.entity.RoleE;
import hibernate.pon.al.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DAORole extends AbstractDAO<RoleE, Integer> implements DAORoleInterface{

    public DAORole(){}

    @Override
    public List<RoleE> getAll() {
        List<RoleE> roles = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT * FROM test.roles").addEntity(RoleE.class);
            roles = query.list();
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            return roles;
        }finally {
            session.close();
        }
        return roles;
    }

    @Override
    public RoleE update(RoleE entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.update(entity);
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
        return entity;
    }

    @Override
    public RoleE getEntityById(Integer id) {
        RoleE role = new RoleE();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            role = session.load(RoleE.class, id);
            if (role != null){
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return role;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            RoleE roleE = session.load(RoleE.class, id);
            if(roleE != null){
                session.delete(roleE);
            }
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean create(RoleE entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(entity);
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public RoleE getRoleByName(String nameRole) {
        RoleE roleE = new RoleE();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            roleE = (RoleE) session.createCriteria(RoleE.class).add(Restrictions.eq("role", nameRole)).uniqueResult();
            if(roleE != null) {
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return roleE;
    }
}
