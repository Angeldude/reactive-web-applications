import com.typesafe.sbt.packager.archetypes.ServerLoader

name := """ch09"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(
    PlayScala,
    DebianPlugin,
    JavaServerAppPackaging
  )

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.webjars" % "jquery" % "2.1.4",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M4" % "test"
)

routesGenerator := InjectedRoutesGenerator

pipelineStages := Seq(rjs)

RjsKeys.mainModule := "application"

RjsKeys.mainConfig := "application"

maintainer := "Manuel Bernhardt <manuel@bernhardt.io>"

packageSummary in Linux := "Chapter 9 of Reactive Web Applications"

packageDescription := "This package installs the Play Application used as an example in Chpater 9 of the book Reactive Web Applications (Manning)"

serverLoading in Debian := ServerLoader.Systemd

dockerExposedPorts in Docker := Seq(9000, 9443)