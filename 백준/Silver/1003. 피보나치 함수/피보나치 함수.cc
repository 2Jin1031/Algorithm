#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 2448

using namespace std;
static vector<pair<int, int> > A;

typedef struct info {
	int cnt0;
	int cnt1;
} T;

T ft_fib(int num) {
	T t;
	if (A[num].first + A[num].second != 0) {
		t.cnt0 = A[num].first;
		t.cnt1 = A[num].second;
		return t;
	}
    if (num == 0) {
        A[0].first = 1; A[0].second = 0;
		t.cnt0 = A[0].first;
		t.cnt1 = A[0].second;
        return t;
    }
    else if (num == 1) {
        A[1].first = 0; A[1].second = 1;
		t.cnt0 = A[1].first;
		t.cnt1 = A[1].second;
        return t;
    }

	T tt = ft_fib(num - 1);
	T s = ft_fib(num - 2);

	t.cnt0 = tt.cnt0 + s.cnt0;
	t.cnt1 = tt.cnt1 + s.cnt1;

	A[num].first = t.cnt0;
	A[num].second = t.cnt1; 
    return t;
}

int main(void) {
	int loop; cin >> loop;
	for (int i = 0; i < loop; i++) {
		int N; cin >> N;
		A.resize(N + 1, make_pair(0, 0));
		T t = ft_fib(N);
		cout << t.cnt0 << " " << t.cnt1 << endl;
	}
}