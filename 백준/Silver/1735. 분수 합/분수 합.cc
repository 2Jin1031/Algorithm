#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <deque>
#include <stack>
#include <queue>

using namespace std;

int ft_gcd(int x, int y)
{
    if (y == 0) 
        return x;
    else 
        return ft_gcd(y, x % y); // 여기서 반환문을 추가해야 함
}

int main(void)
{
	int nm1, dm1, nm2, dm2;
	
	scanf("%d %d %d %d", &nm1, &dm1, &nm2, &dm2);
	
	int resnm = nm1 * dm2 + nm2 * dm1;
	int resdm = dm1 * dm2;
	
	printf("%d %d", resnm / ft_gcd(resnm, resdm), resdm / ft_gcd(resnm, resdm));
}