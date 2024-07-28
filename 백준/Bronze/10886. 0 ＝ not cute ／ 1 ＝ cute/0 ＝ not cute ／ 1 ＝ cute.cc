#include <cstdio>

int main(void) {
    int N;
    scanf("%d", &N);

    int cuteCount = 0, notCuteCount = 0;

    for (int i = 0; i < N; i++) {
        int a;
        scanf("%d", &a);
        if (a == 1) {
            cuteCount++;
        } else {
            notCuteCount++;
        }
    }

    if (cuteCount > notCuteCount) {
        printf("Junhee is cute!");
    } else {
        printf("Junhee is not cute!");
    }

    return 0;
}