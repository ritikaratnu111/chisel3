package problems

import chisel3._
import chisel3.util._



class RevComp extends Module {
  val io = IO(new Bundle {
    val in = Input(Vec(6, UInt(3.W)))
    val out = Output(Vec(6, UInt(3.W)))
   
  })

	val out0 = Wire(Vec(6, UInt(3.W)))


	object ACTG {
	val map = Map('A -> 0.U(3.W), 'C -> 3.U(3.W), 'G -> 2.U(3.W), 'T -> 1.U(3.W), 'N -> 4.U(3.W))
	val width : Int = 3
	def apply(a:Symbol): UInt = map(a)
}

val x = 5
    for (i <- 0 to x)
{

		out0(i) := io.in(x-i)

		io.out(i) := ACTG('N)
		when(out0(i) === ACTG('A)) {
			io.out(i) := ACTG('T) 
		} .elsewhen(out0(i) === ACTG('T)) {
			io.out(i) := ACTG('A) 
		} .elsewhen(out0(i) === ACTG('G)) {
			io.out(i) := ACTG('C)
		} .elsewhen(out0(i) === ACTG('C)) {
			io.out(i) := ACTG('G)
		}
		

}}


