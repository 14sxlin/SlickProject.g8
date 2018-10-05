package demo

import org.scalatest.FunSuite

class TestDB extends FunSuite{
  import tables.Tables._
  import utils.DBUtils._
  import slick.jdbc.H2Profile.api._
  import scala.concurrent.duration._

  test("select") {
    val res = execAndWaitForResult(Bcgm.take(20).result)(1.seconds)
    println(res)
  }

  test("insert"){
    val res = execAndWaitForResult(Bcgm += BcgmRow(-1,"1","1","1","1"))(1.seconds)
    println(res)
  }

}
