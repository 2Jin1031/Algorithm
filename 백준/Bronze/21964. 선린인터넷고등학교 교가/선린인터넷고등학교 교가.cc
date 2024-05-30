#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;

int main(void) {
    int size; cin >> size;
    string str; cin >> str;
    for (int i = size - 5; i < size; i++) cout << str[i];
}