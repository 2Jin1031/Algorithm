#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 1012

using namespace std;

static vector<vector<int> > A;
static int dx[4] = {0, 1, 0, -1};
static int dy[4] = {1, 0, -1, 0};
static int M;
static int N;

void DFS(int i, int j) {
	if (A[i][j] == 0 || A[i][j] == 2) return ;

	A[i][j] = 2;

	for (int d = 0; d < 4; d++) {
		int new_i = i + dx[d];
		int new_j = j + dy[d];
		if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < M) {
			DFS(new_i, new_j);
		}
	}
}

int ft_logic() {
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (A[i][j] == 1) {
				DFS(i, j);
				cnt++;
			}
		}
	}
	return cnt;
}

int main(void) {
	int T; cin >> T;
	for (int t = 0; t < T; t++) {
		int K; cin >> M >> N >> K; A.clear(); A.resize(N, vector<int>(M, 0));

		int a, b;
		for (int i = 0; i < K; i++){
			cin >> b>> a; A[a][b] = 1;
		}

		cout << ft_logic() << endl;
	}
	
}