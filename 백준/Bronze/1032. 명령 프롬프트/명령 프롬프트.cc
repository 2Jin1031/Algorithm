#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

static int N;
static vector<int> A;
static int M;
static vector<int> B;

int main(void) {
    scanf("%d", &N);
    string str; cin >> str;

    for (int i = 1; i < N; i++) {
        string tmp; cin >> tmp;
        for (int j = 0; j < str.size(); j++) {
            if (str[j] != tmp[j]) {
                str[j] = '?';
            }
        }
    }
    cout << str;
}