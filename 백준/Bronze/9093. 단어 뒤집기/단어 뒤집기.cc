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

static int T;
static char str[1001];

void ft_logic2(char *pstart, char *pend) {
    for (char *p = pend; p >= pstart; p--) {
        printf("%c", *p);
    }
    return ;
}

void ft_logic(char *pstr) {
    char *pstart = pstr;
    char *pend = pstr;
    while (*pstr) {
        if (*pstr == ' ') {
            pend = pstr - 1;
            ft_logic2(pstart, pend);
            pstart = ++pstr;
            printf(" ");
        }
        pstr++;
    }
    pend = pstr - 1;
    ft_logic2(pstart, pend);
    printf("\n");
    return ;
}

int main(void) {
    scanf("%d", &T); getchar();

    for (int i = 0; i < T; i++) {
        scanf(" %[^\n]", str);
        ft_logic(str);
    } 
    return 0;
}