#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>

using namespace std;

bool ft_break(char *str) {
    if (str[0] == '#') return true;
    return false;
}

bool ft_isMo(char s) {
    if (s == 'A' || s == 'E' || s == 'O' || s == 'U' || s == 'I') {
        return true;
    }
    else if (s == 'a' || s == 'e' || s == 'o' || s == 'u' || s == 'i') {
        return true;
    }
    return false;
}

int ft_count(char *pstr) {
    int count = 0;
    while (*pstr) {
        if (ft_isMo(*pstr)) {
            count++;
        }
        pstr++;
    }
    return count;
}

int main(void) {
    char str[256];
    while (1) {
        scanf(" %[^\n]s", str);
        if (ft_break(str)) break;
        printf("%d\n", ft_count(str));
    }
}