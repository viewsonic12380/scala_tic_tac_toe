package service

import model.GameTable

import scala.util.Random

class Game(val dataPrinter: DataPrinter,
           val computerMove: ComputerMove,
           val userMove: UserMove,
           val winnerVerifier: WinnerVerifier,
           val drawVerifier: DrawVerifier) {
  def play(): Unit = {
    println("Use the following mapping table to specify a cell using numbers from 1 to 9:")
    dataPrinter.printMappingTable()
    val gameTable = new GameTable
    if (new Random().nextBoolean()) {
      computerMove.make(gameTable)
      dataPrinter.printGameTable(gameTable)
    }
    var isRun = true
    while (isRun) {
      userMove.make(gameTable)
      dataPrinter.printGameTable(gameTable)
      if (winnerVerifier.isUserWin(gameTable)) {
        println("YOU WIN")
        isRun = false
      }
      if (drawVerifier.isDraw(gameTable)) {
        println("SORRY, DRAW")
        isRun = false
      }
      computerMove.make(gameTable)
      dataPrinter.printGameTable(gameTable)
      if (winnerVerifier.isComputerWin(gameTable)) {
        println("COMPUTER WIN")
        isRun = false
      }
      if (drawVerifier.isDraw(gameTable)) {
        println("SORRY, DRAW")
        isRun = false
      }
    }

    println("GAME OVER")
  }

}


//import scala.io
//val name = StdIn.readLine("Your name: ")
//print("Your age: ")
//val age = StdIn.readInt()
//println(s"Hello, ${name}! Next year, you will be ${age + 1}.")
