package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import search._
import items._


object toplevel {
  case class State(query: String)
  val countries = List("Italy", "France", "United Kingdom", "Saudi Arabia", "Nepal", "Australia")

  class Backend($: BackendScope[Unit, State]) {
    def onChange(q: String) = $.modState(_.copy(query = q))
  }

  val TopLevel = ReactComponentB[Unit]("Top level component")
    .initialState(State(""))
    .backend(new Backend(_))
    .render((_, state, backend) =>
      div(className := "container",
        div(className := "row",
          div(className := "col-md-4",
            Search(ValueLink(state.query, backend.onChange)),
            Items(ItemFilter(countries, state.query))
          )
        )
      )
    )
    .build
}