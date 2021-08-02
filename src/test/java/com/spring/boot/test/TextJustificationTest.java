package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an array of strings words and a width maxWidth,
    format the text such that each line has exactly maxWidth characters and
    is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
    Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible.
    If the number of spaces on a line does not divide evenly between words,
    the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left-justified and no extra space is inserted between words.

    Note:

    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.


    Example 1:

    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Example 2:

    Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
    Output:
    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
    Note that the second line is also left-justified becase it contains only one word.
    Example 3:

    Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
    Output:
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]


    Constraints:

    1 <= words.length <= 300
    1 <= words[i].length <= 20
    words[i] consists of only English letters and symbols.
    1 <= maxWidth <= 100
    words[i].length <= maxWidth

    Time Complexity: O(n)
    Space Complexity: O(length of words * length of result lines)
 */
public class TextJustificationTest {

    @Test
    public void test() {
        String[] strs = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> ans = fullJustify(strs, 16);
        System.out.println(Arrays.toString(ans.toArray()));

        Assertions.assertEquals(3, ans.size());
        Assertions.assertEquals("This    is    an", ans.get(0));
        Assertions.assertEquals("example  of text", ans.get(1));
        Assertions.assertEquals("justification.  ", ans.get(2));

        String[] strs2 = {"What","must","be","acknowledgment","shall","be"};
        List<String> ans2 = fullJustify(strs2, 16);
        System.out.println(Arrays.toString(ans2.toArray()));

        Assertions.assertEquals(3, ans2.size());
        Assertions.assertEquals("What   must   be", ans2.get(0));
        Assertions.assertEquals("acknowledgment  ", ans2.get(1));
        Assertions.assertEquals("shall be        ", ans2.get(2));

        String[] strs3 = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        List<String> ans3 = fullJustify(strs3, 20);
        System.out.println(Arrays.toString(ans3.toArray()));

        Assertions.assertEquals(6, ans3.size());
        Assertions.assertEquals("Science  is  what we", ans3.get(0));
        Assertions.assertEquals("understand      well", ans3.get(1));
        Assertions.assertEquals("enough to explain to", ans3.get(2));
        Assertions.assertEquals("a  computer.  Art is", ans3.get(3));
        Assertions.assertEquals("everything  else  we", ans3.get(4));
        Assertions.assertEquals("do                  ", ans3.get(5));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ansList = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        int currentLength = 0;
        int spaceLength = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if ((currentLength + word.length() + spaceLength > maxWidth)) {
                String str = convertToStr(currentList, maxWidth, false);
                ansList.add(str);
                currentList = new ArrayList<>();
                currentLength = 0;
                spaceLength = 0;
            }

            currentList.add(word);
            currentLength += word.length();
            spaceLength++;

            if (i == words.length - 1) {
                String str = convertToStr(currentList, maxWidth, true);
                ansList.add(str);
            }
        }
        return ansList;
    }

    private String convertToStr(List<String> currentList, int maxWidth, boolean isLastLine) {
        int strLength = 0;
        for (String str : currentList) {
            strLength += str.length();
        }

        StringBuilder sb = new StringBuilder();
        int listSize = currentList.size();
        int spaceLength = maxWidth - strLength;
        if (listSize == 1) {
            return currentList.get(0) + getSpaces(spaceLength);
        } else {
            int spaceCount = listSize - 1;
            int eachSpaceLength = spaceLength / spaceCount;
            if (isLastLine) {
                eachSpaceLength = 1;
            }
            int extraSpaceCount = spaceLength % spaceCount;
            for (int i = 0; i < listSize; i++) {
                String str = currentList.get(i);
                sb.append(str);
                if (i < spaceCount) {
                    sb.append(getSpaces(eachSpaceLength));
                    if (extraSpaceCount > 0 && !isLastLine) {
                        sb.append(" ");
                        extraSpaceCount--;
                    }
                }
            }

            if (isLastLine) {
                int spaceCountForLastLine = spaceLength - spaceCount;
                sb.append(getSpaces(spaceCountForLastLine));
            }
        }

        return sb.toString();
    }

    private String getSpaces(int spaceCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaceCount; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
