#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

static vector<int> v;

int main(void) {
    string str; cin >> str;

    int rule = str[0] - str[1];
    int flag = 1;
    for (int i = 1; i < str.size() - 1; i++) {
        if (str[i] - str[i + 1] != rule) {
            flag = 0;
            break;
        }
    }

    if (flag) {
        cout << "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!";
        return 0;
    }
    cout << "흥칫뿡!! <(￣ ﹌ ￣)>";
    return 0;
}