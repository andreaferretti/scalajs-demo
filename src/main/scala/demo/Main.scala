package demo

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom.{ document, window }
import japgolly.scalajs.react.React
import japgolly.scalajs.react.extra.router.{ BaseUrl, Router }

import components.Page


object Main extends js.JSApp {
  def defer(F: => Unit) = window.setTimeout({ () => F }, 0)

  // For development
  val App = Page.router(BaseUrl.fromWindowOrigin / "index-dev.html", Router.consoleLogger)
  // For production
  // val App = Page.router(BaseUrl.fromWindowOrigin / "index.html")

  def main = defer(React.render(App(), document.body))
}