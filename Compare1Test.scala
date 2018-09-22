package problems

import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}

class Compare1Test(c: Compare1) extends PeekPokeTester(c) {



var test1 = 19333
var test2 = 24954
var test = 1237370

	for ( i <- 0 to 4)

	{

		val y = test1 & 0x07

		test1 = test1 >> 3

		poke(c.io.in1(i), y)


	}

	for ( i <- 0 to 4)

	{


		val z = test2 & 0x07

		test2 = test2 >> 3

		poke(c.io.in2(i), z)	

	}

	for ( i <- 0 to 6)

	{

		val b = test & 0x07
		test = test >> 3
		expect(c.io.out(i), b)

	}

}


