package com.vertispan.j2cl.sample;

import com.google.gwt.junit.client.GWTTestCase;

public class OldStyleTestSample extends GWTTestCase {

    public void testSomething() {
        // note that this doesn't work yet, need to use the JUnit4 style for now
//        delayTestFinish(1000);

        assertTrue(true);
    }

    public void testSomethingBroken() {
        assertTrue("Fails, as expected", false);
    }

    public String getModuleName() {
        return "this.does.nothing.in.j2cl";
    }

}
