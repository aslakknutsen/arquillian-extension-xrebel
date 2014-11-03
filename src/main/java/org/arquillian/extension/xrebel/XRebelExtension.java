package org.arquillian.extension.xrebel;

import org.jboss.arquillian.core.spi.LoadableExtension;

public class XRebelExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        builder.observer(XRebelCollector.class);
    }

}
