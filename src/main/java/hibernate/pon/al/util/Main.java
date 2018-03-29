package hibernate.pon.al.util;

import dao.pon.al.role.DAORole;
import dao.pon.al.statgame.DAOGameStat;
import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.RoleE;
import hibernate.pon.al.entity.UserE;
import org.hibernate.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Object> userEntitylist = null;
//        SessionFactory sessionFactory =
//                HibernateUtil.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tx;
        try{
//            tx = session.beginTransaction();
//            RoleE admin = new RoleE();
//            admin.setRole("admin");
//            RoleE manager = new RoleE();
//            manager.setRole("manager");
//            RoleE user = new RoleE();
//            user.setRole("user");
//
//
//            UserE user1 = new UserE();
//            user1.setNickname("a");
//            user1.setEmail("furriets@gmail.com");
//            user1.setFirstname("alex");
//            user1.setLastname("pon");
//            user1.setStatus("ON");
//            user1.setKey("confirm");
//            user1.setPassword("123");
//            user1.setPasswordTwo("123");
//
//            UserE user2 = new UserE();
//            user2.setNickname("b");
//            user2.setEmail("furriets@gmail.com");
//            user2.setFirstname("alex");
//            user2.setLastname("pon");
//            user2.setStatus("ON");
//            user2.setKey("confirm");
//            user2.setPassword("123");
//            user2.setPasswordTwo("123");
//
//            UserE user3 = new UserE();
//            user3.setNickname("c");
//            user3.setEmail("furriets@gmail.com");
//            user3.setFirstname("alex");
//            user3.setLastname("pon");
//            user3.setStatus("OFF");
//            user3.setKey("confirm");
//            user3.setPassword("123");
//            user3.setPasswordTwo("123");
//
//            GameStatE gameStatE = new GameStatE();
//            gameStatE.setLost(0);
//            gameStatE.setVin(1);
//
//            GameStatE gameStatE1 = new GameStatE();
//            gameStatE1.setLost(0);
//            gameStatE1.setVin(2);
//
//            GameStatE gameStatE2 = new GameStatE();
//            gameStatE2.setLost(0);
//            gameStatE2.setVin(3);
//
//            user1.getStatgame().add(gameStatE);
//            gameStatE.setUserE(user1);
//
//            user2.getStatgame().add(gameStatE1);
//            gameStatE1.setUserE(user2);
//
//            user3.getStatgame().add(gameStatE2);
//            gameStatE2.setUserE(user3);
//
//            admin.getUsers().add(user1);
//            user1.setRoleE(admin);
//
//            manager.getUsers().add(user2);
//            user2.setRoleE(manager);
//
//            user.getUsers().add(user3);
//            user3.setRoleE(user);
//
//            session.save(admin);
//            session.save(manager);
//            session.save(user);
//            session.save(user1);
//            session.save(user2);
//            session.save(user3);
//            session.save(gameStatE);
//            session.save(gameStatE1);
//            session.save(gameStatE2);
//            addUser();
//            changeRole();
//            getNameRole();
//            ddd();
//            System.out.println("- " + randomGen() + " -");
//            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
//            session.beginTransaction().rollback();
        }finally {
//            session.close();
//            HibernateUtil.shutdown();
            System.out.println("CLOSE SessionFactory");
        }
    }
    public static void addUser(){
        DAORole daoRole = new DAORole();
        DaoUser daoUser = new DaoUser();
        DAOGameStat daoGameStat = new DAOGameStat();
        UserE userE = new UserE();
//        GameStatE gameStatE = new GameStatE();
//        gameStatE.setLost(0);
//        gameStatE.setVin(0);
        RoleE role;
        role = daoRole.getEntityById(12);

        userE.setNickname("pizdos");
        userE.setEmail("furriets@gmail.com");
        userE.setFirstname("alex");
        userE.setLastname("pon");
        userE.setStatus("OFF");
        userE.setPassword("123");
        userE.setPasswordTwo("123");

//        userE.getStatgame().add(gameStatE);
//        gameStatE.setUserE(userE);

        role.getUsers().add(userE);
        userE.setRoleE(role);

        daoUser.create(userE);
        daoRole.update(role);
//        daoUser.create(userE);
//        daoGameStat.create(gameStatE);

    }

    public static void changeRole(){
        DAORole daoRole = new DAORole();
        DaoUser daoUser = new DaoUser();
        DAOGameStat daoGameStat = new DAOGameStat();

        RoleE roleE = daoRole.getEntityById(13);

        UserE userE = daoUser.findUserByNickName("pizdos");
        System.out.println(userE.toString());

        GameStatE gameStatE = new GameStatE();
        gameStatE.setVin(111);
        gameStatE.setLost(0);

        roleE.getUsers().add(userE);
        userE.setRoleE(roleE);
        userE.setPassword("090909099090909");
        userE.setFirstname("DIADIAVOVA");
        gameStatE.setUserE(userE);
        userE.getStatgame().add(gameStatE);


        daoRole.update(roleE);
    }

    public static void ddd(){
        DaoUser daoUser = new DaoUser();
        UserE userE = daoUser.findUserByNickName("popopopo");
        if(userE != null){
            System.out.println("EST");
        }else{
            System.out.println("NTE");
        }

         userE = daoUser.findUserByNickName("olololo");
        if(userE != null) System.out.println(userE.toString());
    }

    public static void getNameRole(){
        DAORole daoRole = new DAORole();
        RoleE roleE = daoRole.getRoleByName("user");
        if(roleE != null){
            System.out.println("EST");
        }else{
            System.out.println("NTE");
        }
        System.out.println(roleE.toString());
    }

    public static String randomGen(){
        String key ="";
        char[] abs = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f',
                'g','h','j','k','l','z','x','c','v','b','n','m','1','2','3','4','5','6','7','8','9','0',};
        Random random = new Random();
        for (int i = 0; i < abs.length / 2; i++){
             key += abs[random.nextInt(abs.length)];
        }
        return key;
    }
}
