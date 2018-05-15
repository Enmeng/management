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
import scau.aotu.business.entity.Token;
import scau.aotu.business.service.ITokenService;

/**
 * Created by chanyulin.
 */
@RestController
@RequestMapping("/token")
public class TokenAction extends BaseAction{

    @Autowired
    private ITokenService tokenService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        return new ModelAndView("token/index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JsonResult addToken(Token token) throws BaseException{
        tokenService.add(token);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public JsonResult delTokenById(@PathVariable("id") String id) throws BaseException{
        tokenService.deleteById(id);
        return createSuccessJson();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonResult getTokenById(@PathVariable("id") String id) throws BaseException{
        Token token = tokenService.getById(id);
        return createSuccessJson(token);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public JsonResult updateTokenById(@PathVariable("id") String id, Token token) throws BaseException{
        tokenService.updateById(token, id);
        return createSuccessJson();
    }
}
