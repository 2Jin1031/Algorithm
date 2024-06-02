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

bool ft_check_mo(char s) {
    if (s == 'i' || s == 'e' || s == 'o' || s == 'u' || s == 'a') return true;
    return false;
}

int main(void) {
    string str; cin >> str;
    int result = 0;
    for (int i = 0; i < str.size(); i++) {
        if (ft_check_mo(str[i])) result++;
    }
    cout << result;
}