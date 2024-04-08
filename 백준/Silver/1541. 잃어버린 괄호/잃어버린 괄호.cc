#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp

// #1541

using namespace std;

static char str[51];

int ft_make_int(char *pstart, char *pend) { // -> ok
    int num = 0;
    for (char *p = pstart; p <= pend; p++) {
        num = num * 10 +  *p - '0';
    }
    return num;
}

int ft_split_positive_sum(char *pstart, char *pend) {
    int num = 0;
    
    char *pstartt = pstart;
    char *pendd = pstart;
    for (char *p = pstart; p <= pend; p++) {
        if (*p == '+') {
            pendd = p - 1;
            num += ft_make_int(pstartt, pendd);
            pstartt = p + 1;
        }
    }
    pendd = pend;
    num += ft_make_int(pstartt, pendd);
    return num;
}


// ft_logic 설명
// 계속 돌면서 - 를 기준으로 한 덩어리를 묶는다
// 처음 - 가 나오기 전에는 result 에 더하고
// 그 다음은 다음 - 가 나오기 전까지를 묶고 뺀다
//// - 와 - 사이는 + 로 이루어 져있는데 그 수를 더한다 
int ft_logic(char *pstr) {
    char *pc = pstr;
    bool firstFlag = true;
    char *pstart = pstr;
    char *pend = pstr;

    int num = 0;

    while (*pc) {
        if (*pc == '-') {
            pend = pc - 1;
            if (firstFlag) {
                num += ft_split_positive_sum(pstart, pend);
                firstFlag = false;
            }
            else num -= ft_split_positive_sum(pstart, pend);
            pstart = pc + 1;
        }
        pc++;
    }
    pend = pc - 1;
    if (firstFlag) num += ft_split_positive_sum(pstart, pend);
    else num -= ft_split_positive_sum(pstart, pend);

    return num;

}

void ft_input_str(char *str) {
    scanf("%s", str);
}

int main(void) {
    ft_input_str(str);
    printf("%d", ft_logic(str));
}
