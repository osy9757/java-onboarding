package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        TreeSet<String> name_dict = new TreeSet<>();

        name_dict = make_name_dict(forms);

        for(int i = 0; i < forms.size(); i++){
            if(check_name_dict(forms.get(i),name_dict)){
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static TreeSet<String> make_name_dict(List<List<String>> forms){
        List<String> tmp_name_dict = new ArrayList<>();
        TreeSet<String> name_dict = new TreeSet<>();

        for(int i = 0; i < forms.size(); i++){
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++){
                tmp_name_dict.add(forms.get(i).get(1).substring(j,j+2));
            }
        }

        for(String name : tmp_name_dict){
            if(tmp_name_dict.indexOf(name) != tmp_name_dict.lastIndexOf(name)){
                name_dict.add(name);
            }
        }

        return name_dict;
    }

    public static boolean check_name_dict(List<String> forms, TreeSet<String> name_dict){
        for(int j = 0; j < forms.get(1).length() - 1; j++){
            if(name_dict.contains(forms.get(1).substring(j,j+2)))
                return true;
        }
        return false;
    }
}
