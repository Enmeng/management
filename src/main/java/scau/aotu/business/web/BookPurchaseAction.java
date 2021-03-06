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
import scau.aotu.business.entity.BookPurchase;
import scau.aotu.business.service.IBookPurchaseService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/bookpurchase")
public class BookPurchaseAction extends BaseAction{

    @Autowired
    private IBookPurchaseService bookpurchaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("bookpurchase/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addBookPurchase(BookPurchase bookpurchase) throws BaseException{
        bookpurchaseService.add(bookpurchase);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delBookPurchaseById(@PathVariable("id") String id) throws BaseException{
        bookpurchaseService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getBookPurchaseById(@PathVariable("id") String id) throws BaseException{
        BookPurchase bookpurchase = bookpurchaseService.getById(id);
        return createSuccessJson(bookpurchase);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateBookPurchaseById(@PathVariable("id") String id, BookPurchase bookpurchase) throws BaseException{
        bookpurchaseService.updateById(bookpurchase, id);
        return createSuccessJson();
    }
}
