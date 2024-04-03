#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

static int N;
static vector<int> A;
static int result = 0;

int ft_tie(int n, int m) {
    if (n == 1 || m == 1) {
        return n + m;
    }
    return n * m;
}

int ft_find_boundary(vector<int> A, int arrSize) {
    for (int i = 0; i < arrSize; i++) {
        if (A[i] <= 0) {
            return i;
        }
    }
    return arrSize;
}

int ft_positive(vector<int> A, int positive_idx) {
    int result = 0;
    for (int i = 0; i <= positive_idx; i += 2) {
        result += ft_tie(A[i], A[i + 1]);
    }
    return result;
}

int ft_negative(vector<int> A, int arrSize, int negative_idx) {
    int result = 0;
    for (int i = negative_idx; i < arrSize; i += 2) {
        result += ft_tie(A[i], A[i + 1]);
    } 
    return result;
}

int ft_logic(vector<int> A, int arrSize) {
    int idx = ft_find_boundary(A, arrSize);
    int positive_idx = idx - 1;
    int negative_idx = idx;
    int result = 0;
    if (idx % 2 == 1) {
        positive_idx--;
    }
    if ((arrSize - idx) % 2 == 1) {
        negative_idx++;
    }
    result += ft_positive(A, positive_idx);
    result += ft_negative(A, arrSize, negative_idx);
    
    for (int i = positive_idx + 1; i < negative_idx; i++) {
        result += A[i];
    }
    return result;
}

bool compare(int i, int j) {
    return j < i;
}

int main(void) {
    scanf("%d", &N);

    A = vector<int>(N);
    
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    //sort
    sort(A.begin(), A.end(), compare);

    //logic
    if (N == 1) {
        printf("%d", A[0]);
        return 0;
    }
    int result = ft_logic(A, N);
    printf("%d", result);
}