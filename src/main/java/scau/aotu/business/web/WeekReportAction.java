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
import scau.aotu.business.entity.WeekReport;
import scau.aotu.business.service.IWeekReportService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/weekreport")
public class WeekReportAction extends BaseAction{

    @Autowired
    private IWeekReportService weekreportService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("weekreport/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addWeekReport(WeekReport weekreport) throws BaseException{
        weekreportService.add(weekreport);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delWeekReportById(@PathVariable("id") String id) throws BaseException{
        weekreportService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getWeekReportById(@PathVariable("id") String id) throws BaseException{
        WeekReport weekreport = weekreportService.getById(id);
        return createSuccessJson(weekreport);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateWeekReportById(@PathVariable("id") String id, WeekReport weekreport) throws BaseException{
        weekreportService.updateById(weekreport, id);
        return createSuccessJson();
    }
}
