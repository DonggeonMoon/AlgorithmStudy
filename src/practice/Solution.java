package practice;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // map 초기화
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
        }

        // 중복 제거
        HashSet<String> set = new HashSet<>(Arrays.asList(report));

        // map에 신고 횟수 기록
        for (String i : set) {
            int count = map.get(i.split(" ")[0]) + 1;
            map.put(i.split(" ")[1], count);
        }

        for (int i = 0; i < answer.length; i++) {
            for (String j :set) {
                if (map.get(j.split(" ")[0]) >= k) {
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}