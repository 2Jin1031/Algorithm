#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
#include <climits>

using namespace std;

static vector<vector<char> > A;

void ft_preorder(char node);
void ft_inorder(char node);
void ft_postorder(char node);

int main(void) {
    int N; cin >> N; A.resize(N); getchar();

    for (int i = 0; i < N; i++) {
        string input; getline(cin, input); 
        //cout << "input = " << input << "\n"; 
        
        char node = input[0], leftChildNode = input[2], rightChildNode = input[4];

        A[node - 'A'].push_back(leftChildNode);
        A[node - 'A'].push_back(rightChildNode);
    }

    ft_preorder('A'); cout << "\n";
    ft_inorder('A'); cout << "\n";
    ft_postorder('A');
    
    return 0;
}

void ft_preorder(char node) {
    if (node == '.') return ;
    cout << node;
    ft_preorder(A[node - 'A'][0]);
    ft_preorder(A[node - 'A'][1]);
}

void ft_inorder(char node) {
    if (node == '.') return ;
    ft_inorder(A[node - 'A'][0]);
    cout << node;
    ft_inorder(A[node - 'A'][1]);
}

void ft_postorder(char node) {
    if (node == '.') return ;
    ft_postorder(A[node - 'A'][0]);
    ft_postorder(A[node - 'A'][1]);
    cout << node;
}