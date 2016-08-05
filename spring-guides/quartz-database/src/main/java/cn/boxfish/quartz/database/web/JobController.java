package cn.boxfish.quartz.database.web;

import cn.boxfish.quartz.database.job.entity.JobDataForm;
import cn.boxfish.quartz.database.job.entity.JobPolicy;
import cn.boxfish.quartz.database.job.entity.JobType;
import cn.boxfish.quartz.database.service.JobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by LuoLiBing on 16/6/24.
 */
@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/local/add")
    public Object addLocalJob(JobDataForm jobDataForm) throws SchedulerException {
        jobService.addJob(mock());
        return ResponseEntity.ok().build();
    }

    private JobDataForm mock() {
        JobDataForm dataForm = new JobDataForm();
        dataForm.setType(JobType.LOCAL.value());
        dataForm.setClazzName("cn.boxfish.quartz.database.task.SimpleLocalTask");
        dataForm.setMethod("execute");
        dataForm.setStartTime(new Date(new Date().getTime() + 1000 * 10 * 60));
        dataForm.setPolicy(JobPolicy.TIMER.value());
        dataForm.setArgs("1,2,3,4");
        return dataForm;
    }
}
