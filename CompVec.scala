package problems

import chisel3._
import chisel3.util._



class CompVec extends Module {
  val io = IO(new Bundle {
    val in = Input(Vec(5, UInt(3.W)))
    val out = Output(Vec(5, UInt(3.W)))
  })
	object ACTG {
	val map = Map('A -> 0.U(3.W), 'C -> 3.U(3.W), 'G -> 2.U(3.W), 'T -> 1.U(3.W), 'N -> 4.U(3.W))
	val width : Int = 3
	def apply(a:Symbol): UInt = map(a)
}

val x = 4
    for (i <- 0 to x)
{

		io.out(i) := ACTG('N)
		when(io.in(i) === ACTG('A)) {
			io.out(i) := ACTG('T) 
		} .elsewhen(io.in(i) === ACTG('T)) {
			io.out(i) := ACTG('A) 
		} .elsewhen(io.in(i) === ACTG('G)) {
			io.out(i) := ACTG('C)
		} .elsewhen(io.in(i) === ACTG('C)) {
			io.out(i) := ACTG('G)
		}
		

}}


