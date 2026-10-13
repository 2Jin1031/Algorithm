#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(string my_string, string target) {
    int answer = 0;
    if (my_string.find(target) != string::npos) {
        answer = 1;
    }
    return answer;
}