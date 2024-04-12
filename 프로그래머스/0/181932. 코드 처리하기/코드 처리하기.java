class Solution {
    public String solution(String code) {
        int codeSize = code.length();
        String ret = "";
        int mode = 0;
        // 반복 logic
        for (int i = 0; i < codeSize; i++) {
            if (mode == 0) { // mode가 0일 때
                if (code.charAt(i) != '1' && i % 2 == 0) // code[i] !"1" i 짝수
                {
                    ret += code.charAt(i);
                }
                else if (code.charAt(i) == '1') // code[i] "1"
                    mode = 1;
            }
            else { // mode가 1일 때
                if (code.charAt(i) != '1' && i % 2 == 1) // code[i] !"1" i 홀수
                    ret += code.charAt(i);
                else if (code.charAt(i) == '1') // code[i] "1"
                    mode = 0;
            }
        }
        System.out.println(ret);
        int retSize = ret.length();
        if (retSize == 0) return "EMPTY";
        return ret;
    }
}