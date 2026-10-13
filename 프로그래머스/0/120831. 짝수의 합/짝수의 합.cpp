#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = n / 2;
    answer *= answer + 1;
    return answer;
}