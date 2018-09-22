// See README.md for license details.

package problems

import chisel3._


object ACTG {
	val map = Map('A -> 0.U(3.W), 'C -> 1.U(3.W), 'G -> 2.U(3.W), 'T -> 3.U(3.W), 'N -> 4.U(3.W))
	val width : Int = 3
	def apply(a:Symbol): UInt = map(a)
}

object ACTGComplement {
	def apply(a: UInt) : UInt = {
		val out = Wire(UInt(ACTG.width.W))
		out := ACTG('N)
		when(a === ACTG('A)) {
			out := ACTG('T) 
		} .elsewhen(a === ACTG('T)) {
			out := ACTG('A) 
		} .elsewhen(a === ACTG('G)) {
			out := ACTG('C)
		} .elsewhen(a === ACTG('C)) {
			out := ACTG('G)
		}
		return out
	}
}


class GCD extends Module {
  val io = IO(new Bundle {
    val seqIn      = Input(Vec(5, UInt(ACTG.width.W)))
    val seqOut     = Output(Vec(5, UInt(ACTG.width.W)))
  })

  val seqReverseWr = Wire(Vec(5, UInt(ACTG.width.W)))		
  seqReverseWr := io.seqIn.reverse 	  
 
  io.seqOut := seqReverseWr.map(i => ACTGComplement(i))
}
