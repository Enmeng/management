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
import scau.aotu.business.entity.BookBorrow;
import scau.aotu.business.service.IBookBorrowService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/bookborrow")
public class BookBorrowAction extends BaseAction{

    @Autowired
    private IBookBorrowService bookborrowService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("bookborrow/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addBookBorrow(BookBorrow bookborrow) throws BaseException{
        bookborrowService.add(bookborrow);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delBookBorrowById(@PathVariable("id") String id) throws BaseException{
        bookborrowService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getBookBorrowById(@PathVariable("id") String id) throws BaseException{
        BookBorrow bookborrow = bookborrowService.getById(id);
        return createSuccessJson(bookborrow);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateBookBorrowById(@PathVariable("id") String id, BookBorrow bookborrow) throws BaseException{
        bookborrowService.updateById(bookborrow, id);
        return createSuccessJson();
    }
}
