#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    int result1 = 0, result2 = 0;
    for (int value : num_list) {
        if (value % 2) result2++;
        else result1++;
    }
    answer.push_back(result1);
    answer.push_back(result2);
    return answer;
}