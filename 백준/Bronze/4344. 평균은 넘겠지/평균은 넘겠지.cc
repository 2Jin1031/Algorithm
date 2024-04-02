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

static int C, N;

typedef struct T_case {
    int *A;
    int sum;
} T;


T ft_input_arr(int size) {
    T t;
    int tmp;
    int sum = 0;
    int *arr = (int *)malloc(sizeof(int) * size);
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    t.A = arr;
    t.sum = sum;
    return t;
    // return sum;
    free(arr);
}

void ft_logic_N(int N) {
    T t;
    t = ft_input_arr(N);
    int *A = t.A;
    int sum = t.sum;
    int count = 0;
    // int sum = ft_input_arr(N);
    double avg = (sum + 0.0) / N;
    for (int i = 0; i < N; i++) {
        if (A[i] > avg) count++;
    }
    double result = (count + 0.0) / N * 100;
    printf("%.3f%%\n", result);
}

void ft_logic_C(int C) {
    for (int i = 0; i < C; i++) {
        cin >> N;
        ft_logic_N(N);
    }
}

int main(void) {
    cin >> C;
    ft_logic_C(C);
}