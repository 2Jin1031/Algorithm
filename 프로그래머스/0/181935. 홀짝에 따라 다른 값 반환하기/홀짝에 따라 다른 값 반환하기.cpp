#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    if (n%2) {
        for(int i = n; i >= 1; i -= 2) 
            answer += i;
    }
    else {
        for(int i = n; i >= 1; i -= 2) 
            answer += i * i;
    }
    return answer;
}