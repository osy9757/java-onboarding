package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = reverse_change(word);
        return answer;
    }
    public static String reverse_change(String word){
        char[] temp_word = word.toCharArray();
        for(int i = 0; i < word.length() ; i++) {
            int num = (int)temp_word[i];
            if (65 <= num && num <= 90) {
                num = (90 - (num - 65));
            } else if (97 <= num && num <= 122) {
                num = (122 - (num - 97));
            }
            temp_word[i] = (char)num;
        }
        word = String.valueOf(temp_word);
        return word;
    }
}
