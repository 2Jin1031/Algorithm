#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int> answer;
    int gcdv = __gcd(denom1, denom2);
    int denomv = gcdv * (denom1 / gcdv) * (denom2 / gcdv);
    int numerv = numer1 * (denom2 / gcdv) + numer2 * (denom1 / gcdv);
    int gcdr = __gcd(denomv, numerv);
    answer.push_back(numerv/gcdr);
    answer.push_back(denomv/gcdr);
    return answer;
}