package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object hello {
  val Hello = ReactComponentB[Unit]("Hello page")
    .render(_ =>
      blockquote("Hello, routing")
    )
    .build
}