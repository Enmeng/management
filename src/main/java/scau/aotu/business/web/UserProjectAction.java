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
import scau.aotu.business.entity.UserProject;
import scau.aotu.business.service.IUserProjectService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/userproject")
public class UserProjectAction extends BaseAction{

    @Autowired
    private IUserProjectService userprojectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("userproject/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addUserProject(UserProject userproject) throws BaseException{
        userprojectService.add(userproject);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delUserProjectById(@PathVariable("id") String id) throws BaseException{
        userprojectService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getUserProjectById(@PathVariable("id") String id) throws BaseException{
        UserProject userproject = userprojectService.getById(id);
        return createSuccessJson(userproject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateUserProjectById(@PathVariable("id") String id, UserProject userproject) throws BaseException{
        userprojectService.updateById(userproject, id);
        return createSuccessJson();
    }
}
