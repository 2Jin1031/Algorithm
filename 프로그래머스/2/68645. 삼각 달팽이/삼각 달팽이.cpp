#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n) {
    vector<vector<int>> vecs(n);
    for (int i = 0; i < n; i++)
        vecs[i].assign(i + 1, -1);   // i행: 크기 i+1, 전부 -1

    int total = n * (n + 1) / 2;
    int num = 1;
    int cx = 0, cy = 0;
    vecs[cx][cy] = num++;

    while (num <= total) {
    // 방향 1: 아래로 (cx 증가, cy 고정)
    while (cx + 1 < n && vecs[cx + 1][cy] == -1) {
        cx++;
        vecs[cx][cy] = num++;
    }
    // 방향 2: 오른쪽으로 (cy 증가, cx 고정)
    while (cy + 1 < (int)vecs[cx].size() && vecs[cx][cy + 1] == -1) {
        cy++;
        vecs[cx][cy] = num++;
    }
    // 방향 3: 왼쪽 위 대각선 (cx, cy 동시 감소)
    while (cx - 1 >= 0 && cy - 1 >= 0 && vecs[cx - 1][cy - 1] == -1) {
        cx--; cy--;
        vecs[cx][cy] = num++;
    }
}

    vector<int> answer;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < (int)vecs[i].size(); j++)
            answer.push_back(vecs[i][j]);
    return answer;
}