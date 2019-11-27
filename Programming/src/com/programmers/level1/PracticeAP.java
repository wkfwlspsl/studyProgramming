package com.programmers.level1;
/*
	코딩테스트 연습 > 연습문제 > 이상한 문자 만들기

	문제 설명
	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
	각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
	각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
	
	제한 사항
	문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
	첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
	
	입출력 예
	s				return
	try hello world	TrY HeLlO WoRlD
	
	입출력 예 설명
	try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 
	각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 
	따라서 TrY HeLlO WoRlD 를 리턴합니다.
 */
public class PracticeAP {
	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}
	
	public static String solution(String s) {
		s = s.toUpperCase();
		char[] sArr = s.toCharArray();
		int wordIdx = 0;
		
		for(int i=0; i<sArr.length; i++) {
			//공백문자
			if(sArr[i] == 32) {
				wordIdx=0;
				continue;
			}
			if(wordIdx%2 != 0) {
				sArr[i] = Character.toLowerCase(sArr[i]);
			}
			wordIdx++;
		}
		
		return String.valueOf(sArr);
	}
	
}
