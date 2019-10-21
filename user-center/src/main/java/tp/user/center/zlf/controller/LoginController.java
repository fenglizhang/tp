package tp.user.center.zlf.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tp.user.center.zlf.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * [用户中心]
 * @author zhanglifeng
 * @date 2019-10-17
 */
@RestController
@RequestMapping("/user/center")
public class LoginController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private LoginService loginService;
    @RequestMapping("/login")
    public JSONObject userLogin(@RequestParam(value = "mobile") String mobile,
                                @RequestParam(value = "dynamicCode") String dynamicCode,
                                HttpServletRequest request) {
        JSONObject paramJson = new JSONObject();
        LOGGER.info("用户登陆的请求入参mobile:{},dynamicCode:{}",mobile,dynamicCode);
        paramJson.put("mobile",mobile);
        paramJson.put("dynamicCode",dynamicCode);
        boolean b = loginService.queryUserByMobileAndType(mobile, "1");
        return paramJson;
    }

}
