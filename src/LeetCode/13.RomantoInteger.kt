package LeetCode

/*
    13. Roman To Integer    https://leetcode.com/problems/roman-to-integer/

    문제 : 로마 숫자를 정수로 변환하기

    7개의 로마 숫자가 있다.

    Symbol - Value
        I - 1
        V - 5
        X - 10
        L - 50
        C - 100
        D - 500
        M - 1000

    예를 들어 II는 2, III는 3이며, 나열된 로마 숫자는 더하는 것이 기본 규칙이다. 27 = XXVII

    로마 숫자는 보통 큰 숫자부터 작은 숫자의 형태로 왼쪽에서 오른쪽으로 작성되는데,
    5가 되기전에 1을 빼서 4가되기 때문에 4는 IIII가 아니라 IV로 표현한다.
    IX도 같은 방식으로 9가 된다.

    이런 뺄셈을 사용하는 예는 6가지이다.
    I는 V,X앞에 쓰여 4, 9를 만든다.
    X는 L,C앞에 쓰여 40, 90을 만든다.
    C는 D,M앞에 쓰여 400, 900을 만든다.

    Input은 1 ~ 3999 사이의 로마 숫자이다.


    Example 1
        Input: "III"
        Output: 3

    Example 2
        Input: "IV"
        Output: 4

    Example 3
        Input: "IX"
        Output: 9

    Example 4
        Input: "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.

    Example 5
        Input: "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


    Solution 1. 규칙에 맞는 케이스 정리하기 (when or if)
        로마 숫자를 큰 숫자부터 작은숫자순으로 작성되기 때문에, IXC와 같은 숫자는 없다. (IX=9, C=50) , (I = 1, XC = 90)
        제대로 작성된 숫자라면 CXI or CIX일 것이다. (111 or 109)
        따라서 케이스 별로 정리해도 문제가 발생하지 않는다.

    Solution 2. Map을 활용하기
        로마숫자마다 고유 숫자와 연결되어 Map을 사용해 K-V형태로 찾을 수 있다.
        그리고 뺄셈이 쓰이는 6가지의 경우 공통된 규칙이 있다.
        IV, IX, XL, XC, CD, CM 모두 앞의 로마숫자가 작다는 규칙을 가지고 있다는 것이다.
 */

class RomanToInteger {
    companion object {
        fun romanToInteger1(s: String): Int {
            var result = 0
            var prev = ' '

            for (c in s) {
                val cvrt = romanToInt(prev, c)
                result += cvrt
                prev = when (cvrt) {
                    3, 8, 30, 80, 300, 800 -> ' '
                    else -> c
                }
//                prev = c
            }
            println(result)
            return result
        }

        private fun romanToInt(prev: Char, c: Char) = when (c) {
            'I' -> 1
            'V' -> if (prev == 'I') 3 else 5
            'X' -> if (prev == 'I') 8 else 10
            'L' -> if (prev == 'X') 30 else 50
            'C' -> if (prev == 'X') 80 else 100
            'D' -> if (prev == 'C') 300 else 500
            'M' -> if (prev == 'C') 800 else 1000
            else -> 0
        }

        fun romanToInteger2(s: String): Int {
            val numberMap = mapOf('M' to 1000, 'D' to 500, 'C' to 100, 'L' to 50, 'X' to 10, 'V' to 5, 'I' to 1)
            var result = 0
            var prev = 0

            for (c in s) {
                val cur = numberMap[c] ?: 0
                result += cur
                if (prev < cur) result -= (2 * prev)
                prev = cur
            }

            println(result)
            return result
        }
    }
}


fun main(args: Array<String>) {
    val input1 = "III" // 3
    val input2 = "IV" // 4
    val input3 = "IX" // 9
    val input4 = "LVIII" // 58
    val input5 = "MCMXCIV" // 1994
    val input6 = "LIX" // 59

    RomanToInteger.romanToInteger1(input1)
    RomanToInteger.romanToInteger1(input2)
    RomanToInteger.romanToInteger1(input3)
    RomanToInteger.romanToInteger1(input4)
    RomanToInteger.romanToInteger1(input5)
    RomanToInteger.romanToInteger1(input6)
}