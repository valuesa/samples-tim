package cn.boxfish.quartz.database.service;

import cn.boxfish.quartz.database.job.JobFactory;
import cn.boxfish.quartz.database.job.entity.JobDataForm;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

/**
 * Created by LuoLiBing on 16/6/24.
 */
@Service
public class JobService {

    public void addJob(JobDataForm jobDataForm) throws SchedulerException {
        JobFactory.createJobBuild(jobDataForm).build();
    }
}
