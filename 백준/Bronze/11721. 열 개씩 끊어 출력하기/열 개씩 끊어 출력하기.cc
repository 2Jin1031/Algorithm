#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 1931
using namespace std;

static int N;
static char str[101];

int ft_strSize(char *pstr) {
    int cnt = 0;
    while (*pstr) {
        pstr++;
        cnt++;
    }
    return cnt;
}

char *ft_lumpp(char *pstr, char *pstart, int strSize) {
    char *pend = pstr;
    if (pstr + 10 > pstart + strSize) {
        pend = pstart + strSize;
    }
    else {
        pend = pstr + 10;
    }

    for (char *p = pstr; p < pend; p++) {
        printf("%c", *p);
    }
    printf("\n");
    return pend;
}


int main(void) {
    scanf("%s", str); getchar();
    int strSize = ft_strSize(str);

    char *pstr = str;
    char *pstart = str;

    while (*pstr) {
        pstr = ft_lumpp(pstr, str, strSize);
    }
}