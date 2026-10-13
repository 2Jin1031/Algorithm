#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<string> arr) {
    string answer(arr.size(), ' ');
    for (int i = 0; i < arr.size(); i++)
        answer[i] = arr[i][0];
    return answer;
}