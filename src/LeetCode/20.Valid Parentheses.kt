package LeetCode


/*
    20. Valid Parentthese : https://leetcode.com/problems/valid-parentheses/

    문제 : '(', ')', '[', ']', '{', '}' 문자들만 포함된 문자열이 있을 때, input이 유효한지 체크하기.

    조건 1. 열린 괄호는 반드시 같은 형태의 괄호로 닫혀야 한다.
        '(' 있으면 ')'가 있어야 한다.

    조건 2.  열린 괄호들은 반드시 올바른 순서로 닫혀야 한다.
        ([{ 라면 }]) 의 순서로 닫혀야 한다.
            ([{}]) ( O )
            ([{})] ( x )

    빈 문자열도 유효한 것으로 간주된다는 점에 유의할 것.
        ( )
        |_| ( 가운데에 공백이 한개가 있지만 유효하다 )
 */

class ValidParent {
    fun isValid(s: String): Boolean {

        return true
    }
}

fun main() {
    val solution = ValidParent()

    val input = "()"

    println(solution.isValid(input))
}