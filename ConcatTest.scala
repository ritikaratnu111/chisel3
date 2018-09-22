package problems

import chisel3.iotesters.PeekPokeTester

class ConcatTest(c: Concat) extends PeekPokeTester(c) {

poke(c.io.in1, 0)
poke(c.io.in2, 1)
expect(c.io.out, 1)

}
