package com.cv.web.be.cvweb.controller;

import com.cv.web.be.cvweb.service.AdminService;
import com.cv.web.be.cvweb.utils.CommonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by zhou_wb on 2017/5/15.
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping(value = "/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/welcome")
    public String welcome(Model model){
        return "welcome";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String adminLogin(@RequestParam String account,@RequestParam String pwd,
                             @RequestParam String resource){
        UsernamePasswordToken token = new UsernamePasswordToken(account, CommonUtil.MD5Encr(pwd));
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + account + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + account + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + account + "]进行登录验证..验证未通过,未知账户");
            return "admin_not_fount";
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + account + "]进行登录验证..验证未通过,错误的凭证");
            return "password_warn";
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + account + "]进行登录验证..验证未通过,账户已锁定");
            return "islocked";
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + account + "]进行登录验证..验证未通过,错误次数过多");
            return "max";
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + account + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            logger.info("用户[" + account + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return "success";
        } else {
            token.clear();
            return "clear";
        }
    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/login";
    }

}
