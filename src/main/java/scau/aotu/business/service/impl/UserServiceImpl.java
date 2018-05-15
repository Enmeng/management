package scau.aotu.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scau.aotu.base.dao.mybatis.Conditions;
import scau.aotu.base.exception.BaseException;
import scau.aotu.base.service.BaseService;
import scau.aotu.base.utils.ConditionsUtil;
import scau.aotu.business.dao.UserDao;
import scau.aotu.business.entity.User;
import scau.aotu.business.service.IUserService;
import scau.aotu.business.vo.UserSearchProperty;

import java.util.List;

/**
 * Created by AutoSSM.
 */
@Service
public class UserServiceImpl extends BaseService<User> implements IUserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名或邮箱搜索用户
     * @param value
     * @return
     * @throws BaseException
     */
    @Override
    public List<User> searchByUsernameOrEmail(String value) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.like("username", value).or().like("email", value);
        return userDao.list(conditions);
    }

    /**
     * 多条件搜索用户
     * @param searchProperty
     * @return
     * @throws BaseException
     */
    @Override
    public List<User> searchByProperties(UserSearchProperty searchProperty) throws BaseException {
        Conditions conditions = ConditionsUtil.getConditionsByProperty(UserSearchProperty.class, searchProperty, false);
        return userDao.list(conditions);
    }

}
