package Others;

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
        boolean needTestComer = false;
        int comerStart = -1;
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == '&') {
                needTestComer = true;
                result.append(ch);
                comerStart = result.length() - 1;
            } else {
                if (needTestComer) {
                    result.append(ch);
                    if (ch == ';') {
                        String tempKey = result.substring(comerStart);
                        if (keywordSet.containsKey(tempKey)) {
                            result.delete(comerStart, result.length());
                            result.append(keywordSet.get(tempKey));
                        }
                        comerStart = -1;
                        needTestComer = false;
                    }
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
