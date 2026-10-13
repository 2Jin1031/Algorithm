#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string str1, string str2) {
    if (str1.find(str2) == string::npos) return 2;
    return 1;
}
