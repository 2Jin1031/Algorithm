#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }

    int current_sum = A[0];
    int max_sum = A[0];
    
    for (int i = 1; i < n; i++) {
        current_sum = max(A[i], current_sum + A[i]);
        max_sum = max(max_sum, current_sum);
    }
    
    cout << max_sum << endl;
    return 0;
}