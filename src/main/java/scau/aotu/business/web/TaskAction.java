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
import scau.aotu.business.entity.Task;
import scau.aotu.business.service.ITaskService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/task")
public class TaskAction extends BaseAction{

    @Autowired
    private ITaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("task/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addTask(Task task) throws BaseException{
        taskService.add(task);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delTaskById(@PathVariable("id") String id) throws BaseException{
        taskService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getTaskById(@PathVariable("id") String id) throws BaseException{
        Task task = taskService.getById(id);
        return createSuccessJson(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateTaskById(@PathVariable("id") String id, Task task) throws BaseException{
        taskService.updateById(task, id);
        return createSuccessJson();
    }
}
