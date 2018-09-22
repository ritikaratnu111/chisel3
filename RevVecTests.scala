package problems

import chisel3.Bool
import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}


class RevVecTests(c: RevVec) extends PeekPokeTester(c) {
var test_in = BigInt("012765543234555544322") //c.io,in
var test_out = test_in
val y = c.x

	for ( i <- 0 to y)

	{
		val y = test_in & 0x07
		test_in = test_in >> 3
 		poke(c.io.in(i), y)


	}

	for ( i <- y to 0 by -1)

	{
		val z = test_out & 0x07
		test_out = test_out >> 3
		expect(c.io.out(i), z)

	}

}



