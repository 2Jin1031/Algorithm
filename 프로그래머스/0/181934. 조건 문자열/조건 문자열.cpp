#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string ineq, string eq, int n, int m) {
    int answer = 0;
    if (ineq == "<" && eq == "=") {
        answer = (n <= m);
    }
    else if (ineq == "<" && eq == "!")
        answer = (n < m);
    else if (ineq == ">" && eq == "=")
        answer = (n >= m);
    else {
        answer = (n > m);
    }
    
    return answer;
}