#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

static int N;
static vector<int> A;
static int M;
static bool D[21] = {false};

void ft_match_str(string str, int num) {
    if (str[2] == 'd') { // add 
        D[num] = true;
    }
    else if (str[2] == 'm') { // remove
        if(D[num]) { // 특정원소 값이 존재함 
            D[num] = false;
        }
    }
    else if (str[2] == 'e') { // check
        if(D[num]) {
            cout << "1" << "\n";
        }
        else {
            cout << "0" << "\n";
        }
    }
    else if (str[2] == 'g') { // toggle
        if(D[num]) { // 특정원소 값이 존재함 
            D[num] = false;
        }
        else {
            D[num] = true;
        }
    }
    else if (str[2] == 'l') { // all
        for (int i = 1; i <= 20; i++) {
            D[i] = true;
        }
    }
    else if (str[2] == 'p') { // empty
        for (int i = 1; i <= 20; i++) {
            D[i] = false;
        }
    }
}

int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> M;
    
    for (int i = 0; i < M; i++) {
        string str; int num; cin >> str;
        if (str[2] != 'l' && str[2] != 'p') { // not all and empty
            cin >> num;
        }
        ft_match_str(str, num);
    }
}