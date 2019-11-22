package com.programmers.level1;

import java.util.LinkedList;
import java.util.List;

/*
	코딩테스트 연습 > 2020 KAKAO BLIND RECRUITMENT > 문자열 압축

	문제 설명
	데이터 처리 전문가가 되고 싶은 어피치는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 
	최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 
	문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
	간단한 예로 aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 
	이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 
	예를 들면, abcabcdede와 같은 문자열은 전혀 압축되지 않습니다. 
	어피치는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
	
	예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있습니다. 
	다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.
	
	다른 예로, abcabcdede와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 abcabc2de가 되지만, 3개 단위로 자른다면 2abcdede가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 
	이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.
	
	압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
	s의 길이는 1 이상 1,000 이하입니다.
	s는 알파벳 소문자로만 이루어져 있습니다.
	
	입출력 예
	s							result
	"aabbaccc"					7
	"ababcdcdababcdcd"			9
	"abcabcdede"				8
	"abcabcabcabcdededededede"	14
	"xababcdcdababcdcd"			17
 */


public class Test2 {
	public static void main(String[] args) {
//		String str = "abcabcabcabcdededededede";
//		int length = str.length();
//		System.out.println(str.substring(4, 24));
		System.out.println(solution("ababcdpp"));
//		List<String> a = new ArrayList<>();
//		System.out.println(a.stream().reduce((s1, s2) -> s1 + s2).get());
	}
	
	public static int solution(String s) {
		int answer = s.length();
		int halfLength = s.length()/2;
		List<String> strList = new LinkedList<>();
		
		//1~halfLength까지 잘라서 작업..
		for(int i=1; i<=halfLength; i++) {
			String tempStr = "";
			int tempInt = 0;
			//i개씩 잘라서 비교
			for(int j=0; j<s.length(); j+=i) {
				//자를 index가 총문자열 길이보다 작거나 같아야함..
				if(j+i <= s.length()) {
					String substr = s.substring(j, j+i);
					//자른 문자열과 tempStr 비교. 같으면 count++
					//다르면 count값과 tempStr 더해서 list에 넣어줌
					if(substr.equals(tempStr)) {
						tempInt++;
					}else {
						if(!"".equals(tempStr)) {
							String tIntStr = tempInt == 0 ? "" : "" + (tempInt+1);
							strList.add(tIntStr + tempStr);
						}
						tempStr = substr;
						tempInt = 0;
					}
				}
				//마지막에 남아있는 temp들 list에 넣어주기
				if(j+i >= s.length()) {
					String tIntStr = tempInt == 0 ? "" : "" + (tempInt+1);
					strList.add(tIntStr + tempStr);
				}
				if(j+i > s.length()) {
					strList.add(s.substring(j, s.length()));
				}
			}
			//길이가 작은것 answer에
			String resultStr = strList.stream().reduce((s1, s2) -> s1 + s2).get();
			answer = Math.min(answer, resultStr.length());
			strList.clear();
		}
		
		return answer;
	}
}
