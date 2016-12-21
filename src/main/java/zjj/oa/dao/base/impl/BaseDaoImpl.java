package zjj.oa.dao.base.impl;

import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import zjj.oa.dao.base.BaseDao;
import zjj.oa.utils.OAUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class cls;

    public BaseDaoImpl() {
        //得到泛型(ParameterizedType 也就是 T 的实际类型)
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //得到 T 的class(字节码) (e.g. Department.class, User.class, Role.class...)
        this.cls = (Class) type.getActualTypeArguments()[0];
    }

    @Resource(name = "hibernateTemplate")
    public HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void saveEntity(T t) {
        this.hibernateTemplate.save(t);
    }

    public void deleteEntity(Serializable id) {
        T t = (T) this.hibernateTemplate.get(this.cls, id);
        this.hibernateTemplate.delete(t);
    }


    public void updateEntity(T t) {
        this.hibernateTemplate.update(t);
    }

    public T getEntityById(Serializable id) {
        return (T) this.hibernateTemplate.get(this.cls, id);
    }

    public Collection<T> getAllEntities() {
        return this.hibernateTemplate.find("FROM " + this.cls.getName());
    }

    public Set<T> getEntitiesByIds(Serializable[] ids) {
        String segment = OAUtils.array2String(ids);
        //通过获取持久化类的元数据metadata, 得到索引identifier (通过getIdentifierPropertyName())
        ClassMetadata metadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(this.cls);
        List<T> list = this.hibernateTemplate.
                find("FROM " + this.cls.getName() + " WHERE " + metadata.getIdentifierPropertyName() + " IN (" + segment + ")");

        return new HashSet<T>(list);
    }
}
