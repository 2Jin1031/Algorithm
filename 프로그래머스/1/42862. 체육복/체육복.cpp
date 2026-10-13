#include <bits/stdc++.h>

using namespace std;

int findIdxForNum(vector<int> vec, int num) {
    return (int) (find(vec.begin(), vec.end(), num) - vec.begin());
}


int solution(int n, vector<int> lost, vector<int> reserve) {
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    int answer = n - lost.size();
    
    int savedCount = 0;
    for (int i = 0; i < lost.size(); i++) {
        int lostN = lost[i];
        int idx = findIdxForNum(reserve, lostN);
        if (idx != reserve.size()) {
            reserve[idx] = -1;
            lost[i] = -1;
            savedCount++;
        }
    }
    
    for (int i = 0; i < lost.size(); i++) {
        int lostN = lost[i];
        if (lostN == -1) continue; 
        int idx = findIdxForNum(reserve, lostN - 1);
        if (idx != reserve.size()) {
            reserve[idx] = -1;
            savedCount++;
            continue;
        }
        idx = findIdxForNum(reserve, lostN + 1);
        if (idx != reserve.size()) {
            reserve[idx] = -1;   
            savedCount++;
            continue;
        }
    }
    return answer + savedCount;
}