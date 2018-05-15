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
import scau.aotu.business.entity.ProjectApply;
import scau.aotu.business.service.IProjectApplyService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/projectapply")
public class ProjectApplyAction extends BaseAction{

    @Autowired
    private IProjectApplyService projectapplyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("projectapply/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addProjectApply(ProjectApply projectapply) throws BaseException{
        projectapplyService.add(projectapply);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delProjectApplyById(@PathVariable("id") String id) throws BaseException{
        projectapplyService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getProjectApplyById(@PathVariable("id") String id) throws BaseException{
        ProjectApply projectapply = projectapplyService.getById(id);
        return createSuccessJson(projectapply);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateProjectApplyById(@PathVariable("id") String id, ProjectApply projectapply) throws BaseException{
        projectapplyService.updateById(projectapply, id);
        return createSuccessJson();
    }
}
