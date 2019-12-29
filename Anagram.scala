// is_an_anagram : string → string list → boolean that given a dictionary 
// of strings, checks if the input string is an anagram of one or more 
// of the strings in the dictionary;

class Anagram{
	def is_an_anagram(str: String, str_list: List[String]) : Boolean = {
		var sorted = str.map(_.toLower).sorted;
		{var base = false; for (X<-str_list) base= base || (sorted==X.map(_.toLower).sorted); base}
	}
} 

