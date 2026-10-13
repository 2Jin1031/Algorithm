#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> matchCountAndValue(vector<int> vec) {
    map<int,int> cnt;
    for (int x : vec) cnt[x]++;

    vector<pair<int,int>> result(cnt.begin(), cnt.end());  // (value, count)
    sort(result.begin(), result.end(), [](const pair<int,int>& a, const pair<int,int>& b) {
        return a.second > b.second;      // count 내림차순
    });
    return result;
}

int solution(int a, int b, int c, int d) {
    vector<int> vec = {a, b, c, d};
    vector<pair<int, int>> mv = matchCountAndValue(vec);
    int maxMatchCount = mv[0].second;
    int maxMatchValue = mv[0].first;
    int secondMatchCount = mv[1].second;
    int secondMatchValue = mv[1].first;

    if (maxMatchCount == 4) {
        return 1111 * maxMatchValue;
    } else if (maxMatchCount == 3) {
        return (10 * maxMatchValue + secondMatchValue) * (10 * maxMatchValue + secondMatchValue);
    } else if (maxMatchCount == 2) {
        if (secondMatchCount == 2) {
            return (maxMatchValue + secondMatchValue) * abs(maxMatchValue - secondMatchValue);
        } else {
            int thirdMatchValue = mv[2].first;
            return secondMatchValue * thirdMatchValue;
        }
    } 
        int localMinValue = INT_MAX;
        for (int i = 0; i < mv.size(); i++) {
            localMinValue = min(localMinValue, mv[i].first);
        }
        return localMinValue;
}