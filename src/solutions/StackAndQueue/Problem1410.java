package solutions.StackAndQueue;

import java.util.HashMap;

public class Problem1410 {
    public String entityParser(final String text) {
        HashMap<String, String> keywordSet = new HashMap<>();
        keywordSet.put("&gt;",">");
        keywordSet.put("&lt;","<");
        keywordSet.put("&amp;","&");
        keywordSet.put("&quot;","\"");
        keywordSet.put("&apos;","'");
        keywordSet.put("&frasl;","/");
        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        boolean needTestComer = false;
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == '&') {
                needTestComer = true;
                stack.append(ch);
            } else {
                if (needTestComer) {
                    stack.append(ch);
                    if (ch == ';') {
                        String tempKey = stack.toString();
                        if (keywordSet.containsKey(tempKey)) {
                            result.append(keywordSet.get(tempKey));
                        } else {
                            result.append(stack);
                        }
                        stack.setLength(0);
                        needTestComer = false;
                    }
                } else {
                    result.append(ch);
                }
            }
        }
        if (stack.length() != 0) {
            result.append(stack);
        }
        return result.toString();
    }
}
