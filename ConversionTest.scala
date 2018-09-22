package problems
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class ConvertTest(c: Convert) extends PeekPokeTester(c) {

  
var test1 = 'A'
var test2 = 0


for ( i <- 0 to 4)

{
	val y = test1 & 0x7F

	//test1 = test1 >> 7

	poke(c.io.seqIn(i), y)
}

for ( i <- 0 to 4)

{
	val z = test2 & 0x7F
	test2 = test2 >> 7

	expect(c.io.seqOut(i), z)
}


}
  
  
  
  
  
  
  
  
  
  
  /*for(i <- 1 to 10) {
    for (j <- 0 until 5) {
      poke(c.io.seqIn(j), j)
    }
    for (j <- 0 until 5) {
      printf("cyc@%03d".format(t)+" "+ peek(c.io.seqOut(j)).toString()+"\n")
    }
	printf("--\n")
    step(1)
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * testOnly example.test.GCDTester
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'testOnly example.test.GCDTester'
  * }}}
  */
class ConvertUnitTest extends ChiselFlatSpec {
  // Disable this until we fix isCommandAvailable to swallow stderr along with stdout
  private val backendNames = if(false && firrtl.FileUtils.isCommandAvailable(Seq("verilator", "--version"))) {
    Array("firrtl", "verilator")
  }
  else {
    Array("firrtl")
  }
  for ( backendName <- backendNames ) {
    "Convert" should s"calculate proper greatest common denominator (with $backendName)" in {
      Driver(() => new Convert, backendName) {
        c => new ConvertTest(c)
      } should be (true)
    }
  }

  "Basic test using Driver.execute" should "be used as an alternative way to run specification" in {
    iotesters.Driver.execute(Array(), () => new Convert) {
      c => new ConvertTest(c)
    } should be (true)
  }

  "using --backend-name verilator" should "be an alternative way to run using verilator" in {
    if(backendNames.contains("verilator")) {
      iotesters.Driver.execute(Array("--backend-name", "verilator"), () => new Convert) {
        c => new ConvertTest(c)
      } should be(true)
    }
  }

  "running with --is-verbose" should "show more about what's going on in your tester" in {
    iotesters.Driver.execute(Array("--is-verbose"), () => new Convert) {
      c => new ConvertTest(c)
    } should be(true)
  }

  "running with --fint-write-vcd" should "create a vcd file from your test" in {
    iotesters.Driver.execute(Array("--fint-write-vcd"), () => new Convert) {
      c => new ConvertTest(c)
    } should be(true)
  }
}*/




