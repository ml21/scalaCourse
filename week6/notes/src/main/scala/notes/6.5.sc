// https://www.coursera.org/learn/progfun1/lecture/5vUiM/lecture-6-5-putting-the-pieces-together
import scala.io.Source

val in = Source.fromFile("src/main/resources/forcomp/linuxwords.txt")
val words = in.getLines.toList filter (word => word forall (ch => ch.isLetter))

val mnem = Map(
    '2' -> "ABC",
    '3' -> "DEF",
    '4' -> "GHI",
    '5' -> "JKL",
    '6' -> "MNO",
    '7' -> "PQRS",
    '8' -> "TUV",
    '9' -> "WXYZ"
)

val charCode: Map[Char, Char] =
    for ((n, str) <- mnem; ch <- str) yield ch -> n

def wordCode(word: String): String = word.toUpperCase.map(ch => charCode(ch))

wordCode("hello")
wordCode("Java")

val wordsForNum: Map[String, Seq[String]] =
    words.groupBy(wordCode) withDefaultValue Seq()

"1234" drop 2
"1234" take 2

wordsForNum("2426237")

def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
        for {
            split <- 1 to number.length;
            word <- wordsForNum(number take split);
            rest <- encode(number drop split)
        } yield word :: rest
    }.toSet

encode("7225247386")
encode("214")


/****************************************/
val dict = words

def buildOcurrence(word: String): String = word.toLowerCase.sorted

var occurencesByWord: Map[String, List[String]] =
    words.groupBy(buildOcurrence)

def getAnagrams(word: String): List[String] = occurencesByWord.getOrElse(buildOcurrence(word), List("not found"))

// beta bate beat
getAnagrams("abet")

getAnagrams("live")
getAnagrams("dead")
getAnagrams("love")
getAnagrams("they")

"dsfasd".groupBy(x => x).map(m => (m._1, m._2.length)).toList

List("dafsd", "sdfasdf").mkString
buildOcurrence("dfs sdfasf".split(" ").toList.mkString)



def getAnagramsS(sentence: List[String]): List[String] = {
    val joined = sentence.mkString
    for {
        split <- 1 to joined.length;
        word <- joined take split;
        rest <- getAnagrams(joined drop split)
    } yield getAnagrams(word) +++ rest
}

// Dade live
getAnagrams("dead" :: "evil" :: Nil)
