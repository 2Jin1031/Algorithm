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

int main(void) {

    string fingerGroups[8] = {
        "1QAZ", 
        "2WSX",   
        "3EDC",   
        "4RFV5TGB", 
        "6YHN7UJM", 
        "8IK,",   
        "9OL.",   
        "0P;/-=[]'"
    };

    int fingerCounts[8] = {0};

    string input; cin >> input;

    for (char ch : input) {
        for (int i = 0; i < 8; i++) {
            if (fingerGroups[i].find(ch) != string::npos) {
                fingerCounts[i]++;
                break;
            }
        }
    }

    for (int i = 0; i < 8; i++) {
        cout << fingerCounts[i] << " ";
    }
}