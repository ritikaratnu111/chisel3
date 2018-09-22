package problems

import chisel3._

/**
  * From sbt
  * {{{
  * test:runMain problems.CompMain
  * }}}
  * To see all command line options use:
  * {{{
  * test:runMain problems.CompMain --help
  * }}}
  * To run with verilator:
  * {{{
  * test:runMain problems.CompMain --backend-name verilator
  * }}}
  * To run with verilator from your terminal shell use:
  * {{{
  * sbt 'test:runMain problems.CompMain --backend-name verilator'
  * }}}
  */
  
object CompMain extends App {
  iotesters.Driver.execute(args, () => new CompVec) {
    c => new CompVecTest(c)
  }
}

/**
  * To run from sbt
  * {{{
  * test:runMain problems.CompRepl
  * test:runMain problems.CompRepl --help
  * }}}
  * REPL stands for Repeat Eval Print Loop
  */
object CompRepl extends App {
  iotesters.Driver.executeFirrtlRepl(args, () => new CompVec)
}
