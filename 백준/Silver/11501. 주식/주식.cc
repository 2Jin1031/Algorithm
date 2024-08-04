#include <iostream>
#include <vector>
using namespace std;

long long maxProfit(const vector<int>& prices) {
    long long profit = 0;
    int maxPrice = 0;

    for (int i = prices.size() - 1; i >= 0; --i) {
        if (prices[i] > maxPrice) {
            maxPrice = prices[i];
        }
        else {
            profit += maxPrice - prices[i];
        }
    }

    return profit;
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        
        vector<int> prices(n);
        for (int i = 0; i < n; ++i) {
            cin >> prices[i];
        }

        cout << maxProfit(prices) << "\n";
    }

    return 0;
}