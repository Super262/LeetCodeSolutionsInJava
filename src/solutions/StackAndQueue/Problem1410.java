package solutions.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

public class Problem1410 {
    public String entityParser(final String text) {
        HashMap<String, String> keywordSet = new HashMap<>();
        Stack<Character> decodedData = new Stack<>();
        keywordSet.put("&gt;",">");
        keywordSet.put("&lt;","<");
        keywordSet.put("&amp;","&");
        keywordSet.put("&quot;","\"");
        keywordSet.put("&apos;", "'");
        keywordSet.put("&frasl;","/");
        boolean startWithAmp = false;
        for(int i = 0; i < text.length(); ++i){
            char c = text.charAt(i);
            if(c == ';' && startWithAmp){
                StringBuilder temp = new StringBuilder(";");
                while(!keywordSet.containsKey(temp.toString()) && !decodedData.empty() && temp.length() < 8){
                    temp.insert(0, decodedData.pop());
                }
                if(keywordSet.containsKey(temp.toString())){
                    for(char s : keywordSet.get(temp.toString()).toCharArray()){
                        decodedData.push(s);
                    }
                }
                else{
                    for(char s : temp.toString().toCharArray()){
                        decodedData.push(s);
                    }
                }
                startWithAmp = false;
            }
            else{
                if(c == '&'){
                    startWithAmp = true;
                }
                decodedData.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!decodedData.empty()){
            result.insert(0 , decodedData.pop());
        }
        return result.toString();
    }
}
