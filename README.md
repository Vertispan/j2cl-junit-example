This is an early attempt at trying to get unit tests running in maven via j2cl. It doesn't really
work yet, but sets up the basics for what we'll need.

First of all, the junit processor and its dependencies shouldn't be given to j2cl, this is just
a limitation of how we're currently building the classpath. Next, while we have a test suite
defined, and the junit-processor handles it, we don't actually get a single js suite we can run,
but have to run each individual test case automatically. In theory we can probably read these
from the generated json file, but the hammer we have to work with is just DevMode for the moment.

Finally (for now) we don't have a server or a runner - something has to host the JS and launch
a browser (webdriver? htmlunit?) to execute the html page for each test case (or eventually, 
suite), and periodically ask it if it was successful. Probably want to just make a "blocking"
webdriver call, but have the JS invoke the callback once finished with the results.


--

J2cl includes an annotation processor that looks for `@J2clTestInput` on a junit test case or 
suite. It also supports GWT2's GWTTestCase, but without async methods (at this time). From here,
a new class with a `javatests` prefix to the package and a `_Adaptor` suffix to the classname is
generated, and a JS file is created (note that in the upstream j2cl source, the js file has a
different suffix, which I've removed for now). Additionally, a test_summary.json file is 
generated, describing all of the .js files which were created.

If you transpile the test sources and generated sources, and provide the generated .js file as
the entrypoint to the closure compiler, you will get a single JS output file which will run all
test methods in that one class. The various exported methods in closure-library's goog.testing
found at https://github.com/google/closure-library/blob/master/closure/goog/testing/jsunit.js#L67
can be used to see if the test methods are complete, and get some structured output describing
what happened.