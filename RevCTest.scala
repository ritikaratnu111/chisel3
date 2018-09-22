package problems


import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}


class RevCompTest(c: RevComp) extends PeekPokeTester(c) {
var test_in = BigInt("123")
var test_out = test_in
var z = 0
val k = c.x
var p = 0

	for ( i <- 0 to k)

	{
		val y = test_in & 0x07
		test_in = test_in >> 3
		poke(c.io.in(i), y)

	}

	for ( i <- k to 0 by -1)

	{

		val z = test_out & 0x07
		test_out = test_out >> 3


		if ( z == 0) {
		p = 1 }
		else if ( z == 1) {
		p = 0 }
		else if ( z == 2) {
		p = 3 }
		else if ( z == 3) {
		p = 2 }
		else {
		p = 4  } 



	expect(c.io.out(i), p)

//return z

//printf("complement of the given number is ".format(t)+" "+ peek(c.io.out(i)).toString()+"\n")

//printf("--\n")


}

}
