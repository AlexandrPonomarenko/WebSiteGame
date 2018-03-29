package dao.pon.al.util;

import hibernate.pon.al.entity.UserE;

public interface DAOUserInterface {
    UserE findUserByNickName(String nickname);
    UserE findConfirmKey(String key);
}
