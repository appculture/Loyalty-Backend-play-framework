name := "Loyalty-Backend-play-framework"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  cache,
  javaWs,
  "org.mindrot" % "jbcrypt" % "0.3m"
)


fork in run := true