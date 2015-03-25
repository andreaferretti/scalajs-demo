package demo

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom.{ document, window }
import japgolly.scalajs.react.React

import components.toplevel._


object Main extends js.JSApp {
  def defer(F: => Unit) = window.setTimeout({ () => F }, 0)

  def matches(s: String, query: String) = s.toLowerCase contains query

  def main = defer(React.render(TopLevel("Hello, Scala!"), document.body))
}