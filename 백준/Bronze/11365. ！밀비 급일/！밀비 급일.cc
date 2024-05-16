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

int main(void) {
    while (1) {
        string str; getline(cin, str); if (str == "END") break;
        for (int i = str.size() - 1; i >= 0; i--) {
            cout << str[i];
        }cout << endl;
    }
}