package Solutions;

import java.util.ArrayList;
import java.util.List;

class Problem0245 {
    public int shortestWordDistance(String[] dict,String w1,String w2) {
        List<Integer> locations1 = new ArrayList<>();
        List<Integer> locations2 = new ArrayList<>();
        for (int i = 0; i < dict.length; ++i) {
            if (dict[i].equals(w1)) {
                locations1.add(i);
            } else if (dict[i].equals(w2)) {
                locations2.add(i);
            }
        }
        int result = Integer.MAX_VALUE;
        if (w1.equals(w2)) {
            for (int i = 1; i < locations1.size(); ++i) {
                result = Math.min(result,locations1.get(i) - locations1.get(i - 1));
            }
        } else {
            int p1 = 0;
            int p2 = 0;
            while (p1 < locations1.size() && p2 < locations2.size()) {
                result = Math.min(result,Math.abs(locations1.get(p1) - locations2.get(p2)));
                if (locations1.get(p1) > locations2.get(p2)) {
                    ++p2;
                } else {
                    ++p1;
                }
            }
        }
        return result;
    }
}
