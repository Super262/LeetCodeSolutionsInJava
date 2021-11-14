package Solutions;

import java.util.*;

public class Problem0721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> father = new HashMap<>();
        HashMap<String, String> emailUser = new HashMap<>();
        int accLen;
        String currentChild;
        String currentUser;
        for (List<String> a : accounts) {
            accLen = a.size();
            currentUser = a.get(0);
            for (int i = 1; i < accLen; ++i) {
                currentChild = a.get(i);
                father.put(currentChild,currentChild);
                emailUser.put(currentChild,currentUser);
            }
        }
        String firstChild;
        for (List<String> a : accounts) {
            accLen = a.size();
            firstChild = a.get(1);
            for (int i = 2; i < accLen; ++i) {
                currentChild = a.get(i);
                union(father,firstChild,currentChild);
            }
        }
        String currentFather;
        HashMap<String, HashSet<String>> emailCluster = new HashMap<>();
        for (List<String> a : accounts) {
            accLen = a.size();
            for (int i = 1; i < accLen; ++i) {
                currentChild = a.get(i);
                currentFather = findAndCompress(father,currentChild);
                if (!emailCluster.containsKey(currentFather)) {
                    emailCluster.put(currentFather,new HashSet<>());
                }
                emailCluster.get(currentFather).add(currentChild);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (String mainEmail : emailCluster.keySet()) {
            HashSet<String> childSet = emailCluster.get(mainEmail);
            ArrayList<String> tempResult = new ArrayList<>(childSet.size() + 1);
            tempResult.addAll(childSet);
            Collections.sort(tempResult);
            tempResult.add(0,emailUser.get(mainEmail));
            result.add(tempResult);
        }
        return result;
    }

    private void union(HashMap<String, String> father,String aKey,String bKey) {
        String rootA = findAndCompress(father,aKey);
        String rootB = findAndCompress(father,bKey);
        if (rootA.equals(rootB)) {
            return;
        }
        father.put(rootB,rootA);
    }

    private String findAndCompress(HashMap<String, String> father,String nodeIndex) {
        List<String> path = new LinkedList<>();
        while (!father.get(nodeIndex).equals(nodeIndex)) {
            path.add(nodeIndex);
            nodeIndex = father.get(nodeIndex);
        }
        for (String v : path) {
            father.put(v,nodeIndex);
        }
        return nodeIndex;
    }
}
