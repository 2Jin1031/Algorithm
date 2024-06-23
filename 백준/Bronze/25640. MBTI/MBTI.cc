#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
#include <climits>

using namespace std;

int main(void) {
    string src; cin >> src;
    int N; cin >> N; getchar();

    int resultCnt = 0;
    for (int i = 0; i < N; i++){
        string dest; cin >> dest;
        if (src == dest) {
            resultCnt++;
        }
    }

    cout << resultCnt;
}