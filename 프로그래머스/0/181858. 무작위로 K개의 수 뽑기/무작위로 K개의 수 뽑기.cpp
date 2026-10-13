#include <bits/stdc++.h>

using namespace std;

bool findNum(vector<int> vec, int num) {
    for (int i = 0; i < vec.size(); i++) {
        if (vec[i] == num) {
            return true;
        }
    }
    return false;
}

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer(1, arr[0]);
    for (int i = 1; i < arr.size(); i++) {
        if (!findNum(answer, arr[i])) {
            answer.push_back(arr[i]);
        }
        if (answer.size() >= k) {
            break;
        }
    }
    if (answer.size() < k) {
        for (int i = answer.size() + 1; i <= k; i++) {
            answer.push_back(-1);
        }
    }
    return answer;
}