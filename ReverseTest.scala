package problems

import chisel3.iotesters.PeekPokeTester

class ReverseTest(c: Reverse) extends PeekPokeTester(c) {

poke(c.io.in, 28787743)
expect(c.io.out, 32523739)

}
