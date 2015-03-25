package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object items {
  case class ItemFilter(items: List[String], query: String)

  def matches(s: String, query: String) = s.toLowerCase contains query

  val Items = ReactComponentB[ItemFilter]("Item list")
    .render(props =>
      ul(props.items filter { s => matches(s, props.query) } map { s => li(s) })
    )
    .build
}