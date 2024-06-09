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

bool isSpecial(int year) {
    if (year == 2000) return true;
    if (year % 100 == 0) return false;
    if (year % 4 == 0) return true;
    return false;
}

int main(void) {
    int lastdate[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int year, month, date;
    while (1) {
        cin >> date >> month >> year;
        if (!year && !month  && !date) break;
        if (month < 1 ||  month > 12) {
            cout << "Invalid";
        }
        else if (isSpecial(year) && month == 2 && (date > 0 && date < 30)) { 
            cout << "Valid";
        } 
        else if (date < 1 || date > lastdate[month]) {
            cout << "Invalid";
        }
        else cout << "Valid";
        cout << "\n";
    }
}