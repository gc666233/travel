package com.example.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.controller.utils.CheckCodeUtil;
import com.example.controller.utils.R;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CheckCodeUtil checkCodeUtil;

    @CreateCache(name = "code_",cacheType = CacheType.REMOTE)
    private Cache<String,String> cache;

    /**
     * 生成验证码
     * @param response
     * @throws IOException
     */
    @GetMapping("/checkCode")
    public void checkCode(HttpServletResponse response) throws IOException {
        String checkCode = checkCodeUtil.createCode(response);
        //将生成的验证码存入缓存中
        cache.put("default_code_CHECKCODE",checkCode);
    }

    /**
     * 校验验证码
     * @param check
     * @return
     */
    @GetMapping("/{check}")
    public R isCheckCodeOk(@PathVariable String check) {
        //从缓存中获取验证码
        String code = cache.get("default_code_CHECKCODE");

        //比较
        boolean flag= code != null && code.equalsIgnoreCase(check);
        return new R(flag);
    }

    /**
     * 用户登录
     * @param user
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("/login")
    public R login(User user,HttpServletRequest request) throws IOException {
        User loginUser = userService.login(user);
        if (loginUser!=null){
            request.getSession().setAttribute("user",loginUser);
            return new R(true,loginUser);
        }else {
            return new R(false,"用户名或密码错误！");
        }
    }

    /**
     * 查看有无用户登录
     * @param request
     * @return
     */
    @GetMapping("/findUser")
    public R findOne(HttpServletRequest request){
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        return new R(null!=user,user);
    }

    /**
     * 退出登录
     * @param request
     */
    @GetMapping("/exit")
    public void exit(HttpServletRequest request){
        //销毁session
        request.getSession().invalidate();
    }

    @PostMapping("/register")
    public R register(@RequestBody User user){
        Boolean flag = userService.save(user);
        return new R(flag);
    }

}
