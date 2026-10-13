#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    sort(score.begin(), score.end());
    //if (score.size() < m) return answer;
    for(int i = score.size() - m; i >= 0; i -= m) {
        answer += score[i] * m;
    }
    return answer;
}