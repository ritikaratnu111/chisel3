// See LICENSE.txt for license details.
package problems

import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}
import chisel3.util.Cat

class CompTest(c: Comp) extends PeekPokeTester(c) {
  
	 var y = 0
      
	
    for( t <- 0 until 5){
	    
	    poke(c.io.in, 32523739)
	    poke(c.io.i, t)
	    step(1)
	    expect(c.io.out, 28787743)
 
   
	    val x = ((28787743 >> (t * 5)) & 0x1F)
	
		if ( x == 31) {
		y = 0 }
		else if ( x == 0) {
		y = 31 }
		else if ( x == 17) {
		y = 14 }
		else if ( x == 14) {
		y = 17 }
		else {
		y = 27  }      

	    expect(c.io.out1, y)

   

	}
	
}

