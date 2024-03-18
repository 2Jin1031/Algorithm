#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <cmath>

using namespace std;

static int A[5];

int main(void) {

    int sum = 0;
    for (int i = 0; i < 5; i++) {
        scanf("%d", &A[i]);
        if (A[i] < 40) A[i] = 40;
        sum += A[i];
    }
    printf("%d", sum / 5);
}