package com.vertispan.j2cl.sample;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        OldStyleTestSample.class,
        TestSample.class
})
@J2clTestInput(J2clSampleSuite.class)
public class J2clSampleSuite {
}
