package zjj.oa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface BaseDao<T> {

    void saveEntity(T t);

    void deleteEntity(Serializable id);

    void updateEntity(T t);

    T getEntityById(Serializable id);

    Collection<T> getAllEntities();

    Set<T> getEntitiesByIds(Serializable[] ids);

}
