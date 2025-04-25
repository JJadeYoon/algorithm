import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> numbers = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> sortedNumbers = new ArrayList(numbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers.toString());
        int minNum = sortedNumbers.get(0);
        System.out.println(minNum);
        int maxNum = sortedNumbers.get(sortedNumbers.size() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(minNum);
        sb.append(" ");
        sb.append(maxNum);

        return sb.toString();
    }
}