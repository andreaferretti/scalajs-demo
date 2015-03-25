package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object items {
  case class Country(name: String, population: Int)
  case class ItemFilter(items: List[Country], query: String)

  def matches(s: String, query: String) = s.toLowerCase contains query

  val Items = ReactComponentB[ItemFilter]("Item list")
    .render(props =>
      ul(props.items filter { s =>
        matches(s.name, props.query)
      } take 30 map { s => li(s"${ s.name }: ${ s.population }") })
    )
    .build
}