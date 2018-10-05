name := $name$

version := "0.1"

scalaVersion := $scala_version$
scalacOptions += "-feature"

libraryDependencies += "org.scalactic" %% "scalactic" % $scalatest_version$ % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % $scalatest_version$ % "test"

// https://mvnrepository.com/artifact/com.h2database/h2
libraryDependencies += "com.h2database" % "h2" % "1.4.197"

// https://mvnrepository.com/artifact/com.typesafe.slick/slick
libraryDependencies += "com.typesafe.slick" %% "slick" % $slick_version$
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % $slick_version$
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % $slick_version$