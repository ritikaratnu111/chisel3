package problems

import chisel3._
import chisel3.util._



class Reverse extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(25.W))
    val out = Output(UInt(25.W))
  })

    io.out := Reverse(io.in)
}



