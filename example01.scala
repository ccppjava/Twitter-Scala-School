class Calculator(brand:String) {
	var color: String = if (brand == "TI") {
		"blue"
	} else if (brand == "HP") {
		"black"
	} else {
		"white"
	}

	//var brand: String = "HP"
	def add(m: Int, n: Int): Int = m + n
}

var calc = new Calculator("HP")

println(calc.add(1, 2))

//println(calc.brand)
println(calc.color)

class ScientificCalculator(brand: String) extends Calculator(brand) {
	def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
	def log(m: Int):Double = log(m, math.exp(1))
}

var esCalc = new EvenMoreScientificCalculator("HP"); 
println(esCalc.log(12));

def outter() {
	var abc = "abc";

	def inner() {
		println("inner called", abc);
	}

	abc = "efg"
	println("outter called")
	return inner;
}

outter();

// Types
trait Cache[K, V] {
	def get(key: K): V
	def put(key: K, value: V)
	def delete(key: K)
}

class MyCache extends Cache[String, String] {
  def get(key: String): String = {
		println("get is called")
	  return "value";
	}
	def put(key: String, value: String) = {}
	def delete(key: String) = {}
}

val myCache = new MyCache
myCache.get("me")
