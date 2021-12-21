package com.Package;

import java.util.*;

public class SSC {

  public static String small(String str, String pattern) {
	Map<Character, Integer> map = new HashMap<>();
    int matchedElement = 0;
    int start = 0;
    int minSubstringLegth = Integer.MAX_VALUE;
    int minSubStringStart = 0;
    
    for (int i = 0; i < pattern.length(); i++) {
      map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i),0) + 1);
    }

    for (int j = 0; j< str.length(); j++) {
      char currentChar = str.charAt(j);

      if (map.containsKey(currentChar)) {
        map.put(currentChar, map.get(currentChar) - 1);

        if (map.get(currentChar) >= 0) {
          matchedElement++;
        }
      }

      while (matchedElement == pattern.length()) {
        if(j - start + 1 < minSubstringLegth) {
          minSubstringLegth = j - start + 1;
          minSubStringStart = start;
        }
        
        char charAtStart = str.charAt(start++);

        if (map.containsKey(charAtStart)) {
          if (map.get(charAtStart) == 0) {
            matchedElement--;
          }

          map.put(charAtStart, map.get(charAtStart) + 1);
        }
      }

    }

    if (minSubstringLegth > str.length()) {
      return "";
    }

    return str.substring(minSubStringStart, minSubStringStart + minSubstringLegth);
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the 1st string");
    String str=sc.nextLine();
    System.out.println("enter the 2st string");
     String pattern=sc.nextLine();
    System.out.println(SSC.small(str, pattern));
  }

}

