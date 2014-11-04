package org.arquillian.extension.xrebel;

import org.arquillian.extension.xrebel.recorder.RecorderAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;

public class XRebelExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        builder.observer(XRebelCollector.class);

        if(Validate.classExists("org.arquillian.recorder.reporter.event.PropertyReportEvent")) {
            builder.observer(RecorderAppender.class);
        }
    }

}
