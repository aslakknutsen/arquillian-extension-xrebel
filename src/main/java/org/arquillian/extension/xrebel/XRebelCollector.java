package org.arquillian.extension.xrebel;

import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.arquillian.extension.xrebel.model.Invocation;
import org.jboss.arquillian.container.spi.client.protocol.metadata.HTTPContext;
import org.jboss.arquillian.container.spi.client.protocol.metadata.ProtocolMetaData;
import org.jboss.arquillian.container.spi.event.container.BeforeUnDeploy;
import org.jboss.arquillian.core.api.annotation.Observes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class XRebelCollector {

    private static final Pattern p = Pattern.compile(".*'([a-z0-9]+)/resources.*", Pattern.DOTALL);
    private String lastContext = null;

    
    public void getId(@Observes ProtocolMetaData metaData) throws Exception {
        URL idUrl = new URL(getBase(metaData), "xrebel");
        String xrebelResponse = IOUtil.asUTF8String(idUrl.openStream());

        Matcher m = p.matcher(xrebelResponse);
        m.find();
        lastContext = m.group(1);
        System.out.println("Found context : " + lastContext);
    }
    
    public void collect(@Observes BeforeUnDeploy event, ProtocolMetaData metaData) throws Exception {
        URL collectUrl = new URL(getBase(metaData), "xrebel/" + lastContext + "/updates/1?rnd=0.99999");
        String xrebelResponse = IOUtil.asUTF8String(collectUrl.openStream());

        System.out.println("Data: " + xrebelResponse);
        
        Gson gson = new GsonBuilder().create();
        Invocation[] invocations = gson.fromJson(xrebelResponse, Invocation[].class);
        
        System.out.println(Arrays.toString(invocations));
    }

    private URL getBase(ProtocolMetaData metaData) throws Exception {
        return metaData.getContext(HTTPContext.class).getServlets().get(0).getBaseURI().toURL();
    }
}
