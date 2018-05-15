package scau.aotu.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import scau.aotu.base.dao.entity.Unique;
import scau.aotu.base.dao.mybatis.Conditions;
import scau.aotu.base.dao.mybatis.IBaseDao;
import scau.aotu.base.dao.utils.Page;
import scau.aotu.base.exception.BaseException;

import java.util.List;

/**
 * Created by lsp on 24/11/2016.
 */
public class BaseService<T extends Unique> implements IBaseService<T>{
    @Autowired
    private IBaseDao<T> baseDao;

    @Override
    public String add(T entity) throws BaseException {
        return baseDao.add(entity);
    }

    @Override
    public void update(T entity, Conditions conditions) throws BaseException {
        baseDao.update(entity, conditions);
    }

    @Override
    public void updateById(T entity, String id) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.equal("id", id);
        baseDao.update(entity, conditions);
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        baseDao.delete(conditions);
    }

    @Override
    public void deleteById(String id) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.equal("id", id);
        baseDao.delete(conditions);
    }

    @Override
    public void deleteAll() throws BaseException {
        baseDao.delete(null);
    }

    @Override
    public <V> V get(Conditions conditions) throws BaseException {
        return get(conditions, null);
    }

    @Override
    public <V> V get(Conditions conditions, String... properties) throws BaseException {
        return baseDao.get(conditions, properties);
    }

    @Override
    public <V> V getById(String id) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.equal("id", id);
        return get(conditions);
    }

    @Override
    public <V> List<V> list(Conditions conditions, String... properties) throws BaseException {
        return baseDao.list(conditions, properties);
    }

    @Override
    public <V> List<V> list(Conditions conditions) throws BaseException {
        return list(conditions, null);
    }

    @Override
    public <V> List<V> listAll() throws BaseException {
        return list(null, null);
    }

    @Override
    public <V> Page<V> page(Conditions conditions, String... properties) throws BaseException {
        long count = count(conditions);
        List<V> result = list(conditions, properties);
        return new Page<>(count, result);
    }

    @Override
    public <V> Page<V> page(Conditions conditions) throws BaseException {
        long count = count(conditions);
        List<V> result = list(conditions);
        return new Page<>(count, result);
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        return baseDao.count(conditions);
    }
}
