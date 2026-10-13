#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> names, vector<int> yearning, vector<vector<string>> photos) {
    vector<int> answer;
    int size = names.size();
    int sum;
    for (vector<string> photo : photos) {
        sum = 0;
        for(string value : photo) {
            for (int i=0; i<size; i++) {
                if (value == names[i]) {
                    sum += yearning[i];
                    break;
                }
            }
        }
        answer.push_back(sum);
    }
    return answer;
}