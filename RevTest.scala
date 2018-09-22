package problems

import chisel3.iotesters.PeekPokeTester

class RevTest(c: Rev) extends PeekPokeTester(c) {

poke(c.io.in, 0x123456)

expect(c.io.out, 0x654321)

}

