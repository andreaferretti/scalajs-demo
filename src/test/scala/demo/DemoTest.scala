package demo

import utest._


object DemoTest extends TestSuite {
  import components.items.matches
  def tests = TestSuite {
    'DemoMatch {
      assert(matches("Hello, Scala!", "scala"))
      assert(! matches("Hello, Scala!", "erlang"))
    }
  }
}