package com.dejionline.stress.test

/**
  * Created by zcfrank1st on 12/01/2017.
  */
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class DemoSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://www.baidu.com") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("demo")
    .exec(http("demo-test").get("/"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}
