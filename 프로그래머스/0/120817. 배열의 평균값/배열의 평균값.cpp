#include <string>
#include <vector>

using namespace std;

double solution(vector<int> numbers) {
    double answer = 0.0;
    for (int value : numbers)
        answer += value;
    
    return answer/numbers.size();
}