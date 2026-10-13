#include <bits/stdc++.h>

using namespace std;

int findIdxNumber(string str, int i) {
    if (str.size() <= i) {
        return 0;
    }
    return str[str.size() - 1 - i] - '0';
}


string solution(string a, string b) {
    string answer = "";
    
    int upperInt = 0;
    int maxSize = a.size() > b.size() ? a.size() : b.size();
    for (int i = 0; i < maxSize; i++) {
        int aInt = findIdxNumber(a, i);
        int bInt = findIdxNumber(b, i);
        int result = aInt + bInt + upperInt;
        upperInt = (result / 10) >= 1 ? 1 : 0;
        answer = to_string(result % 10) + answer;

    }
    if (upperInt > 0) {
        answer = "1" + answer;
    }
    return answer; 
}