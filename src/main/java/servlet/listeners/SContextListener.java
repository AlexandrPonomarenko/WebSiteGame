package servlet.listeners;

import dao.pon.al.role.DAORole;
import dao.pon.al.statgame.DAOGameStat;
import dao.pon.al.user.DaoUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("daoUser", new DaoUser());
        servletContext.setAttribute("daoRole", new DAORole());
        servletContext.setAttribute("daoStatGame", new DAOGameStat());
//        servletContext.setAttribute("list",);
        System.out.println("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("contextDestroyed");
    }
}
