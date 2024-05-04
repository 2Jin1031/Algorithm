#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 11931

using namespace std;

static vector<int> A;


int main(void) {
	int N; scanf("%d", &N); A.resize(N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &A[i]);
	}

	sort(A.rbegin(), A.rend());

	for (int i = 0; i < N; i++) {
		printf("%d\n",A[i]);
	}
}