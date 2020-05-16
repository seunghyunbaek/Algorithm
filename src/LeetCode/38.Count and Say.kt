package LeetCode

import java.lang.StringBuilder

/*
    38. Count and Say : https://leetcode.com/problems/count-and-say/

    문제 : 나열된 숫자의 갯수를 세기

    각 단계별 순서가 아래를 따라 진행된다.

    1. 1
    2. 11
    3. 21
    4. 1211
    5. 111221

    갯수+숫자 의 형태로 표현된다.

    1단계는 1로 시작한다.
    2단계는 위의 1단계의 1 은 "one 1" or 11 로 읽는다. ( 1개 1 )
    3단계는 2단계의 11 을 "two 1s" or 21 로 읽는다. ( 2개 1 )
    4단계는 3단계의 21 을 "one 2, then one 1" or 1211 로 읽는다. ( 1개 2, 1개 1)
    5단계는 4단계의 1211 을 "one 1, one 2 then two 1" or 111221 로 읽는다. (1개 1, 1개 2, 2개 1)

    위와 같은 진행을 가지며

    1 <= n <= 30의 n이 주어질 때, n번째 단계의 결과를 출력하면 된다.

    Note : 나열된 정수는 문자의 형태.

    Point
        * 첫 단계의 숫자 나열은 1 이다.
        * n번째가 될 때가지 반복된다.
        * 이전 단계의 숫자의 나열을 이용하여 다음 단계가 만들어진다.

    Solution 1. 재귀함수 만들기
        종료 조건
            현재 단계가 n번째일 때

        할일
            n-1번째의 나열된 숫자의 갯수를 확인하여 결과로 출력한다.
 */

class CountAndSay {
    fun countAndSay1(n: Int): String {
        var s = StringBuilder("1")
        var now = 1

        var result = solution1(now, s, n)

        return result.toString()
    }

    private fun solution1(now: Int, s: StringBuilder, n: Int): StringBuilder {

        // 종료 조건
        if (now == n)
            return s

        // 길이가 1일 때
        if (s.length == 1) {
            return solution1(now + 1, StringBuilder("1$s"), n)
        }

        // 최소 11 부터 시작
        // n-1단계의 s 숫자갯수세기
        var result = StringBuilder()

        // index 0번의 상황
        var count = 1
        var prev = s[0]

        // index 1번부터 시작
        for (i in 1..s.lastIndex) {
            if (prev == s[i]) { // 같은 숫자일 때
                count++ // 갯수 증가
            } else { // 다른 숫자일 때
                result.append(count).append(prev) // 문자열에 기록
                prev = s[i] // 현재숫자
                count = 1 // 갯수
            }

            // if와 else 모두에서 일어날 수 있어 for문 마지막에 위치함
            if (i == s.lastIndex) { // 마지막 인덱스일 때 갯수와 숫자를 추가기록
                result.append(count).append(prev) // 문자열에 기록
            }
        }

        return solution1(now + 1, result, n)
    }


    fun countAndSay2(n: Int): String {
        var n = n
        var ret = "" + 1

        while(--n > 0)
            ret = solution2(ret)

        return ret
    }

    fun solution2(s:String):String {
        val ret = StringBuilder()

        var i = 0
        var count = 0

        while(i < s.length) {
            while(i+count < s.length && s[i] == s[i+count])
                count++

            ret.append(count).append(s[i])
            i += count
            count = 0
        }

        return ret.toString()
    }
}

fun main() {
    var solution = CountAndSay()

    println(solution.countAndSay1(1))
    println(solution.countAndSay1(3))
    println(solution.countAndSay1(4))
}