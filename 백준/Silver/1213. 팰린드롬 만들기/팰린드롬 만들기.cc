#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <queue>
#include <functional>

using namespace std;

static char arr[26] = {0};

string ft_res(string str) {
    reverse(str.begin(), str.end());
    return str;
}

int main(void) {
    string str; cin >> str;

    for (int i = 0; i < str.size(); i++) {
        arr[str[i] - 'A']++;
    }

    int cntOdd = 0;
    char middleC = 0;
    for (int i = 0; i < 26; i++) {
        if (arr[i] % 2 == 1) {
            middleC = i + 'A';
            cntOdd++;
        }
    }

    if (cntOdd > 1) {
        cout << "I'm Sorry Hansoo" << endl;
        return 0;
    }

    string result = "";
    for (int i = 0; i < 26; i++) {
        if (arr[i] == 0) continue;
        while (arr[i] > 1) {
            result += (i + 'A');
            arr[i] -= 2;
        }
    }
    string tmp = result;
    if (middleC != 0) result += middleC;
    result += ft_res(tmp);

    cout << result << endl;
}