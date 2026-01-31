class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean worldFlag = false;
        for (int i = 0; i < dic.length; i++) {
            String word = dic[i];
            boolean flag = true;
            for (int j = 0; j < spell.length; j++) {
                if (!word.contains(spell[j])) {
                    flag = false;
                    break;
                }    
            }
            if (flag) worldFlag = true;
        }
        return worldFlag ? 1 : 2;
    
    }
}