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

// 4949

using namespace std;


bool ft_logic(const string& str) {
    stack<char> s;
    for (char ch : str) {
        if (ch == '(') {
            s.push(')');
        } else if (ch == '[') {
            s.push(']');
        } else if (ch == ')' || ch == ']') {
            if (s.empty() || s.top() != ch) {
                return false;
            }
            s.pop();
        }
    }
    return s.empty();
}

int main(void) {
	string str;
	while (1) {
		getline(cin, str);
		if (str[0] == '.') break;
		if (ft_logic(str)) printf("yes");
		else printf("no");
		printf("\n");
	}

	return 0;
}