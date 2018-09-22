package problems

import chisel3._
import chisel3.util._



class Rev extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(24.W))
    val out = Output(UInt(24.W))

 
  })

val r0 = Wire(UInt(4.W))
val r1 = Wire(UInt(4.W))
val r2 = Wire(UInt(4.W))
val r3 = Wire(UInt(4.W))
val r4 = Wire(UInt(4.W))
val r5 = Wire(UInt(4.W))
val x = 0x0f.U


 r0 := ((io.in >> 0.U) & x)
 r1 := ((io.in >> 4.U) & x)
 r2 := ((io.in >> 8.U) & x)
 r3 := ((io.in >> 12.U) & x)
 r4 := ((io.in >> 16.U) & x)
 r5 := ((io.in >> 20.U) & x)
 
    

io.out := Cat(r0,r1,r2,r3,r4,r5)
    

}
