package demo

import org.scalatest.{FunSuite, Matchers}
import utils.HttpRequestUtils

class TestGetWeibo extends FunSuite with Matchers{

  import HttpRequestUtils._

  test("get weibo hot keyword") {
    reqHeader += "referer" -> "http://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6"
    val (con,result) = httpGet("http://s.weibo.com/ajax/jsonp/gettopsug")
    println(new String(result,"utf8"))
    con.disconnect()
  }

}
