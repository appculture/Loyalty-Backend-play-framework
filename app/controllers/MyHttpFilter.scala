package controllers

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}
import play.api.http.HttpFilters
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc._

import scala.concurrent.Future

class MyHttpFilter extends HttpFilters {
  val filters = Seq(DisableBrowserCache)

}

object DisableBrowserCache extends Filter {

  implicit val system = ActorSystem("MyActorSystem")
  implicit val mat = ActorMaterializer()

  def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {

    nextFilter(requestHeader).map { result =>

      result.withHeaders("Cache-Control" -> "no-cache, no-store, must-revalidate",
        "Pragma" -> "no-cache",
        "Expires" -> "0")
    }
  }

}



