package problems

import chisel3._
import chisel3.util._



class RevVec extends Module {
  val io = IO(new Bundle {
    val in = Input(Vec(180, UInt(3.W)))
    val out = Output(Vec(180, UInt(3.W)))
  })

val x = 179
    for (i <- 0 to x)
{

io.out(i) := io.in(x-i)

}}


