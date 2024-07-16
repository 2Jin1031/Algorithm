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
#include <cstdlib>

using namespace std;

static vector<vector<char> > A;
static int N;
static int length;

void ft_row(int i, int idx1, int idx2) {
    if (i >= length) {
        return ;
    }
    int startIdx, endIdx;
    if (idx1 < idx2) {
        startIdx = idx1;
        endIdx = idx2;
    }
    else {
        startIdx = idx2;
        endIdx = idx1;
    }

    for (int j = startIdx; j <= endIdx; j++) {
        A[i][j] = '*';
    }

    ft_row(i + 2, idx1 + 2, idx2 - 2);
}

void ft_column(int j, int idx1, int idx2) {
    if (j >= length) {
        return ;
    }

    int startIdx, endIdx;
    if (idx1 < idx2) {
        startIdx = idx1;
        endIdx = idx2;
    }
    else {
        startIdx = idx2;
        endIdx = idx1;
    }

    for (int i = startIdx; i <= endIdx; i++) {
        A[i][j] = '*';
    }

    ft_column(j + 2, idx1 + 2, idx2 - 2);
}

int main(void) {
    cin >> N;
    length = 4 * (N - 1) + 1;
    A.resize(length, vector<char>(length, ' '));

    // 테투리
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            if (i == 0 || i == length - 1 || j == 0 || j == length - 1) { 
                A[i][j] = '*';
                continue;
            }
        }
    }

    int i, j;
    // 가로행
    ft_row(0, 0, length - 1);
    // 세로
    ft_column(0, 0, length - 1);


    // print
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            cout << A[i][j];
        }
        cout << "\n";
    }
}