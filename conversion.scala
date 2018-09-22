package problems

import chisel3._


object ATGC {
val map = Map('A -> 65.U(7.W), 'T -> 84.U(7.W), 'G -> 71.U(7.W), 'C -> 67.U(7.W), 'N -> 78.U(7.W))
val width : Int = 7
def apply(a:Symbol): UInt = map(a)
}

	object ATGCConversion {
		def apply(a: UInt) : UInt = {
			val out = Wire(UInt(ATGC.width.W))
			out := 4.U
				when(a === ATGC('A)) {
					out := 0.U 
				} .elsewhen(a === ATGC('T)) {
					out := 1.U
				} .elsewhen(a === ATGC('G)) {
					out := 2.U
				} .elsewhen(a === ATGC('C)) {
					out := 3.U
				}
					return out
				}
			}


class Convert extends Module {
	val io = IO(new Bundle {
    		val seqIn      = Input(Vec(5, UInt(ATGC.width.W)))
    		val seqOut     = Output(Vec(5, UInt(ATGC.width.W)))
  	})

  	  
 
  	io.seqOut := io.seqIn.map(i => ATGCConversion(i))
}
