package LeetCode

/*
    387. First Unique Character in a String     https://leetcode.com/problems/first-unique-character-in-a-string/

    문제 : 문자열이 주어지면, 처음으로 반복되지 않은 문자의 인덱스를 찾아라. 없다면 -1을 리턴해라

    Examples:
        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.

    Note
        문자열은 모두 소문자라고 가정합니다.


    Solution 1. 앞에서부터 비교하기 ( 1번 방법은 코드로 작성은 하지 않도록 하겠습니다. )
        1번 문자가 다음번째랑 같은지 안같으면 다음과 같은지 비교하다 같으면 2번 문자부터 순차적으로 비교하기
        1......n
         2.....n
          3....n

    Solution 2. Map활용하기
        문자를 Key, 갯수를 Value로 만들기 ( 1...n )

        문자열의 앞의 문자부터 순서대로 Map의 키로 전달해 Value를 확인하여 1인 문자가 나오면 해당 인덱스를 반환한다. ( 1...n )

 */

class Solution {
    /* Solution 2 [Start] */
    fun firstUniqChar2(s: String): Int {

        val map = HashMap<Char, Int>()

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        for (i in 0..s.lastIndex) {
            if (map[s[i]] == 1)
                return i
        }

        return -1
    }
    /* Solution 2 [End] */
}

fun main() {
    val solution = Solution()

    println(solution.firstUniqChar2("leetcode"))
    println(solution.firstUniqChar2("loveleetcode"))
    println(solution.firstUniqChar2("llllllllllll"))

}