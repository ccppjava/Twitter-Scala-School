object example02 {
	def apply() {
/*
 * It looks like you're trying to declare the package membership in a Scala
 * script (run using the scala command) or in the REPL.
 *
 * Only files defining just classes and objects which are compiled with scalac
 * may be defined as belonging to a package.
 *
 * When you run code in a script or a REPL session, behind the scenes it is
 * actually compiled inside a method of an object, in which scope a package
 * declaration wouldn't be legal.
 *
 */
// package com.twitter.example

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


object colorHolder {
	val BLUE = "Blue"
	val RED = "Red"
}

// see top for more information on the reason
// println("this colour is:" + com.twitter.example.colorHolder.BLUE)

val times = 1

val matched = times match {
	case 1 => "one"
	case 2 => "two"
	case _ => "SOME OTHER VALUE"
}

println("matched:" + matched)

/* this bit of code in scala twitter page, is not working
 * as the match expect match class, not boolean
def calcType(calc: example01.Calculator) = calc match {
	case (calc.brand == "hp" && true) => "financial"
	case calc.brand == "hp" => "scientific"
	case calc.brand == "hp" => "business"
	case _ => "unknown"
}

println(calcType(new example01.Calculator("hp")))
*/

case class Calculator(brand: String, model: String)

val hp20b = Calculator("hp", "20B");
val hp20B = Calculator("hp", "20B");

println("hp20b == hp20B" + (hp20b == hp20B))

def calcType(calc: Calculator) = calc match {
	case Calculator("hp", "20B") => "financial"
	// scalac will detect "unreachable code" if not commented follows
	// case Calculator("hp", "20B") => "scientific"
	case Calculator("hp", "30B") => "business"
	case Calculator(_, _) => "unknown type"
}

// Exception handling code not added now

}
}
