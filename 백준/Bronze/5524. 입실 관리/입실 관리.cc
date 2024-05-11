#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>
#include <tuple>
#include <utility>
#include <climits>


// 
using namespace std;

static int arr[26] = {0};

int main(void) {
    int N; cin >> N; getchar();
    for (int i = 0; i < N; i++) {
        string str; cin >> str;
        for (int j = 0; j < str.size(); j++) {
            str[j] = tolower(str[j]);
        }
        cout << str << endl;
    }
}