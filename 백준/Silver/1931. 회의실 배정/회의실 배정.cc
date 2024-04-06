#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 1931
using namespace std;

static int N;
static vector<pair<int, int> > A;


bool compare(pair<int, int> i, pair<int, int> j) {
    if (i.second == j.second) return i.first < j.first;
    return i.second < j.second;
}

int main(void) {
    scanf("%d", &N);

    A.resize(N); 

    for (int i = 0; i < N; i++) {
        scanf("%d %d", &A[i].first, &A[i].second);
    }

    // sort
    sort(A.begin(), A.end(), compare);

    //
    int line = A[0].second; // 첫 번째 회의의 끝나는 시간으로 초기화
    int cnt = 1;
    for (int i = 1; i < N; i++) { // i를 1부터 시작
        if (A[i].first >= line) { // A[i].first가 line 이상일 경우, 즉 회의 시작 시간이 마지막으로 선택된 회의의 끝나는 시간 이후일 경우
            line = A[i].second; // 마지막으로 선택된 회의의 끝나는 시간을 갱신
            cnt++;
        }
    }

    printf("%d", cnt);
}