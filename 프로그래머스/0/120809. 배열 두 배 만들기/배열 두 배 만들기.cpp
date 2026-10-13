#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    for (int value : numbers) 
        answer.push_back(2*value);
    return answer;
}