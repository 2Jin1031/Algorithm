#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> strlist) {
    vector<int> answer;
    for (string value : strlist)
        answer.push_back(value.size());
    return answer;
}