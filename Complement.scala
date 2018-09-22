package problems

import chisel3._
import chisel3.util._



class Comp extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(25.W))
    val out = Output(UInt(25.W))
    val i = Input(UInt(4.W))
    val out0   = Output(UInt(5.W))
    val out1   = Output(UInt(5.W))
 
  })


val r8 = Wire(UInt(5.W))
 
io.out := Reverse(io.in)



 io.out0 := 0.U(8.W)
  when (io.i === 0.U) {
    io.out0 := io.out(4,0)
  } .elsewhen (io.i === 1.U) {
    io.out0 := io.out(9,5)
  } .elsewhen (io.i === 2.U) {
    io.out0 := io.out(14,10)
  } .elsewhen (io.i === 3.U) {
    io.out0 := io.out(19,15)
  } .elsewhen (io.i === 4.U) {
    io.out0 := io.out(24,20)
  }  

	when(io.out0 === 31.U) {
	r8 := 0.U            
	}.elsewhen(io.out0 === 0.U) {
        r8 := 31.U
	}.elsewhen(io.out0 === 17.U) {
        r8 := 14.U  
	}.elsewhen(io.out0 === 14.U) {
    	r8 := 17.U            
  	}.otherwise {
    	r8 := 27.U            
  	}

   
	io.out1 := r8


	
}


