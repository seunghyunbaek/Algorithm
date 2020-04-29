package LeetCode
/*
    344. Reverse String : https://leetcode.com/problems/reverse-string/

    문제 : 문자열을 Reverse(뒤집는)하는 함수를 만들어라.

        조건 1. 입력 문자열을 char[] 형태로 제공된다.
        조건 2. 다른 Array에 추가 공간을 할당하지 않는다.
        조건 3. 모든 문자는 출력가능한 아스키 문자로 구성된다고 가정한다.

    Example 1
        Input: ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]

    Example 2
        Input: ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]

    Solution 1. 반복문 활용하기
        Input 문자열의 크기만큼 반복문을 사용해 역순으로 출력하기

    Solution 2. 반복문 활용하기
        Reverse는 뒤집는 것이므로 1 2 3 4 5 가 있을 때 5 4 3 2 1 이 되야 하는 것.
        1 2 3 4 5
        5 4 3 2 1
        이 형태를 보면
        1과 5를 바꾸고
        2와 4를 바꾸는 형태임을 확인할 수 있다.

        즉, Swap하면 n번의 반복문이 절반으로 줄어들 수 있게 된다.

    Solution 3. 제공되는 함수 활용하기

    주의사항
        main에 있는 원본 Input에 변화가 생길 수 있다.

        1번은 역순으로 출력을 하여 원본에 변화가 생기지 않지만,
        2번과, 3번은 원본에 변화가 생기게 되므로 주의해야한다.

        만약 원본이 변하지 않길 바란다면 s를 그대로 넘겨주지 말고
        s.copyOf(), s.clone() 을 사용한다.
*/

class ReverseString {
    companion object {
        fun reverseString1(s: CharArray): Unit {
            for(i in 0 until s.size) { // until은 끝 값을 사용하지 않는다.
                print(s[s.size-1-i])
            }
        }

        fun reverseString2(s:CharArray): Unit {
            var left = 0
            var right = s.lastIndex // 마지막 Index를 얻는다. (lastIndex)
            var tmp = ' '

            while(left < right) {
                tmp = s[left]
                s[left++] = s[right]
                s[right--] = tmp
            }
            print(s)
        }

        fun reverseString3(s:CharArray): Unit {
            s.reverse()
            print(s)
        }
    }
}


fun main(args: Array<String>) {
    val s = charArrayOf('h', 'e', 'l', 'l', 'o')
    print("reverse1 : ")
    ReverseString.reverseString1(s)
    println()

    print("reverse2 : ")
//    ReverseString.reverseString2(s)
    ReverseString.reverseString2(s.copyOf())
    println()

    print("reverse3 : ")
//    ReverseString.reverseString3(s)
    ReverseString.reverseString3(s.clone())
    println()

    println("original s: ${s.contentToString()}")


    // 부가적인 것
    val copyOfS = s.copyOf()
    val cloneS = s.clone()

    println(copyOfS == s) // object를 비교한다.
    println(cloneS == s)
    println(copyOfS == cloneS)

    println(copyOfS.equals(s)) // ==의 다른표현. (java에서는 eqauls로 내용을 비교할 수 있었지만 Kotlin은 다르다)
    println(cloneS.equals(s))
    println(copyOfS.equals(cloneS))

    println(copyOfS.contentEquals(s)) // 배열안의 내용을 비교하고 싶다면 contentEquals()를 이용해 비교할 수 있다.
    println(cloneS.contentEquals(s))
    print(copyOfS.contentEquals(cloneS))
}