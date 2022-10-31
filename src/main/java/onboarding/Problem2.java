package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String[] Rm_sen = new String[2];
        Rm_sen[0] = cryptogram;
        Rm_sen[1] = cryptogram;
        for(int i = 0;;i = (i + 1) % 2){
            Rm_sen[i] = Remove_Duplicates(Rm_sen[(i + 1) % 2]);
            if(Rm_sen[i].equals(Rm_sen[(i + 1) % 2])){
                answer = Rm_sen[i];
                return answer;
            }
        }
    }

    public static String Remove_Duplicates(String cryptogram){
        //char[] char_crypto = cryptogram.toCharArray();

        for(int i = 0; i < cryptogram.length()-1 ; i++){
            int count;
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                for(count = 1; cryptogram.charAt(i) == cryptogram.charAt(i+count); count++ ){
                    if(i+count+1>=cryptogram.length()){
                        cryptogram = cryptogram.substring(0,i) + cryptogram.substring(i+count+1,cryptogram.length());
                        return cryptogram;
                    }
                }
                cryptogram = cryptogram.substring(0,i) + cryptogram.substring(i+count,cryptogram.length());}
        }
        return cryptogram;
    }
}
