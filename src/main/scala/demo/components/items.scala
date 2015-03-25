package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import piechart._

object items {
  case class ItemFilter(items: List[Country], query: String)

  def matches(s: String, query: String) = s.toLowerCase contains query

  val Items = ReactComponentB[ItemFilter]("Item list")
    .render(props => {
        val countries = props.items filter { s =>
          matches(s.name, props.query)
        } take 30
        val list = ul(countries map { s => li(s"${ s.name }: ${ s.population }") })

        div(
          div(className := "col-md-4", list),
          div(className := "col-md-8", if (countries.length > 0) PieChart(countries) else div())
        )
      }
    )
    .build
}