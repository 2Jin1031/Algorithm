#include <iostream>
#include <vector>

using namespace std;

static vector<int> A;

int ft_fibo(int n) {
    if (A[n] != -1) return A[n];
    A[n] = ft_fibo(n - 2) + ft_fibo(n - 1);
    return A[n];
}

int main(void) {
    int n; cin >> n; A.resize(n + 1, -1);

    A[0] = 0; A[1] = 1;
    cout << ft_fibo(n);
}