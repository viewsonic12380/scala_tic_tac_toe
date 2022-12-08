import service.{ComputerMove, DataPrinter, DrawVerifier, Game, UserMove, WinnerVerifier}

object Launcher {
  def main(args: Array[String]): Unit = {
    val game = new Game(new DataPrinter, new ComputerMove, new UserMove, new WinnerVerifier, new DrawVerifier)
    game.play()
  }
}
