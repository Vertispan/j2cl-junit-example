package com.vertispan.j2cl.sample;

import com.google.j2cl.junit.apt.J2clTestInput;
import elemental2.promise.Promise;
import org.junit.Assert;
import org.junit.Test;

public class TestSample {

    @Test
    public void testSomething() {
        Assert.assertTrue(true);
    }

    @Test
    public void testSomethingBroken() {
        Assert.assertTrue("Fails, as expected", false);
    }

    @Test(timeout = 20000)
    public Promise<String> checkSomethingAsync() {
        Assert.assertTrue(true);

        // This is a little silly, but it is technically async, it will run in a microtask
        // instead of resolving right away
        return Promise.resolve("success").then(Promise::resolve);
    }

    public String getModuleName() {
        return "this.does.nothing";
    }
}