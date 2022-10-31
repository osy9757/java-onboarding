package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = counting_359(number);
        return answer;
    }

    public static int counting_359(int number){
        int count = 0;
        for(int i = number ; i > 0 ; i--) {
            number = i;
            while (number > 0) {
                if ((number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9) {
                    count += 1;
                }
                number /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(13));
    }
}
