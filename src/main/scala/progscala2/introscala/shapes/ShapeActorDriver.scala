package progscala2.introscala.shapes

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

private object Start

object ShapeActorDriver {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("DrawingActorSystem", ConfigFactory.load())
    val drawer = system.actorOf(Props(new ShapesDrawingActor), "drawingActor")
    val driver = system.actorOf(Props(new ShapeActorDriver(drawer)), "drawingService")

    driver ! Start
  }
}

class ShapeActorDriver(drawerActor: ActorRef) extends Actor {
  import Messages._

  override def receive: Receive = {
    case Start =>
      drawerActor ! Circle(Point(0.0, 0.0), 1.0)
      drawerActor ! Rectangle(Point(0.0, 0.0), 2.5, 2.5)
      drawerActor ! 3.14159
      drawerActor ! Triangle(Point(0.0, 0.0), Point(2.0, 0.0), Point(1.0, 2.0))
      drawerActor ! Exit
    case Finished =>
      println(s"ShapesDrawingDriver: Cleaning up")
      context.system.terminate()
    case response: Response =>
      println("ShapesDrawingDriver: Response = " + response)
    case unexpected =>
      println("ShapesDrawingDriver: ERROR: Received an unexpected message = " + unexpected)

  }
}
