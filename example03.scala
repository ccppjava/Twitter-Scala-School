object example03 {
	def apply() {
		val numbers = List(1, 2, 3, 4)
		// it will automatically delete duplicated entries, due to 
		// the fact it is set
		val sets = Set(1, 1, 2, 2, 3)

		// tuple are used for grouping together simple logical collections
		// of items without using a class
		val hostPort = ("localhost", 8080)
		// tuple don't have named accessors, they use 1-based position accessor
		// 1 based !!! 1 based !!!
		println(hostPort._1)
		println(hostPort._2)

		// tuple fit with pattern matching nicely [match ... case ... => ...]
		// tuple has some special way to make tuples of two values
		val twoTuple = 1 -> 2
		println(twoTuple)


		// Maps
		Map(1 -> 2)
		Map("foo" -> "bar")
		val map = Map(1 -> Map("foo" -> "bar"))
		// map with 1 -> 2 will automatically expands to (1, 2)

		// Option is a container which may or may not hold something.
		// basic interface for Option look like		
		// trait Option[T] {def isDefined: Boolean def get: T def getOrElse(t: T): T}
		// Option itself is generic and has two subclasses: Some[T] or None
		val mapNumbers = Map(1 -> "one", 2 -> "two")

		// Map.get use Option for it's return type. Option signifies to you
		// that the method might not be able to return what you're asking for
		// and that you should be prepared for that.
		println(mapNumbers.get(2))
		println(mapNumbers.get(3))
		println("pattern matching" + mapNumbers.get(2) match {case Some(n) => n * 2 case None => 0})
		println("pattern matching" + mapNumbers.get(3) match {case Some(n) => n * 2 case None => 0})

		// Functional Combinators
		//
		// Combinator are so-called because they are meant to be combined
		// The output of one function is often suitable as the input for another
		// map: Evaluates a function over each element in the list
		// return a list with the same number of elements
		println(numbers.map((i: Int) => i * 2))

		// foreach: foreach is like map but returns nothing
		// foreach is intended for side-effects only
		println("foreach returns nothing: " + numbers.foreach((i: Int) => i * 2))

		// when List(1, 2.0), it will ends up with a Double Typed List
		// when Map(1 -> 1, 1 -> 2), it will pick the last unique key (put?)
		// ends up with Map(1 -> 2)
		//
		// List(1, 2, 3, 4).map(n => n * 2 + "not")
		// can also pass in 'anonymouse' function
		// List(1, 2, 3, 4).map(((i: Int) => i * 2 + "not").apply _)
		// (i: Int) => i * 2 + "not") --- create anonymouse function, which is 
		// () => (Int) => String
		// the apply property (method) will give a required  (Int) => String
		// which call upon the wildcard of _, is similar effect as above
		// notice, there is no comma between function and _
		//
		// filter
		// removes any elements where the function you pass in evaluates to false
		// Function that returns boolean are often called predicate functions
		//
		// zip
		// zip aggregate the contents of two lists into a single list of pairs.
		// (quite similar to Python/Ruby idea)
		//
		// partition
		// partition splits a list based on where it falls with respect to a
		// predicate function.
		//
		// find 
		// find returns the first element of a collection that matches a predicate
		// function. (first!!!, which is the difference from filter)
		//
		// drop
		// drops the first i element (takes Int as only parameter)
		// dropWhile
		// dropWhile removes elements that don't match a predicate function.
		//
		// foldLeft
		// List(1, 3, 5, 7).foldLeft(100){(m:Int, n:Int) => println("m: " + m + " n: " + n); m + n}
		// m (left value/parameter) acts as an accumulator, 100 is the start value
		// given 
		// note: as multiple statement involved, curly bracket is used, normal
		// bracket will cause error, the online example of foldRight will not run
		//
		// foldRight
		// is the same as foldLeft except it runs in the opposite direction
		// 
		// flatten
		// flatten collapses one level of nested structure
		// List(List(1, 2), List(3, 4)).flatten
		// note: there is no bracket (), after the flatten, if present will not run
		// still not quite sure how all these combinator functions are applied
		//
		// flatMap
		// flatMap is a frequently used combinator that combines mapping and
		// flattening. flatMap takes a function that works on the nested lists and
		// then concatenates the results back together. (more like mapFlatten)
		// List(List(1, 2), List(3, 4)).flatMap(x => x.map(_ * 2))
		// note: the map function call, which can be as shorter as "_ * 2"
		// the call can be consider as:
		// .map(x: List[Int] => x.map(_ * 2)).flatten
		//
		// Generalized functional combinators (TODO)
	}
}

example03()
