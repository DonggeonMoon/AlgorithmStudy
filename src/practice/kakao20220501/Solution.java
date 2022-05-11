package practice.kakao20220501;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // map 초기화
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
        }

        // 중복 제거
        HashSet<String> set = new HashSet<>(Arrays.asList(report));

        // 신고 횟수 카운트
        for (String i : set) {
            map.put(i.split(" ")[1], map.get(i.split(" ")[1]) + 1);
        }

        for (String i : set) {
            if(map.get(i.split(" ")[1]) >= k) {
                for(int j = 0; j < answer.length; j++) {
                    if(id_list[j].equals(i.split(" ")[0])) {
                        answer[j] += 1;
                    }
                }
            }
        }

        return answer;
    }
}