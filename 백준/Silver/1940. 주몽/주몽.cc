#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void) {
    int N, M; scanf("%d %d", &N, &M);
    vector<int> V;

    // Input
    int tmp;
    for (int i = 0; i < N; i++) {
        scanf("%d", &tmp);
        V.push_back(tmp);
    }

    //Sort
    sort(V.begin(), V.end());

    //
    int start = 0, end = N - 1;
    int result;
    int cnt = 0;
    while (1) {
        if (start >= end) break;
        result = V.at(start) + V.at(end);
        if (result < M) {
            start++;
        }
        else if (result > M) {
            end--;
        }
        else {
            cnt++;
            start++;
            end--;
        }
    }
    printf("%d", cnt);
}