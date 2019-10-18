package tp.user.center.zlf.service;

/**
 * @author zhanglifeng
 */
public interface LoginService {
    /**
     * [根据手机号查询用户是否存在]
     * @param mobile
     * @param userType
     * @return
     */
    boolean queryUserByMobileAndType(String mobile,String userType);
}
