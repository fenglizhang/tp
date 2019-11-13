package tp.task.center.zlf.job;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;
import tp.task.center.zlf.task.TradeOrderCompleteTask;

/**
 * [定时任务触发器配置]
 * @author zhanglifeng
 * @date 20196-11-13
 */
@Component
public class TradeOrderCompleteJob {

    @Bean(name = "jobOrderCompleteTrigger")
    public CronTriggerFactoryBean jobOrderCompleteTrigger(@Qualifier("jobOrderCompleteDetail") JobDetail jobDetail) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setCronExpression("0 0/3 * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean(name = "jobOrderCompleteDetail")
    public JobDetailFactoryBean jobOrderCompleteDetail(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(TradeOrderCompleteTask.class);
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setRequestsRecovery(true);
        return jobDetailFactoryBean;
    }
}
