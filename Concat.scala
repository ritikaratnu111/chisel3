package problems

import chisel3._
import chisel3.util._



class Concat extends Module {
  val io = IO(new Bundle {
    val in1 = Input(UInt(1.W))
    val in2 = Input(UInt(1.W))
    val out = Output(UInt(2.W))

 
  })
    

io.out := Cat(io.in1,io.in2)
    

}
