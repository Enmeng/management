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
import scau.aotu.business.entity.ApplyUser;
import scau.aotu.business.service.IApplyUserService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/applyuser")
public class ApplyUserAction extends BaseAction{

    @Autowired
    private IApplyUserService applyuserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("applyuser/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addApplyUser(ApplyUser applyuser) throws BaseException{
        applyuserService.add(applyuser);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delApplyUserById(@PathVariable("id") String id) throws BaseException{
        applyuserService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getApplyUserById(@PathVariable("id") String id) throws BaseException{
        ApplyUser applyuser = applyuserService.getById(id);
        return createSuccessJson(applyuser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateApplyUserById(@PathVariable("id") String id, ApplyUser applyuser) throws BaseException{
        applyuserService.updateById(applyuser, id);
        return createSuccessJson();
    }
}
