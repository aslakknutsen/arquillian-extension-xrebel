package org.arquillian.extension.xrebel;

import org.arquillian.extension.xrebel.model.Invocation;
import org.jboss.arquillian.core.spi.event.Event;

public class XRebelResult implements Event {

    private Invocation[] invocations;
    
    public XRebelResult(Invocation[] invocations) {
        this.invocations = invocations;
    }
    
    public Invocation[] getInvocations() {
        return invocations;
    }
}
