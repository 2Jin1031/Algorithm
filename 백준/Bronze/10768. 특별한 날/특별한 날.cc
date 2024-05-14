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
    int month, date; cin >> month >> date;
    if (month < 2) {
        cout << "Before";
        return 0;
    }
    if (month == 2 && date < 18) {
        cout << "Before";
        return 0;
    }
    if (month == 2 && date == 18) {
        cout << "Special";
        return 0;
    }
    cout << "After";
}