// is_an_anagram : string → string list → boolean that given a 
// dictionary of strings, checks if the input string is an anagram 
// of one or more of the strings in the dictionary;

class Palindrome{
	def is_palindrome(str: String) : Boolean = {
		var filtered = str.filter(pred);
		filtered==filtered.reverse;
		}
	private def pred(c: Char): Boolean = {
		c.toLower>='a' && c.toLower<='z'
		}
	
	def main(arg: Array[String]) : Unit = {
		arg.map(is_palindrome(_))
		}
	} 

