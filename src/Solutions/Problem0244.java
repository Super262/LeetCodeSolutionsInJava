package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0244 {
    class WordDistance {
        private final Map<String, ArrayList<Integer>> locations;

        public WordDistance(final String[] dict) {
            locations = new HashMap<>();
            for (int i = 0; i < dict.length; ++i) {
                if (!locations.containsKey(dict[i])) {
                    locations.put(dict[i],new ArrayList<>());
                }
                locations.get(dict[i]).add(i);
            }
        }

        public int shortest(final String w1,final String w2) {
            int result = Integer.MAX_VALUE;
            int p1 = 0;
            int p2 = 0;
            List<Integer> locs1 = locations.get(w1);
            List<Integer> locs2 = locations.get(w2);
            while (p1 < locs1.size() && p2 < locs2.size()) {
                result = Math.min(result,Math.abs(locs1.get(p1) - locs2.get(p2)));
                if (locs1.get(p1) > locs2.get(p2)) {
                    ++p2;
                } else {
                    ++p1;
                }
            }
            return result;
        }
    }
}
