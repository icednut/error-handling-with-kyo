import kyo.*
import kyo.ios.*
import kyo.aborts.*
import kyo.direct.*
import kyo.tries.*

object Main extends KyoApp {

  run {
//    for {
//      _ <- Consoles.println(s"Main args: $args")
//      currentTime <- Clocks.now
//      _ <- Consoles.println(s"Current time is : $currentTime")
//      randomNumber <- Randoms.nextInt(100)
//      _ <- Consoles.println(s"Generated random number: $randomNumber")
//    } yield {
//      "example"
//    }

//    Aborts[Throwable].run(Tries.catching {
//      100 / 1
//    }) match {
//      case Left(e: Throwable) =>
//        println(s"ERROR: ${e.getMessage}")
//      case Right(v) =>
//        println(v)
//    }

//    Aborts[Throwable].run(for {
//      result1 <- Tries.catching {
//        1 + 2
//      }
//      result2 <- Tries.catching {
//        result1 - 3
//      }
//      result3 <- Tries.catching {
//        100 / result2
//      }
//    } yield {
//      println(result3)
//    }) match {
//      case Left(e: Throwable) =>
//        println(s"ERROR: ${e.getMessage}")
//      case Right(v) =>
//        println(v)
//    }

//    Tries.handle(for {
//      result1 <- IOs {
//        1 + 2
//      }
//      result2 <- IOs {
//        result1 - 3
//      }
//      result3 <- IOs {
//        100 / result2
//      }
//    } yield {
//      println(result3)
//    }) { e =>
//      println(s"ERROR: ${e.getMessage}")
//    }

//    defer {
//      await {
//        Tries.handle(for {
//          result1 <- IOs {
//            1 + 2
//          }
//          result2 <- IOs {
//            result1 - "asdflkjas".toInt
//          }
//          result3 <- IOs {
//            100 / result2
//          }
//        } yield {
//          result3
//        }) { e =>
//          println(s"ERROR: ${e.getMessage}")
//        }
//      }
//    }

    Tries.handle(
      defer {
        val result1 = await(IOs {
          1 + 2
        })
        val result2 = await(IOs {
          result1 - "3".toInt
        })
        val result3 = await(IOs {
          100 / result2
        })

        result3
      }
    ) { e =>
      println(s"ERROR: ${e.getMessage}")
    }
  }
}
