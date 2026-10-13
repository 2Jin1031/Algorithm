#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int res1 = stoi(to_string(a) + to_string(b));
    int res2 = stoi(to_string(b) + to_string(a));
    
    if (res1 < res2) res1 = res2;
    return res1;
}