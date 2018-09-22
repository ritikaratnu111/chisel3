package problems

import chisel3._
import chisel3.util._

class prefix extends Module {
    val io = IO(new Bundle {
    val in = Input(Vec(7, UInt(3.W)))
    val out = Output(Vec(7, UInt(3.W)))

  })

val i = 2 //if ATGC is input, you will get AT
val L = 7


	for (l <- 0 to i)
	{
		io.out(l) := io.in( L - i - l)

	}
	
	
	for (k <- i until L)
	{
		io.out(k) := 0.U
	}
	
	
}	
	
