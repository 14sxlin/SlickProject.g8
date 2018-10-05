package demo

import java.io.File

import io.FileUtils
import org.jsoup.Jsoup
import org.scalatest.FunSuite
import utils.HttpRequestUtils

/**
  * 尝试抓取本草纲目
  */
class TestGetBencaogangm extends FunSuite {

  test("crwal bencaogangmu") {
    val (_, htmlBytes) = HttpRequestUtils.httpGet("http://book.sbkk8.com/gudai/gudaiyishu/bencaogangmu/")
    FileUtils.save(new File("本草纲目-parent.html"),htmlBytes)
  }

  test("jsoup parse") {
    val doc = Jsoup.connect("http://book.sbkk8.com/gudai/gudaiyishu/bencaogangmu/").get()
    val contacts = doc.getElementsByClass("muluList")
//    println(contacts.outerHtml())
    val aLabel = contacts.select("a")
    val aIter = aLabel.iterator()
    val sb = new StringBuilder()
    aIter.forEachRemaining { a =>
      sb ++= a.text() ++ "\n"
      sb ++= a.attr("href") ++ "\n"
    }
    FileUtils.save(new File("本草纲目目录.txt"),sb.toString().getBytes)

  }

  test("parse detail") {
    val doc = Jsoup.connect("http://book.sbkk8.com/gudai/gudaiyishu/bencaogangmu/743.html").get()
    val content = doc.getElementById("content")
    val pIter = content.select("p").iterator()
    val explain
    = pIter.next().text()
    val smell = pIter.next().text()
    val functions = new StringBuilder()
    pIter.forEachRemaining { p =>
      functions ++= p.text() ++ "\n"
    }
    println(explain)
    println(smell)
    println(functions)
  }
}
