package progscala2.typesystem.selftype

trait Persistence {def startPersistence(): Unit}
trait Midtier {def startMidtier(): Unit}
trait UI {def startUI(): Unit}

trait Database extends Persistence {
  def startPersistence(): Unit = println("Starting Database")
}

trait BizLogic extends Midtier {
  override def startMidtier(): Unit = println("String BizLogic")
}

trait WebUI extends UI {
  override def startUI(): Unit = println("String WebUI")
}

trait AppRun {
  self: Persistence with Midtier with UI =>
  def run() = {
    startPersistence()
    startMidtier()
    startUI()
  }
}

object MyApp extends AppRun with Database with BizLogic with WebUI {
  def main(args: Array[String]): Unit = {
    run()
  }
}
