package tp.base.config.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhanglifeng
 * bus消息暴露接口供git服务调用，刷新配置信息
 */
@RestController
public class RefreshController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RefreshController.class);

    @PostMapping("/actuator/autoRefresh")
    @ResponseBody
    public Object busRefresh2(@RequestBody(required = false) String param) {
        LOGGER.info("auto refresh start:param={}", param);
        return new ModelAndView("/actuator/bus-refresh");
    }
}