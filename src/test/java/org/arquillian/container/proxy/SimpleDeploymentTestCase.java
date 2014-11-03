package org.arquillian.container.proxy;

import static org.arquillian.container.proxy.Asserts.assertResponseEquals;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SimpleDeploymentTestCase {

    @Deployment(testable = false)
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(SimpleServlet.class);
    }

    @ArquillianResource
    private URL base;

    @Test
    public void shouldReturnOK() throws Exception {
        assertResponseEquals("ok", new URL(base, "test"));
        //assertResponseEquals("ok", new URL(base, "test"));
    }
}
