import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
  /**
   * 遍历找到最长子串
   * @param s 输入的字符串
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {
    if (null == s || "".equals(s)) {
      return 0;
    }
    int max = 1;
    List<Character> list = s.chars().mapToObj(q -> (char) q).collect(Collectors.toList());
    // 出现过的字符
    List<Character> appearList = new ArrayList<>();
    for (int i = 0; i < list.size() - 1; i++) {
      appearList.clear();
      appearList.add(list.get(i));
      for (int j = i + 1; j < list.size(); j++) {
        Character ch = list.get(j);
        if (!appearList.contains(ch)) {
          appearList.add(ch);
          if(appearList.size() > max){
            max = appearList.size();
          }
          continue;
        }
        break;
      }
    }
    return max;
  }

  public static int lengthOfLongestSubstring2(String s){
    // ascii表 共有128个字符, last数组用于记录上次出现这个字符的位置
    int[] last = new int[128];
    int length = s.length();
    // 结果
    int res = 0;
    // 窗口开始的位置
    int start = 0;
    for (int i = 0; i < length; i++){
      // 第i个字符对应ASCII值
      int index = s.charAt(i);
      start = Math.max(start, last[index]);
      res = Math.max(res, i - start + 1);
      last[index] = i + 1;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("输入字符串");
    while (scanner.hasNext()){
      String str = scanner.next();
      int length = lengthOfLongestSubstring2(str);
      System.out.println(length);
    }

  }
}
