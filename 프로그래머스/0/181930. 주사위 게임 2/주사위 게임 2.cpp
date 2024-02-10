#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int c) {
    int answer = a + b + c;
    if (a == b && b == c) {
        answer = answer * 9 * a * a * a * a * a;
    }
    else if (a == b || b == c || a == c) {
        answer = answer * (a * a + b * b + c * c);
    }
    
    return answer;
}