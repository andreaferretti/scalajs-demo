package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object toplevel {

  val TopLevel = ReactComponentB[String]("Top level component")
    .render(message =>
      div(className := "container",
        div(className := "row",
          div(className := "col-md-4 alert alert-success", message)
        )
      )
    )
    .build
}