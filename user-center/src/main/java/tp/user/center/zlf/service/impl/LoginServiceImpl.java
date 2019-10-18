package tp.user.center.zlf.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tp.user.center.zlf.entity.User;
import tp.user.center.zlf.mapper.LoginMapper;
import tp.user.center.zlf.service.LoginService;

import javax.annotation.Resource;

/**
 * @author zhanglifeng
 * 用户登陆服务层
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Resource
    private LoginMapper loginMapper;

    @Override
    public boolean queryUserByMobileAndType(String mobile, String userType) {
        LOGGER.info("queryUserByMobileAndType方法入参mobile：{},userType:{}", mobile, userType);
        User userByMobileAndType = loginMapper.getUserByMobileAndType(mobile, userType);
        if (userByMobileAndType != null) {
            return true;
        }
        return false;
    }
}
