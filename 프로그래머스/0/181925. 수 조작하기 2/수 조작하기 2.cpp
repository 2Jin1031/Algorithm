#include <bits/stdc++.h>

using namespace std;

string findStr(int num1, int num2) {
    int result = num1 - num2;
    if (result == 1) {
        return "w";
    } else if (result == -1) {
        return "s";
    } else if (result == 10) {
        return "d";
    } else if (result == -10) {
        return "a";
    }
    return "-1";
}

string solution(vector<int> numLog) {
    string answer = "";
    for (int i = 1; i < numLog.size(); i++) {
        answer += findStr(numLog[i], numLog[i - 1]);
    }
    return answer;
}