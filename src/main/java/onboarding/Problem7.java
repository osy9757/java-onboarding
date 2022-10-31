package onboarding;

import java.sql.Array;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<>();
        Map<String, ArrayList<String>> linked_friend = new HashMap<String, ArrayList<String>>();
        Map<String,Integer> score_list = new HashMap<String, Integer>();


        score_list = friend_list_up(friends,visitors);
        linked_friend = make_friend_list(friends);
        score_list = counting_points(user, linked_friend, visitors, score_list);
        score_list = visitors_points(score_list, visitors);
        answer = sortbyscorename(answer,score_list,user,linked_friend);

        return answer;
    }

    public static Map<String, Integer> friend_list_up (List<List<String>> friends, List<String> visitors){
        HashSet<String> erase_duplicates = new HashSet<String>();
        for(int i = 0 ; i < friends.size(); i++){
            erase_duplicates.add(friends.get(i).get(0));
            erase_duplicates.add(friends.get(i).get(1));
        }
        for(int i = 0; i < visitors.size(); i++){
            erase_duplicates.add(visitors.get(i));
        }
        List<String> list = new ArrayList<>(erase_duplicates);
        Map<String,Integer> list_up = new HashMap<String, Integer>();
        for(int i = 0 ; i < erase_duplicates.size(); i++){
            list_up.put(list.get(i),0);
        }
        return list_up;
    }
    public static Map<String, ArrayList<String>> make_friend_list(List<List<String>> friends){
        Map<String, ArrayList<String>> linked_friend = new HashMap<String, ArrayList<String>>();

        for(int i = 0 ; i < friends.size() ; i++){

            ArrayList<String> tmp_list1 = linked_friend.getOrDefault(friends.get(i).get(0),new ArrayList<String>());
            tmp_list1.add(friends.get(i).get(1));
            linked_friend.put(friends.get(i).get(0),tmp_list1);

            ArrayList<String> tmp_list2 = linked_friend.getOrDefault(friends.get(i).get(1),new ArrayList<String>());
            tmp_list2.add(friends.get(i).get(0));
            linked_friend.put(friends.get(i).get(1),tmp_list2);
        }
        return linked_friend;
    }

    public static Map<String, Integer> counting_points(String user, Map<String, ArrayList<String>> friend_list, List<String> visitors, Map<String,Integer> list_up){
        ArrayList<String> user_friends = new ArrayList<>();

        user_friends = friend_list.getOrDefault(user, new ArrayList<String>());

        Set<String> keySet = friend_list.keySet();
        List<String> keylist = new ArrayList<>(keySet);

        for (int i  = 0; i < user_friends.size(); i++){
            for (int j = 0 ; j < keylist.size() ; j++){
                if(friend_list.get(keylist.get(j)).contains(user_friends.get(i))){
                    list_up.put(keylist.get(j),list_up.getOrDefault(keylist.get(j),0)+10);
                }
            }
        }

        return list_up;
    }

    public static Map<String, Integer> visitors_points(Map<String,Integer> list_up, List<String> visitors){

        for(int i = 0 ; i < visitors.size() ; i++){
            list_up.put(visitors.get(i), list_up.getOrDefault(visitors.get(i), 0) + 1 );
        }
        return list_up;
    }

    public static List<String> sortbyscorename(List<String> answer, Map<String,Integer> list_up, String user, Map<String, ArrayList<String>> friend_list){

        List<Map.Entry<String, Integer>> sort_score = new LinkedList<>(list_up.entrySet());

        Collections.sort(sort_score, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = sort_score.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.remove(user);
        for(int i = 0 ; i < friend_list.get(user).size() ; i++){
            sortedMap.remove(friend_list.get(user).get(i));
        }

        Set<String> keySet = sortedMap.keySet();
        answer = new ArrayList<>(keySet);

        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"),
                List.of("smith", "andole"),
                List.of("shakevan", "jony"),
                List.of("smith", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        System.out.println(solution(user, friends, visitors));
    }

}
