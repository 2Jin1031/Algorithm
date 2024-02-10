#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<char> charV;
    vector<int> idxV;
    int flag;
    vector<int> answer(s.size(), -1);
    for (int i = 0; i < s.size(); i++) {
        flag = 0;
        for (int j = 0; j < charV.size(); j++) {
            if (charV[j] == s[i]) {
                answer[i] = i - idxV[j]; // 만약 두번째 a 였다면 3 - 1
                idxV[j] = i;
                flag = 1;
                break;
            }
        }
        if (!flag) { // 중복해서 안 나왔다면
            charV.push_back(s[i]); 
            idxV.push_back(i); // charV에 저장된 위치에 인덱스 값 대입
        }
    }
    return answer;
}