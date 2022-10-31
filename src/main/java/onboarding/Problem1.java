package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(Exception_check(pobi) || Exception_check(crong)){
            answer = -1;
            return answer;
        }

        int pobi_max = Math.max(cal_sum(pobi),cal_mul(pobi));
        int crong_max = Math.max(cal_sum(crong),cal_mul(crong));

        if(pobi_max > crong_max){
            answer = 1;
        }
        else if(pobi_max == crong_max){
            answer = 0;
        }
        else{
            answer = 2;
        }
        return answer;
    }
    public static  int cal_sum(List<Integer> page){
        int max = 0;
        int[] res_sum = new int[2];

        for(int i = 0; i<page.size(); i++){
            int page_num = page.get(i);
            int res = 0;
            while(page_num>0){
                res += page_num % 10;
                page_num /= 10;
            }
            res_sum[i] = res;
        }
        max = Math.max(res_sum[0],res_sum[1]);
        return max;
    }
    public static  int cal_mul(List<Integer> page){
        int max = 0;
        int[] res_mul = new int[2];

        for(int i = 0; i<page.size(); i++){
            int page_num = page.get(i);
            int res = 1;
            while(page_num>0){
                res *= page_num % 10;
                page_num /= 10;
            }
            res_mul[i] = res;
        }
        max = Math.max(res_mul[0],res_mul[1]);
        return max;
    }
    public static boolean Exception_check(List<Integer> page){ // 페이지 에러 측정
        if(page.size() != 2){
            return true;
        }
        if(page.get(0) <= 1 || page.get(0) >= 400 || page.get(0) % 2 == 0){ // 페이지 범위
            return true;
        }
        if(page.get(1) != page.get(0) + 1 ){
            return true;
        }
        return false;
    }
}

