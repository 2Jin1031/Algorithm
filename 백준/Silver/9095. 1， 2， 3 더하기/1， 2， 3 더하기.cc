#include <iostream>
#include <cstdio>

static int N;
static int D[11] = {0};

int ft_dp(int i) {
    if (D[i]) return D[i];
    D[i] = ft_dp(i - 1) + ft_dp(i - 2) + ft_dp(i - 3);
    return D[i];
}

int main(void) {
    scanf("%d", &N);

    D[0] = 1; D[1] = 1; D[2] = 2;

    for (int i = 0; i < N; i++) {
        int tmp; scanf("%d", &tmp);
        printf("%d\n", ft_dp(tmp));
    }
}
