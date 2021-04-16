package com.alvinalexander.general

import java.util.concurrent.ForkJoinPool
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

object ConcurrencyWithFuture {

  def test1() = {
    val baseTime = System.currentTimeMillis()
//    implicit val executionContext: ExecutionContext = ExecutionContext.fromExecutor(new ForkJoinPool(30))

    val f = Future {
      println("sleeping 500")
      Thread.sleep(800)
      1 + 1
    }

    val result = Await.result(f, 1 second)
    println(result)
    println("sleeping 1000")
    Thread.sleep(1000)
  }


  def run() = {
    test1()
  }

}
