package cn.wang.rbac.controller;


//import cn.deep.system.shiro.config.UserUtil;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * @author hjm10
 * @version 1.0
 * @date 2020-01-06 22:17
 */
@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     */
    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }


    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        //获取subject

        //用户认证信息
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                username,
                password
        );
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);

        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {

            return "用户名不存在！";
        } catch (AuthenticationException e) {

            return "账号或密码错误！";
        } catch (AuthorizationException e) {

            return "没有权限";
        }
        catch (Exception e){
            return "没有权限";
        }
        model.addAttribute("name", "test");
        return "index";

    }


}
