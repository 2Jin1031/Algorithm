#include <iostream>
#include <cstdio>

using namespace std;

static int N;
static int M;

int main(void) {
    scanf("%d %d", &N, &M);
    if (N % M == 0) printf("Yes");
    else printf("No");
}