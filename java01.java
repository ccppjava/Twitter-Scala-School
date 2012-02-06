interface DummyInterface {
    void printInfo();
}

class JavaOutter {
	private String theString;

	void setTheString(String str) {
		this.theString = str;
	}

	String getAllString() {
		return "abc" + theString;
	}

	void printSomething() {
		DummyInterface anon = new DummyInterface() {
			@Override
			public void printInfo() {
				System.out.println(theString);
			}
		};

		// print information from the annoymous object
		anon.printInfo();
	}

	public static void main(String[] args) {
		JavaOutter out = new JavaOutter();
		JavaInner in = out.new JavaInner();
		out.setTheString("the outter string");
		in.printInfo();

		out.printSomething();
	}

	class JavaInner {
		// inner class cannot have static member
		// unless it is const (final primitive decided at compile time)
		static final String CONST_STR = "abcdefg";
    JavaInner() {
			this.theInnerString = "the inner string";
		}

		String theInnerString;

		void printInfo() {
			System.out.println(theString);
			System.out.println(theInnerString);
		}
	}
}
