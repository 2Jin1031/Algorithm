#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    int trash = 0;
    while (n >= a) {
        answer += (n / a) * b;
        trash += n % a;
        n = (n / a) * b;
        if (n < a) {
            n += trash;
            trash = 0;
        }
    }
    return answer;
}