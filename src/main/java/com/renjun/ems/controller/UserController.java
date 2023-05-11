package com.renjun.ems.controller;

import com.renjun.ems.entity.User;
import com.renjun.ems.service.UserService;
import com.renjun.ems.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getCode")
    public void getCode(HttpSession session, HttpServletResponse httpServletResponse) throws IOException {
        //生产验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //放入session验证 todo 考虑放入redis
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        ImageIO.write(image,"png",outputStream);
    }

    @PostMapping("regist")
    public String userRegist(User user, String code, HttpSession session){
        //判断验证码
        if(code.equals(session.getAttribute("code"))){
            //实现注册
            userService.save(user);
            return "redirect:/ems/login.jsp";
        }else {
            //不通过回到注册页面
            return "redirect:/ems/regist.jsp?error=1";
        }
    }

    @PostMapping("login")
    public String userLogin(@RequestParam(value = "name") String username, @RequestParam(value = "pwd") String password, HttpSession session){
        User user = userService.userLogin(username, password);
        if(user != null){
            session.setAttribute("user",user);
            return "redirect:/emp/findAllEmp";
        }else {
            return "redirect:/ems/login.jsp?userError=1";
        }
    }


}
