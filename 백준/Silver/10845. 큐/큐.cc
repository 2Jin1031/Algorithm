#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;
static queue<int> A;

int findNum(string str) {
    int num = 0;
    for (int i = 5; i < str.size(); i++) {
        num = num * 10 + str[i];
    }

    return (num);
}

int main(void) {
    int N; scanf("%d", &N);
    int v;
    string str;
    for (int i = 0; i < N; i++) {
        cin >> str;
        if (str[1] == 'u') { // push
            scanf("%d", &v);
            A.push(v);
        }
        else if (str[1] == 'r') { // front
            if (!A.empty()) {
                printf("%d\n", A.front());
            }
            else {
                printf("-1\n");
            }
        }
        else if (str[1] == 'a') { // back
            if (!A.empty()) {
                printf("%d\n", A.back());
            }
            else {
                printf("-1\n");
            }
        }
        else if (str[1] == 'i') { // size
            printf("%d\n", A.size());
        }
        else if (str[1] == 'm') { // empty
            if (A.empty()) {
                printf("1\n");
            }
            else {
                printf("0\n");
            }
        }
        else if (str[1] == 'o') { // pop
            if (!A.empty()) {
                printf("%d\n", A.front());
                A.pop();
            }
            else {
                printf("-1\n");
            }
        }
    }
}