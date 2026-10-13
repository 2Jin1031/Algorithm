#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer(num_list.size() + 1, -1);
    for (int i = 0; i < num_list.size(); i++) {
        answer[i] = num_list[i];
    }
    
    int lastValue = num_list[num_list.size() - 1];
    int last2Value = num_list[num_list.size() - 2];
    if (lastValue > last2Value) {
        answer[num_list.size()] = lastValue - last2Value;
    } else {
        answer[num_list.size()] = lastValue * 2;
    }
    return answer;
}