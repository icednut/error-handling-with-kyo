ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "error-handling-with-kyo",
    libraryDependencies ++= Seq(
      "io.getkyo" %% "kyo-core" % "0.8.2",
      "io.getkyo" %% "kyo-direct" % "0.8.2"
    )
  )