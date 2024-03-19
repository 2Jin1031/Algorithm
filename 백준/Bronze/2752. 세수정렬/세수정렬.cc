#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <cmath>
#include <vector>
#include <algorithm> // 추가된 헤더

using namespace std;

static vector<int> A(3);

int main(void) {
    for (int i = 0; i < 3; i++) {
        scanf("%d", &A[i]);
    }
    
    // sort
    sort(A.begin(), A.end()); // std::sort로 수정

    // print
    for (int i = 0; i < 3; i++) {
        printf("%d ", A[i]);
    }
}
