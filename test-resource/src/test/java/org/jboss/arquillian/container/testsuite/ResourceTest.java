package org.jboss.arquillian.container.testsuite;

import java.io.File;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ResourceTest {

    @Resource(name = "resourceInjectionTestName")
    String resource;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../package-plain-war/target/test.war"));
    }

    @Test
    public void resourceTest() {
        Assert.assertNotNull("Resource from web.xml was injected", resource);
        Assert.assertEquals("Resource value reflect web.xml content", "Hello World from an env-entry", resource);
    }
}
