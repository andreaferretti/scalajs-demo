Example application written in Scala.js and React
=================================================

This is a barebone example of an application written in
[Scala.js](http://www.scala-js.org/).

Get started
-----------

To get started, open `sbt` in this example project, and execute the task
`fastOptJS`. This creates the file `target/scala-2.11/demo-fastopt.js`.

The file `index-dev.html` contains the working application. It uses
the scalajs-react router, which in turn relies on the history API of
the browser. Since this API is disabled for security reasons on local
files, you need to serve the main directory through a server.

For instance, you can run

    python -m SimpleHTTPServer

and then visit `http://localhost:8000/index-dev.html`.

During development, it is useful to use `~fastOptJS` in sbt, so that each
time you save a source file, a compilation of the project is triggered.
Hence only a refresh of your Web page is needed to see the effects of your
changes.

Run the tests
-------------

To run the test suite, execute the task `test`. If you have installed
[Node.js](http://nodejs.org/), you can also run `fastOptStage::test` which is
faster.

The fully optimized version
---------------------------

For ultimate code size reduction, use `fullOptJS`. This will take several
seconds to execute, so typically you only use this for the final, production
version of your application. While `index-dev.html` refers to the
JavaScript emitted by `fastOptJS`, `index.html` refers to the optimized
JavaScript emitted by `fullOptJS`.