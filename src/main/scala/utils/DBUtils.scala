package utils

import org.slf4j.LoggerFactory
import slick.dbio.DBIO
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration._

object DBUtils {

  lazy val db = Database.forConfig("H2Config")

  private[this] val logger = LoggerFactory.getLogger(getClass)

  def execAndWaitForResult[T](ioAction:DBIO[T])(duration: Duration = 500.millis):T = {
    try{
      Await.result(db.run(ioAction),duration)
    }catch {
      case e:Exception =>
        logger.error("",e)
        throw e
    }
  }

  def exec[T](ioAction:DBIO[T]) = {
    db.run(ioAction)
  }

}
