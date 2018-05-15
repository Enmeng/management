package scau.aotu.business.service;

import scau.aotu.base.exception.BaseException;
import scau.aotu.base.service.IBaseService;
import scau.aotu.business.entity.User;
import scau.aotu.business.vo.UserSearchProperty;

import java.util.List;

/**
 * Created by AutoSSM.
 */
public interface IUserService extends IBaseService<User> {

    // 根据用户名或邮箱搜索用户
    List<User> searchByUsernameOrEmail(String value) throws BaseException;

    // 多条件搜索用户
    List<User> searchByProperties(UserSearchProperty searchProperty) throws BaseException;

}
