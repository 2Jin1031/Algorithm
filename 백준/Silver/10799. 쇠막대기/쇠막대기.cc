#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <queue>
#include <functional>

using namespace std;

static bool pass_flag = false;

bool IsLaser(char *pc) {
    if (*pc == '(' && *(pc + 1) == ')') return true;
    return false;
}

int main(void) {
    string str; cin >> str;

    // [0] ~ [str.size() - 2]
    int pieceCnt = 0;
    int stickCnt = 0;
    bool pass_flag = false;
    for (int i = 0; i < str.size() - 1; i++) {
        if (pass_flag) {
            pass_flag = false;
            continue;
        }
        if (IsLaser(&str[i])) {
            pieceCnt += stickCnt;
            pass_flag = true;
            continue;
        }
        if (str[i] == '(') {
            stickCnt++;
        }
        if (str[i] == ')') {
            stickCnt--;
            pieceCnt++;
        }
    }

    if (stickCnt != 0) {
        pieceCnt++;
    }

    cout << pieceCnt << endl;
}