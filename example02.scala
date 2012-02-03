class Bar {
	def apply() = 0
}

var bar = new Bar

println(bar())


// Objects are used to hold single instance of a class
// Often used for factories
object Timer {
	var count = 0

	def currentCount(): Long = {
		count +=1
		count
	}
}

println(Timer.currentCount())

// Classes and Objects can have the same name
// The object is called a 'Companion Object'
class BarAgain(foo:String)

object BarAgain {
	// this effectively called when BarAgain(String)
	// and in turn initialize a new BarAgain object
	def apply(foo: String) = new BarAgain(foo)
}

// this basically print newly created object
println(BarAgain("me"))

// A Function is a set of traits
object addOne extends Function1[Int, Int] {
	def apply(m: Int): Int = m + 1
}

println(addOne(1))

class AddOne extends Function[Int, Int] {
	def apply(m: Int): Int = m + 1
}

val plusOne = new AddOne()
println("plusOne(3)" + plusOne(3))
