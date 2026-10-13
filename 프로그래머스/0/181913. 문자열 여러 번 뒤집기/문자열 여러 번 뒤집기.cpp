#include <bits/stdc++.h>

using namespace std;

string reverseStr(string str, vector<int> idxs) {
    reverse(str.begin() + idxs[0], str.begin() + idxs[1] + 1);
    return str;
}

string solution(string my_string, vector<vector<int>> queries) {
    for (int i = 0; i < queries.size(); i++) {
        my_string = reverseStr(my_string, queries[i]);
    }
    return my_string;
}