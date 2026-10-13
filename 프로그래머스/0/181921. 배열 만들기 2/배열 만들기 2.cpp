#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    for (int i = l; i <= r; i++) {
        int temp = i;
        
        bool flag = true;
        while (temp > 0) {
            int num = temp % 10;
            if (num != 0 && num != 5) {
                flag = false;
                break;
            }
            temp /= 10;
        }
        if (flag) {
            answer.push_back(i);    
        }
    }
    if (answer.size() <= 0) {
        return {-1};
    }
    return answer;
}