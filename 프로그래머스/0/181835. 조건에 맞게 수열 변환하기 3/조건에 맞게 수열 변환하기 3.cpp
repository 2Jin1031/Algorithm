#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer(arr.size(), -1);
    if (k % 2 != 0) {
        for (int i = 0; i < answer.size(); i++) {
            answer[i] = arr[i] * k;
        }
    } else {
        for (int i = 0; i < answer.size(); i++) {
            answer[i] = arr[i] + k;
        }
    }
    return answer;
}