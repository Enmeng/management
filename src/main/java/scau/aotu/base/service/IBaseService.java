package scau.aotu.base.service;

import scau.aotu.base.dao.entity.Unique;
import scau.aotu.base.dao.mybatis.Conditions;
import scau.aotu.base.dao.utils.Page;
import scau.aotu.base.exception.BaseException;

import java.util.List;

/**
 * Created by lsp on 24/11/2016.
 */
public interface IBaseService<T extends Unique> {
    /**
     * 持久化entity
     *
     * @param entity
     * @return 主键
     * @throws BaseException
     */
    String add(T entity) throws BaseException;

    /**
     * 根据条件更新entity
     *
     * @param entity
     * @param conditions
     * @throws BaseException
     */
    void update(T entity, Conditions conditions) throws BaseException;

    /**
     * 根据主键值更新
     *
     * @param entity
     * @param id
     * @throws BaseException
     */
    void updateById(T entity, String id) throws BaseException;

    /**
     * 根据条件删除指定记录
     *
     * @param conditions
     * @throws BaseException
     */
    void delete(Conditions conditions) throws BaseException;

    /**
     * 根据主键删除记录
     *
     * @param id
     * @throws BaseException
     */
    void deleteById(String id) throws BaseException;

    /**
     * 删除当前entity对应的所有数据表记录
     *
     * @throws BaseException
     */
    void deleteAll() throws BaseException;

    /**
     * 根据条件查询单个对象
     * @param conditions
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> V get(Conditions conditions) throws BaseException;

    /**
     * 根据条件查询单个对象，可指定只投影的字段列表
     * @param conditions
     * @param properties
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> V get(Conditions conditions, String... properties) throws BaseException;

    /**
     * 根据主键查询单个对象
     * @param id
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> V getById(String id) throws BaseException;

    /**
     * 根据条件查询多个对象，可指定只投影的字段列表
     * @param conditions
     * @param properties
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> List<V> list(Conditions conditions, String... properties) throws BaseException;

    /**
     * 根据条件查询多个对象
     * @param conditions
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> List<V> list(Conditions conditions) throws BaseException;

    /**
     * 查询所有对象的所有字段
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> List<V> listAll() throws BaseException;

    /**
     * 根据条件查询分页对象，可指定只投影的字段列表
     * @param conditions
     * @param properties
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> Page<V> page(Conditions conditions, String... properties) throws BaseException;

    /**
     * 根据条件查询分页对象
     * @param conditions
     * @param <V>
     * @return
     * @throws BaseException
     */
    <V> Page<V> page(Conditions conditions) throws BaseException;

    /**
     * 根据条件查询记录数
     * @param conditions
     * @return
     * @throws BaseException
     */
    long count(Conditions conditions) throws BaseException;
}
