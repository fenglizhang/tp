package tp.task.center.zlf.task;


import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author zhanglifeng
 */
@Component
public class TradeOrderCompleteTask extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeOrderCompleteTask.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        try {
            LOGGER.info("------------------任务开始--------");
            /**
             * 具体业务处理逻辑调用地方
             */
            LOGGER.info("------------------任务结束--------");
        } catch (Exception e) {
            LOGGER.error("----------出错:" + e.getMessage(), e);
        }
    }
}
