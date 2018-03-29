package dao.pon.al.util;


import hibernate.pon.al.entity.RoleE;

public interface DAORoleInterface {
    RoleE getRoleByName(String nameRole);
}
