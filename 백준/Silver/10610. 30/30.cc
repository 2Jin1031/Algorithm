#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <queue>
#include <functional>

using namespace std;

int main(void) {
    vector<char> v;
    bool isDrainage = false;

    string str; cin >> str;
    long long sum = 0;
    for (int i = 0; i < str.size(); i++) {
        v.push_back(str[i]);
        if (str[i] == '0') isDrainage = true;
        sum += str[i] - '0';
    }

    sort(v.begin(), v.end(), greater<char>());

    if (isDrainage && sum % 3 == 0) {
        for (int i = 0; i < v.size(); i++) {
            cout << v[i];
        }
    }
    else {
        cout << "-1";
    }
}