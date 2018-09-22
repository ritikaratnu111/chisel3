package problems


import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}


class CompVecTest(c: CompVec) extends PeekPokeTester(c) {
var test_in = BigInt("012")
var z = 0
val y = c.x

	for ( i <- 0 to y)

	{
	val y = test_in & 0x07
	test_in = test_in >> 3
	 
	poke(c.io.in(i), y)


		if ( y == 0) {
		z = 1 }
		else if ( y == 1) {
		z = 0 }
		else if ( y == 2) {
		z = 3 }
		else if ( y == 3) {
		z = 2 }
		else {
		z = 4  } 
	
		//return z

	printf("complement of the given number is ".format(t)+" "+ peek(c.io.out(i)).toString()+"\n")

	printf("--\n")


//expect(c.io.out(i), z)

}

}
