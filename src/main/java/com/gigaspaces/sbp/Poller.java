package com.gigaspaces.sbp;

import org.apache.log4j.Logger;
import org.openspaces.events.EventDriven;
import org.openspaces.events.EventTemplate;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.openspaces.events.polling.Polling;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 6/15/14
 * Time: 10:18 PM
 */
@EventDriven
@Polling
public class Poller {

    private Logger log4jLogger = Logger.getLogger(getClass());

    @EventTemplate
    public Pojo template() {
        Pojo pojo = new Pojo();
        pojo.setProcessed(false);
        return pojo;
    }

    @SpaceDataEvent
    public Pojo process(Pojo pojo) {

        String msg = String.format("Processing pojo: [ %s ]", pojo);

        log4jLogger.info(msg);

        pojo.setProcessed(true);
        return pojo;
    }
}
