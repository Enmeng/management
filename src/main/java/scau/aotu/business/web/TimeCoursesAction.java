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
import scau.aotu.business.entity.TimeCourses;
import scau.aotu.business.service.ITimeCoursesService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/timecourses")
public class TimeCoursesAction extends BaseAction{

    @Autowired
    private ITimeCoursesService timecoursesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("timecourses/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addTimeCourses(TimeCourses timecourses) throws BaseException{
        timecoursesService.add(timecourses);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delTimeCoursesById(@PathVariable("id") String id) throws BaseException{
        timecoursesService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getTimeCoursesById(@PathVariable("id") String id) throws BaseException{
        TimeCourses timecourses = timecoursesService.getById(id);
        return createSuccessJson(timecourses);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateTimeCoursesById(@PathVariable("id") String id, TimeCourses timecourses) throws BaseException{
        timecoursesService.updateById(timecourses, id);
        return createSuccessJson();
    }
    //请求登陆
    @RequestMapping("/login.do")
    public String login(){
        return "/login.jsp";
    }
}
