package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.extra.router.{ RoutingRules, Redirect }

import navbar._
import toplevel._
import hello._


object Page extends RoutingRules {
  val root = register(rootLocation(TopLevel(())))
  val hello = register(location("#hello", Hello(())))

  override val notFound = redirect(root, Redirect.Replace)
  override protected def interceptRender(i: InterceptionR): ReactElement =
    div(className := "container",
      Navbar(i.router),
      i.element
    )
}