#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

void ft_Add(char c);
void ft_Remove(char c);

int correctSecret = 0;
vector<int> correctKey(4, 0);
vector<int> testKey(4, 0);

int main(void) {
    int S, P; cin >> S >> P;
    string A; cin >> A;

    int Result = 0;
    
    for (int i = 0; i < 4; i++) {
        cin >> correctKey[i];
        if (correctKey[i] == 0)
            correctSecret++;
    }

    // is Correct
    for(int i = 0; i < P; i++) {
        ft_Add(A[i]);
    }

    if (correctSecret == 4)
        Result++;
    
    for (int i = P; i < S; i++) {
        int j = i - P;
        ft_Add(A[i]);
        ft_Remove(A[j]);

        if (correctSecret == 4) {
            Result++;
        }
    }

    cout << Result << "\n";

}

void ft_Add(char c) {
    switch(c) {
        case 'A':
            testKey[0]++;
            if (correctKey[0] == testKey[0])
                correctSecret++;
            break;
        case 'C':
            testKey[1]++;
            if (correctKey[1] == testKey[1])
                correctSecret++;
            break;
        case 'G':
            testKey[2]++;
            if (correctKey[2] == testKey[2])
                correctSecret++;
            break;
        case 'T':
            testKey[3]++;
            if (correctKey[3] == testKey[3])
                correctSecret++;
            break;
    }
}

void ft_Remove(char c) {
    switch(c) {
        case 'A':
            if (correctKey[0] == testKey[0])
                correctSecret--;
            testKey[0]--;
            break;
        case 'C':
            if (correctKey[1] == testKey[1])
                correctSecret--;
            testKey[1]--;
            break;
        case 'G':
            if (correctKey[2] == testKey[2])
                correctSecret--;
            testKey[2]--;
            break;
        case 'T':
            if (correctKey[3] == testKey[3])
                correctSecret--;
            testKey[3]--;
            break;
    }
}