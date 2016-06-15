package com.manchey.controller.test;

import com.manchey.model.vo.test.AccountModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 数据绑定DEMO
 * Created by Ray on 2016/6/15.
 */
@Controller
@RequestMapping(value = "/databind")
public class DataBindController {

    @RequestMapping(value = "/parambind", method = RequestMethod.GET)
    public ModelAndView paramBind() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/test/parambind");

        return modelAndView;
    }

    @RequestMapping(value = "/parambind", method = RequestMethod.POST)
    public ModelAndView paramBind(HttpServletRequest request,
                                  // 【重要】：注解参数的名必须和jsp页面input标签的name名字相对应，否则报错400
                                  @RequestParam("urlParam") String url,
                                  @RequestParam("formParam") String form,
                                  @RequestParam("formFile") MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView();

        // 此处的名字必须和结果页面的调用名字相同
        modelAndView.addObject("urlParam", url);
        modelAndView.addObject("formParam", form);
        modelAndView.addObject("formFileName", file.getOriginalFilename());

        //如果不用注解自动绑定，我们还可以像下面一样手动获取数据
        String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
        String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
        MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile");

        modelAndView.addObject("urlParam1", urlParam1);
        modelAndView.addObject("formParam1", formParam1);
        modelAndView.addObject("formFileName1", formFile1.getOriginalFilename());

        modelAndView.setViewName("/test/parambindresult");
        return modelAndView;
    }


    @RequestMapping(value = "/modelautobind", method = RequestMethod.GET)
    public String modelAutoBind(Model model) {

        // 此处的名称必须与页面中的 modelAttribute="accountBean" 相同
        model.addAttribute("accountBean", new AccountModel());

        return "/test/modelautobind";
    }

    @RequestMapping(value = "/modelautobind", method = RequestMethod.POST)
    public String modelAutoBind(Model model, AccountModel accountModel) {

        model.addAttribute("accountBean", accountModel);

        return "/test/modelautobindresult";
    }




}
