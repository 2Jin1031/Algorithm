#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    int idx1end = cards1.size();
    int idx2end = cards2.size();
    int idx1 = 0, idx2 = 0;
    string answer = "Yes";
    for (string value : goal) {
        if (cards1[idx1] == value) {
            idx1++;
        }
        else if (cards2[idx2] == value) {
            idx2++;
        }
        else {
            answer = "No";
            break;
        }
    }
            
    return answer;
}