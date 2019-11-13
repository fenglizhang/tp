package tp.task.center.zlf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tp.task.center.zlf.entity.User;

/**
 * [用户登陆持久层操作]
 *
 * @author zhanglifeng
 */
@Mapper
public interface LoginMapper {
    /**
     * [根据用户名，用户类型查询用户是否存在]
     * @param mobile
     * @param userType
     * @return
     */
    User getUserByMobileAndType(@Param("mobile") String mobile, @Param("userType") String userType);
}
