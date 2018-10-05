import slick.codegen.SourceCodeGenerator

/**
  * Created by linsixin on 2018/7/28.
  */
object TablesGenerator extends App {

  SourceCodeGenerator.run(
    profile = "slick.jdbc.H2Profile",
    jdbcDriver = "org.h2.Driver",
    url = "jdbc:h2:./$h2dbName$",
    outputDir = "src/main/scala",
    pkg = "tables",
    user = Some("sa"),
    password = None,
    ignoreInvalidDefaults = true
  )

}
