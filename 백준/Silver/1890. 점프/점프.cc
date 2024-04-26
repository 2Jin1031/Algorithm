#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 1890

using namespace std;

static vector< vector<long> > A;
static vector<vector<long> > D;
static long N;

void DFS(int i, int j);

int main(void) {
	cin >> N; A.resize(N, vector<long>(N)); D.resize(N, vector<long>(N, 0));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
	}

	// logic
	D[N-1][N-1] = 1;
	for (int i = N - 1; i >= 0; i--) {
		for (int j = N - 1; j >= 0; j--) {
			DFS(i, j);
		}
	}

	cout << D[0][0];
}

void DFS(int i, int j) {
	int nx = i + 0;
	int ny = j + -1;
	if (nx >= 0 && ny >= 0) {
		if (ny + A[nx][ny] < N && D[nx][ny + A[nx][ny]] != 0) {
			D[nx][ny] += D[nx][ny + A[nx][ny]];
		}
	}

	nx = i + -1;
	ny = j + 0;
	if (nx >= 0 && ny >= 0) {
		if (nx + A[nx][ny] < N && D[nx + A[nx][ny]][ny] != 0) {
				D[nx][ny] += D[nx + A[nx][ny]][ny];
			}
	}
}