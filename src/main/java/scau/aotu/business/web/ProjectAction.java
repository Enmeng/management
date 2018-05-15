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
import scau.aotu.business.entity.Project;
import scau.aotu.business.service.IProjectService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/project")
public class ProjectAction extends BaseAction{

    @Autowired
    private IProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("project/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addProject(Project project) throws BaseException{
        projectService.add(project);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delProjectById(@PathVariable("id") String id) throws BaseException{
        projectService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getProjectById(@PathVariable("id") String id) throws BaseException{
        Project project = projectService.getById(id);
        return createSuccessJson(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateProjectById(@PathVariable("id") String id, Project project) throws BaseException{
        projectService.updateById(project, id);
        return createSuccessJson();
    }
}
