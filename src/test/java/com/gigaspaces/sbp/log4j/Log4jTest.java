package com.gigaspaces.sbp.log4j;

import com.gigaspaces.sbp.Pojo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openspaces.core.GigaSpace;
import org.openspaces.pu.container.integrated.IntegratedProcessingUnitContainer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 6/15/14
 * Time: 10:15 PM
 */
@ContextConfiguration(locations = "classpath*:Log4jTest-context.xml")
@RunWith(value = SpringJUnit4ClassRunner.class)
public class Log4jTest {

    private static final int NUM_TEST_INSTANCES = 5;
    private static final int TEST_ROUTING_ID = 0;

    @Resource
    private GigaSpace gigaSpace;

    /**
     * Writing an instance is sufficient to cause logging in the Processing Unit
     * (when the {@link com.gigaspaces.sbp.Poller} processes the newly written
     * {@link Pojo}.
     */
    @Test
    public void testPollerLoggingByWriting() {
        for (int i = 0; i < NUM_TEST_INSTANCES; i++)
            gigaSpace.write(testInstance());
    }

    private int pojoNum = 1;

    private Pojo testInstance() {
        Pojo pojo = new Pojo();
        pojo.setRoutingId(TEST_ROUTING_ID);
        pojo.setPayload("Test pojo [" + pojoNum++ + "].");
        return pojo;
    }

}
