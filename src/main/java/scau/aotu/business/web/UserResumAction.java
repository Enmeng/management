package scau.aotu.business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import scau.aotu.base.exception.BaseException;
import scau.aotu.base.web.controller.BaseAction;
import scau.aotu.base.web.entity.JsonResult;
import scau.aotu.business.entity.UserResume;
import scau.aotu.business.service.IUserResumeService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/userresum")
public class UserResumAction extends BaseAction{

    @Autowired
    private IUserResumeService userresumService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("userresum/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addUserResum(UserResume userresume) throws BaseException{
        userresumService.add(userresume);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delUserResumById(@PathVariable("id") String id) throws BaseException{
        userresumService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getUserResumById(@PathVariable("id") String id) throws BaseException{
        UserResume userresume = userresumService.getById(id);
        return createSuccessJson(userresume);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateUserResumById(@PathVariable("id") String id, UserResume userresume) throws BaseException{
        userresumService.updateById(userresume, id);
        return createSuccessJson();
    }
}
