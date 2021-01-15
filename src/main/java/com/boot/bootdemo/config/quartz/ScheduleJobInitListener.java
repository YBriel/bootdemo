package com.boot.bootdemo.config.quartz;

import com.boot.bootdemo.entity.TaskEntity;
import com.boot.bootdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {

    @Autowired
    StudentMapper scheduleJobService;
    @Autowired
    private QuartzManager quartzManager;

    @Override
    public void run(String... arg0) {
        try {
            List<TaskEntity> taskEntities = scheduleJobService.queryAllTask();
            for (TaskEntity task : taskEntities) {
                if ("2".equals(task.getJobStatus())) {
                    quartzManager.addJob(task);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}