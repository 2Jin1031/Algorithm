#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <deque>
#include <stack>
#include <queue>

using namespace std;

int main(void) {
    string str; cin >> str;
    vector<int> A(str.size());
    for (int i = 0; i < str.size(); i++) {
        A[i] = str[i] - '0';
    }
    
    // Sort
    for (int i = 0; i < str.size(); i++) {
        for (int j = i + 1; j < str.size(); j++) {
            if (A[i] < A[j]) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
    }

    //Print
    for (int i = 0; i < str.size(); i++) {
        printf("%d", A[i]);
    }

}
