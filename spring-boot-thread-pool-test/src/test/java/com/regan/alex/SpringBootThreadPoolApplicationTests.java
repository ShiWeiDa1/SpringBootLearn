package com.regan.alex;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import static com.regan.alex.constant.TheadNameConstant.SIMPLE_TASK;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootThreadPoolApplicationTests {
    @Autowired
    @Qualifier(SIMPLE_TASK)
    private TaskExecutor simpleTask;

    @Test
    void contextLoads() {
        System.out.println("doing something!");
    }

    @Test
    void ThreadTest01() {

        for (int i = 0; i < 50; ++i) {
            int finalI = i;
            simpleTask.execute(() -> {
                while (true) {
                    System.out.println("handle:" + finalI);
                }
            });
        }
        while (true) {
            // doing
        }
    }

}
