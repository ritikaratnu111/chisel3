package problems

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class prefixTest(c: prefix) extends PeekPokeTester(c) {


var test1 = 12 // 00000000000001100
var test2 = 0  // prefix is 0


	for ( i <- 0 to 6)

	{
		val y = test1 & 0x07

		test1 = test1 >> 3

		poke(c.io.in(i), y)
	}

	for ( i <- 0 to 6)

	{
		val z = test2 & 0x07

		test2 = test2 >> 3

		expect(c.io.out(i), z)
	}


}
