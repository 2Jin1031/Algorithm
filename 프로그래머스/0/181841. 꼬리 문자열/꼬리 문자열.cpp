#include <string>
#include <vector>

using namespace std;

string solution(vector<string> str_list, string ex) {
    string answer = "";
    for (int i = 0; i < str_list.size(); i++) {
        string str = str_list[i];
        if (str.find(ex) == string::npos) {
            answer += str;
        }
    }
    return answer;
}