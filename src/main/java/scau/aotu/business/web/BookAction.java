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
import scau.aotu.business.entity.Book;
import scau.aotu.business.service.IBookService;

/**
 * Created by AutoSSM.
 */
@RestController
@RequestMapping("/book")
public class BookAction extends BaseAction{

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("book/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addBook(Book book) throws BaseException{
        bookService.add(book);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delBookById(@PathVariable("id") String id) throws BaseException{
        bookService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getBookById(@PathVariable("id") String id) throws BaseException{
        Book book = bookService.getById(id);
        return createSuccessJson(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateBookById(@PathVariable("id") String id, Book book) throws BaseException{
        bookService.updateById(book, id);
        return createSuccessJson();
    }
}
