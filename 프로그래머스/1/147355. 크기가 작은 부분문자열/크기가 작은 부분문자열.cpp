#include <string>
#include <vector>
#include <cstring>

using namespace std;

int solution(string t, string p) {
    int len = p.size();
    int answer = 0;
    for(int i = 0; i <= t.size() - len; i++) {
        if (strncmp(t.c_str() + i, p.c_str(), len) <= 0) {
            answer++;
        }
    }
    return answer;
}