package scau.aotu.business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import scau.aotu.base.dao.mybatis.Conditions;
import scau.aotu.base.exception.BaseException;
import scau.aotu.base.web.controller.BaseAction;
import scau.aotu.base.web.entity.JsonResult;
import scau.aotu.business.entity.User;
import scau.aotu.business.service.IUserService;
import scau.aotu.business.vo.UserSearchProperty;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户
 * @Author chanyulin
 */
@RestController
@RequestMapping("/user")
public class UserAction extends BaseAction {

    @Autowired
    private IUserService userService;

    /**
     * 首页
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws BaseException {
        return new ModelAndView("user/index");
    }

    /*---------------*/
    /* 前台
    /*---------------*/

    /**
     * 根据用户名或邮箱搜索
     * @param value
     * @param model
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public JsonResult searchUser(String value, Model model) throws BaseException {
        List<User> userList = userService.searchByUsernameOrEmail(value);
        model.addAttribute("result" , userList);
        return new JsonResult(model);
    }

    /**
     * 根据id获取某个用户
     * @param id
     * @param model
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResult getUserById(@PathVariable("id") String id, Model model) throws BaseException {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return new JsonResult(model);
    }

    /*---------------*/
    /* 后台
    /*---------------*/

    /**
     * 多条件搜索
     * @param searchProperty
     * @param model
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public JsonResult searchUser(UserSearchProperty searchProperty, Model model) throws BaseException {
        List<User> userList = userService.searchByProperties(searchProperty);
        model.addAttribute("userList", userList);
        return new JsonResult(model);
    }

    /**
     * 添加用户
     * @param user
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult addUser(User user) throws BaseException {
        userService.add(user);
        return createSuccessJson();
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResult deleteUserById(@PathVariable("id") String id) throws BaseException {
        userService.deleteById(id);
        return createSuccessJson();
    }

    /**
     * 获取所有用户
     * @param model
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonResult listUsers(Model model) throws BaseException {
        List<User> userList = userService.listAll();
        model.addAttribute("userList", userList);
        return new JsonResult(model);
    }

    /**
     * 更新用户
     * @param user
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult updateUserById(User user) throws BaseException {
        userService.updateById(user, user.getId());
        return createSuccessJson();
    }

}
