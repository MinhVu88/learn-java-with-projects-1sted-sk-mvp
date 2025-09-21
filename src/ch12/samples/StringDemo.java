// Comparing String with StringBuilder - pg 320
package ch12.samples;

public class StringDemo {
	// String immutability | Figure 12.8 | pg 324
	private static void demoStringImmutability() {
		String s = "The ";
    s += "quick ";           
    System.out.println("String s = \"The \" | s += \"quick \" | s => " + s);

    s.concat("brown fox");
    System.out.println("s.concat(\"brown fox\") | s => " + s);

    s = s.concat("brown fox");
    System.out.println("s = s.concat(\"brown fox\") | s => " + s);
	}

	// StringBuilder class | Figure 12.10 | pg 328
	private static void demoStringBuilder() {
		StringBuilder sb = new StringBuilder("The ");
		System.out.println("sb = new StringBuilder(\"The \") | sb => " + sb);

    sb.append("quick ");
    System.out.println("sb.append(\"quick \") | sb => " + sb);
    
		sb.append("brown fox");
    System.out.println("sb.append(\"brown fox\") | sb => " + sb);
	}

	// String vs StringBuilder | Figure 12.12 | pg 330
	private static void stringVsStringBuilder(String s, StringBuilder sb) {
		s = s.concat(" there");
    sb.append(" there");
    System.out.println("String => " + s + " | StringBuilder => " + sb);
	}

	// Figure 12.6 - pg 322
	public static void main(String[] args) {
		String str0 = "abc";
		String str1 = "abc";
		System.out.println(
			(str0 == str1) 
			? "str0 == str1 | 'abc' == 'abc'" 
			: "str0 != str1 | 'abc' != 'abc'"
		);

		String str2 = new String("abc");
		System.out.println(
			(str0 == str2) 
			? "str0 == String str2 = new String(\"abc\")" 
			: "str0 != String str2 = new String(\"abc\")" + 
			((str0.equals(str1)) 
			? " | str0.equals(str1) => true" 
			: " | str0.equals(str1) => false") +
			((str0.equals(str2)) 
			? " | str0.equals(new String(\"abc\")) => true" 
			: " | str0.equals(new String(\"abc\")) => false")
		);

		str2 = str2.intern();
		System.out.println(
			(str0 == str2) 
			? "str0 == str2 = str2.intern()" 
			: "str0 != str2 = str2.intern()"
		);

		System.out.println("-----------------------------------------------------------");

		demoStringImmutability();
		
		System.out.println("-----------------------------------------------------------");

		demoStringBuilder();

		System.out.println("-----------------------------------------------------------");

		String str3 = "hi";
		StringBuilder sb0 = new StringBuilder("hi");
		stringVsStringBuilder(str3, sb0);
		System.out.println("str3 => " + str3 + " | sb0 => " + sb0);
	}
}
