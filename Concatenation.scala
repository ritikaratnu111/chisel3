package problems

import chisel3._
import chisel3.util._

class Compare1 extends Module {
    val io = IO(new Bundle {
    val in1 = Input(Vec(8, UInt(3.W)))
    val in2 = Input(Vec(8, UInt(3.W)))
    val out = Output(Vec(8, UInt(3.W)))
    
  })
   
    val in3 = Wire(Vec(8, UInt(3.W)))
    val in4 = Wire(Vec(8, UInt(3.W)))
     
     

	var c = 1.U
	var b = 0.U
	val L1 = 8
	val L = 5
	val ml = 3
	val m = (2*L) - ml	

	for (l <- 0 to ml)
	{
		in3(l) := io.in1(l)

	}
	
	for (l <- 0 to ml)
	{
		in4(l) := io.in2(l + (L - ml))

	}
	
	for (k <- ml until L1)
	{
		in3(k) := 0.U
		in4(k) := 0.U
	}
	
	
	when ((in3(0) === in4(0)) && (in3(1) === in4(1)) && (in3(2) === in4(2))) {
	
		for (a <- 0 until L)
		{
			io.out(a) := io.in2(a)
		}

		for (i <- L until m)
		{
	
			io.out(i) := io.in1(i - (L - ml))
	
		}
	
	
		for (i <- m until L1)
		{
			io.out(m) := 0.U
		}
		
	}.otherwise {
	
		for (i <- 0 until L1)
		{
	
			io.out(i) := 0.U
	
		}
	}
}
		
	


