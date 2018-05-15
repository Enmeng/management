package scau.aotu.base.dao.mybatis;

import scau.aotu.base.dao.entity.Unique;
import scau.aotu.base.exception.BaseException;

import java.util.List;

/**
 * 通用的DAO方法类
 *
 *
 * 对于 T entity实例属性 忽略规则说明：
 * 1。没有getter和setter的字段，只有一种也不行
 * 2。实例obj中属性值为空
 * 3。被Transmit注解标注的属性
 * @param <T>
 */
public interface IBaseDao<T extends Unique> {

    /**
     * 新增对象
     * (如果要添加的对象没有设置Id或者Id为空字符串或者是空格，则添加数据之前会调用 generateId()方法设置Id)
     *
     * @param entity 要新增的对象
     * @return 返回新增记录的主键
     */
    String add(T entity) throws BaseException;

    /**
     * 更根据条件进行更新，忽略value=null的值
     *
     * @param entity    要持久化的对象
     * @param conditions 查询条件
     */
    void update(T entity, Conditions conditions) throws BaseException;

    /**
     * 根据条件删除对象
     *
     * @param conditions 查询条件
     */
    void delete(Conditions conditions) throws BaseException;

    /**
     * 查询一个对象，如果返回的结果多于一个对象将会抛出TooManyResultsException
     *
     * @param conditions 查询条件
     * @param property 指定投影的字段列表
     * @return
     */
    <V> V get(Conditions conditions, String... property) throws BaseException;

    /**
     * 查询对象列表
     *
     * @param conditions 查询参数，如果为null则查询所有
     * @param property 指定投影的字段列表
     * @return 结果对象列表
     */
    <V> List<V> list(Conditions conditions, String... property) throws BaseException;

    /**
     * 根据条件查询记录数
     *
     * @param conditions
     */
    long count(Conditions conditions) throws BaseException;

    /**
     * 执行更新语句
     *
     * @param id
     * @param sql
     */
    void executeUpdate(String id, String sql) throws BaseException;

    /**
     * 执行sql查询语句
     *
     * @param id
     * @param sql
     * @return
     */
    <V> List<V> executeList(String id, String sql) throws BaseException;
}
