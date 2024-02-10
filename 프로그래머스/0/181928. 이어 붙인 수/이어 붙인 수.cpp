#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int even = 0, odd = 0;
    for (int i = 0; i < num_list.size(); i++) {
        if (num_list[i] % 2) { // 홀수
            odd = odd * 10 + num_list[i];
        }
        else {
            even = even * 10 + num_list[i];
        }
    }
    int answer = odd + even;
    return answer;
}