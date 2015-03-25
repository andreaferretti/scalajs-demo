package demo.components

import scala.scalajs.js
import scala.concurrent.ExecutionContext.Implicits.global
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.ext.Ajax

import search._
import items._


object toplevel {
  case class State(query: String, countries: List[Country])

  class Backend($: BackendScope[Unit, State]) {
    def onChange(q: String) = $.modState(_.copy(query = q))
    def setCountries(cs: List[Country]) = $.modState(_.copy(countries = cs))
  }

  val TopLevel = ReactComponentB[Unit]("Top level component")
    .initialState(State("", List()))
    .backend(new Backend(_))
    .render((_, state, backend) =>
      div(className := "row",
        div(className := "col-md-4",
          Search(ValueLink(state.query, backend.onChange)),
          Items(ItemFilter(state.countries, state.query))
        )
      )
    )
    .componentDidMount(scope => {
      Ajax.get("countries.json", responseType = "json") onSuccess { case xhr =>
        val countries = xhr.response.asInstanceOf[js.Array[js.Dynamic]] map { c =>
          Country(name = c.name.asInstanceOf[String], population = c.population.asInstanceOf[Int])
        }
        scope.backend.setCountries(countries.toList)
      }
    })
    .build
}