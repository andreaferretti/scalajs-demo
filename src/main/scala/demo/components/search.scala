package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object search {
  case class ValueLink(value: String, handler: String => Unit)

  val Search = ReactComponentB[ValueLink]("Search box")
    .render(props => {
      def handler(e: ReactEventI) = props.handler(e.target.value)

      div(className := "form-group",
        input(className := "form-control",
          onChange ==> handler,
          value := props.value,
          placeholder := "Filter here"
        )
      )
    })
    .build
}