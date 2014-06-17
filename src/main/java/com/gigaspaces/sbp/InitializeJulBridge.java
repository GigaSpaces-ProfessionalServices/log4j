package com.gigaspaces.sbp;

import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Created by IntelliJ IDEA.
 * User: jason
 * Date: 6/16/14
 * Time: 10:06 PM
 */
public class InitializeJulBridge {

    public void init(){
        System.err.println("IIIIIIIIII>>>>> Initializing JUL bridge. <<<<< IIIIII");
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

}
