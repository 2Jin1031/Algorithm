#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>

using namespace std;

static long long N[100] = {0};

long long ft_dp(int num);

int main(void) {
    int T; scanf("%d", &T);

    // basic config
    N[0] = 1; N[1] = 1; N[2] = 1; N[3] = 1; N[4] = 2; N[5] = 2;

    for (int i = 0; i < T; i++) {
        int tmp; scanf("%d", &tmp);
        printf("%lld\n", ft_dp(tmp));
    }
}

long long ft_dp(int num) {
    if (N[num] != 0) {
        return N[num];
    }
    N[num] = ft_dp(num - 5) + ft_dp(num - 1);
    return N[num];
}