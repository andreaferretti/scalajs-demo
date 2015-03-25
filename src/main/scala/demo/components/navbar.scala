package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object navbar {
  val Navbar = ReactComponentB[Page.Router]("Navigation bar")
    .render(router =>
      nav(
        ul(className := "nav nav-pills",
          li(router.link(Page.root)("Home")),
          li(router.link(Page.hello)("Hello"))
        )
      )
    )
    .build
}