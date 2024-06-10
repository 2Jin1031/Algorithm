#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>
#include <stack>
#include <iomanip>

using namespace std;

vector<string> v;

void ft_logic(string str) {
    string num = "";
    int flag = 0;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] >= '0' && str[i] <= '9') {
            flag = 1;
            if (num.size() == 0 && str[i] == '0') continue;
            num += str[i];
            
        }
        else if (flag == 1) {
            if (num.size() == 0) num = '0';
            v.push_back(num);
            num = "";
            flag = 0;
        }
    }
    if (str[str.size() - 1] >= '0' && str[str.size() - 1] <= '9') {
        if (num.size() == 0) num = '0';
        v.push_back(num);
    }
    return ;
}

bool compareNumericStrings(const string &a, const string &b) {
    if (a.size() == b.size())
        return a < b;
    return a.size() < b.size();
}

int main(void) {
    int N; cin >> N;

    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        ft_logic(str);
    }

    sort(v.begin(), v.end(), compareNumericStrings);

    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << "\n";
    }

    return 0;
}