#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp

using namespace std;

static char str[5];

int main(void) {
    scanf("%4s", str); // Ensure to avoid buffer overflow, read at most 4 characters + null terminator
    if (strcmp(str, "NLCS") == 0) {
        printf("North London Collegiate School");
    } else if (strcmp(str, "BHA") == 0) {
        printf("Branksome Hall Asia");
    } else if (strcmp(str, "KIS") == 0) {
        printf("Korea International School");
    } else if (strcmp(str, "SJA") == 0) {
        printf("St. Johnsbury Academy");
    }

    return 0;
}
