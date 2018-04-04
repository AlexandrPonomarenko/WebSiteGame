package dao.pon.al.role;

import dao.pon.al.util.AbstractDAO;
import dao.pon.al.util.DAORoleInterface;
import hibernate.pon.al.entity.RoleE;
import hibernate.pon.al.entity.UserE;
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
            System.out.println("Error in method getAll " + e.getMessage());
            return roles;
        }finally {
            System.out.println("Sesion close getAll - in class ROLE");
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
            System.out.println("Error in method update Role" + e.getMessage());
            return null;
        }finally {
            System.out.println("Sesion close update - in class ROLE");
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
//            tx = session.beginTransaction();
            role = session.load(RoleE.class, id);
            if (role != null){
                System.out.println("it is a getEntityById " + role.toString());
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method getEntityById " + e.getMessage());
        }finally {
            System.out.println("Sesion close getEntityById - in class ROLE");
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
            System.out.println("Error in method delete " + e.getMessage());
            return false;
        }finally {
            System.out.println("Sesion close delete - in class ROLE");
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
            System.out.println("Error in method create ROLE " + e.getMessage());
            return false;
        }finally {
            System.out.println("Sesion close create - in class USER");
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
                System.out.println(roleE.toString());
            }
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            e.printStackTrace();
            System.out.println("Error in method getRoleByName " + e.getMessage());
        }finally {
            System.out.println("Sesion close getRoleByName - in class ROLE");
            session.close();
        }

        return roleE;
    }
}
