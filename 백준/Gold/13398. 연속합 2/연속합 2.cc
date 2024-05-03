#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 13398

using namespace std;

static int N;
static vector<int> A, L, R;

int main(void) {
	cin >> N; A.resize(N); L.resize(N); R.resize(N);

	for (int i = 0; i < N; i++) cin >> A[i];

	L[0] = A[0];
	int result = L[0];
	for (int i = 1; i < N; i++) {
		L[i] = max(A[i], L[i-1] + A[i]);
		result = max(result, L[i]);
	}

	R[N-1] = A[N-1];
	for (int i = N-2; i >= 0; i--) {
		R[i] = max(A[i], R[i+1] + A[i]);
	}

	for (int i = 1; i < N - 1; i++) {
		int tmp = L[i-1] + R[i+1];
		result = max(result, tmp);
	}

	cout << result;
}