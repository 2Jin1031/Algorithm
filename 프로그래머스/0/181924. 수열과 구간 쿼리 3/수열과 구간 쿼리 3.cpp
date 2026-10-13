#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (int i = 0; i < queries.size(); i++) {
        int startIdx = queries[i][0], endIdx = queries[i][1];
        
        int temp = arr[startIdx];
        arr[startIdx] = arr[endIdx];
        arr[endIdx] = temp;
    }
    
    return arr;
}