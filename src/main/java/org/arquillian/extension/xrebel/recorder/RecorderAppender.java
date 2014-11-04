package org.arquillian.extension.xrebel.recorder;

import org.arquillian.extension.xrebel.XRebelResult;
import org.arquillian.extension.xrebel.model.Invocation;
import org.arquillian.extension.xrebel.model.Invocation.IOUpdate;
import org.arquillian.extension.xrebel.model.Invocation.Query;
import org.arquillian.extension.xrebel.model.Invocation.Stats;
import org.arquillian.recorder.reporter.event.PropertyReportEvent;
import org.arquillian.recorder.reporter.model.entry.KeyValueEntry;
import org.jboss.arquillian.core.api.Event;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;

public class RecorderAppender {

    @Inject
    private Event<PropertyReportEvent> event;
    
    public void record(@Observes XRebelResult result) {
        for(Invocation invocation : result.getInvocations()) {
            if(invocation.getUrl().endsWith("/xrebel")) {
                continue;
            }
            KeyValueEntry request = new KeyValueEntry();
            request.setKey("XRebel Request");
            request.setValue(invocation.getUrl());
            event.fire(new PropertyReportEvent(request));
            
            IOUpdate updates = invocation.getIoUpdates();
            for(Query query : updates.getQueries()) {
                KeyValueEntry queryEntry = new KeyValueEntry();
                queryEntry.setKey("XRebel " + query.getType());
                queryEntry.setValue(query.getProcessedQuery());
                event.fire(new PropertyReportEvent(queryEntry));
            }
            for(Stats stats : updates.getStats()) {
                for(String driver : stats.getDriver()) {
                    KeyValueEntry entry = new KeyValueEntry();
                    entry.setKey("XRebel Driver");
                    entry.setValue(driver);
                    event.fire(new PropertyReportEvent(entry));
                }
                for(String framework : stats.getFramework()) {
                    KeyValueEntry entry = new KeyValueEntry();
                    entry.setKey("XRebel Framework");
                    entry.setValue(framework);
                    event.fire(new PropertyReportEvent(entry));
                }
            }
        }
    }
}
