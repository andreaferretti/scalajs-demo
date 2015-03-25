enablePlugins(ScalaJSPlugin)

name := "Demo"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

skip in packageJSDependencies := false

libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "com.lihaoyi" %%% "utest" % "0.3.0" % "test",
    "com.github.japgolly.scalajs-react" %%% "core" % "0.8.2",
    "com.github.japgolly.scalajs-react" %%% "extra" % "0.8.2",
    "com.github.japgolly.scalajs-react" %%% "test" % "0.8.2" % "test",
    "eu.unicredit" %%% "paths-scala-js" % "0.3.2"
)

jsDependencies += "org.webjars" % "react" % "0.12.1" / "react-with-addons.js" commonJSName "React"

requiresDOM := true