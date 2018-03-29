package dao.pon.al.util;

import hibernate.pon.al.util.SessionUtil;

import java.util.List;

public abstract class AbstractDAO<E, K>{

    public abstract List<E> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

}
