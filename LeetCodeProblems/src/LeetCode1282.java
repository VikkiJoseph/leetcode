import java.util.*;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * @author JosephMiriyala
 */
public class LeetCode1282 {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }

    /**
     * Groups the people as stated in the problems
     * @param groupSizes
     * @return
     */
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> finalGroupList = new ArrayList<>();
        Map<Integer,List<Integer>> finalMap = new HashMap<>();
        int index = 0;
        for(int group : groupSizes){
            List<Integer> intList = finalMap.getOrDefault(group,new ArrayList<>());
            intList.add(index);
            finalMap.put(group,intList);
            index++;
        }
        for(Map.Entry<Integer,List<Integer>> entry : finalMap.entrySet()){
            finalGroupList.addAll(getArrayLists(entry.getKey(),entry.getValue()));
        }
        return  finalGroupList;
    }

    /**
     * Gives the array list by performing sub lists.
     * @param index
     * @param values
     * @return
     */
    private static List<List<Integer>> getArrayLists(Integer index, List<Integer> values) {
            List<List<Integer>> finalValues = new ArrayList<>();
            for(int begin=0;begin<values.size();begin=begin+index) {
                finalValues.add(values.subList(begin, begin + index));
            }
            return finalValues;
    }
}
