n = int(input())

sum1 = 0
sum2 = 1
tmp = 0
for i in range(n):
    tmp = sum2
    sum2 = sum1
    sum1 = sum1 + tmp

print(sum1)