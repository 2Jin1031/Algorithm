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
    string str; cin >> str;
    for (int i = 0; i < str.size(); i++) {
        arr[str[i] - 'a']++;
    }

    for (int i = 0; i < 26; i++) printf("%d ", arr[i]);

    return 0;
}