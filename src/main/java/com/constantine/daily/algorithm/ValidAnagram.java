package com.constantine.daily.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入：s =“anagram”，t =“nagaram”
 *
 * 输出：true
 *
 *
 *
 * 输入：s =“rat”，t =“car”
 *
 * 输出：false
 */
public class ValidAnagram {

    public static void main(String[] args) {
        boolean result = isAnagram("aaabbb","bbbaaa");
        boolean result2 = isAnagram2("aaabbb","bbbaaa");
        boolean result3 = isAnagram3("aaabbb","bbbaaa");

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ch = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch2);
        return Arrays.equals(ch, ch2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for (int j=0; j<t.length(); j++) {
            char ch = t.charAt(j);
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch)-1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}
